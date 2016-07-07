package yuweixiang.first.test.cas;

import yuweixiang.first.tools.UnsafeUtil;

/**
 * cas测试类
 *
 * @author yuweixiang
 * @version $ Id: CASTest.java, v 0.1 16/7/7 下午6:40 yuweixiang Exp $
 */
public class CASTest {

    private static class Node<E> {

        volatile E                           item;

        volatile Node<E>                     next;

        private static final long            itemOffSet;
        private static final long            nextOffSet;

        static {
            try {
                itemOffSet = UnsafeUtil.getUnsafe().objectFieldOffset(Node.class.getDeclaredField("item"));
                nextOffSet = UnsafeUtil.getUnsafe().objectFieldOffset(Node.class.getDeclaredField("next"));
            } catch (Exception e) {
                throw new Error(e);
            }
        }

        public void castNode(Node node, Node next) throws Exception{
            UnsafeUtil.getUnsafe().compareAndSwapObject(this, nextOffSet, node, next);
        }
    }

    public static void main(String args[]) throws Exception{
        CASTest casTest = new CASTest();
        Node<String> node = new Node<String>();
        node.item = "a";
        node.castNode(null, node);
        System.out.println(node.item);
    }
}
