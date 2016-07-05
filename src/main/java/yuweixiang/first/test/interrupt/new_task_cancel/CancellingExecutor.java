package yuweixiang.first.test.interrupt.new_task_cancel;

import java.util.concurrent.*;

/**
 * 取消执行器
 *
 * @author yuweixiang
 * @version $ Id: CancellingExecutor.java, v 0.1 16/7/5 上午10:27 yuweixiang Exp $
 */
public class CancellingExecutor extends ThreadPoolExecutor{

    public CancellingExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public <T> RunnableFuture<T> newTaskFor(Callable<T> callable){
        if (callable instanceof CancelCallableTask){
            return ((CancelCallableTask<T>)callable).newTask();
        }else {
            return super.newTaskFor(callable);
        }
    }
}
