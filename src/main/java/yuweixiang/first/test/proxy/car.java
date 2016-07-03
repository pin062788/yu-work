package yuweixiang.first.test.proxy;

/**
 * 实现类
 *
 * @author yuweixiang
 * @version $ Id: car.java, v 0.1 16/6/30 下午2:35 yuweixiang Exp $
 */
public class car implements IVehical {

    @Override
    public void run() {
        System.out.println("实现方法..:car is running");
    }
}
