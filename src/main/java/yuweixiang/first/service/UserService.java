package yuweixiang.first.service;

import yuweixiang.first.request.user.AddAddressRequest;
import yuweixiang.first.request.user.RegisterRequest;
import yuweixiang.first.result.BaseResult;
import yuweixiang.first.result.user.LoginResult;
import yuweixiang.first.result.user.QueryUserAddressResult;
import yuweixiang.first.result.user.RegisterResult;

/**
 * 用戶服務
 *
 * @author yuweixiang
 * @version $ Id: yuweixiang.first.service, v 0.1 16/5/15 上午12:39 yuweixiang Exp $
 */
public interface UserService {

    /**
     * 用户注册结果
     *
     * @param request 请求参数
     * @return 处理结果,成功返回用户id
     */
    public RegisterResult registerUser(RegisterRequest request);


    /**
     * 用户登录
     *
     * @param userId 用户id
     * @param password 密码
     * @return 登录结果
     */
    public LoginResult userLogin(String userId,String password);

    /**
     * 新增收货地址
     *
     * @param request 请求参数
     * @return 返回处理结果
     */
    public BaseResult addAddress(AddAddressRequest request);

    /**
     * 查询用户收货地址
     *
     * @param userId 用户id
     * @return 收货地址
     */
    public QueryUserAddressResult queryUserAddress(String userId);

    /**
     * 设置默认地址
     *
     * @param addressId 地址id
     * @return 返回处理结果
     */
    public BaseResult setDefaultAddress(long addressId);
}
