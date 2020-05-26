package edu.hut.keshe.library.dao;

import edu.hut.keshe.library.pojo.ReturnInfo;

public interface ReturnInfoMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(ReturnInfo record);

    int insertSelective(ReturnInfo record);

    ReturnInfo selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(ReturnInfo record);

    int updateByPrimaryKey(ReturnInfo record);
}