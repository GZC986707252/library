package edu.hut.library.service;

import edu.hut.library.param.BookParam;
import edu.hut.library.pojo.Book;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 17:54
 */
public interface BookService {
    int addBook(Book record);

    int updateBook(Book record);

    int deleteBookById(Integer bookId);

    Book findBookById(Integer bookId);

    List<Book> getBooksByBookParam(BookParam param);

    int getCount();
}
