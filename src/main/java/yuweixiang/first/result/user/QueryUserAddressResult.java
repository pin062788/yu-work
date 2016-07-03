package yuweixiang.first.result.user;

import yuweixiang.first.modle.vo.UserAddressVO;
import yuweixiang.first.result.BaseResult;

import java.util.ArrayList;
import java.util.List;

/**
 * 查询用户收货地址结果
 *
 * @author yuweixiang
 * @version $ Id: QueryUserAddressResult.java, v 0.1 16/5/16 下午6:36 yuweixiang Exp $
 */
public class QueryUserAddressResult extends BaseResult{

    /** 序列号 */
    private static final long serialVersionUID = -9167984439569772276L;

    private List<UserAddressVO> userAddressVOList = new ArrayList<UserAddressVO>();

    /**
     * Getter method for property <tt>userAddressVOList</tt>.
     *
     * @return property value of userAddressVOList
     */
    public List<UserAddressVO> getUserAddressVOList() {
        return userAddressVOList;
    }

    /**
     * Setter method for property <tt>userAddressVOList</tt>.
     *
     * @param userAddressVOList value to be assigned to property userAddressVOList
     */
    public QueryUserAddressResult setUserAddressVOList(List<UserAddressVO> userAddressVOList) {
        this.userAddressVOList = userAddressVOList;
        return this;
    }
}
