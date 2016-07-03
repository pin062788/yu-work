package yuweixiang.first.test.interrupt;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 中断线程测试
 *
 * @author yuweixiang
 * @version $ Id: InterruptThreadTest.java, v 0.1 16/7/2 下午10:40 yuweixiang Exp $
 */
public class InterruptThreadTest {

    private static int timeout = 3000;

    private static ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

    public static void timeRun() throws InterruptedException{
        class RethrowableTask implements Runnable{
            private volatile Throwable t;
            @Override
            public void run() {
                try{
                    System.out.println("time Run");
                    throw new RuntimeException("aa");
                }catch(Throwable t){
                    System.out.println("exception");
                    this.t = t;
                }
            }
            void rethrew(){
                if (t!=null){
                    System.out.println("rethrew");
                    throw new RuntimeException(t);
                }
            }
        }
        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        },timeout, TimeUnit.MILLISECONDS);
        taskThread.join(timeout);
        task.rethrew();
        System.out.println("over");
    }

    public static void main(String args[]){
        try{
            InterruptThreadTest.timeRun();
            System.exit(1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
