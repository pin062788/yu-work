package yuweixiang.first.search;

import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.action.admin.indices.alias.exists.AliasesExistResponse;
import org.elasticsearch.action.admin.indices.alias.get.GetAliasesResponse;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.collect.UnmodifiableIterator;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * elasticsearch 管理器，用于初始化elasticsearch相关配置，并且连接elasticsearch节点
 *
 * @author yuweixiang
 * @version $Id: ESManager.java, v 0.1 2015-11-23 下午4:28:13 yuweixiang Exp $
 */
public class ESManager {

    /** 日志 */
    private static final Logger LOGGER     = LoggerFactory.getLogger(ESManager.class);

    /** 别名,指向真正的index，做全量索引的时候,只需要将alias指向新的索引就行了 */
    private String              alias;

    /** elasticsearch客户端 */
    private Client              esClient;

    /** transports配置,和es集群的node通信 */
    private String              transports;

    /** 集群名称 */
    private String              clusterName;

    /** 类型 */
    private static final String SEARCH_TYPE = "searchResult";

    /**
     * 获取elasticsearch客户端对象
     * @return 返回结果
     */
    public Client getESClient() {
        if (esClient == null) {
            init();
        }
        return esClient;
    }

    /**
     * 初始化配置信息
     */
    private void init() {

        // 1. 初始化
        String indexName = initClient();

        // 2. 判断Alisa是否存在,不存在就创建,如果存在多个则抛异常
        // 注：alisa别名，别名指向类型
        //判断Alisa是否存在,不存在就创建,如果存在多个就抛异常
        AliasesExistResponse aliasesExistResponse = esClient.admin().indices()
                .prepareAliasesExist(alias).execute().actionGet();
        LOGGER.info("aliasesExistResponse:{}", new Gson().toJson(aliasesExistResponse));
        //如果alias不存在,则创建alias,创建index,创建alias和index的映射关系
        if (!aliasesExistResponse.exists()) {
            // 2.1. 创建索引
            createIndexIfNotExists(indexName);

            // 2.2. 关联索引与别名
            esClient.admin().indices().prepareAliases().addAlias(indexName, alias).execute()
                    .actionGet();

            // 2.3. 定义类型的数据结构
            createMapping(alias, SEARCH_TYPE);
        } else {
            //检查alias是否只指向一个index,如果指向多个index则抛异常
            checkIfAliasOnlyPointToOneIndex(alias);
        }
    }

    /**
     * 判断alias是否只指向一个index
     * 如果指向多个index的话会导致数据重复
     * @param alias
     */
    private void checkIfAliasOnlyPointToOneIndex(String alias) {
        GetAliasesResponse actionResponse = esClient.admin().indices().prepareGetAliases()
                .setAliases(alias).execute().actionGet();
        UnmodifiableIterator<String> iterator = actionResponse.getAliases().keysIt();
        int aliasPointCount = 0;
        while (iterator.hasNext()) {
            String index = iterator.next();
            LOGGER.info("exist index:{}", index);
            aliasPointCount++;
        }
        //如果alias指向多个index就抛异常
        if (aliasPointCount > 1) {
            throw new IllegalStateException(
                    "alias point to multi indexes, it's impossible, quit now");
        }
    }

    /**
     * 创建mapping，类型的结构，相当于mysql中表结构，json形式
     *
     * @param alias 别名名称
     * @param orderType 类型
     * @return 返回创建结果
     */
    private ActionResponse createMapping(String alias, String orderType) {
        String map = StringUtils.EMPTY;
        if (StringUtils.equals(orderType, SEARCH_TYPE)) {
            map = createSearchTypeMapping();
        } else {
            return null;
        }
        return esClient.admin().indices().preparePutMapping(alias).setType(orderType)
                .setSource(map).execute().actionGet();
    }

