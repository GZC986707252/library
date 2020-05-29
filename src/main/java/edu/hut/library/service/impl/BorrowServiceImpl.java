package edu.hut.library.service.impl;

import edu.hut.library.dao.BookMapper;
import edu.hut.library.dao.BorrowInfoMapper;
import edu.hut.library.dao.ReaderMapper;
import edu.hut.library.exception.CustomizeException;
import edu.hut.library.pojo.Book;
import edu.hut.library.pojo.BorrowInfo;
import edu.hut.library.pojo.Reader;
import edu.hut.library.service.BorrowService;
import edu.hut.library.util.ResultCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description: 书籍借阅业务实现类
 * @Author: guozongchao
 * @Date: 2020/5/29 13:39
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class BorrowServiceImpl implements BorrowService {

    //设置书籍可以借阅的月份数
    private final int NUMBER_OF_MONTHS=3;
    @Resource
    private ReaderMapper readerMapper;
    @Resource
    private BookMapper bookMapper;
    @Resource
    private BorrowInfoMapper borrowInfoMapper;

    /**
     * 书籍借阅业务
     * @param readerId
     * @param bookId
     * @return
     */
    @Override
    public void borrowBook(Long readerId, Integer bookId) {
        Reader reader = readerMapper.selectReaderById(readerId);
        Book book = bookMapper.selectBookById(bookId);
        //查询读者
        if ( reader== null) {
            throw new CustomizeException(ResultCode.RECORD_NOT_FOUND, "读者编号"+readerId+"不存在");
        }
        //查询书籍
        if ( book== null) {
            throw new CustomizeException(ResultCode.RECORD_NOT_FOUND,"书籍编号"+bookId+"不存在");
        }
        //书籍是否已借出
        if(book.getStatus()){
            throw new CustomizeException(ResultCode.FAILED,"借阅失败,当前书籍不在馆");
        }
        //获取当前时间
        Date now = new Date();
        //计算过期时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        //当前月份+3，作为书籍过期时间
        calendar.add(Calendar.MONTH,NUMBER_OF_MONTHS);

        BorrowInfo borrowInfo = new BorrowInfo();
        borrowInfo.setReaderId(readerId);
        borrowInfo.setBookId(bookId);
        borrowInfo.setBorrowTime(now);  //设置借阅时间
        borrowInfo.setExpireTime(calendar.getTime()); //设置过期时间
        //添加借阅记录
        borrowInfoMapper.insert(borrowInfo);
        //更新书籍在馆状态为“借出（true）”
        book.setStatus(true);
        bookMapper.updateBookById(book);
    }

    /**
     * 根据读者ID获取读者借阅记录
     * @param readerId
     * @return
     */
    @Override
    public List<BorrowInfo> getBorrowRecordsByReaderId(Long readerId) {
        return borrowInfoMapper.selectByReaderId(readerId);
    }

}
