package edu.hut.library.service;

import edu.hut.library.param.ReaderParam;
import edu.hut.library.pojo.Reader;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 13:44
 */
public interface ReaderService {

    List<Reader> getReadersByReaderParam(ReaderParam param);

    int addReader(Reader record);

    int updateReader(Reader record);

    int deleteReaderById(Long readerId);

    Reader findReaderById(Long readerId);

    int getCount();
}
