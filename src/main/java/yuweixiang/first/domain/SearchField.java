package yuweixiang.first.domain;

import java.io.Serializable;

/**
 * 搜索字段条件
 * @author yuweixiang
 * @version $ Id: yu-work, v 0.1 16/5/8 下午11:39 yuweixiang Exp $
 */
public class SearchField implements Serializable{

    /** 序列号 */
    private static final long serialVersionUID = 9082853401569772909L;

    /** 内嵌类型 */
    private String nestedType;

    /** 查询条件对应的key */
    private String key;

    /** 值 */
    private String value;

    /**
     * Getter method for property <tt>nestedType</tt>.
     *
     * @return property value of nestedType
     */
    public String getNestedType() {
        return nestedType;
    }

    /**
     * Setter method for property <tt>nestedType</tt>.
     *
     * @param nestedType value to be assigned to property nestedType
     */
    public SearchField setNestedType(String nestedType) {
        this.nestedType = nestedType;
        return this;
    }

    /**
     * Getter method for property <tt>key</tt>.
     *
     * @return property value of key
     */
    public String getKey() {
        return key;
    }

    /**
     * Setter method for property <tt>key</tt>.
     *
     * @param key value to be assigned to property key
     */
    public SearchField setKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * Getter method for property <tt>value</tt>.
     *
     * @return property value of value
     */
    public String getValue() {
        return value;
    }

    /**
     * Setter method for property <tt>value</tt>.
     *
     * @param value value to be assigned to property value
     */
    public SearchField setValue(String value) {
        this.value = value;
        return this;
    }
}
