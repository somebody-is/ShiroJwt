package com.lzf.shirojwt.exception;

import com.lzf.shirojwt.model.BaseResponse;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zongfang
 * @date 2022/4/20
 */
@RestControllerAdvice
public class ExceptionController {


    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public BaseResponse<String> handle4011(ShiroException e) {
        e.printStackTrace();
        return new BaseResponse<>(401, "", null);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public BaseResponse<String> handle401(UnauthorizedException e) {
        e.printStackTrace();
        return new BaseResponse<>(401, "没有权限", null);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse<String> globalException(HttpServletRequest request, Throwable ex) {
        ex.printStackTrace();
        return new BaseResponse<>(400, "出错了，请稍后再试~", null);
    }

}
