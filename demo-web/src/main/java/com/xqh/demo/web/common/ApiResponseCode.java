package com.xqh.demo.web.common;

/**
 * Created by xqh on 2018/1/28.
 */
public enum ApiResponseCode {
    SUCCESS(0, "成功"),
    ERROR(-1, "失败"),

    ACCESS_DENIED(4000, "无操作权限");

    ApiResponseCode(int code, String name) {
        this.code = code;
        this.name = name;
    }

    private int code;

    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
