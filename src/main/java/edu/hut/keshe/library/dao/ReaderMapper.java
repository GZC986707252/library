package edu.hut.keshe.library.dao;

import edu.hut.keshe.library.pojo.Reader;

public interface ReaderMapper {
    int deleteByPrimaryKey(Long readerId);

    int insert(Reader record);

    int insertSelective(Reader record);

    Reader selectByPrimaryKey(Long readerId);

    int updateByPrimaryKeySelective(Reader record);

    int updateByPrimaryKey(Reader record);
}