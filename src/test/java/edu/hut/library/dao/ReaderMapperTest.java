package edu.hut.library.dao;

import edu.hut.library.LibraryApplication;
import edu.hut.library.pojo.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @Author: guozongchao
 * @Date: 2020/5/28 12:39
 */
@SpringBootTest(classes = LibraryApplication.class)
public class ReaderMapperTest {

    @Resource
    private ReaderMapper readerMapper;

    @Test
    @Transactional    //测试完回滚
    public void testInsert() {
        int num=0;
        Reader reader =new Reader();
        for (int i = 0; i < 15; i++) {
            reader.setReaderName("张三" + i);
            reader.setPhone("13124974854");
            num+=readerMapper.insert(reader);
        }
        assertEquals(15,num);
    }

    @Test
    @Transactional
    public void testUpdate(){
        Reader reader = new Reader();
        reader.setReaderId((long)2020015);
        reader.setReaderName("李四");
        assertEquals(1,readerMapper.updateReaderById(reader));
    }

    @Test
    @Transactional
    public void testDelete(){
        assertEquals(1,readerMapper.deleteReaderById((long)2020014));
    }

    @Test
    public void testSelect(){
        Reader reader = readerMapper.selectReaderById((long)2020015);
        assertEquals(2020015,reader.getReaderId());
    }

    @Test
    public void testSelectCount(){
        int count = readerMapper.selectCount();
        assertEquals(16,count);
    }

    @Test
    public void testSelectReaders(){
       /* List<Reader> readers1 = readerMapper.selectReaders(1,10);
        List<Reader> readers2 = readerMapper.selectReaders(null,null);
        assertEquals(10,readers1.size());
        assertEquals(16,readers2.size());*/
    }
}
