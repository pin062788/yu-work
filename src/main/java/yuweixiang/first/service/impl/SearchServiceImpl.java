package yuweixiang.first.service.impl;


import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import yuweixiang.first.item.SearchItem;
import yuweixiang.first.result.search.SearchResult;
import yuweixiang.first.search.ESClient;
import yuweixiang.first.service.SearchService;
import yuweixiang.first.template.HelloWorldServiceTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 搜索服务实现类
 *
 * Created by yuweixiang on 16/1/13.
 */
public class SearchServiceImpl extends HelloWorldServiceTemplate implements SearchService {

    /** es管理器 */
    @Resource
    private ESClient esClient;


    public SearchResult search(final String keyWord){

        final SearchResult result  = new SearchResult();
        processWithNoTrasaction(result, new BusinessProcess() {
            @Override
            public void doProcess() {

                List<SearchItem> searchItemList = searchDetail(keyWord);
                result.setSearchItemList(searchItemList);
                result.setTotalAmount(searchItemList.size());
                buildSuccessResult(result);

            }
        });
        return result;
    }

    /**
     * 搜索
     *
     * @param q 条件
     */
    private List<SearchItem> searchDetail(String q) {

        List<SearchItem> searchItemList = new ArrayList<SearchItem>();
        SearchResponse response = esClient.searchData("search","searchItem","title",q);
        SearchResponse response1 = esClient.searchData("search","searchItem","url",q);
        buildSearchResult(searchItemList,response);
        buildSearchResult(searchItemList,response1);
        return searchItemList;
    }

    /**
     * 组装搜索结果
     *
     * @param searchItemList 结果集
     * @param response 查询结果
     */
    private void buildSearchResult(List<SearchItem> searchItemList,SearchResponse response){
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        for (int i = 0; i < hits.length; i++) {
            SearchItem searchItem = new SearchItem();
            SearchHit hit = hits[i];
            Map result = hit.getSource();
            searchItem.setContext(String.valueOf(result.get("context")));
            searchItem.setTitle(String.valueOf(result.get("title")));
            searchItem.setUrl(String.valueOf(result.get("url")));
            searchItemList.add(searchItem);
        }
    }
}
