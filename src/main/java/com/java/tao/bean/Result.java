package com.java.tao.bean;

public class Result {
    private int code;
    private String message;
    private Object data;

    public Result(){}
    public Result(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public static Result success(Object data){
        return new Result(0, "success", data);
    }
    public static Result fail(String message){
        return new Result(-1, message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
