package yuweixiang.first.dal.daointerface;

import yuweixiang.first.dal.dataobject.OrderGoodsDO;

public interface OrderGoodsDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderGoodsDO record);

    int insertSelective(OrderGoodsDO record);

    OrderGoodsDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderGoodsDO record);

    int updateByPrimaryKey(OrderGoodsDO record);
}