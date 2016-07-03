package yuweixiang.first.domain;

import java.io.Serializable;

/**
 * 搜索对象
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.domain, v 0.1 16/5/13 下午6:55 yuweixiang Exp $
 */
public class Search implements Serializable{

    /** 序列号 */
    private static final long serialVersionUID = -8944377795558344347L;

    /** 标题 */
    private String title;

    /** url */
    private String url;

    /** 详细描述 */
    private String context;

    /** 查询关键字 */
    private KeyWords keyWords = new KeyWords();

    /** 权重,数值越大权重越大 */
    private int priority;

    /**
     * Getter method for property <tt>title</tt>.
     *
     * @return property value of title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setter method for property <tt>title</tt>.
     *
     * @param title value to be assigned to property title
     */
    public Search setTitle(String title) {
        this.title = title;
        return this;
    }

    /**
     * Getter method for property <tt>url</tt>.
     *
     * @return property value of url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Setter method for property <tt>url</tt>.
     *
     * @param url value to be assigned to property url
     */
    public Search setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Getter method for property <tt>context</tt>.
     *
     * @return property value of context
     */
    public String getContext() {
        return context;
    }

    /**
     * Setter method for property <tt>context</tt>.
     *
     * @param context value to be assigned to property context
     */
    public Search setContext(String context) {
        this.context = context;
        return this;
    }

    /**
     * Getter method for property <tt>keyWords</tt>.
     *
     * @return property value of keyWords
     */
    public KeyWords getKeyWords() {
        return keyWords;
    }

    /**
     * Setter method for property <tt>keyWords</tt>.
     *
     * @param keyWords value to be assigned to property keyWords
     */
    public Search setKeyWords(KeyWords keyWords) {
        this.keyWords = keyWords;
        return this;
    }

    /**
     * Getter method for property <tt>priority</tt>.
     *
     * @return property value of priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Setter method for property <tt>priority</tt>.
     *
     * @param priority value to be assigned to property priority
     */
    public Search setPriority(int priority) {
        this.priority = priority;
        return this;
    }
}
