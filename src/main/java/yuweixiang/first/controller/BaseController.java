package yuweixiang.first.controller;

import org.dom4j.tree.BaseElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.FieldError;
import yuweixiang.first.enums.ResultCodeEnum;
import yuweixiang.first.exception.SearchException;
import yuweixiang.first.modle.BaseForm;
import yuweixiang.first.validation.ValidateResult;
import yuweixiang.first.validation.ValidateService;


/**
 * 基础控制类
 * @author wb-yuweixiang
 * @version $Id: BaseController.java, v 0.1 2014-8-22 下午01:38:29 wb-yuweixiang Exp $
 */
public class BaseController {

    /** 校验器 */
    @Autowired
    private ValidateService validateService;

    /**
     * 参数校验
     * @param requestFrom 请求表单
     */
    protected void validate(BaseForm requestFrom) {

        ValidateResult validateResult = validateService.validate(requestFrom);

        if (!validateResult.isSuccess()) {
            //获取错误信息
            final FieldError fieldError = validateResult.getError().getFieldError();
            throw new SearchException(ResultCodeEnum.ILLEGAL_ARGUMENT,
                fieldError.getDefaultMessage());
        }
    }
}
