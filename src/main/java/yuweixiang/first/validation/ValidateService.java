package yuweixiang.first.validation;


import yuweixiang.first.modle.BaseForm;

/**
 * 校验服务
 * 
 * @author wb-yuweixiang
 * @version $Id: ValidateService.java, v 0.1 2014-8-21 下午04:43:33 wb-yuweixiang Exp $
 */
public interface ValidateService {

    /**
     * 表单基本校验
     * 
     * <p>需要被校验的表单对象需要继承{@link BaseForm}</p>
     * 
     * @param baseForm 表单 
     * @return 校验结果
     */
    public ValidateResult validate(BaseForm baseForm);
}
