package yuweixiang.first.domain;

/**
 * 查询关键字,默认目前有四个属性
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.domain, v 0.1 16/5/13 下午7:00 yuweixiang Exp $
 */
public class KeyWords extends Model{

    /** 第一关键字 */
    private String key1;

    /** 第二关键字 */
    private String key2;

    /** 第三关键字 */
    private String key3;

    /** 第四关键字 */
    private String key4;

    /**
     * Getter method for property <tt>key1</tt>.
     *
     * @return property value of key1
     */
    public String getKey1() {
        return key1;
    }

    /**
     * Setter method for property <tt>key1</tt>.
     *
     * @param key1 value to be assigned to property key1
     */
    public KeyWords setKey1(String key1) {
        this.key1 = key1;
        return this;
    }

    /**
     * Getter method for property <tt>key2</tt>.
     *
     * @return property value of key2
     */
    public String getKey2() {
        return key2;
    }

    /**
     * Setter method for property <tt>key2</tt>.
     *
     * @param key2 value to be assigned to property key2
     */
    public KeyWords setKey2(String key2) {
        this.key2 = key2;
        return this;
    }

    /**
     * Getter method for property <tt>key3</tt>.
     *
     * @return property value of key3
     */
    public String getKey3() {
        return key3;
    }

    /**
     * Setter method for property <tt>key3</tt>.
     *
     * @param key3 value to be assigned to property key3
     */
    public KeyWords setKey3(String key3) {
        this.key3 = key3;
        return this;
    }

    /**
     * Getter method for property <tt>key4</tt>.
     *
     * @return property value of key4
     */
    public String getKey4() {
        return key4;
    }

    /**
     * Setter method for property <tt>key4</tt>.
     *
     * @param key4 value to be assigned to property key4
     */
    public KeyWords setKey4(String key4) {
        this.key4 = key4;
        return this;
    }
}
