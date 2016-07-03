package yuweixiang.first.modle.user;

import yuweixiang.first.modle.BaseForm;
import yuweixiang.first.validation.annotation.Required;

/**
 * 查询收货地址表单
 *
 * @author yuweixiang
 * @version $ Id: QueryUserAddressRequestForm.java, v 0.1 16/5/16 下午6:32 yuweixiang Exp $
 */
public class QueryUserAddressRequestForm extends BaseForm{

    /** 序列号 */
    private static final long serialVersionUID = -7241249587181006601L;

    @Required(errorCode = "USERID_IS_NULL", message = "uderId is empty!")
    private String userId;

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
    public QueryUserAddressRequestForm setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
