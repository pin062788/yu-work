package yuweixiang.first.dal.daointerface;

import yuweixiang.first.dal.dataobject.SkuDO;

public interface SkuDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuDO record);

    int insertSelective(SkuDO record);

    SkuDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SkuDO record);

    int updateByPrimaryKey(SkuDO record);
}