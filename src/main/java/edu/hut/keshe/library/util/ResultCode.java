package edu.hut.keshe.library.util;

/**
 * @Description: 响应代码
 * @Author: guozongchao
 * @Date: 2020/5/28 0:39
 */
public enum ResultCode {

    SUCCESS(0,"操作成功"),
    FAILED(1000,"操作失败"),
    USER_NOT_LOGGED_IN(1001,"请先登录"),
    USER_NOT_FOUND(1002,"用户不存在"),
    PASSWORD_ERROR(1003,"密码错误"),
    UNKNOWN_ERROR(-1,"未知错误");
    private int code;
    private String msg;

    ResultCode(int code,String msg){
        this.code=code;
        this.msg=msg;
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
