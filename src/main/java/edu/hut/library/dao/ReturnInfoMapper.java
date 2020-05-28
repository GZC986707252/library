package edu.hut.library.dao;

import edu.hut.library.pojo.ReturnInfo;

public interface ReturnInfoMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(ReturnInfo record);

    int insertSelective(ReturnInfo record);

    ReturnInfo selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(ReturnInfo record);

    int updateByPrimaryKey(ReturnInfo record);
}