package edu.hut.library.dao;

import edu.hut.library.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/30 15:48
 */
@SpringBootTest
public class AdminMapperTest {

    @Resource
    private AdminMapper adminMapper;

    @Test
    public void test1() {
        Admin admin = new Admin();
        admin.setAdminName("abc");
        admin.setPassword("123456");
        assertEquals(1, adminMapper.insert(admin));

    }

    @Test
    public void test2() {
        Admin admin = new Admin();
        admin.setAdminName(null);
        admin.setPassword("123456");
        assertEquals(0, adminMapper.insert(admin));
    }

    @Test
    public void test3() {
        assertEquals(0, adminMapper.insert(null));
    }


}
