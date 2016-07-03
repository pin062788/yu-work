package yuweixiang.first.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import yuweixiang.first.constants.SpringDemoConstants;
import yuweixiang.first.enums.ResultCodeEnum;
import yuweixiang.first.exception.SearchException;
import yuweixiang.first.modle.RequestForm;
import yuweixiang.first.result.QueryUserResult;
import yuweixiang.first.service.HelloWorldService;


/**
 * 控制器
 * 
 * @author wb-yuweixiang
 * @version $Id: HelloWorldController.java, v 0.1 2014-8-21 下午01:51:25 wb-yuweixiang Exp $
 */
@Controller
@RequestMapping("/helloworld")
public class HelloWorldController extends BaseController {

    /** 日志 */
//    Logger LOGGER = LoggerFactory.getLogger(HelloWorldController.class);

    /** 你好世界服务 */
    @Autowired
    private HelloWorldService helloWorldService;

    /**
     * 获取姓名
     * @param requestFrom 请求表单
     * @param model 
     * @return 字符串
     */
    @RequestMapping(value = "/helloworld.htm")
    public String doGet(RequestForm requestFrom, ModelMap model) {

//        LOGGER.info("requestForm:"+requestFrom);
        // 1. 参数校验
        validate(requestFrom);

        // 2. 获取用户名
        QueryUserResult result = helloWorldService.getNewName(requestFrom.getUserId());
        if (result == null || !result.isSuccess()) {
            throw new SearchException(ResultCodeEnum.SYSTEM_ERROR, result.getResultMessage());
        }

        // 3. 组装返回数据
        model.put("newUserName", result.getUserName());
//        LOGGER.info("result:"+result.getUserName());


        // 4. 跳转
        return SpringDemoConstants.HELLO_WORLD;
    }

    /**
     * 获取惊喜
     * 
     * @param model 模型
     * @return 返回跳转页面
     */
    @RequestMapping(value = "/seeSurprise.htm")
    public String getSurprise(ModelMap model) {
        model.put("supriceMessage", "surprise!!!!you got 10000000RMB,getIt!");
        return SpringDemoConstants.HELLO_WORLD;
    }
}