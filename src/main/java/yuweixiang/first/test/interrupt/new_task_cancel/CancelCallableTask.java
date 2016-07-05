package yuweixiang.first.test.interrupt.new_task_cancel;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

/**
 * 使用newtaskfor封装非标准取消
 *
 * @author yuweixiang
 * @version $ Id: CancelCallableTask.java, v 0.1 16/7/5 上午10:25 yuweixiang Exp $
 */
public interface CancelCallableTask<T> extends Callable<T>{
    void cancel();
    RunnableFuture<T> newTask();
}
