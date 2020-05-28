package edu.hut.library.service;

import edu.hut.library.pojo.Reader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 13:59
 */

@SpringBootTest
public class ReaderServiceTest {
    @Autowired
    private ReaderService readerService;

    @Test
    public void testGetReaderListWithCount() {
       /* Map<String,Object> map1 = readerService.getReaderListWithCount(1, 5);
        List<Reader> readers1= (List<Reader>) map1.get("data");
        int count1 = (int) map1.get("count");
        Map<String,Object> map2 = readerService.getReaderListWithCount(2, 5);
        List<Reader> readers2= (List<Reader>) map2.get("data");
        int count2 = (int) map2.get("count");
        Map<String,Object> map3 = readerService.getReaderListWithCount(null, 5);
        List<Reader> readers3= (List<Reader>) map3.get("data");
        int count3 = (int) map3.get("count");
        Map<String,Object> map4 = readerService.getReaderListWithCount(1, null);
        List<Reader> readers4= (List<Reader>) map4.get("data");
        int count4 = (int) map4.get("count");
        Map<String,Object> map5 = readerService.getReaderListWithCount(null, null);
        List<Reader> readers5= (List<Reader>) map5.get("data");
        int count5 = (int) map5.get("count");

        assertEquals(5, readers1.size());
        assertEquals(16, count1);

        assertEquals(5, readers2.size());
        assertEquals(16, count1);

        assertEquals(16, readers3.size());
        assertEquals(16, count1);

        assertEquals(16, readers4.size());
        assertEquals(16, count1);

        assertEquals(16, readers5.size());
        assertEquals(16, count1);*/
    }
}
