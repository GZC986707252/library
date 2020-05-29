package edu.hut.library.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ReturnInfo{
    private Integer rId;

    private Long readerId;

    private Integer bookId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date borrowTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date returnTime;

    private Book bookInfo;

    public Book getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(Book bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Integer getrId() {
        return rId;
    }

    public void setrId(Integer rId) {
        this.rId = rId;
    }

    public Long getReaderId() {
        return readerId;
    }

    public void setReaderId(Long readerId) {
        this.readerId = readerId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public Date getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }
}