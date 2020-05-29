package edu.hut.library.service;

import edu.hut.library.pojo.BorrowInfo;

import java.util.List;

/**
 * @Description: 书籍借阅业务接口
 * @Author: guozongchao
 * @Date: 2020/5/29 13:28
 */
public interface BorrowService {

    void borrowBook(Long readerId, Integer bookId);

    List<BorrowInfo> getBorrowRecordsByReaderId(Long readerId);
}
