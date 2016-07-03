package yuweixiang.first.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import yuweixiang.first.service.HelloWorldService;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 任意测试使用
 *
 * @author yuweixiang
 * @version $ Id: AnyTest.java, v 0.1 16/7/3 下午11:08 yuweixiang Exp $
 */
public class AnyTest {

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
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/spring-service.xml");
        HelloWorldService helloWorldService = (HelloWorldService)applicationContext.getBean("helloWorldService");
        System.out.println("here");
    }
}
