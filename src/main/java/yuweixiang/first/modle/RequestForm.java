package yuweixiang.first.modle;

import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;
import yuweixiang.first.validation.annotation.Required;

/**
 * 请求参数表单
 * 
 * @author wb-yuweixiang
 * @version $Id: RequestForm.java, v 0.1 2014-8-21 下午01:53:15 wb-yuweixiang Exp $
 */
public class RequestForm extends BaseForm {

    /** 序列号 */
    private static final long serialVersionUID = -1073504461591955753L;

    /** 用户名称 */
    @Required(errorCode = "USERID_IS_NULL", message = "userId is empty!")
    @MaxLength(value = 64, errorCode = "USERID_ILLEGAL_LENGTH", message = "用户Id长度错误")
    //    @Number(lessThanOrEqualTo = 9999999, greaterThanOrEqualTo = 0)
    private String            userId;

    /**
     * Getter method for property <tt>userId</tt>.
     * 
     * @return property value of userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Setter method for property <tt>userId</tt>.
     * 
     * @param userId value to be assigned to property userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
