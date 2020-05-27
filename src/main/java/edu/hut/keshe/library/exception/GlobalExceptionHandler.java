package edu.hut.keshe.library.exception;

import edu.hut.keshe.library.util.ResultCode;
import edu.hut.keshe.library.util.ResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description: 全局异常处理
 * @Author: guozongchao
 * @Date: 2020/5/28 0:55
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    /**
     * 自定义异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(CustomizeException.class)
    public ResultVO customizeExceptionHandler(CustomizeException e){
        log.error(e.getMessage());
        return new ResultVO(e.getCode(),e.getMsg(),null);
    }

    /**
     * 其他异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResultVO ExceptionHandler(Exception e){
        log.error(e.getMessage());
        return new ResultVO(ResultCode.UNKNOWN_ERROR,e.getMessage());
    }
}
