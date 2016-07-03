package yuweixiang.first.modle.user;

import org.springmodules.validation.bean.conf.loader.annotation.handler.MaxLength;
import yuweixiang.first.modle.BaseForm;
import yuweixiang.first.validation.annotation.Required;

/**
 * 注册请求列表
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.modle.user, v 0.1 16/5/15 上午1:02 yuweixiang Exp $
 */
public class RegisterRequestForm extends BaseForm{

    /** 序列号 */
    private static final long serialVersionUID = 4861793377455898568L;

    @Required(errorCode = "CELLPHONE_IS_NULL", message = "cellphone is empty!")
    @MaxLength(value = 32, errorCode = "CELLPHONE_ILLEGAL_LENGTH", message = "手机长度错误")
    //    @Number(lessThanOrEqualTo = 9999999, greaterThanOrEqualTo = 0)
    /** 电话 */
    private String            cellphone;

    /** 邮箱 */
    private String email;

    /** 昵称 */
    private String nickName;

    @Required(errorCode = "PASSWORD_IS_NULL", message = "password is empty!")
    @MaxLength(value = 32, errorCode = "PASSWORD_ILLEGAL_LENGTH", message = "密码字长度错误")
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
    public RegisterRequestForm setCellphone(String cellphone) {
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
    public RegisterRequestForm setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * Getter method for property <tt>nickName</tt>.
     *
     * @return property value of nickName
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * Setter method for property <tt>nickName</tt>.
     *
     * @param nickName value to be assigned to property nickName
     */
    public RegisterRequestForm setNickName(String nickName) {
        this.nickName = nickName;
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
    public RegisterRequestForm setPassword(String password) {
        this.password = password;
        return this;
    }
}
