package yuweixiang.first.result.user;

import yuweixiang.first.result.BaseResult;

/**
 * 注册结果
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.result.user, v 0.1 16/5/15 上午12:50 yuweixiang Exp $
 */
public class RegisterResult extends BaseResult{

    /** 序列号 */
    private static final long serialVersionUID = 3376174017304679362L;

    /** 用户id */
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
    public RegisterResult setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
