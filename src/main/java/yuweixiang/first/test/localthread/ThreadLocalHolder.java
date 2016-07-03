package yuweixiang.first.test.localthread;

public class ThreadLocalHolder {

    private static final ThreadLocal<String> threadLocal1 = new ThreadLocal<String>();
    private static final ThreadLocal<String> threadLocal2 = new ThreadLocal<String>();

    public static void setThreadLocal1(String s){
        threadLocal1.set(s);
    }

    public static String getThreadLocal1(){
        return threadLocal1.get();
    }

    public static void setThreadLocal2(String s){
        threadLocal2.set(s);
    }

    public static String getThreadLocal2(){
        return threadLocal2.get();
    }
}
