package yuweixiang.first.test.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 执行测试类
 *
 * @author yuweixiang
 * @version $ Id: FutureExecutorsTest.java, v 0.1 16/6/27 下午8:19 yuweixiang Exp $
 */
public class FutureExecutorsTest {

    /**
     * 挨个轮训,使用countDown控制执行结果
     *
     * @param threadNum
     * @throws Exception
     */
    public void testExecutors(int threadNum) throws Exception {

        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(threadNum);

        Callable<String> run = new Callable<String>() {
            @Override
            public String call() {
                try {
                    startGate.await();
                    System.out
                        .println("time:" + System.currentTimeMillis() + ",start a new thread,id:"
                                 + Thread.currentThread().getId() + ",threadNum:" + threadNum);
                    return "aa";
                } catch (Exception e) {
                    e.printStackTrace();
                    return "";
                } finally {
                    endGate.countDown();
                }
            }
        };

        List<FutureTask<String>> list = new ArrayList<FutureTask<String>>();
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 4; i++) {
            FutureTask<String> futureTask = new FutureTask<String>(run);
            list.add(futureTask);
            cachedThreadPool.submit(futureTask);
        }

        startGate.countDown();
        endGate.await();
        for (FutureTask<String> futureTask : list) {
            System.out.println(futureTask.get());
        }
    }

    /***
     * 使用一次调用所有来处理,设置超时时间
     *
     * @param threadNum
     */
    public void testInvokeAllExecutors(int threadNum) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Task1> tasks = new ArrayList<Task1>();
        for (int i = 0; i < threadNum; i++) {
            tasks.add(new Task1());
        }
        List<Future<String>> taskList = executorService.invokeAll(tasks, 1000,
            TimeUnit.MILLISECONDS);
        for (Future<String> futureTask : taskList) {
            String ss = futureTask.get();
            System.out.println(ss);
        }
    }

    private class Task1 implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("task:" + Thread.currentThread().getId() + ",name:"
                               + Thread.currentThread().getName());
            return "bb";
        }
    }

    public static void main(String args[]) throws Exception {
        FutureExecutorsTest executorsTest = new FutureExecutorsTest();
        executorsTest.testExecutors(4);
        executorsTest.testInvokeAllExecutors(4);

    }

}
