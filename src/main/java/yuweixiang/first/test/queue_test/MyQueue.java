package yuweixiang.first.test.queue_test;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 我的队列,有界队列
 *
 * @author yuweixiang
 * @version $ Id: MyQueue.java, v 0.1 16/7/2 下午11:53 yuweixiang Exp $
 */
public class MyQueue {

    private int           capacity;

    private int           count;

    private Object[]      queue;

    private volatile int  putIndex;

    private ReentrantLock lock;

    private Condition     notFull;
    private Condition     notEmpty;

    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        lock = new ReentrantLock(true);
        notEmpty = lock.newCondition();
        notFull = lock.newCondition();
    }

    public void put(Object object) throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            count++;
            if (count >= capacity) {
                notFull.await();
            }
            queue[putIndex] = object;
            if (++putIndex == queue.length)
                putIndex--;
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            if (count == 0) {
                notEmpty.await();
            }
            Object object = queue[0];
            resetQueue();
            count--;
            notFull.signal();
            return object;
        }finally {
            lock.unlock();
        }
    }

    private void resetQueue() {
        for (int i = 0; i < queue.length; i++) {
            if (i + 1 != queue.length) {
                if (queue[i] == null && i != 0) {
                    putIndex = i - 1;
                    break;
                }
                queue[i] = queue[i + 1];
            } else {
                if (queue[i] == null) {
                    putIndex = i - 1;
                } else {
                    queue[i] = null;
                    putIndex = i;
                }
            }
        }
    }

    public static void main(String args[]) {
        MyQueue myQueue = new MyQueue(10);
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        try {
            PutHander putHandler = new PutHander(myQueue);
            Thread thread = new Thread(putHandler);
            executorService.execute(thread);

            CompletionService<Object> completionService = new ExecutorCompletionService<Object>(
                Executors.newFixedThreadPool(10));
            for (int i = 0; i < 100; i++) {
                GetHandler getHandler = new GetHandler(myQueue);
                Future<Object> futureTask = completionService.submit(getHandler);
                System.out.println(futureTask.get());
                getHandler.rethrow();
            }
            putHandler.rethrow();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
