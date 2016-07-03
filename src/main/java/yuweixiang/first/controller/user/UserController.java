package yuweixiang.first.controller.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import yuweixiang.first.constants.SpringDemoConstants;
import yuweixiang.first.controller.BaseController;
import yuweixiang.first.enums.ResultCodeEnum;
import yuweixiang.first.exception.SearchException;
import yuweixiang.first.modle.user.*;
import yuweixiang.first.request.user.AddAddressRequest;
import yuweixiang.first.request.user.RegisterRequest;
import yuweixiang.first.result.BaseResult;
import yuweixiang.first.result.user.LoginResult;
import yuweixiang.first.result.user.QueryUserAddressResult;
import yuweixiang.first.result.user.RegisterResult;
import yuweixiang.first.service.UserService;
import yuweixiang.first.validation.ValidateResult;
import yuweixiang.first.validation.ValidateService;

/**
 * 用戶控制器
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.controller.user, v 0.1 16/5/15 上午12:37 yuweixiang Exp $
 */
public class UserController extends BaseController {
    /**
     * 日志
     */
    Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    /**
     * 你好世界服务
     */
    @Autowired
    private UserService userService;

    @Autowired
    private ValidateService validateService;

    /**
     * 获取用户注册
     *
     * @param requestForm 请求表单
     * @param model
     * @return 字符串
     */
    @RequestMapping(value = "/register.htm")
    public String doPost(RegisterRequestForm requestForm, ModelMap model) {
        LOGGER.info("requestForm:" + requestForm);

        // 1. 参数校验
        ValidateResult validateResult = validateService.validate(requestForm);
        if (!validateResult.isSuccess()) {
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "请求参数有误");
        }

        // 2. 获取用户名
        RegisterRequest request = buildRegistRequest(requestForm);
        RegisterResult result = userService.registerUser(request);
        if (result == null || !result.isSuccess()) {
            throw new SearchException(ResultCodeEnum.REGISTER_FAILD, result.getResultMessage());
        }

        // 3. 组装返回数据
        model.put("result", result);

        // 4. 跳转
        return SpringDemoConstants.SEARCH;
    }

    /**
     * 用户登录
     *
     * @param requestForm 请求表单
     * @param model
     * @return 字符串
     */
    @RequestMapping(value = "/login.htm")
    public String doPost(LoginRequestForm requestForm, ModelMap model) {
        LOGGER.info("requestForm:" + requestForm);

        // 1. 参数校验
        ValidateResult validateResult = validateService.validate(requestForm);
        if (!validateResult.isSuccess()) {
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "请求参数有误");
        }

        // 2. 获取用户名
        LoginResult result = userService.userLogin(requestForm.getCellphone(), requestForm.getPassword());
        if (result == null || !result.isSuccess()) {
            throw new SearchException(ResultCodeEnum.LOGIN_FAILD, result.getResultMessage());
        }

        // 3. 组装返回数据
        model.put("result", result);

        // 4. 跳转
        return SpringDemoConstants.SEARCH;
    }

    /**
     * 用户新增用户地址
     *
     * @param requestForm 请求表单
     * @param model
     * @return 字符串
     */
    @RequestMapping(value = "/addUserAddress.htm")
    public String doPost(AddAddressRequestForm requestForm, ModelMap model) {
        LOGGER.info("requestForm:" + requestForm);

        // 1. 参数校验
        ValidateResult validateResult = validateService.validate(requestForm);
        if (!validateResult.isSuccess()) {
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "请求参数有误");
        }

        // 2. 获取用户名
        AddAddressRequest request = new AddAddressRequest();
        BeanUtils.copyProperties(requestForm,request);
        BaseResult result = userService.addAddress(request);
        if (result == null || !result.isSuccess()) {
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "新增失败!");
        }

        // 3. 组装返回数据
        model.put("result", result);

        // 4. 跳转
        return SpringDemoConstants.SEARCH;
    }

    /**
     * 查询用户收货地址
     *
     * @param requestForm 请求表单
     * @param model
     * @return 字符串
     */
    @RequestMapping(value = "/queryUserAddress.htm")
    public String doPost(QueryUserAddressRequestForm requestForm, ModelMap model) {
        LOGGER.info("requestForm:" + requestForm);

        // 1. 参数校验
        ValidateResult validateResult = validateService.validate(requestForm);
        if (!validateResult.isSuccess()) {
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "请求参数有误");
        }

        // 2. 获取用户名
        QueryUserAddressResult result = userService.queryUserAddress(requestForm.getUserId());
        if (result == null || !result.isSuccess()) {
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "查询失败!");
        }

        // 3. 组装返回数据
        model.put("result", result);

        // 4. 跳转
        return SpringDemoConstants.SEARCH;
    }

    /**
     * 设置默认收货地址
     *
     * @param requestForm 请求表单
     * @param model
     * @return 字符串
     */
    @RequestMapping(value = "/setDefalutAddress.htm")
    public String doPost(SetDefaultAddressRequestForm requestForm, ModelMap model) {
        LOGGER.info("requestForm:" + requestForm);

        // 1. 参数校验
        ValidateResult validateResult = validateService.validate(requestForm);
        if (!validateResult.isSuccess()) {
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "请求参数有误");
        }

        // 2. 获取用户名
        BaseResult result = userService.setDefaultAddress(requestForm.getAddressId());
        if (result == null || !result.isSuccess()) {
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT, "设置默认收货地址失败!");
        }

        // 3. 组装返回数据
        model.put("result", result);

        // 4. 跳转
        return SpringDemoConstants.SEARCH;
    }

    /*********************************************私有方法**********************************************/

    /**
     * 将form表单转换为业务请求参数
     *
     * @param requestForm form请求表单
     * @return 业务请求参数
     */
    private RegisterRequest buildRegistRequest(RegisterRequestForm requestForm) {
        RegisterRequest request = new RegisterRequest();
        request.setPassword(requestForm.getPassword());
        request.setCellphone(requestForm.getCellphone());
        request.setEmail(requestForm.getEmail());
        request.setNickName(requestForm.getNickName());
        return request;
    }
}
