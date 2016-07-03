/****************************************************************************
 *  Copyright (c) 2011 Alipay.com Inc, All rights reserved.
 *
 *  CONFIDENTIAL TRADE SECRET: THIS PRODUCT CONSISTS OF TRADE SECRETS
 *  AND COPYRIGHT MATERIAL THAT ARE THE PROPERTY OF Alipay TECHNOLOGY,
 *  THE CONTENTS MAY NOT BE DISCLOSED.
 *
 *  Source Code License:  LIMITED TO AUTHORIZED DEVELOPERS ONLY
 ****************************************************************************/
package yuweixiang.first.validation.configuration;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springmodules.validation.bean.conf.loader.annotation.DefaultValidationAnnotationHandlerRegistry;
import org.springmodules.validation.bean.conf.loader.annotation.handler.AbstractPropertyValidationAnnotationHandler;
import yuweixiang.first.validation.handler.NumberValidationAnnotationHandler;
import yuweixiang.first.validation.handler.RequiredValidationAnnotationHandler;


/**
 * <pre>
 * Registry模式，注册handler注解处理器，可通过XML配置
 * </pre>
 * @author kun.zhouk
 * @version $Id: ExtendedValidationAnnotationHandlerRegistry.java, v 0.1 2011-9-1 下午02:26:52 kun.zhouk Exp $
 */
public class ExtendedValidationAnnotationHandlerRegistry extends
                                                        DefaultValidationAnnotationHandlerRegistry
                                                                                                  implements
                                                                                                  InitializingBean,
                                                                                                  ApplicationContextAware {

    /**  */
    private ApplicationContext applicationContext;

    /**
     *  构造器
     */
    public ExtendedValidationAnnotationHandlerRegistry() {
        super();

        //注册相关的注解解析器
        registerPropertyHandler(new NumberValidationAnnotationHandler());
        registerPropertyHandler(new RequiredValidationAnnotationHandler());
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        //注册用户自定义的扩展的注解解析器(XML配置方式)
        String[] beanNames = applicationContext
            .getBeanNamesForType(AbstractPropertyValidationAnnotationHandler.class);
        for (String beanName : beanNames) {
            registerPropertyHandler((AbstractPropertyValidationAnnotationHandler) applicationContext
                .getBean(beanName));
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}