package yuweixiang.first.util;

import org.springframework.beans.BeanUtils;
import yuweixiang.first.dal.dataobject.UserAddressDO;
import yuweixiang.first.modle.vo.UserAddressVO;

import java.util.ArrayList;
import java.util.List;

/**
 * 转换类
 *
 * @author yuweixiang
 * @version $ Id: ConvertUtil.java, v 0.1 16/5/16 下午6:55 yuweixiang Exp $
 */
public class ConvertUtil {

    /**
     * 将收货地址do转换为vo对象
     *
     * @param userAddressDOList 收货地址do集合
     * @return vo对象集合
     */
    public static List<UserAddressVO> convertToUserAddressVOList(List<UserAddressDO> userAddressDOList) {
        List<UserAddressVO> userAddressVOList = new ArrayList<UserAddressVO>();
        if (userAddressDOList != null && !userAddressDOList.isEmpty()) {
            for (UserAddressDO userAddressDO : userAddressDOList){
                UserAddressVO userAddressVO = new UserAddressVO();
                BeanUtils.copyProperties(userAddressDO,userAddressVO);
                userAddressVOList.add(userAddressVO);
            }
        }
        return userAddressVOList;
    }
}
