package com.meicai.ppblossom.theone.commons.exception;

import com.meicai.ppblossom.theone.commons.constants.ExceptionConstant;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/12 11:59
 * @Version 1.0
 **/
public class BusinessException extends RuntimeException implements
        BaseException {
    private static final long serialVersionUID = 1L;

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, Throwable t) {
        super(msg, t);
    }

    public int getErrorCode() {
        return ExceptionConstant.BUSINISS_ERROR_CODE;
    }

}