package yuweixiang.first.modle.user;

import yuweixiang.first.modle.BaseForm;
import yuweixiang.first.validation.annotation.Required;

/**
 * 修改默认地址请求表单
 *
 * @author yuweixiang
 * @version $ Id: SetDefaultAddressRequestForm.java, v 0.1 16/5/16 下午6:34 yuweixiang Exp $
 */
public class SetDefaultAddressRequestForm extends BaseForm{

    /** 序列号 */
    private static final long serialVersionUID = 2070216721106927677L;

    @Required(errorCode = "USERID_IS_NULL", message = "uderId is empty!")
    private String userId;

    @Required(errorCode = "ADDRESSID_IS_NULL", message = "addressId is empty!")
    private long addressId;

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
    public SetDefaultAddressRequestForm setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Getter method for property <tt>addressId</tt>.
     *
     * @return property value of addressId
     */
    public long getAddressId() {
        return addressId;
    }

    /**
     * Setter method for property <tt>addressId</tt>.
     *
     * @param addressId value to be assigned to property addressId
     */
    public SetDefaultAddressRequestForm setAddressId(long addressId) {
        this.addressId = addressId;
        return this;
    }
}
