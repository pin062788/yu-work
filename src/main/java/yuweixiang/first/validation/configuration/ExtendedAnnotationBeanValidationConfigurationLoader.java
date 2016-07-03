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

import org.springmodules.validation.bean.conf.loader.annotation.AnnotationBeanValidationConfigurationLoader;

/**
 * <pre>
 * 通用加载器
 * </pre>
 * @author kun.zhouk
 * @version $Id: ExtendedAnnotationBeanValidationConfigurationLoader.java, v 0.1 2011-9-1 下午02:26:22 kun.zhouk Exp $
 */
public class ExtendedAnnotationBeanValidationConfigurationLoader extends
                                                                AnnotationBeanValidationConfigurationLoader {

    /**
     * 构造器
     */
    public ExtendedAnnotationBeanValidationConfigurationLoader() {
        super();
        setHandlerRegistry(new ExtendedValidationAnnotationHandlerRegistry());
    }
}
