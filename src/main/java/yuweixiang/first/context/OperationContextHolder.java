/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.context;

import java.util.Date;

/**
 * 上下文的本地线程hold类--当前用户
 * 
 * @author wb-yuweixiang
 * @version $Id: OperationContextHolder.java, v 0.1 2014-9-25 下午04:15:12 wb-yuweixiang Exp $
 */
public class OperationContextHolder {
    /** 本地线程 */
    private static ThreadLocal<OperationContext> contextLocal = new ThreadLocal<OperationContext>();

    /**
     * 获取转运操作上下文。
     *
     * @return 账务交易操作上下文
     */
    public static OperationContext get() {
        return contextLocal.get();
    }

    /**
     * 设置转运操作上下文。
     * 
     * @param operationContext 操作操作上下文
     */
    public static void set(OperationContext operationContext) {
        contextLocal.set(operationContext);
    }

    /**
     * 清理转运操作上下文。
     */
    public static void clear() {
        contextLocal.set(null);
    }

    /**
     * 
     * @return 用户信息
     */
    public static OperationPrincipal getPrincipal() {
        return (OperationPrincipal) contextLocal.get().getPrincipal();
    }

    /**
     * 快捷方法：取得操作时间。
     *
     * @return  获取操作时间
     */
    public static Date getTime() {
        if (get() != null) {
            return get().getTime();
        }
        return null;
    }
}
