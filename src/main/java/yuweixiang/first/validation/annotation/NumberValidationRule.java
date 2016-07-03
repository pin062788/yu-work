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

import org.springmodules.validation.bean.rule.AbstractValidationRule;
import org.springmodules.validation.util.condition.Condition;

/**
 *  校验数字的规则
 * @author wb-yuweixiang
 * @version $Id: NumberValidationRule.java, v 0.1 2014-8-22 下午02:43:39 wb-yuweixiang Exp $
 */
public class NumberValidationRule extends AbstractValidationRule {

    /**  */
    public static final String DEFAULT_ERROR_CODE = "非法数字";

    /**  */
    private final double       equalTo;
    /**  */
    private final double       notEqualTo;
    /**  */
    private final double       lessThan;
    /**  */
    private final double       greaterThan;
    /**  */
    private final double       lessThanOrEqualTo;
    /**  */
    private final double       greaterThanOrEqualTo;

    /**
     * @param equalTo
     * @param notEqualTo
     * @param lessThan
     * @param greaterThan
     * @param lessThanOrEqualTo
     * @param greaterThanOrEqualTo
     */
    public NumberValidationRule(double equalTo, double notEqualTo, double lessThan,
                                double greaterThan, double lessThanOrEqualTo,
                                double greaterThanOrEqualTo) {
        super(DEFAULT_ERROR_CODE);
        this.equalTo = equalTo;
        this.notEqualTo = notEqualTo;
        this.lessThan = lessThan;
        this.greaterThan = greaterThan;
        this.lessThanOrEqualTo = lessThanOrEqualTo;
        this.greaterThanOrEqualTo = greaterThanOrEqualTo;
    }

    /**
     *  构造器
     */
    public NumberValidationRule() {
        this(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN);
    }

    /* (non-Javadoc)
     * @see org.springmodules.validation.bean.rule.ValidationRule#getCondition()
     */
    public Condition getCondition() {
        return new NumberCondition(equalTo, notEqualTo, lessThan, greaterThan, lessThanOrEqualTo,
            greaterThanOrEqualTo);
    }

}
