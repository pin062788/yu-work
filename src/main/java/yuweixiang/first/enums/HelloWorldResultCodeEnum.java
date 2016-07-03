/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.enums;

/**
 * 结果枚举
 * 
 * @author wb-yuweixiang
 * @version $Id: HelloWorldResultCodeEnum.java, v 0.1 2014-9-12 下午05:38:57 wb-yuweixiang Exp $
 */
public enum HelloWorldResultCodeEnum {

    /***************** 公共结果码  *****************************************/
    /** 成功 */
    SUCCESS("SUCCESS", "成功"),

    /** 系统错误 */
    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),

    /** 参数非法 */
    ILLEGAL_ARGUMENT("ILLEGAL_ARGUMENT", "参数非法"),

    /** 未知异常 */
    UNKNOWN_EXCEPTION("UNKNOWN_EXCEPTION", "未知异常"),
    ;

    /** 枚举代码 */
    private String code;

    /** 枚举描述 */
    private String desc;

    /**
     * Constructors
     * 
     * @param code 结果码
     * @param desc 结果描述
     */
    private HelloWorldResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Getter method for property <tt>code</tt>.
     * 
     * @return property value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Getter method for property <tt>desc</tt>.
     * 
     * @return property value of desc
     */
    public String getDesc() {
        return desc;
    }
}
