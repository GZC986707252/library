package edu.hut.library.controller;

import edu.hut.library.param.ReaderParam;
import edu.hut.library.pojo.Reader;
import edu.hut.library.service.ReaderService;
import edu.hut.library.util.ResultCode;
import edu.hut.library.util.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: guozongchao
 * @Date: 2020/5/28 14:13
 */
@RestController
@RequestMapping("/reader")
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    /**
     * 分页查询读者列表
     * @param page 页码
     * @param limit 每页数量
     * @return
     */
    @GetMapping("/list")
    public ResultVO getReaders(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer limit) {
        ReaderParam param = new ReaderParam();
        param.setPage(page);
        param.setLimit(limit);
        List<Reader> readers = readerService.getReadersByReaderParam(param);
        int count =readerService.getCount();
        return new ResultVO(ResultCode.SUCCESS, count, readers);
    }

    /**
     * 添加读者
     * @param reader
     * @return
     */
    @PostMapping("/list")
    public ResultVO addReader(@RequestBody @Valid Reader reader) {
        readerService.addReader(reader);
        return new ResultVO(ResultCode.SUCCESS, null);
    }

    /**
     * 根据ID查询读者
     * @param rid
     * @return
     */
    @GetMapping("/list/{rid}")
    public ResultVO getReader(@PathVariable Integer rid) {
        Reader reader = readerService.findReaderById(rid.longValue());

        return new ResultVO(ResultCode.SUCCESS, reader);
    }

    /**
     * 删除读者
     * @param rid
     * @return
     */
    @DeleteMapping("/list/{rid}")
    public ResultVO deleteReader(@PathVariable Integer rid) {
        readerService.deleteReaderById(rid.longValue());
        return new ResultVO(ResultCode.SUCCESS, null);
    }

    /**
     * 更新读者
     * @param rid
     * @param reader
     * @return
     */
    @PutMapping("/list/{rid}")
    public ResultVO updateReader(@PathVariable Integer rid,@RequestBody @Valid Reader reader) {
        reader.setReaderId(rid.longValue());
        readerService.updateReader(reader);
        return new ResultVO(ResultCode.SUCCESS, null);
    }

    /**
     * 多条件查询读者
     * @param param
     * @return
     */
    @GetMapping("/search")
    public ResultVO searchReaders(ReaderParam param) {
        System.out.println(param);
        param.setPage(null);
        param.setLimit(null);
        if(param.getReaderName().isEmpty()){
            param.setReaderName(null);
        }
        if(param.getPhone().isEmpty()){
            param.setPhone(null);
        }
        System.out.println(param);
        List<Reader> readers = readerService.getReadersByReaderParam(param);
        return new ResultVO(ResultCode.SUCCESS, readers);
    }

}
