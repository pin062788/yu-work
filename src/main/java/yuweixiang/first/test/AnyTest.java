package yuweixiang.first.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yuweixiang.first.util.LoggerUtil;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 任意测试使用
 *
 * @author yuweixiang
 * @version $ Id: AnyTest.java, v 0.1 16/7/3 下午11:08 yuweixiang Exp $
 */
public class AnyTest {

    /** 日志 */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AnyTest.class);

    private int num;

    private  AnyTest anyTest1 = new AnyTest(1);

    private static AnyTest anyTest;

    private AnyTest(int num){
        this.num = num;
    }

    public static AnyTest getAnyTest(int num){
        ReadWriteLock lock = new ReentrantReadWriteLock();
        lock.writeLock();
        try {

            if (anyTest == null) {
                {
                    if (anyTest == null) {
                        anyTest = new AnyTest(num);
                    }
                }
            }
        }finally {
            lock.writeLock().unlock();
        }
        return anyTest;
    }

    public static void main(String args[]){
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/spring-service.xml");
//        HelloWorldService helloWorldService = (HelloWorldService)applicationContext.getBean("helloWorldService");
//        System.out.println("here");
        System.out.println((-1<<29) | 0);
        LoggerUtil.info(LOGGER,"anyTest");
    }
}
