package com.xqh.demo.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xqh.demo.web.common.ResponseResult;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import springfox.documentation.spring.web.json.Json;

/**
 * Created by xqh on 2018/1/28.
 */
@ControllerAdvice
public class ResponseFilter implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        if(body instanceof springfox.documentation.spring.web.json.Json){
//            return body;
//        }

        if(request.getURI().getPath().contains("api-docs") || request.getURI().getPath().contains("swagger")){
            return body;
        }
        if(body instanceof ResponseResult){
            return body;
        }
        return ResponseResult.createSuccess(body);
    }
}
