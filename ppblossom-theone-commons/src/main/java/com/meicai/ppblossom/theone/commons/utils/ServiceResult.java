package com.meicai.ppblossom.theone.commons.utils;

import java.io.Serializable;

public class ServiceResult<T> implements Serializable {
    private int ret = 1;
    private int error_code;
    private String error;
    private T data;

    public ServiceResult() {
    }

    public ServiceResult(T body) {
        this.data = body;
    }

    public ServiceResult(int errorCode, String message) {
        this.ret = 0;
        this.error_code = errorCode;
        this.error = message;
    }

    public boolean getSuccess() {
        return this.ret == 1 ? true : false;
    }

    public void setSuccess(boolean success) {
        this.ret = success ? 1 : 0;
    }

    public int getErrorCode() {
        return this.error_code;
    }

    public void setErrorCode(int errorCode) {
        this.error_code = errorCode;
    }

    public String getMessage() {
        return this.error;
    }

    public void setMessage(String message) {
        this.error = message;
    }

    public T getBody() {
        return this.data;
    }

    public void setBody(T body) {
        this.data = body;
    }
}
