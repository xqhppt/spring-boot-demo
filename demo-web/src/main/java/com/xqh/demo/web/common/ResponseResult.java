package com.xqh.demo.web.common;

import com.fasterxml.jackson.databind.JsonSerializable;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xqh on 2018/1/28.
 */
public class ResponseResult<T> implements Serializable {
    private int code;

    private String message;

    private T data;

    private String serverTime;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    private ResponseResult(int code, T data) {
        this(code, null, data);
    }

    private ResponseResult(int code, String message) {
        this(code, message, null);
    }

    private ResponseResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.serverTime = df.format(new Date());
    }

    public static<T> ResponseResult<T> createSuccess(T t) {
        return new ResponseResult<T>(ApiResponseCode.SUCCESS.getCode(),t);
    }
}
