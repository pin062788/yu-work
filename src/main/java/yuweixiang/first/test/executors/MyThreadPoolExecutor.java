package yuweixiang.first.test.executors;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 我的线程池执行器
 *
 * @author yuweixiang
 * @version $ Id: MyThreadPoolExecutor.java, v 0.1 16/7/9 上午12:07 yuweixiang Exp $
 */
public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    ThreadLocal<Long> timer = new ThreadLocal<Long>();

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime,
                                TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    @Override
    public void beforeExecute(Thread t, Runnable r) {
        timer.set(System.currentTimeMillis());
        System.out.println(this.getClass().getName() + ",beforExecute");
    }

    @Override
    public void afterExecute(Runnable r, Throwable t) {
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        long useTime = System.currentTimeMillis() - timer.get();
        System.out.println(this.getClass().getName() + ",afterExecute,threadTime:"+useTime);
    }

    @Override
    public void terminated() {
        System.out.println(this.getClass().getName() + ",terminated");
    }
}
