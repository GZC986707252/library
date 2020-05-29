package edu.hut.library.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;

public class Book {
    private Integer bookId;

    @NotBlank(message = "书名不能为空")
    private String bookName;

    @NotBlank(message = "ISBN不能为空")
    private String isbn;

    @NotBlank(message = "作者不能为空")
    private String author;

    @NotBlank(message = "出版社不能为空")
    private String press;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "出版日期不能在当前时间之后")
    private Date publicationDate;

    @DecimalMin(value = "0.00",message = "价格必须大于或者等于0.00")
    private BigDecimal price;

    private Boolean status;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press == null ? null : press.trim();
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                ", status=" + status +
                ", createTime=" + createTime +
                '}';
    }
}