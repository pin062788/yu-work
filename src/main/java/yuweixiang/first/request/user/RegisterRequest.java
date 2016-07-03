package yuweixiang.first.request.user;

import yuweixiang.first.request.BaseRequest;

/**
 * 用戶註冊請求參數
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.request.user, v 0.1 16/5/15 上午12:44 yuweixiang Exp $
 */
public class RegisterRequest extends BaseRequest{

    /** 序列 */
    private static final long serialVersionUID = -139193367506226672L;

    /** email */
    private String email;

    /** 暱稱 */
    private String nickName;

    /** 手机 */
    private String cellphone;

    /** 密码 */
    private String password;

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
    public RegisterRequest setEmail(String email) {
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
    public RegisterRequest setNickName(String nickName) {
        this.nickName = nickName;
        return this;
    }

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
    public RegisterRequest setCellphone(String cellphone) {
        this.cellphone = cellphone;
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
    public RegisterRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
