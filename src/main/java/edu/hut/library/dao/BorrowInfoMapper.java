package edu.hut.library.dao;

import edu.hut.library.pojo.BorrowInfo;

import java.util.List;

public interface BorrowInfoMapper {
    int deleteByReaderIdAndBookId(Long readerId,Integer bookId);

    int deleteByBookId(Integer bookId);

    BorrowInfo selectByBookId(Integer bookId);

    List<BorrowInfo> selectByReaderId(Long readerId);

    int insert(BorrowInfo record);

}