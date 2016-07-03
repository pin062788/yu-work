package yuweixiang.first.result.user;

import yuweixiang.first.result.BaseResult;

/**
 * 登录结果
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.result.user, v 0.1 16/5/15 下午10:46 yuweixiang Exp $
 */
public class LoginResult extends BaseResult{

    /** 序列号 */
    private static final long serialVersionUID = 8824043404329344845L;

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
    public LoginResult setUserId(String userId) {
        this.userId = userId;
        return this;
    }
}
