package yuweixiang.first.util;

import java.util.function.Predicate;

/**
 * 预测工具类
 *
 * @author yuweixiang
 * @version $ Id: PredicateUtil.java, v 0.1 16/6/20 上午11:47 yuweixiang Exp $
 */
public class PredicateUtil {

    public boolean isEmpty(String str){
        Predicate<String> predicate = String::isEmpty;
        return predicate.test(str);
    }

    public boolean isLength(String str){
        Predicate<String> predicate = (s) -> s.length() > 0;
        return predicate.test(str);
    }

    public static void main(String args[]){
        PredicateUtil util = new PredicateUtil();
        System.out.println(util.isEmpty(""));
        System.out.println(util.isLength("a"));
    }
}
