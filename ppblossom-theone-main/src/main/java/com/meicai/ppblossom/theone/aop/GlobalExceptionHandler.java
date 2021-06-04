package com.meicai.ppblossom.theone.aop;



import com.meicai.ppblossom.theone.api.response.JsonResult;
import com.meicai.ppblossom.theone.commons.enums.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;

/**
 * @author guohaibin
 * @date 2020/6/4
 */
@ResponseBody
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    JsonResult<String> handle(ConstraintViolationException e) {
        log.error("ConstraintViolationException", e);
        StringBuffer sb = new StringBuffer();
        e.getConstraintViolations().forEach(c -> {
            sb.append(c.getRootBeanClass().getName()).append(".").append(c.getPropertyPath()).append(c.getMessage())
                    .append(";");
        });
        return JsonResult.failure(ErrorCode.INVALID_PARAM_EXCEPTION.getCode(), ErrorCode.INVALID_PARAM_EXCEPTION.getMessage() + " : " + sb.toString());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    JsonResult<String> handle(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException", e);

        StringBuffer sb = new StringBuffer();
        e.getBindingResult().getFieldErrors().forEach(c -> {
            sb.append(c.getDefaultMessage()).append(";");
        });
        return JsonResult.failure(ErrorCode.INVALID_PARAM_EXCEPTION.getCode(), ErrorCode.INVALID_PARAM_EXCEPTION.getMessage() + " : " + sb.toString());
    }

}
