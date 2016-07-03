package yuweixiang.first.test.finalTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * final测试类
 *
 * @author yuweixiang
 * @version $ Id: Holder.java, v 0.1 16/6/24 上午12:53 yuweixiang Exp $
 */
public class Holder {

    private final int n;

    public Holder(int n){
        this.n = n;
    }

    public void assertSanity(){
        if (n!=n){
            System.out.println("here");
        }
    }

    public int getN(){
        return n;
    }

    public static void main(String args[]){
        List<String> list = Collections.synchronizedList(new ArrayList<String>());
        list.add("a");
        System.out.println(list);
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
