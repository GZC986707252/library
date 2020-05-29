package edu.hut.library.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.hut.library.pojo.BorrowInfo;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/29 15:52
 */
@SpringBootTest
public class BorrowServiceTest {
    @Autowired
    private BorrowService borrowService;
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 1、读者存在
     * 2、书籍存在
     * 3、书籍在馆
     */
    @Test
    public void testBorrowBook1() {
        /*Long readerId = 2020000l;
        Integer bookId = 1008;
        borrowService.borrowBook(readerId, bookId);
        */
    }

    /**
     * 1、读者不存在
     * 2、书籍存在
     * 3、书籍在馆
     */
    @Test
    public void testBorrowBook3() {
       /* Long readerId = 10000l;
        Integer bookId = 1018;
        borrowService.borrowBook(readerId, bookId);
        */
    }
    /**
     * 1、读者存在
     * 2、书籍不存在
     * 3、书籍在馆
     */
    @Test
    public void testBorrowBook2() {
       /* Long readerId = 2020046l;
        Integer bookId = 100;
        borrowService.borrowBook(readerId, bookId);
        */
    }


    /**
     * 1、读者存在
     * 2、书籍存在
     * 3、书籍不在馆
     */
    @Test
    public void testBorrowBook4() {
       /* Long readerId = 2020046l;
        Integer bookId = 1003;
        borrowService.borrowBook(readerId, bookId);
        */
    }

    @Test
    public void testGetBorrowRecordsByReaderId() throws JsonProcessingException {
        List<BorrowInfo> borrowRecords = borrowService.getBorrowRecordsByReaderId(2020046l);
        String s = objectMapper.writeValueAsString(borrowRecords);
        System.out.println(s);
    }

}
