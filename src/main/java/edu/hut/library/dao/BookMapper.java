package edu.hut.library.dao;

import edu.hut.library.param.BookParam;
import edu.hut.library.pojo.Book;

import java.util.List;

public interface BookMapper {
    int deleteBookById(Integer bookId);

    int insert(Book record);

    Book selectBookById(Integer bookId);

    int updateBookById(Book record);

    List<Book> selectBooksByBookParam(BookParam param);

    int selectCount();
}