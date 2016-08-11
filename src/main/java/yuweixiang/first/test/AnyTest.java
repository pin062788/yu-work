package yuweixiang.first.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import yuweixiang.first.util.DateUtil;

import java.util.concurrent.atomic.AtomicReference;
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

    private static AtomicReference<AnyTest> anyTest1 = new AtomicReference<AnyTest>();

    private static AnyTest anyTest;

    private AnyTest(int num){
        this.num = num;
    }

    public static AnyTest getAnyTest1(){
        AnyTest a = new AnyTest(2);
        if (anyTest1.compareAndSet(null,a)){
            return a;
        }else{
            return anyTest1.get();
        }
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
//        AnyTest a = AnyTest.getAnyTest1();
//        AnyTest b = AnyTest.getAnyTest1();
//        System.out.println(a==b);
        System.out.println(DateUtil.getLongDatetime(DateUtil.NEW_DATE_FORMAT_OUTPUT_TIME,"2016-08-03 00:23:23"));
        System.out.println(DateUtil.getLongDateToDate(1469917889,DateUtil.NEW_DATE_FORMAT_OUTPUT_TIME));
//        int i=0;
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/spring-service.xml");
//        HelloWorldService helloWorldService = (HelloWorldService)applicationContext.getBean("helloWorldService");
//        System.out.println("here");
//        System.out.println((-1<<29) | 0);
//        System.out.println( i |= 3);
//        LoggerUtil.info(LOGGER,"anyTest");
//        KeyWords keywords = new KeyWords();
//        JSONObject.toJSONString(keywords);
    }
}
