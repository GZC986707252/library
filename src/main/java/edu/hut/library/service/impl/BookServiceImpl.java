package edu.hut.library.service.impl;

import edu.hut.library.dao.BookMapper;
import edu.hut.library.exception.CustomizeException;
import edu.hut.library.param.BookParam;
import edu.hut.library.pojo.Book;
import edu.hut.library.service.BookService;
import edu.hut.library.util.ResultCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 18:05
 */
@Service
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;

    @Override
    public int addBook(Book record) {
        return bookMapper.insert(record);
    }

    @Override
    public int updateBook(Book record) {
        return bookMapper.updateBookById(record);
    }

    @Override
    public int deleteBookById(Integer bookId) {
        return bookMapper.deleteBookById(bookId);
    }

    @Override
    public List<Book> getBooksByBookParam(BookParam param) {
        return bookMapper.selectBooksByBookParam(param);
    }

    @Override
    public int getCount() {
        return bookMapper.selectCount();
    }

    @Override
    public Book findBookById(Integer bookId) {
        Book book = bookMapper.selectBookById(bookId);
        if (book == null) {
            throw new CustomizeException(ResultCode.RECORD_NOT_FOUND,"查询不到该书籍");
        }
        return book;
    }
}
