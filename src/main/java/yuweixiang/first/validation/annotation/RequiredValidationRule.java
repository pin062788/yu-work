/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package yuweixiang.first.validation.annotation;

import org.springmodules.validation.bean.rule.AbstractValidationRule;
import org.springmodules.validation.util.condition.Condition;

/**
 * 
 * @author kun.zhouk
 * @version $Id: RequiredValidationRule.java, v 0.1 2011-10-31 上午09:55:59 kun.zhouk Exp $
 */
public class RequiredValidationRule extends AbstractValidationRule {

    /** 必须码 */
    public static final String DEFAULT_ERROR_CODE = "required";

    /**
     * 校验规则
     */
    public RequiredValidationRule() {
        super(DEFAULT_ERROR_CODE);
    }

    /** 
     * @see org.springmodules.validation.bean.rule.ValidationRule#getCondition()
     */
    public Condition getCondition() {
        return new RequiredCondition();
    }

    /** 
     * @see org.springmodules.validation.bean.rule.AbstractValidationRule#supportsNullValues()
     */
    @Override
    protected boolean supportsNullValues() {
        return true;
    }
}
