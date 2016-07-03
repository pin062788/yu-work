package yuweixiang.first.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 反向代理帮助类
 *
 * @author yuweixiang
 * @version $ Id: VehicalInvacationHandler.java, v 0.1 16/6/30 下午3:06 yuweixiang Exp $
 */
public class VehicalInvacationHandler implements InvocationHandler{

    private IVehical ivehial;

    VehicalInvacationHandler(IVehical ivehical){
        this.ivehial = ivehical;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before..");
        Object object = method.invoke(ivehial,args);
        System.out.println("after..");
        return object;
    }
}
