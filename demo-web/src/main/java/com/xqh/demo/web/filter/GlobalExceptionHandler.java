package com.xqh.demo.web.filter;

import com.xqh.demo.web.common.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by xqh on 2018/1/28.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseResult exceptionHandler(Exception ex) {
        return ResponseResult.createError(ex.getMessage());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseResult nullPointerExceptionHandler(NullPointerException ex) {
        return ResponseResult.createError(ex.toString());
    }
}
