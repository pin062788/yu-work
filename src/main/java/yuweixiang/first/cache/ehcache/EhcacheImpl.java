package yuweixiang.first.cache.ehcache;


import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * @author yuweixiang
 * @version $ Id: yu-work, v 0.1 16/4/3 下午8:38 yuweixiang Exp $
 */
public class EhcacheImpl implements Ehcache {

    /** 缓存 */
    @Resource
    private Cache ehcacheFactory;

    @Override
    public void putValue(String key, String value) {
        try {
            Element element = new Element(key, (Serializable) value);
            ehcacheFactory.put(element);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String getValue(String key) {
        Element element =  ehcacheFactory.get(key);
        if(element==null){
            return null;
        }
        return (String) element.getObjectValue();
    }
}
