package yuweixiang.first.dal.daointerface;

import yuweixiang.first.dal.dataobject.UserDO;

public interface UserDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Integer id);

    UserDO selectByUserId(String userId);

    UserDO selectByCellphone(String cellphone);

    UserDO selectByEmail(String email);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);
}