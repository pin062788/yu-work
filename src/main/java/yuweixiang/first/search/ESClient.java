package yuweixiang.first.search;

import org.elasticsearch.action.search.SearchResponse;
import yuweixiang.first.request.search.SearchRequest;

/**
 * Created by yuweixiang on 16/1/27.
 */
public interface ESClient {

    /**
     * 保存数据
     *
     * @param alis 索引
     * @param type 类型
     * @param data 数据
     */
    public void saveData(String alis,String type,String data);

    /**
     * 搜索数据
     *
     * @param alis 索引
     * @param type 类型
     * @param key 查询的值
     * @param value 搜索的词
     * @return 搜索结果
     */
    public SearchResponse searchData(String alis,String type,String key,String value);

    /**
     * 通过关键字进行搜索
     *
     * @param searchRequest 请求参数
     * @return 搜索结果
     */
    public SearchResponse searchDataByKeys(SearchRequest searchRequest);

//    /**
//     * 删除类型中的数据
//     *
//     * @param alis 索引
//     * @param type 类型
//     */
//    public void deleteData(String alis,String type);
}
