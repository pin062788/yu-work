package yuweixiang.first.test.annotation;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共类
 *
 * @author yuweixiang
 * @version $ Id: AbstractClass.java, v 0.1 16/6/30 下午3:57 yuweixiang Exp $
 */
public class AbstractClass {

    protected String getAnnotation(Class clazz,Class clazz2) {
//        Class rt_class = Class.forName("com.magc.annotation.Utility");
        Map<String,String> map = new HashMap<String,String>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(Name.class)) {
                System.out.println(field.getAnnotation(clazz2).getClass().getDeclaredFields());
                return field.getAnnotation(Name.class).value();
            }
        }
        return null;
    }
}
