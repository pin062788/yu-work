package yuweixiang.first.test;

import org.junit.Test;
import yuweixiang.first.cache.ehcache.Ehcache;

import javax.annotation.Resource;

/**
 * ehcache缓存测试
 *
 * @author yuweixiang
 * @version $ Id: yu-work, v 0.1 16/4/3 下午8:45 yuweixiang Exp $
 */
public class EhcacheTest extends BaseTest{

    @Resource
    private Ehcache ehcache;

    @Test
    public void testEhcache(){
        ehcache.putValue("aa","aa");
        System.out.println(ehcache.getValue("aa"));
    }



}
