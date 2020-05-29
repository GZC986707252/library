package edu.hut.library.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hut.library.pojo.BorrowInfo;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/29 12:16
 */
@SpringBootTest
public class BorrowInfoMapperTest {
    @Resource
    private BorrowInfoMapper borrowInfoMapper;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Transactional
    public void testInsert() {
        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setBookId(1003);
        borrowInfo.setReaderId(2020047l);
        Date now = new Date();
        Calendar calendar =Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, 2);
        borrowInfo.setBorrowTime(now);
        borrowInfo.setExpireTime(calendar.getTime());
        System.out.println(now.toString());
        System.out.println(calendar.getTime().toString());
        borrowInfoMapper.insert(borrowInfo);
    }

    @Test
    public void testSelectByBookId() throws JsonProcessingException {
        BorrowInfo borrowInfo = borrowInfoMapper.selectByBookId(1003);
        String s = objectMapper.writeValueAsString(borrowInfo);
        System.out.println(s);
    }

    @Test
    public void testSelectByReaderId() throws JsonProcessingException {
        List<BorrowInfo> borrowInfo = borrowInfoMapper.selectByReaderId(2020047l);
        String s = objectMapper.writeValueAsString(borrowInfo);
        System.out.println(s);
    }

    @Test
    @Transactional
    public void testDeleteByBookId() {
        int code=borrowInfoMapper.deleteByBookId(1003);
        assertEquals(1, code);
    }

    @Test
    @Transactional
    public void testDeleteByReaderIdAndBookId() {
        int code=borrowInfoMapper.deleteByReaderIdAndBookId(2020047l,1003);
        assertEquals(1, code);
    }

}
