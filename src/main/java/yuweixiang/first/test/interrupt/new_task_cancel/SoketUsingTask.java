package yuweixiang.first.test.interrupt.new_task_cancel;

import org.apache.poi.ss.formula.functions.T;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/**
 * 对soket非标准异常进行处理
 *
 * @author yuweixiang
 * @version $ Id: SoketUsingTask.java, v 0.1 16/7/5 上午10:36 yuweixiang Exp $
 */
public class SoketUsingTask implements CancelCallableTask{

    private Socket socket;

    SoketUsingTask(Socket socket){
        this.socket = socket;
    }

    @Override
    public void cancel() {
        try{
            if (socket!=null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {

            public boolean cancel(boolean mayInterruptIfRunning){
                try {
                    SoketUsingTask.this.cancel();
                }finally {
                    return super.cancel(mayInterruptIfRunning);
                }
            }
        };
    }

    @Override
    public Object call() throws Exception {
        return "socketcancel";
    }
}
