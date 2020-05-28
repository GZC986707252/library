package edu.hut.library.exception;

import edu.hut.library.util.ResultCode;

/**
 * @Description: 自定义异常
 * @Author: guozongchao
 * @Date: 2020/5/28 0:51
 */
public class CustomizeException extends RuntimeException{
    private int code;
    private String msg;

    public CustomizeException(int code, String msg) {
        super(msg);
        this.code=code;
        this.msg=msg;
    }
    public CustomizeException(ResultCode resultCode) {
        this(resultCode.getCode(), resultCode.getMsg());
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
