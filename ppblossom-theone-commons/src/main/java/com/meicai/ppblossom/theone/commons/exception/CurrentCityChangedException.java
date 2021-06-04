package com.meicai.ppblossom.theone.commons.exception;

import com.meicai.ppblossom.theone.commons.constants.ExceptionConstant;

/**
 * @ClassName CurrentCityChangedException
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/12 12:02
 * @Version 1.0
 **/
public class CurrentCityChangedException extends RuntimeException implements
        BaseException {
    private static final long serialVersionUID = 1L;

    public CurrentCityChangedException(String msg) {
        super(msg);
    }

    public CurrentCityChangedException(String msg, Throwable t) {
        super(msg, t);
    }

    public int getErrorCode() {
        return ExceptionConstant.CITY_CHANGED_CODE;
    }

}