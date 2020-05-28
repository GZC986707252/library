package edu.hut.library.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 18:14
 */
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookService bookService;

    @Test
    public void testGetBooksByBookParam() {

    }
}
