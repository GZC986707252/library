package edu.hut.keshe.library.dao;

import edu.hut.keshe.library.pojo.BorrowInfo;

public interface BorrowInfoMapper {
    int deleteByPrimaryKey(Integer borrowId);

    int insert(BorrowInfo record);

    int insertSelective(BorrowInfo record);

    BorrowInfo selectByPrimaryKey(Integer borrowId);

    int updateByPrimaryKeySelective(BorrowInfo record);

    int updateByPrimaryKey(BorrowInfo record);
}