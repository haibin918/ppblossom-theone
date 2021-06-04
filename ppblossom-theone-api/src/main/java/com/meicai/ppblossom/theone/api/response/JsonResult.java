package com.meicai.ppblossom.theone.api.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = -3388060704712156502L;
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
    private String error;


    private T data;

    public JsonResult() {
    }

    public static <T> JsonResult<T> success() {
        return new JsonResult<T>();
    }

    /**
     * 返回老数据兼容
     *
     * @param body
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> success(T body) {
        return new JsonResult<T>(body);
    }

    public JsonResult(T body) {
        this.data = body;
    }

    public JsonResult(int ret, String message) {
        this.ret = 0;
        this.error_code = ret;
        this.error = message;
    }

    /**
     * 自定义错误
     * @param ret
     * @param message
     * @param data
     */
    public JsonResult(int ret, String message,T data) {
        this.ret = 0;
        this.error_code = ret;
        this.error = message;
        this.data = data;
    }

    /**
     * 获取失败的返回
     *
     * @param errorCode
     * @param message
     * @return
     */
    public static <T> JsonResult<T> failure(int errorCode, String message) {
        return new JsonResult<>(errorCode, message);
    }

    /**
     *
     * @param errorCode
     * @param message
     * @param body
     * @param <T>
     * @return
     */
    public static <T> JsonResult<T> failure(int errorCode, String message,T body) {
        return new JsonResult<>(errorCode,message,body);
    }

    public static <T> boolean success(JsonResult<T> result) {
        return result != null && result.getRet() == 1;
    }
}
