package yuweixiang.first.dal.daointerface;

import yuweixiang.first.dal.dataobject.OrderFeeDO;

public interface OrderFeeDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderFeeDO record);

    int insertSelective(OrderFeeDO record);

    OrderFeeDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderFeeDO record);

    int updateByPrimaryKey(OrderFeeDO record);
}