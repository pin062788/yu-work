package yuweixiang.first.search.impl;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.index.query.*;
import yuweixiang.first.domain.SearchField;
import yuweixiang.first.request.search.SearchRequest;
import yuweixiang.first.search.ESClient;
import yuweixiang.first.search.ESManager;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuweixiang on 16/1/27.
 */
public class ESClientImpl implements ESClient {

    /** es管理器 */
    @Resource
    private ESManager esManager;

    @Override
    public void saveData(String alis, String type, String data) {

        // 保存数据
        esManager.getESClient().prepareIndex(alis, type).setSource(data).execute()
                .actionGet();
    }

    @Override
    public SearchResponse searchData(String alis, String type,String key, String value) {

        // 先进行关键字匹配
        SearchRequest request = new SearchRequest();
        request.setAlis(alis);
        request.setType(type);
        SearchField searchField1 = new SearchField();
        searchField1.setKey(key);
        searchField1.setValue(value);
        List<SearchField> searchFieldList = new ArrayList<SearchField>();
        searchFieldList.add(searchField1);
        SearchResponse response = searchDataByKeys(request);
        if (response.getHits().getTotalHits()>0){
            return response;
        }

        // 创建查询索引
        SearchRequestBuilder searchRequestBuilder = esManager.getESClient().prepareSearch(alis);

        // 设置查询条件
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.matchQuery(key,value).minimumShouldMatch("100%"));


        // 设置查询索引类型
        searchRequestBuilder.setTypes(type);
        searchRequestBuilder.setSearchType(SearchType.DFS_QUERY_THEN_FETCH);
        searchRequestBuilder.setQuery(boolQueryBuilder);
//        searchRequestBuilder.setQuery(QueryBuilders.matchQuery("content",q));
        // 设置查询数据的位置,分页用吧
        searchRequestBuilder.setFrom(0);
        // 设置查询结果集的最大条数
        searchRequestBuilder.setSize(10);
        // 设置是否按查询匹配度排序
        searchRequestBuilder.setExplain(true);
        System.out.println(searchRequestBuilder.toString());
        // 最后就是返回搜索响应信息
        return searchRequestBuilder.execute().actionGet();
    }

    @Override
    public SearchResponse searchDataByKeys(SearchRequest searchRequest) {

        BoolFilterBuilder filter = FilterBuilders.boolFilter();
        buildNestedQueryBuilder(filter,searchRequest.getSearchFieldList());
        // 搜索
        QueryBuilder query = QueryBuilders.filteredQuery(null, filter);
        SearchRequestBuilder searchRequestBuilder = esManager.getESClient()
                .prepareSearch(searchRequest.getAlis()).setTypes(searchRequest.getType()).setQuery(query);

        return searchRequestBuilder.execute().actionGet();
    }

    /**
     * 构建内嵌查询
     *
     * @param filterBuilder 查询条件
     * @param searchFieldList 内嵌查询请求参数
     */
    private void buildNestedQueryBuilder(FilterBuilder filterBuilder,
                                         List<SearchField> searchFieldList) {
        if (searchFieldList != null) {
            BoolFilterBuilder boolFilterBuilder = (BoolFilterBuilder) filterBuilder;
            for (SearchField searchField : searchFieldList) {
                // 暂时使用math查询
                MultiMatchQueryBuilder matchQuery = QueryBuilders.multiMatchQuery(searchField.getValue(),
                        buildMultiQueryKey(searchField));
                NestedFilterBuilder nestQueryBuilder = FilterBuilders
                        .nestedFilter(searchField.getNestedType(), matchQuery);
                boolFilterBuilder.must(nestQueryBuilder);
            }
        }
    }

    /**
     * 构建内嵌查询关键字的key
     * @param searchField
     * @return 组装的key
     */
    private String buildMultiQueryKey(SearchField searchField) {
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<5;i++) {
            sb.append(searchField.getNestedType() + ".");
            sb.append("key"+i);
            if(i!=4) {
                sb.append(",");
            }
        }
        return sb.toString();
    }
}
