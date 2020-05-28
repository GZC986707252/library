package edu.hut.library.service.impl;

import edu.hut.library.dao.ReaderMapper;
import edu.hut.library.param.ReaderParam;
import edu.hut.library.pojo.Reader;
import edu.hut.library.service.ReaderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 13:53
 */
@Service
public class ReaderServiceImpl implements ReaderService {
    @Resource
    private ReaderMapper readerMapper;

    @Override
    public List<Reader> getReadersByReaderParam(ReaderParam param) {
        List<Reader> readers=readerMapper.selectReadersByReaderParam(param);
        return readers;
    }

    @Override
    public int getCount() {
        return readerMapper.selectCount();
    }

    @Override
    public int addReader(Reader record) {
        return readerMapper.insert(record);
    }

    @Override
    public int updateReader(Reader record) {
        return readerMapper.updateReaderById(record);
    }

    @Override
    public int deleteReaderById(Long readerId) {
        return readerMapper.deleteReaderById(readerId);
    }

    @Override
    public Reader findReaderById(Long readerId) {
        return readerMapper.selectReaderById(readerId);
    }
}