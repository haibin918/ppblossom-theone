package com.meicai.ppblossom.theone.commons.exception;


import com.meicai.ppblossom.theone.commons.constants.ExceptionConstant;

/**
 * @ClassName InvalidParamException
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/6 09:57
 * @Version 1.0
 **/
public class InvalidParamException extends RuntimeException implements
        BaseException {
    private static final long serialVersionUID = 1L;

    public InvalidParamException(String msg) {
        super(msg);
    }

    public InvalidParamException(String msg, Throwable t) {
        super(msg, t);
    }

    public int getErrorCode() {
        return ExceptionConstant.INVALID_PARAM_ERROR_CODE;
    }

}

