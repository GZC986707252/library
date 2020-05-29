package edu.hut.library.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BorrowInfo{
    private Integer borrowId;

    private Long readerId;

    private Integer bookId;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date borrowTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date expireTime;
    private Book bookInfo;

    public Book getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(Book bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
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

    public Date getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
}