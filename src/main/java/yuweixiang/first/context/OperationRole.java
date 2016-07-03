/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.context;

import org.springframework.security.core.GrantedAuthority;

/**
 * 
 * @author wb-yuweixiang
 * @version $Id: OperationRole.java, v 0.1 2014-9-25 下午04:23:49 wb-yuweixiang Exp $
 */
public class OperationRole implements GrantedAuthority {

    /** 序列号 */
    private static final long serialVersionUID = 7053959118821446798L;

    /** 
     * @see org.springframework.security.core.GrantedAuthority#getAuthority()
     */
    public String getAuthority() {
        return null;
    }
}
