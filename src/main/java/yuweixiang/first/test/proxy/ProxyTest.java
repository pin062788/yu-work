package yuweixiang.first.test.proxy;

import java.lang.reflect.Proxy;

/**
 * 代理类测试
 *
 * @author yuweixiang
 * @version $ Id: ProxyTest.java, v 0.1 16/6/30 下午2:33 yuweixiang Exp $
 */
public class ProxyTest {

    public static void main(String args[]) {
        car proxyInterface = new car();
        VehicalInvacationHandler handler = new VehicalInvacationHandler(proxyInterface);

        IVehical proxyClass = (IVehical) Proxy.newProxyInstance(IVehical.class.getClassLoader(),
            new Class[] { IVehical.class }, handler);
        proxyClass.run();
    }
}
