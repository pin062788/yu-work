package yuweixiang.first.request.search;

import yuweixiang.first.domain.SearchField;
import yuweixiang.first.request.BaseRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * 搜索请求参数
 *
 * @author yuweixiang
 * @version $ Id: yu-work, v 0.1 16/5/8 下午11:36 yuweixiang Exp $
 */
public class SearchRequest extends BaseRequest{

    /** 别名 */
    private String alis;

    /** 类型 */
    private String type;

    /** 搜索域集合 */
    List<SearchField> searchFieldList = new ArrayList<SearchField>();

    public String getAlis() {
        return alis;
    }

    public void setAlis(String alis) {
        this.alis = alis;
    }

    public List<SearchField> getSearchFieldList() {
        return searchFieldList;
    }

    public void setSearchFieldList(List<SearchField> searchFieldList) {
        this.searchFieldList = searchFieldList;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
