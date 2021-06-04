package com.meicai.ppblossom.theone.api.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class ApiJsonResult<T> implements Serializable {
    /**
     * 错误码
     */
    private int ret = 1;

    /**
     * 错误码
     */
    private int error_code = 0;
    /**
     * 错误message
     */
    private Error error;

    private T data;

    public static <T> ApiJsonResult<T> success() {
        return new ApiJsonResult<T>();
    }

    public ApiJsonResult() {
    }

    /**
     * 成功
     *
     * @param body
     * @param <T>
     * @return
     */
    public static <T> ApiJsonResult<T> success(T body) {
        return new ApiJsonResult<T>(body);
    }

    public ApiJsonResult(T body) {
        this.data = body;
    }

    /**
     * 获取失败的返回
     *
     * @param errorCode
     * @param message
     * @return
     */
    public static <T> ApiJsonResult<T> failure(int errorCode, String message) {
        Error error = new Error(errorCode,message);
        return new ApiJsonResult<>(errorCode,error);
    }

    /**
     * 获取失败的返回
     *
     * @param errorCode
     * @param message
     * @return
     */
    public static <T> ApiJsonResult<T> failure(int errorCode, String message,String type ,String name) {
        Error error = new Error(errorCode,name,type,message);
        return new ApiJsonResult<>(errorCode,error);
    }

    /**
     * 自定义错误
     * @param error
     */
    public ApiJsonResult(int errorCode,Error error) {
        this.ret = 0;
        this.error_code = errorCode;
        this.error = error;
    }


}
