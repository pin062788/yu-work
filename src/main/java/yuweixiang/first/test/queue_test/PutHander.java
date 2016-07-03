package yuweixiang.first.test.queue_test;

/**
 * 放数据
 *
 * @author yuweixiang
 * @version $ Id: PutHander.java, v 0.1 16/7/3 上午12:40 yuweixiang Exp $
 */
public class PutHander implements Runnable{
    private volatile Throwable t;
    private MyQueue myQueue;

    public PutHander(MyQueue myQueue){
        this.myQueue = myQueue;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                myQueue.put(i);
            } catch (Throwable t) {
                this.t = t;
            }
        }
    }

    public void rethrow() {
        if (t != null) {
            throw new RuntimeException(t);
        }
    }
}
