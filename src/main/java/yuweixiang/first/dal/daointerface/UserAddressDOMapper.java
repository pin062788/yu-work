package yuweixiang.first.dal.daointerface;

import yuweixiang.first.dal.dataobject.UserAddressDO;

import java.util.List;

public interface UserAddressDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserAddressDO record);

    int insertSelective(UserAddressDO record);

    UserAddressDO selectByPrimaryKey(Long id);

    List<UserAddressDO> selectByUserId(String userId);

    int updateByPrimaryKeySelective(UserAddressDO record);

    int updateByPrimaryKey(UserAddressDO record);
}