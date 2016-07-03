package yuweixiang.first.test.queue_test;

import java.util.concurrent.Callable;

/**
 * 取数据
 *
 * @author yuweixiang
 * @version $ Id: GetHandler.java, v 0.1 16/7/3 上午12:41 yuweixiang Exp $
 */
public class GetHandler implements Callable<Object>{

    private MyQueue myQueue;

    private volatile Throwable t;

    public GetHandler(MyQueue myQueue){
        this.myQueue = myQueue;
    }
    public void rethrow() {
        if (t != null) {
            throw new RuntimeException(t);
        }
    }

    @Override
    public Object call() throws Exception {
        try {
            return myQueue.take();
        } catch (Throwable t) {
            this.t = t;
            return null;
        }
    }
}
