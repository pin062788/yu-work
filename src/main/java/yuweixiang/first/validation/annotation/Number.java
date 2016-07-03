/****************************************************************************
 *  Copyright (c) 2011 Alipay.com Inc, All rights reserved.
 *
 *  CONFIDENTIAL TRADE SECRET: THIS PRODUCT CONSISTS OF TRADE SECRETS
 *  AND COPYRIGHT MATERIAL THAT ARE THE PROPERTY OF Alipay TECHNOLOGY,
 *  THE CONTENTS MAY NOT BE DISCLOSED.
 *
 *  Source Code License:  LIMITED TO AUTHORIZED DEVELOPERS ONLY
 ****************************************************************************/
package yuweixiang.first.validation.annotation;

import org.springmodules.validation.bean.conf.loader.annotation.handler.ValidationRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 是否是数字
 * @author wb-yuweixiang
 * @version $Id: Number.java, v 0.1 2014-8-22 下午02:42:44 wb-yuweixiang Exp $
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidationRule
public @interface Number {

    /**
     * 
     * @return 比较结果
     */
    double equalTo() default Double.NaN;

    /**
     * 
     * @return 比较结果
     */
    double notEqualTo() default Double.NaN;

    /**
     * 
     * @return 比较结果
     */
    double lessThan() default Double.NaN;

    /**
     * 
     * @return 比较结果
     */
    double greaterThan() default Double.NaN;

    /**
     * 
     * @return 比较结果
     */
    double lessThanOrEqualTo() default Double.NaN;

    /**
     * 
     * @return 比较结果
     */
    double greaterThanOrEqualTo() default Double.NaN;

    /**
     * Returns the error code that represents the error when the validation fails.
     */
    String errorCode() default NumberValidationRule.DEFAULT_ERROR_CODE;

    /**
     * Returns the default message that represents the error when the validation fails.
     */
    String message() default NumberValidationRule.DEFAULT_ERROR_CODE;

    /**
     * Comma-delimited list of arguments to be attached to the error code.
     */
    String args() default "";

    /**
     * An condition expressed in an expression language (e.g. OGNL, Valag) that determines when
     * this validation rule should be applied.
     */
    String applyIf() default "";

    /**
     * A list of context in which this validation rule is applicable. Empty list means this rule is always applicable
     * regardless the validation context.
     */
    String[] contexts() default {};
}
