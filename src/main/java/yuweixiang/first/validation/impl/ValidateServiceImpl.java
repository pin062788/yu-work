package yuweixiang.first.validation.impl;

import org.springframework.validation.Errors;
import org.springmodules.validation.bean.BeanValidator;
import yuweixiang.first.modle.BaseForm;
import yuweixiang.first.validation.ValidateResult;
import yuweixiang.first.validation.ValidateService;
import yuweixiang.first.validation.ValidationResult;


/**
 * 校验服务实现类
 * 
 * @author wb-yuweixiang
 * @version $Id: ValidateServiceImpl.java, v 0.1 2014-8-21 下午04:46:04 wb-yuweixiang Exp $
 */
public class ValidateServiceImpl implements ValidateService {

    /** 校验器 */
    private BeanValidator validator;

    /** 
     * @see org.app.demo.validation.ValidateService#validate(org.app.demo.spring.model.BaseForm)
     */
    public ValidateResult validate(BaseForm baseForm) {
        return commonValidate(baseForm);
    }

    /**
     * 参数校验
     * @param object 校验对象
     * @return 返回校验结果
     */
    private ValidateResult commonValidate(Object object) {
        ValidateResult result = new ValidateResult();
        Errors error = new ValidationResult(object, object.getClass().getName());
        validator.validate(object, error);
        result.setSuccess(Boolean.TRUE);
        if (error.getAllErrors().size() > 0) {
            result.setSuccess(Boolean.FALSE);
            result.setError(error);
            result.setFieldError(error.getFieldError());
        }
        return result;
    }

    /**
     * Setter method for property <tt>validator</tt>.
     * 
     * @param validator value to be assigned to property validator
     */
    public void setValidator(BeanValidator validator) {
        this.validator = validator;
    }
}
