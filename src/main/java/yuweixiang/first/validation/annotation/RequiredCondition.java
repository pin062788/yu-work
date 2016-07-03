/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package yuweixiang.first.validation.annotation;

import org.springmodules.validation.util.condition.AbstractCondition;

/**
 * 
 * @author wb-yuweixiang
 * @version $Id: RequiredCondition.java, v 0.1 2014-8-22 上午10:51:55 wb-yuweixiang Exp $
 */
public class RequiredCondition extends AbstractCondition {

    /** 
     * @see org.springmodules.validation.util.condition.AbstractCondition#doCheck(Object)
     */
    @Override
    public boolean doCheck(Object value) {

        if (value instanceof String) {
            return isNotBlank((String) value);
        } else {
            return value != null;
        }
    }

    /**
     * 
     * @param str
     * @return 真假
     */
    private boolean isNotBlank(String str) {
        int length;

        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }

        return false;
    }
}
