package com.meicai.ppblossom.theone.commons.exception;

/**
 * @ClassName BaseException
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/6 09:56
 * @Version 1.0
 **/
public interface BaseException {

    /**
     * 获得异常码
     *
     * @return
     */
    int getErrorCode();

    /**
     * 获得异常信息
     *
     * @return
     */
    String getMessage();
}
