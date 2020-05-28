package edu.hut.library.dao;

import edu.hut.library.param.BookParam;
import edu.hut.library.pojo.Book;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 17:10
 */
@SpringBootTest
public class BookMapperTest {
    @Resource
    private BookMapper bookMapper;

    @Test
    @Transactional
    public void testInsert(){
        int num=0;
        Book book =new Book();
        for(int i=1;i<=15;i++){
            book.setBookName("图书"+i);
            book.setIsbn("00000"+i);
            book.setAuthor("李四"+i);
            book.setPress("清华大学出版社"+i);
            book.setPublicationDate(new Date());
            book.setPrice(new BigDecimal(26.25));
            num+=bookMapper.insert(book);
        }
        assertEquals(15,num);
    }

    @Test
    public void testSelectBooksByBookParam() {
        BookParam param=new BookParam();
        param.setPage(1);
        param.setLimit(5);
        List<Book> books=bookMapper.selectBooksByBookParam(param);
        assertEquals(5,books.size());

        param.setAuthor("12");
        books=bookMapper.selectBooksByBookParam(param);
        assertEquals(1,books.size());
    }
}
