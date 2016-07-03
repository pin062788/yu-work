/**
 *
 *  * Alipay.com Inc.
 *  * Copyright (c) 2004-2014 All Rights Reserved.
 *  
 */
package yuweixiang.first.enums;

/**
 *  * 业务层结果码
 * 
 * <p>错误码的用途:用于显示给调用方处理结果<p>
 * 
 * @author wb-yuweixiang
 * @version $Id: MyResultCodeEnum.java, v 0.1 2014-7-24 下午5:05:37 wb-yuweixiang Exp $
 */
public enum ResultCodeEnum {

    /** 成功 */
    SUCCESS("SUCCESS", "success"),

    /** 所有异常 */
    ALL_WRONG("ALL_WRONG", "allWrong"),

    /** 系统错误 */
    SYSTEM_ERROR("SYSTEM_ERROR", "system_error"),

    /** 用户注册失败 */
    REGISTER_FAILD("REGISTER_FAILD", "用户注册失败!"),

    /** 用户登录失败 */
    LOGIN_FAILD("LOGIN_FAILD", "用户登录失败!"),

    /** 参数有误 */
    ILLEGAL_ARGUMENT("ILLEGAL_ARGUMENT", "illegal_argument"), ;

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
    private ResultCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 通过枚举<code>code</code>获得枚举
     * 
     * @param resultCode 结果码
     * @return 服务结果枚举
     */
    public static ResultCodeEnum getByCode(String resultCode) {
        for (ResultCodeEnum type : values()) {
            if (type.getCode().equals(resultCode)) {
                return type;
            }
        }
        return null;
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
