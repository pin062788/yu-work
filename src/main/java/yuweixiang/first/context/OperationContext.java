/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.context;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Date;

/**
 * 操作上下文
 * @author wb-yuweixiang
 * @version $Id: OperationContext.java, v 0.1 2014-9-25 下午04:17:40 wb-yuweixiang Exp $
 */
public class OperationContext implements Authentication {

    /** 序列号 */
    private static final long  serialVersionUID = -3360532632275632658L;

    /** 操作员主体 */
    private OperationPrincipal principal;

    /** 操作时间 */
    private Date               time;

    /**
     * 构造方法。
     * 
     * @param principal
     * @param 
     */
    public OperationContext(OperationPrincipal principal) {
        this.principal = principal;
        this.time = new Date();
    }

    /** 
     * @see org.springframework.security.core.Authentication#getAuthorities()
     */
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    /** 
     * @see org.springframework.security.core.Authentication#getCredentials()
     */
    public Object getCredentials() {
        return null;
    }

    /** 
     * @see org.springframework.security.core.Authentication#getDetails()
     */
    public Object getDetails() {
        return null;
    }

    /** 
     * @see org.springframework.security.core.Authentication#getPrincipal()
     */
    public Object getPrincipal() {
        return principal;
    }

    /** 
     * @see org.springframework.security.core.Authentication#isAuthenticated()
     */
    public boolean isAuthenticated() {
        return false;
    }

    /** 
     * @see org.springframework.security.core.Authentication#setAuthenticated(boolean)
     */
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    }

    /** 
     * @see java.security.Principal#getName()
     */
    public String getName() {
        return null;
    }

    /**
     * Setter method for property <tt>principal</tt>.
     * 
     * @param principal value to be assigned to property principal
     */
    public void setPrincipal(OperationPrincipal principal) {
        this.principal = principal;
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
}
