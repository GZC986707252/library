package edu.hut.library.dao;

import edu.hut.library.param.ReaderParam;
import edu.hut.library.pojo.Reader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderMapper {
    int deleteReaderById(Long readerId);

    int insert(Reader record);

    Reader selectReaderById(Long readerId);

    int updateReaderById(Reader record);

    List<Reader> selectReadersByReaderParam(ReaderParam param);

    int selectCount();
}