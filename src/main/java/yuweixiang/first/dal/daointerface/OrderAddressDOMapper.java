package yuweixiang.first.dal.daointerface;

import yuweixiang.first.dal.dataobject.OrderAddressDO;

public interface OrderAddressDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderAddressDO record);

    int insertSelective(OrderAddressDO record);

    OrderAddressDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderAddressDO record);

    int updateByPrimaryKey(OrderAddressDO record);
}