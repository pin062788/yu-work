package yuweixiang.first.test;

import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import yuweixiang.first.item.SearchItem;

import java.util.Map;

/**
 * Created by yuweixiang on 16/1/24.
 */
public class ESTest extends BaseTest {

    @Test
    public void testESManager(){

        SearchItem searchItem = new SearchItem();
        searchItem.setTitle("第一个");
        searchItem.setContext("具体信息");
        searchItem.setUrl("www.baidu.com");

        Client client = esManager.getESClient();

        client.admin().indices().preparePutMapping("yuweixiang").setType("searchResult").execute().actionGet();
        client.prepareIndex("search", "searchItem").setSource(JSONObject.toJSONString(searchItem)).execute()
                .actionGet();
    }

    @Test
    public void testSearchInfo(){

        search("第一个");
    }

    public void search(String q) {
        // 创建查询索引
        SearchRequestBuilder searchRequestBuilder = esManager.getESClient().prepareSearch("search");
        // 设置查询索引类型
        searchRequestBuilder.setTypes("searchItem");
        // 设置查询类型
        // 1.SearchType.DFS_QUERY_THEN_FETCH = 精确查询
        // 2.SearchType.SCAN = 扫描查询,无序
        // 3.SearchType.COUNT = 不设置的话,这个为默认值,还有的自己去试试吧
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        // 设置查询关键词
        // fieldQuery 这个必须是你的索引字段哦,不然查不到数据,这里我只设置两个字段 id ,title
//        searchRequestBuilder.setQuery(QueryBuilders.nestedQuery("searchItemList",
//                QueryBuilders.matchQuery("searchItemList.title", q)));
        searchRequestBuilder.setQuery(QueryBuilders.matchQuery("title",q));
        // 设置查询数据的位置,分页用吧
        searchRequestBuilder.setFrom(0);
        // 设置查询结果集的最大条数
        searchRequestBuilder.setSize(60);
        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);
        // 最后就是返回搜索响应信息
        SearchResponse response = searchRequestBuilder.execute().actionGet();
        //        MultiSearchRequestBuilder multiSearchRequestBuilder = client.prepareMultiSearch();
        //        MultiSearchResponse sr = multiSearchRequestBuilder.add(searchRequestBuilder).execute()
        //            .actionGet();

        //        for (MultiSearchResponse.Item item : sr.getResponses()) {
        //            SearchResponse response = item.getResponse();
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchHit hit = hits[i];
            Map result = hit.getSource();
            System.out.println("搜索成功!结果:" + result);
        }
        //        }
        System.out.println("search success ..");
    }
}
