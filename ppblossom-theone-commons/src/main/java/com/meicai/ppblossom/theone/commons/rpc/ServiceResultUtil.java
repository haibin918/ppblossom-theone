package com.meicai.ppblossom.theone.commons.rpc;

import com.meicai.ppblossom.theone.commons.enums.ErrorCode;
import com.meicai.ppblossom.theone.commons.utils.ServiceResult;

public class ServiceResultUtil {

    public static boolean isSuccess(ServiceResult<?> result) {
        return result != null && result.getSuccess();
    }

    public static <T> ServiceResult<T> success(T data) {
        ServiceResult<T> result = new ServiceResult<>();
        result.setErrorCode(ErrorCode.SUCCESS.getCode());
        result.setMessage("");
        result.setSuccess(true);
        result.setBody(data);
        return result;
    }

    public static <T> ServiceResult<T> error(ErrorCode code) {
        ServiceResult<T> result = new ServiceResult<>();
        result.setErrorCode(code.getCode());
        result.setMessage(code.getMessage());
        result.setSuccess(false);
        result.setBody(null);
        return result;
    }

    public static <T> ServiceResult<T> error(ErrorCode code, T data) {
        ServiceResult<T> result = new ServiceResult<>();
        result.setErrorCode(code.getCode());
        result.setMessage(code.getMessage());
        result.setSuccess(false);
        result.setBody(data);
        return result;
    }

    public static <T> ServiceResult<T> error(int code, String message, T data) {
        ServiceResult<T> result = new ServiceResult<>();
        result.setErrorCode(code);
        result.setMessage(message);
        result.setSuccess(false);
        result.setBody(data);
        return result;
    }

}
