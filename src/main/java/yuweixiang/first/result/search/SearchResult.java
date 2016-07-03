package yuweixiang.first.result.search;


import yuweixiang.first.item.SearchItem;
import yuweixiang.first.result.BaseResult;

import java.util.List;

/**
 * 搜索結果對象
 *
 * Created by yuweixiang on 16/1/13.
 */
public class SearchResult extends BaseResult {

    /** 搜索item结果 */
    private List<SearchItem> searchItemList;

    /** 总数 */
    private int totalAmount;

    public void setSearchItemList(List<SearchItem> searchItemList) {
        this.searchItemList = searchItemList;
    }

    public List<SearchItem> getSearchItemList() {
        return searchItemList;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
