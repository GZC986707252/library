package edu.hut.keshe.library.util;

/**
 * @Description: 统一响应数据格式封装
 * @Author: guozongchao
 * @Date: 2020/5/28 0:31
 */
public class ResultVO<T> {
    private int code;
    private String msg;
    private int count;
    private T data;

    public ResultVO(int code,String msg,T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public ResultVO(int code,String msg,int count,T data){
        this(code,msg,data);
        this.count=count;
    }

    public ResultVO(ResultCode resultCode,T data){
        this(resultCode.getCode(),resultCode.getMsg(),data);
    }
    public ResultVO(ResultCode resultCode,int count ,T data){
        this(resultCode.getCode(),resultCode.getMsg(),count,data);
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
