/****************************************************************************
 *  Copyright (c) 2011 Alipay.com Inc, All rights reserved.
 *
 *  CONFIDENTIAL TRADE SECRET: THIS PRODUCT CONSISTS OF TRADE SECRETS
 *  AND COPYRIGHT MATERIAL THAT ARE THE PROPERTY OF Alipay TECHNOLOGY,
 *  THE CONTENTS MAY NOT BE DISCLOSED.
 *
 *  Source Code License:  LIMITED TO AUTHORIZED DEVELOPERS ONLY
 ****************************************************************************/
package yuweixiang.first.validation.handler;

import org.springmodules.validation.bean.conf.loader.annotation.handler.AbstractPropertyValidationAnnotationHandler;
import org.springmodules.validation.bean.rule.AbstractValidationRule;
import yuweixiang.first.validation.annotation.NumberValidationRule;
import yuweixiang.first.validation.annotation.Number;
import java.lang.annotation.Annotation;


/**
 * <pre>
 * 数值注解处理器
 * </pre>
 * @author kun.zhouk
 * @version $Id: NumberValidationAnnotationHandler.java, v 0.1 2011-9-1 下午02:40:03 kun.zhouk Exp $
 */
public class NumberValidationAnnotationHandler extends AbstractPropertyValidationAnnotationHandler {

    /**
     * 构造器
     */
    public NumberValidationAnnotationHandler() {
        super(Number.class);
    }

    /** 
     * @see org.springmodules.validation.bean.conf.loader.annotation.handler.AbstractPropertyValidationAnnotationHandler#createValidationRule(Annotation, Class, String)
     */
    @Override
    protected AbstractValidationRule createValidationRule(Annotation annotation,
                                                          @SuppressWarnings("rawtypes") Class clazz,
                                                          String propertyName) {
        Number number = (Number) annotation;
        return new NumberValidationRule(number.equalTo(), number.notEqualTo(), number.lessThan(),
            number.greaterThan(), number.lessThanOrEqualTo(), number.greaterThanOrEqualTo());
    }

}
