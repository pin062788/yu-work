package yuweixiang.first.test.cas;

import java.util.concurrent.atomic.AtomicReference;

/**
 * CAS改变对象,改变对象中的一个值
 *
 * @author yuweixiang
 * @version $ Id: CASChangeObject.java, v 0.1 16/7/21 下午10:42 yuweixiang Exp $
 */
public class CASChangeObject {

    private class IntPair{
        private int low;
        private int upper;
        IntPair(int low,int upper){
            this.low =low;
            this.upper = upper;
        }
        private int getLow(){
            return this.low;
        }
        private int getUpper(){
            return this.upper;
        }
    }
    public IntPair getIntPair(){
        return intPairAtomic.get();
    }
    private final AtomicReference<IntPair> intPairAtomic = new AtomicReference<>(new IntPair(0,100));
    public void setLow(int i){
        while (true) {
            IntPair inpir = intPairAtomic.get();
            if (i > inpir.getUpper()) {
                throw new RuntimeException("数值太大");
            }
            IntPair newIntPair = new IntPair(i, inpir.getUpper());
            if (intPairAtomic.compareAndSet(inpir, newIntPair)) {
                return;
            }
        }
    }

    public static void main(String args[]){
        CASChangeObject casChangeObject = new CASChangeObject();
        casChangeObject.setLow(10);
        System.out.println(casChangeObject.getIntPair().getLow());
    }
}
