package edu.hut.library.param;

import edu.hut.library.pojo.Reader;

/**
 * @Description: 读者参数类
 * @Author: guozongchao
 * @Date: 2020/5/28 20:35
 */
public class ReaderParam extends Reader {
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
        return "ReaderParam{" +
                "id=" + this.getReaderId() +
                ", name=" + this.getReaderName() +
                ", phone=" + this.getPhone() +
                ", page=" + page +
                ", limit=" + limit +
                '}';
    }
}
