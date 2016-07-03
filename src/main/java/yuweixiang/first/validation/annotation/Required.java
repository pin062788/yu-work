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
 * <pre>
 * <li>必须:包括字符串非空，非“”</li>
 * </pre>
 * @author kun.zhouk
 * @version $Id: Required.java, v 0.1 2011-9-1 下午02:35:23 kun.zhouk Exp $
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ValidationRule
public @interface Required {
    /**
     * Returns the error code that represents the error when the validation fails.
     */
    String errorCode() default RequiredValidationRule.DEFAULT_ERROR_CODE;

    /**
     * Returns the default message that represents the error when the validation fails.
     */
    String message() default RequiredValidationRule.DEFAULT_ERROR_CODE;

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