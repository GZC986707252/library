package edu.hut.library.service;

import edu.hut.library.pojo.BorrowInfo;
import edu.hut.library.pojo.ReturnInfo;

import java.util.List;

/**
 * @Description: 书籍归还业务接口
 * @Author: guozongchao
 * @Date: 2020/5/29 15:37
 */
public interface ReturnService {
    BorrowInfo returnBook(Integer bookId);

    List<ReturnInfo> getReturnRecords(Long readerId, Integer bookId);
}
