package edu.hut.library.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/29 17:30
 */
@SpringBootTest
public class ReturnServiceTest {

    @Autowired
    private ReturnService returnService;

    @Test
    public void testReturnBook() {
        /*Integer bookId=1010;
        returnService.returnBook(bookId);
        */
    }
}
