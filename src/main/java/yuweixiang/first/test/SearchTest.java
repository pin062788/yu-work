package yuweixiang.first.test;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.junit.Test;
import yuweixiang.first.item.SearchItem;
import yuweixiang.first.result.search.SearchResult;
import yuweixiang.first.service.SearchService;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by yuweixiang on 16/1/26.
 */
public class SearchTest extends BaseTest {

    @Resource
    private SearchService searchService;

    @Test
    public void testSearch(){

        SearchResult result = searchService.search("www.csdn.net");
        System.out.print(result.getSearchItemList().get(0).getTitle());
    }

    @Test
    public void testSearchData(){
        SearchResponse response = esClient.searchData("search","searchItem","url","http://www.baidu.com/");
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        if(response.getHits().getHits().length>0){
            for (int i = 0; i < hits.length; i++) {
                SearchItem searchItem = new SearchItem();
                SearchHit hit = hits[i];
                Map result = hit.getSource();
               System.out.println("result:"+result);
            }
        }
    }

    @Test
    public void testOrderSearch(){
        SearchResponse response = esClient.searchData("haitao","employee","orderId","1201511232011042665");
        SearchHits searchHits = response.getHits();
        SearchHit[] hits = searchHits.getHits();
        if(response.getHits().getHits().length>0){
            for (int i = 0; i < hits.length; i++) {
                SearchHit hit = hits[i];
                Map result = hit.getSource();
                System.out.println("result:"+result);
            }
        }
    }
}
