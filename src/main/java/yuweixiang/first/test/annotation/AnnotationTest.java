package yuweixiang.first.test.annotation;

/**
 * 测试类
 *
 * @author yuweixiang
 * @version $ Id: AnnotationTest.java, v 0.1 16/6/30 下午3:55 yuweixiang Exp $
 */
public class AnnotationTest {

    public static void main(String args[]){

        Student student = new Student();
        System.out.println(student.getAnnotation(student.getClass(),Name.class));
    }
}
