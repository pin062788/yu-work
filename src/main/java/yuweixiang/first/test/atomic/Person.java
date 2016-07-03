package yuweixiang.first.test.atomic;

/**
 * 测试使用类
 *
 * @author yuweixiang
 * @version $ Id: yu-work, v 0.1 16/4/3 下午10:54 yuweixiang Exp $
 */
public class Person {
    volatile long id;

    public Person(long id) {
        this.id = id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
