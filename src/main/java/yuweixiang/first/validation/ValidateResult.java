/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.validation;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.io.Serializable;

/**
 * 校验结果
 * 
 * @author wb-yuweixiang
 * @version $Id: ValidationResult.java, v 0.1 2014-8-21 下午04:39:45 wb-yuweixiang Exp $
 */
public class ValidateResult implements Serializable {

    /** 序列号 */
    private static final long serialVersionUID = -475717766517936962L;

    /** 错误 */
    private Errors            error;

    /** 成功标志 */
    private boolean           isSuccess;

    /** 字段错误 */
    private FieldError        fieldError;

    /**
     * Getter method for property <tt>error</tt>.
     * 
     * @return property value of error
     */
    public Errors getError() {
        return error;
    }

    /**
     * Setter method for property <tt>error</tt>.
     * 
     * @param error value to be assigned to property error
     */
    public void setError(Errors error) {
        this.error = error;
    }

    /**
     * Getter method for property <tt>isSuccess</tt>.
     * 
     * @return property value of isSuccess
     */
    public boolean isSuccess() {
        return isSuccess;
    }

    /**
     * Setter method for property <tt>isSuccess</tt>.
     * 
     * @param isSuccess value to be assigned to property isSuccess
     */
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    /**
     * Getter method for property <tt>fieldError</tt>.
     * 
     * @return property value of fieldError
     */
    public FieldError getFieldError() {
        return fieldError;
    }

    /**
     * Setter method for property <tt>fieldError</tt>.
     * 
     * @param fieldError value to be assigned to property fieldError
     */
    public void setFieldError(FieldError fieldError) {
        this.fieldError = fieldError;
    }

    /** 
     * @see Object#toString()
     */
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}