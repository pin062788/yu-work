package yuweixiang.first.test;

import org.junit.Test;

/**
 * Created by yuweixiang on 16/1/26.
 */
public class SpiderTest extends BaseTest{

    @Test
    public void testSpider(){

        bfsSpider.crawling(new String[]{"http://www.csdn.net"});
    }
}
