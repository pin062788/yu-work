package yuweixiang.first.item;

import java.io.Serializable;

/**
 * Created by yuweixiang on 16/1/14.
 */
public class SearchItem implements Serializable {

    /** 序列号 */
    private static final long serialVersionUID = -1;

    /** 标题 */
    private String title;

    /** url */
    private String url;

    /** 详细描述 */
    private String context;

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
