package com.meicai.ppblossom.theone.commons.exception;


import com.meicai.ppblossom.theone.commons.constants.ExceptionConstant;

public class DatabaseAccessException extends RuntimeException implements BaseException {

    private static final long serialVersionUID = 1L;

    public DatabaseAccessException(String msg) {
        super(msg);
    }

    public DatabaseAccessException(String msg, Throwable t) {
        super(msg, t);
    }

    public int getErrorCode() {

        return ExceptionConstant.DATABASE_ACCESS_ERROR;
    }

}
