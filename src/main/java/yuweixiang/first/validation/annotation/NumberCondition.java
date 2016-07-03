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

import org.apache.commons.lang.StringUtils;
import org.springmodules.validation.util.condition.string.AbstractStringCondition;

/**
 *  校验一个字符串是数字
 * @author wb-yuweixiang
 * @version $Id: NumberCondition.java, v 0.1 2014-8-22 下午02:44:32 wb-yuweixiang Exp $
 */
/**
 * 
 * @author wb-yuweixiang
 * @version $Id: NumberCondition.java, v 0.1 2014-8-22 下午02:44:47 wb-yuweixiang Exp $
 */
public class NumberCondition extends AbstractStringCondition {

    /**  */
    private final double equalTo;
    /**  */
    private final double notEqualTo;
    /**  */
    private final double lessThan;
    /**  */
    private final double greaterThan;
    /**  */
    private final double lessThanOrEqualTo;
    /**  */
    private final double greaterThanOrEqualTo;

    /**
     * @param equalTo
     * @param notEqualTo
     * @param lessThan
     * @param greaterThan
     * @param lessThanOrEqualTo
     * @param greaterThanOrEqualTo
     */
    public NumberCondition(double equalTo, double notEqualTo, double lessThan, double greaterThan,
                           double lessThanOrEqualTo, double greaterThanOrEqualTo) {
        this.equalTo = equalTo;
        this.notEqualTo = notEqualTo;
        this.lessThan = lessThan;
        this.greaterThan = greaterThan;
        this.lessThanOrEqualTo = lessThanOrEqualTo;
        this.greaterThanOrEqualTo = greaterThanOrEqualTo;
    }

    /**
     * 构造器
     */
    public NumberCondition() {
        this(Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN, Double.NaN);
    }

    @Override
    protected final boolean checkString(String text) {

        //判断text是否为空，为空返回true，不做校验
        if (StringUtils.isBlank(text)) {
            return true;
        }

        double doubleValue = Double.NaN;

        if (StringUtils.containsOnly(text, "+-.0123456789")) {
            try {
                doubleValue = Double.parseDouble(text);
            } catch (NumberFormatException e) {

                return false;
            }
        }

        if (Double.isNaN(doubleValue)) {
            return false;
        } else {

            boolean valid = true;

            if (!Double.isNaN(equalTo)) {
                valid &= (doubleValue == equalTo);
            }

            if (!Double.isNaN(notEqualTo)) {
                valid &= (doubleValue != notEqualTo);
            }

            if (!Double.isNaN(lessThan)) {
                valid &= (doubleValue < lessThan);
            }

            if (!Double.isNaN(greaterThan)) {
                valid &= (doubleValue > greaterThan);
            }

            if (!Double.isNaN(lessThanOrEqualTo)) {
                valid &= (doubleValue <= lessThanOrEqualTo);
            }

            if (!Double.isNaN(greaterThanOrEqualTo)) {
                valid &= (doubleValue >= greaterThanOrEqualTo);
            }
            return valid &= checkNumber(text);
        }
    }

    /**
     * 作为模版方法给子类覆盖，可以进一步检查是否如金额，长度，面积等的字符串
     * @param text
     * @return true if text valid, false is otherwise
     */
    protected boolean checkNumber(String text) {
        return true;
    }

}
