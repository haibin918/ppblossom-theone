package com.meicai.ppblossom.theone.commons.exception;


import com.meicai.ppblossom.theone.commons.constants.ExceptionConstant;

/**
 * Exception 描述：未响应
 *
 * @author Administrator
 */
public class NotResponseException extends RuntimeException implements
        BaseException {
    private static final long serialVersionUID = 1L;

    public NotResponseException(String msg) {
        super(msg);
    }

    public NotResponseException(String msg, Throwable t) {
        super(msg, t);
    }

    @Override
    public int getErrorCode() {
        return ExceptionConstant.NOT_RESPONSE_CODE;
    }

}
