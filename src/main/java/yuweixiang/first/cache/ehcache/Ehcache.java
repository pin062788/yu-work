package yuweixiang.first.cache.ehcache;

/**
 * ehcache缓存 -支持集群,分布式缓存
 * @author yuweixiang
 * @version $ Id: yu-work, v 0.1 16/4/3 下午8:23 yuweixiang Exp $
 */
public interface Ehcache {

    /**
     * 存入数据
     *
     * @param key key值
     * @param value value值
     */
    public void putValue(String key,String value);

    /**
     * 根据key值获取缓存中数据
     *
     * @param key key
     * @return 获取结果
     */
    public String getValue(String key);
}
