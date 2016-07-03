package yuweixiang.first.test.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 任务调度线程启动测试器,TimerTask内部只有一个线程,所以是按照顺序执行的.并且第一个异常会影响第二个异常
 *
 * @author yuweixiang
 * @version $ Id: ScheduledThreadPoolTest.java, v 0.1 16/6/29 上午11:29 yuweixiang Exp $
 */
public class ScheduledThreadPoolTest {

    public static long start = System.currentTimeMillis();

    private void testScheduledThread() {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(44);
        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("task1 invoked : " + (System.currentTimeMillis() - start));
                    //                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("task2 invoked : " + (System.currentTimeMillis() - start));
                    //                    Thread.sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        // 延迟多久后,循环执行
        executor.scheduleAtFixedRate(task1, 1000,1000, TimeUnit.MILLISECONDS);
        // 延迟执行
        executor.schedule(task2, 3000, TimeUnit.MILLISECONDS);
    }

    public static void main(String args[]) {
        ScheduledThreadPoolTest scheduledThreadPoolTest = new ScheduledThreadPoolTest();
        scheduledThreadPoolTest.testScheduledThread();
    }
}
