package yuweixiang.first.test.executors;

import java.util.concurrent.*;

/**
 * 完成执行器测试,相比futureTask优势是能够成功一个就及时返回,不用等待所有成功之后统一get
 *
 * @author yuweixiang
 * @version $ Id: CompletionExecutorsTest.java, v 0.1 16/6/28 上午11:22 yuweixiang Exp $
 */
public class CompletionExecutorsTest {

    private final ExecutorService executorService;

    CompletionExecutorsTest(ExecutorService executorService) {
        this.executorService = executorService;
    }

    void doTest(int num) {
        CompletionService<String> completionService = new ExecutorCompletionService<String>(
            executorService);
        for (int i = 0; i < num; i++) {
            completionService.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("thread:" + Thread.currentThread().getName());
                    return Thread.currentThread().getName();
                }
            });
        }
        try {
            for (int i = 0; i < num; i++) {
                Future<String> f = completionService.take();
                System.out.println(f.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        String a = "a";
        String b = "a";
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}
