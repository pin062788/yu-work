package yuweixiang.first.dal.daointerface;

import yuweixiang.first.dal.dataobject.OrderDO;

public interface OrderDOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderDO record);

    int insertSelective(OrderDO record);

    OrderDO selectByPrimaryKey(Integer id);

    OrderDO selectByOrderId(String orderId);

    int updateByPrimaryKeySelective(OrderDO record);

    int updateByPrimaryKey(OrderDO record);
}