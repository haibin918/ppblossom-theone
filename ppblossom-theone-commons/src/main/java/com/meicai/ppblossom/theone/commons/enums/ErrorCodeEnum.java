package com.meicai.ppblossom.theone.commons.enums;


import com.meicai.ppblossom.theone.commons.exception.BizException;

public enum ErrorCodeEnum {

    ARG_MUST_NOT_NULL(100_100, "[%s]参数不能为空"),
    COLLECTION_MUST_NOT_NULL(100_101, "[%s]参数不能为空");

    private Integer code;

    private String message;


    private ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BizException getException(String message) {
        return new BizException(code, String.format(this.message, message));
    }


    public BizException getException() {
        return new BizException(code, this.message);
    }

    public BizException getException(Throwable e) {
        return new BizException(code, this.message, e);
    }

    public BizException getException(String message, Throwable e) {
        return new BizException(code, String.format(this.message, message), e);
    }

}
