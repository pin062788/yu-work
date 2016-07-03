/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.result;

/**
 * 用户查询结果集
 * 
 * @author wb-yuweixiang
 * @version $Id: QueryUserResult.java, v 0.1 2014-9-12 下午05:42:02 wb-yuweixiang Exp $
 */
public class QueryUserResult extends BaseResult {

    /** 序列号 */
    private static final long serialVersionUID = -2443571179517975698L;

    /** 用户姓名 */
    private String            userName;

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
}
