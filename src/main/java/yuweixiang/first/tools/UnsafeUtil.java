package yuweixiang.first.tools;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * unsafe帮助类
 *
 * @author yuweixiang
 * @version $ Id: UnsafeUtil.java, v 0.1 16/7/7 下午10:10 yuweixiang Exp $
 */
public class UnsafeUtil {

    /**
     * 获得不安全Unsafe对象
     *
     * @return Unsafe对象
     */
    public static Unsafe getUnsafe()throws Exception{
        try{
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return  (Unsafe) field.get(null);
        }catch(IllegalArgumentException e){
            throw e;
        }catch (SecurityException e){
            throw e;
        }catch (NoSuchFieldException e){
            throw e;
        }catch (IllegalAccessError e){
            throw e;
        }
    }
}
