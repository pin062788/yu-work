package yuweixiang.first.spider;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import yuweixiang.first.domain.KeyWords;
import yuweixiang.first.domain.Search;
import yuweixiang.first.search.ESClient;

import javax.annotation.Resource;
import java.io.*;

/**
 * Created by yuweixiang on 16/1/16.
 */
public class DownTool {

    @Resource
    private ESClient esClient;

    /**
     * 根据 URL 和网页类型生成需要保存的网页的文件名，去除 URL 中的非文件名字符
     */
    private String getFileNameByUrl(String url, String contentType) {
        // 移除 "http://" 这七个字符
        url = url.substring(7);
        // 确认抓取到的页面为 text/html 类型
        if (contentType.indexOf("html") != -1) {
            // 把所有的url中的特殊符号转化成下划线
            url = url.replaceAll("[\\?/:*|<>\"]", "_") + ".html";
        } else {
            url = url.replaceAll("[\\?/:*|<>\"]", "_") + "."
                    + contentType.substring(contentType.lastIndexOf("/") + 1);
        }
        return url;
    }
    /**
     * 保存网页字节数组到本地文件，filePath 为要保存的文件的相对地址
     */
    private void saveToLocal(byte[] data, String filePath) {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(
                    new File(filePath)));
            for (int i = 0; i < data.length; i++)
                out.write(data[i]);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 下载 URL 指向的网页
    public String downloadFile(String url) {
        String filePath = null;
        // 1.生成 HttpClinet对象并设置参数
        HttpClient httpClient = new HttpClient();
        // 设置 HTTP连接超时 5s
        httpClient.getHttpConnectionManager().getParams()
                .setConnectionTimeout(5000);
        // 2.生成 GetMethod对象并设置参数
        GetMethod getMethod = new GetMethod(url);
        // 设置 get请求超时 5s
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        // 设置请求重试处理
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                new DefaultHttpMethodRetryHandler());
        // 3.执行GET请求
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            // 判断访问的状态码
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: "
                        + getMethod.getStatusLine());
                filePath = null;
            }
            // 4.处理 HTTP 响应内容
            InputStream inputStream = getMethod.getResponseBodyAsStream();// 读取为字节数组
            byte[] responseBody = toByteArray(inputStream);
            // 根据网页 url 生成保存时的文件名
            filePath = "/Users/yuweixiang/Downloads/my/yu-work/temp/"
                    + getFileNameByUrl(url,
                    getMethod.getResponseHeader("Content-Type")
                            .getValue());
            saveToLocal(responseBody, filePath);
            saveToSearch(url,responseBody);
        } catch (HttpException e) {
            // 发生致命的异常，可能是协议不对或者返回的内容有问题
            System.out.println("请检查你的http地址是否正确");
            e.printStackTrace();
        } catch (IOException e) {
            // 发生网络异常
            e.printStackTrace();
        } finally {
            // 释放连接
            getMethod.releaseConnection();
        }
        return filePath;
    }

    /**
     * 將數據保存到缓存
     *
     * @param url url链接
     * @param data 数据
     */
    public void saveToSearch(String url,byte[] data){

        String strData = new String(data);
        String title = "";
        String content = "";

        int titleFirst = strData.indexOf("<title>");
        int titleSecond = strData.indexOf("</title>");
        if(titleSecond!=-1||titleFirst!=-1) {
            title = strData.substring(titleFirst + 7, titleSecond);
        }

        int contentFirst = strData.indexOf("<content>");
        int contentSecond = strData.indexOf("</content>",contentFirst);
        if(contentFirst!=-1||contentSecond!=-1) {
            content = strData.substring(contentFirst + 9, contentSecond);
        }
        // 具体描述
        content = buildContent(strData,"description");
        // 关键字
        String keyWords = buildContent(strData,"keywords");

        if(StringUtils.isNotBlank(title)) {

            // 1. 判断数据是否已经存在,存在则不处理
           if(isExistsData(url)){
               return;
           }
            // 2. 不存在则保存
            Search search = new Search();
            search.setUrl(url);
            search.setTitle(title);
            search.setContext(content);
            search.setKeyWords(buildKeyWords(keyWords));
            esClient.saveData("search","search",JSONObject.toJSONString(search));
        }
    }

    /**
     * 构建关键字对象
     *
     * @param keyWords 关键字
     * @return 返回构建结果
     */
    private KeyWords buildKeyWords(String keyWords) {
        String[] innerKeyWords = keyWords.split(",");
        KeyWords searchKeyWord = new KeyWords();
        if(innerKeyWords.length>4){
            searchKeyWord.setKey1(innerKeyWords[0]);
            searchKeyWord.setKey2(innerKeyWords[1]);
            searchKeyWord.setKey3(innerKeyWords[2]);
            searchKeyWord.setKey4(innerKeyWords[3]);
            return searchKeyWord;
        }else if(innerKeyWords.length>0){
            switch (innerKeyWords.length) {
                case 1:
                    searchKeyWord.setKey1(innerKeyWords[0]);
                    break;
                case 2:
                    searchKeyWord.setKey1(innerKeyWords[0]);
                    searchKeyWord.setKey2(innerKeyWords[1]);
                    break;
                case 3:
                    searchKeyWord.setKey1(innerKeyWords[0]);
                    searchKeyWord.setKey2(innerKeyWords[1]);
                    searchKeyWord.setKey3(innerKeyWords[2]);
                    break;
            }
        }
        return searchKeyWord;
    }

    /**
     * 获取网站描述信息
     *
     * @param strData 原始数据
     * @return 返回结果
     */
    private static String buildContent(String strData,String keyWord) {
        int start = strData.indexOf("<meta name=\""+keyWord+"\"");
        if(start<0){
            String firstWord = keyWord.substring(0,1);
            keyWord = firstWord.toUpperCase()+keyWord.substring(1,keyWord.length());
            start = strData.indexOf("<meta name=\""+keyWord+"\"");
        }
        if(start>0) {
            String subStr = strData.substring(start, strData.length());
            int firstContent = subStr.indexOf("content");
            int firstFlag = subStr.indexOf("/>");
            return subStr.substring(firstContent + 9, firstFlag - 2);
        }
        return null;
    }

    /**
     * 判断数据是否已经存在,如果是,返回true
     * @param url url
     * @return 判断结果
     */
    private boolean isExistsData(String url){
        // 1. 判断结果先按照简单的过滤规则,重复的url前缀排除
        // 1.1. 如果以http://开头,则取中间,如果不是,直接取开头
        if(url.startsWith("http://")){
            System.out.println(url);
            int index = url.indexOf("?");
            if(index>0) {
                url = url.substring(8, index);
            }else{
                url = url.substring(8, url.length());
            }
        }else {
            url = url.split("\\?")[0];
        }
        SearchResponse response = esClient.searchData("search","searchItem","url",url);
        if(response.getHits().getHits().length>0){
            return true;
        }
        return false;
    }
    /**
     *
     * @param input
     * @return 返回结果
     * @throws IOException
     */
    public static byte[] toByteArray(InputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = input.read(buffer))) {
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }
}
