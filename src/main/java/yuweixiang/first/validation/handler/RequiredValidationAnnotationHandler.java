/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2011 All Rights Reserved.
 */
package yuweixiang.first.validation.handler;

import org.springmodules.validation.bean.conf.loader.annotation.handler.AbstractPropertyValidationAnnotationHandler;
import org.springmodules.validation.bean.rule.AbstractValidationRule;
import yuweixiang.first.validation.annotation.Required;
import yuweixiang.first.validation.annotation.RequiredValidationRule;

import java.lang.annotation.Annotation;


/**
 * 
 * @author wb-yuweixiang
 * @version $Id: RequiredValidationAnnotationHandler.java, v 0.1 2014-8-22 上午11:27:18 wb-yuweixiang Exp $
 */
public class RequiredValidationAnnotationHandler extends
                                                AbstractPropertyValidationAnnotationHandler {
    /**
     *  构造器
     */
    public RequiredValidationAnnotationHandler() {
        super(Required.class);
    }

    /** 
     * @see org.springmodules.validation.bean.conf.loader.annotation.handler.AbstractPropertyValidationAnnotationHandler#createValidationRule(Annotation, Class, String)
     */
    @Override
    protected AbstractValidationRule createValidationRule(Annotation annotation,
                                                          @SuppressWarnings("rawtypes") Class clazz,
                                                          String propertyName) {
        return new RequiredValidationRule();
    }
}
