package yuweixiang.first.test.atomic;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * @author yuweixiang
 * @version $ Id: yu-work, v 0.1 16/4/3 下午10:53 yuweixiang Exp $
 */
public class AtomicLongFieldUpdaterTest {

    public static void main(String[] args) {

        // 获取Person的class对象
        Class cls = Person.class;
        // 新建AtomicLongFieldUpdater对象，传递参数是“class对象”和“long类型在类中对应的名称”
        AtomicLongFieldUpdater<Person> mAtoLong = AtomicLongFieldUpdater.newUpdater(cls, "id");
        Person person = new Person(12345678L);

        // 比较person的"id"属性，如果id的值为12345678L，则设置为1000。
        mAtoLong.set(person, 1000);
        System.out.println("id=" + person.getId());
    }
}
