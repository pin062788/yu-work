package yuweixiang.first.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import yuweixiang.first.spider.BfsSpider;
import yuweixiang.first.search.ESClient;
import yuweixiang.first.search.ESManager;

import javax.annotation.Resource;

/**
 * User: <a href="mailto:lenolix@163.com">李星</a> Version: 1.0.0 Since: 14/11/6
 * 下午12:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/META-INF/spring/spring-service.xml","classpath:/META-INF/spring/mybatis.xml" })
public class BaseTest {

    @Resource
    protected ESManager esManager;

    @Resource
    protected BfsSpider bfsSpider;

    @Resource
    protected ESClient esClient;
}
