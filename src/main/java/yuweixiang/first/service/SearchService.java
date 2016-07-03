package yuweixiang.first.service;

import yuweixiang.first.result.search.SearchResult;

/**
 * 搜索服務
 *
 * Created by yuweixiang on 16/1/13.
 */
public interface SearchService {

    /**
     * 搜索實現類,根据关键字搜索所需要的结果
     *
     * @param keyWord 关键字
     * @return 返回搜索结果
     */
    public SearchResult search(String keyWord);
}
