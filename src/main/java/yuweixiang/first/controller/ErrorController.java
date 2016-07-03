/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2014 All Rights Reserved.
 */
package yuweixiang.first.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * 错误控制器
 * 
 * @author wb-yuweixiang
 * @version $Id: ErrorController.java, v 0.1 2014-9-11 下午02:45:11 wb-yuweixiang Exp $
 */
@Controller
@RequestMapping("/error.htm")
public class ErrorController {

    /** 错误页面 */
    private static final String ERROR_PAGE = "error";

    /**
     * 错误页面渲染
     *
     * @param request http请求
     * @param modelMap 页面存储容器
     * @return 错误页面
     */
    @RequestMapping
    public String doGet(HttpServletRequest request, ModelMap modelMap) {

        @SuppressWarnings("unchecked")
        Enumeration<String> paraNames = request.getParameterNames();
        for (Enumeration<String> e = paraNames; e.hasMoreElements();) {
            String thisName = e.nextElement().toString();
            String thisValue = request.getParameter(thisName);
            modelMap.put(thisName, thisValue);
        }
        return ERROR_PAGE;
    }
}
