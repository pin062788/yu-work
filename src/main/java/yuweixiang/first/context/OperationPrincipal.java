/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.context;

import java.io.Serializable;
import java.security.Principal;
import java.util.Date;

/**
 * 一个适用于身份标识类.
 * 
 * <p>
 * 引入这个类的目的是提供一个统一的“大而全”的类，用于在支付宝的所有系统间标识用户身份。 不同的应用根据自已的需求可以只使用其中的一部分。
 * 
 * @author wb-yuweixiang
 * @version $Id: OperationPrincipal.java, v 0.1 2014-9-25 下午04:12:37 wb-yuweixiang Exp $
 */
public class OperationPrincipal implements Serializable, Principal {

    /** 序列号 */
    private static final long serialVersionUID = -9096711279710049612L;

    /** 登录ID */
    private String            logonId;

    /** 用户的名称，前台操作是用户真实姓名，后台操作是管理员昵称 */
    private String            userName;

    /** 用户ID，前台操作是用户ID，后台操作是管理员ID */
    private String            userId;

    /** 日期 */
    private Date              time;

    /**
     * Getter method for property <tt>logonId</tt>.
     * 
     * @return property value of logonId
     */
    public String getLogonId() {
        return logonId;
    }

    /**
     * Setter method for property <tt>logonId</tt>.
     * 
     * @param logonId value to be assigned to property logonId
     */
    public void setLogonId(String logonId) {
        this.logonId = logonId;
    }

    /**
     * Getter method for property <tt>userName</tt>.
     * 
     * @return property value of userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Setter method for property <tt>userName</tt>.
     * 
     * @param userName value to be assigned to property userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Getter method for property <tt>userId</tt>.
     * 
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     * 
     * @param userId value to be assigned to property userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Getter method for property <tt>time</tt>.
     * 
     * @return property value of time
     */
    public Date getTime() {
        return time;
    }

    /**
     * Setter method for property <tt>time</tt>.
     * 
     * @param time value to be assigned to property time
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /** 
     * @see Principal#getName()
     */
    public String getName() {
        return "u_" + getUserId();
    }
}
