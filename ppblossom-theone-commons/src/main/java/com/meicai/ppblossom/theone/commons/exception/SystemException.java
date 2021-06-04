package com.meicai.ppblossom.theone.commons.exception;

import com.meicai.ppblossom.theone.commons.constants.ExceptionConstant;

/**
 * @ClassName SystemException
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/12 11:57
 * @Version 1.0
 **/
public class SystemException extends RuntimeException implements BaseException {
    private static final long serialVersionUID = 1L;

    public SystemException(String msg) {
        super(msg);
    }

    public SystemException(String msg, Throwable t) {
        super(msg, t);
    }

    public int getErrorCode() {
        return ExceptionConstant.SYSTEM_ERROR_CODE;
    }
}
