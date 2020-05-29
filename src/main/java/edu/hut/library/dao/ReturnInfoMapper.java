package edu.hut.library.dao;

import edu.hut.library.pojo.ReturnInfo;

import java.util.List;

public interface ReturnInfoMapper {

    int insertReturnRecord(ReturnInfo record);

    List<ReturnInfo> selectReturnRecords(Long readerId, Integer bookId);

}