    /**
     * 创建订单类型的结构，由于此处设置的是订单领域模型的对象，所以结构稍复杂
     *
     * @return 返回结果
     */
    private String createSearchTypeMapping() {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(
                    "/mapping/search.json")));
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                line = line.trim();
                sb.append(line);
            }
        } catch (Exception ex) {
            LOGGER.error("initPrefixKeywordMapping failed", ex);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Exception ex) {
                    LOGGER.error("initPrefixKeywordMapping failed", ex);
                }
            }
        }
        return sb.toString();
    }

    /**
     * 初始化client
     *
     * @return 索引名称
     */
    private String initClient() {

        // 1. 给每个机器安排一个索引名称，对应mysql的数据库名称
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmSS");
        String indexName = "yuweixiang-search-index-" + simpleDateFormat.format(new Date()) + "-"
                + getLocalIP();
        indexName = indexName.toLowerCase();

        // 2. 设置配置文件和集群名称，只要集群名称一致，则自动加入集群
        String[] transportsArray = transports.split(",");
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", clusterName.trim()).build();
        TransportClient transportClient = new TransportClient(settings);
        // 2.1. 连接TransportClient,TransportClient的默认端口是9300
        //注意TransportClient的端口和Http服务的端口是不一样的
        for (String transport : transportsArray) {
            String[] transportInfo = transport.split(":");
            transportClient.addTransportAddress(new InetSocketTransportAddress(transportInfo[0].trim()
                    , Integer.parseInt(transportInfo[1].trim())));
        }

        // 2.2. 验证节点是否存在，如果存在说明成功
        List<DiscoveryNode> nodes = transportClient.connectedNodes();
        if (nodes.isEmpty()) {
            LOGGER.error("DiscoveryNode node list is empty, it's impossible, quit now");
            throw new IllegalStateException(
                    "DiscoveryNode node list is empty, it's impossible, quit now");
        } else {
            Iterator<DiscoveryNode> iter = nodes.iterator();
            while (iter.hasNext()) {
                DiscoveryNode discoveryNode = iter.next();
                LOGGER.info("find node:{}", new Gson().toJson(discoveryNode));
            }
        }
        // 3. 给对象赋值
        esClient = transportClient;
        return indexName;
    }

    /**
     * 判断index是否存在,不存在就创建
     *
     * @param indexName
     */
    public void createIndexIfNotExists(String indexName) {
        IndicesExistsResponse indicesExistsResponse = esClient.admin().indices()
                .prepareExists(indexName).execute().actionGet();
        LOGGER.info("indicesExistsResponse:{}", new Gson().toJson(indicesExistsResponse));
        if (!indicesExistsResponse.isExists()) {
            CreateIndexResponse createIndexResponse = esClient.admin().indices()
                    .prepareCreate(indexName).execute().actionGet();
            LOGGER.info("createIndexResponse:{}", new Gson().toJson(createIndexResponse));
        }
    }

    /**
     * 获取当前ip地址
     *
     * @return ip地址
     */
    public static String getLocalIP() {
        InetAddress ia = null;
        try {
            ia = InetAddress.getLocalHost();
            return ia.getHostAddress().replaceAll("\\.", "_");
        } catch (UnknownHostException e) {
        }
        return "";
    }

    /**
     * Getter method for property <tt>clusterName</tt>.
     *
     * @return property value of clusterName
     */
    public String getClusterName() {
        return clusterName;
    }

    /**
     * Setter method for property <tt>clusterName</tt>.
     *
     * @param clusterName value to be assigned to property clusterName
     */
    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    /**
     * Getter method for property <tt>alias</tt>.
     *
     * @return property value of alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Setter method for property <tt>alias</tt>.
     *
     * @param alias value to be assigned to property alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Getter method for property <tt>transports</tt>.
     *
     * @return property value of transports
     */
    public String getTransports() {
        return transports;
    }

    /**
     * Setter method for property <tt>transports</tt>.
     *
     * @param transports value to be assigned to property transports
     */
    public void setTransports(String transports) {
        this.transports = transports;
    }
}
