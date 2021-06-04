package com.meicai.ppblossom.theone.commons.utils;

import com.meicai.ppblossom.theone.commons.exception.BaseException;
import com.meicai.ppblossom.theone.commons.exception.ExceptionUtil;

/**
 * @ClassName ServiceResultUtil
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/6/12 11:54
 * @Version 1.0
 **/
public class ServiceResultUtil {

    public static <T> ServiceResult<T> success(T body) {
        ServiceResult<T> serviceResult = new ServiceResult<>();
        serviceResult.setSuccess(true);
        serviceResult.setBody(body);
        return serviceResult;
    }

    public static <T> ServiceResult<T> failure(Integer errorCode, String message) {
        ServiceResult<T> serviceResult = new ServiceResult<>();
        serviceResult.setSuccess(false);
        serviceResult.setErrorCode(errorCode);
        serviceResult.setMessage(message);
        return serviceResult;
    }

    public static <T> ServiceResult<T> failure(Integer errorCode, String message, T body) {
        ServiceResult<T> serviceResult = new ServiceResult<>();
        serviceResult.setSuccess(false);
        serviceResult.setErrorCode(errorCode);
        serviceResult.setMessage(message);
        serviceResult.setBody(body);
        return serviceResult;
    }

    public static ServiceResult<RuntimeException> failure(Throwable ex) {
        BaseException be = ExceptionUtil.parseException(ex);

        ServiceResult<RuntimeException> sr = new ServiceResult<>();
        sr.setSuccess(false);
        sr.setErrorCode(be.getErrorCode());
        sr.setMessage(be.getMessage());

        return sr;
    }
}
