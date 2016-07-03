package yuweixiang.first.test.annotation;

/**
 * 学生
 *
 * @author yuweixiang
 * @version $ Id: Student.java, v 0.1 16/6/30 下午3:55 yuweixiang Exp $
 */
public class Student extends AbstractClass{

    @Name(value = "yuweixiang")
    private String name;

    /**
     * Getter method for property <tt>name</tt>.
     *
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     *
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }
}
