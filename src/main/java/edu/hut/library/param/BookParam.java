package edu.hut.library.param;

import edu.hut.library.pojo.Book;

/**
 * @Description: 书籍查询参数
 * @Author: guozongchao
 * @Date: 2020/5/28 16:53
 */
public class BookParam extends Book {
    private Integer page;
    private Integer limit;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "BookParam{" +
                "bookId="+this.getBookId()+
                ", bookName="+this.getBookName()+
                ", bookISBN="+this.getIsbn()+
                ", status="+this.getStatus()+
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}
