package com.lzf.shirojwt.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zongfang
 * @date 2022/4/19
 */
@Getter
@Setter
public class BaseResponse<T>{

    private Integer status;

    private String message;

    private T data;

    public BaseResponse() {
    }

    public BaseResponse(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "\"status\":\"" + status +
                "\", \"message\":\"" + message +
                "\", \"data\":\"" + data +
                "\"}";
    }
}
