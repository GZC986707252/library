package edu.hut.library.controller;

import edu.hut.library.pojo.Book;
import edu.hut.library.pojo.BorrowInfo;
import edu.hut.library.pojo.Reader;
import edu.hut.library.service.BookService;
import edu.hut.library.service.BorrowService;
import edu.hut.library.service.ReaderService;
import edu.hut.library.service.ReturnService;
import edu.hut.library.util.ResultCode;
import edu.hut.library.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/29 17:55
 */
@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private BorrowService borrowService;
    @Autowired
    private ReturnService returnService;
    @Autowired
    private BookService bookService;

    @PostMapping("/borrow")
    public ResultVO borrowBook(@RequestParam(required = true) Long readerId, @RequestParam(required = true) Integer bookId) {
        borrowService.borrowBook(readerId, bookId);
        return new ResultVO(ResultCode.SUCCESS,null);
    }

    @PostMapping("/return")
    public ResultVO returnBook(@RequestParam(required = true) Integer bookId) {
        BorrowInfo borrowInfo = returnService.returnBook(bookId);
        Map<String, Object> data = new HashMap<>();
        data.put("readerId", borrowInfo.getReaderId());
        data.put("bookId",borrowInfo.getBookId());
        return new ResultVO(ResultCode.SUCCESS,data);
    }


    @GetMapping("/borrow_record")
    public ResultVO getBorrowRecords(@RequestParam(required = true) Long readerId) {
        List<BorrowInfo> records = borrowService.getBorrowRecordsByReaderId(readerId);
        return new ResultVO(ResultCode.SUCCESS, records);
    }

}
