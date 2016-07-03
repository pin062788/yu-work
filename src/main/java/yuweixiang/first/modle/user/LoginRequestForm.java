package yuweixiang.first.modle.user;

import yuweixiang.first.modle.BaseForm;
import yuweixiang.first.validation.annotation.Required;

/**
 * 用户登录请求表单
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.modle.user, v 0.1 16/5/15 下午10:41 yuweixiang Exp $
 */
public class LoginRequestForm extends BaseForm{

    /** 序列号 */
    private static final long serialVersionUID = 5166639477462321330L;

    @Required(errorCode = "CELLPHONE_IS_NULL", message = "cellphone is empty!")
    /** 电话 */
    private String cellphone;

    /** email */
    private String email;

    @Required(errorCode = "PASSWORD_IS_NULL", message = "password is empty!")
    /** 密码 */
    private String password;

    /**
     * Getter method for property <tt>cellphone</tt>.
     *
     * @return property value of cellphone
     */
    public String getCellphone() {
        return cellphone;
    }

    /**
     * Setter method for property <tt>cellphone</tt>.
     *
     * @param cellphone value to be assigned to property cellphone
     */
    public LoginRequestForm setCellphone(String cellphone) {
        this.cellphone = cellphone;
        return this;
    }

    /**
     * Getter method for property <tt>email</tt>.
     *
     * @return property value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for property <tt>email</tt>.
     *
     * @param email value to be assigned to property email
     */
    public LoginRequestForm setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Getter method for property <tt>password</tt>.
     *
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     *
     * @param password value to be assigned to property password
     */
    public LoginRequestForm setPassword(String password) {
        this.password = password;
        return this;
    }
}
