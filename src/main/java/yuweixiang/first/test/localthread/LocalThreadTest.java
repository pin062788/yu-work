package yuweixiang.first.test.localthread;

public class LocalThreadTest {

    public static void main(String args[]){
        System.out.println("start");
        ThreadLocalHolder.setThreadLocal1("1");
        System.out.println(ThreadLocalHolder.getThreadLocal1());
        ThreadLocalHolder.setThreadLocal2("2");
        System.out.println(ThreadLocalHolder.getThreadLocal2());
        System.out.println("end");
    }
}
