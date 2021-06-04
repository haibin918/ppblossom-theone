package com.meicai.ppblossom.theone.commons.exception;


import com.meicai.ppblossom.theone.commons.enums.BizCodeEnum;
import com.meicai.ppblossom.theone.commons.enums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Author: guohaibin
 * @Date: 2020/06/03
 * @Version 1.0
 */
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
public class BizException extends RuntimeException {

	private static final long serialVersionUID = -8817615173762463039L;
	private int code;
    private String message;

    public BizException(int code, String message, Throwable e) {
        super(message, e);
        this.code = code;
        this.message = message;
    }

    public BizException(ErrorCode errorCodeEnum) {
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMessage();
    }

    public BizException(BizCodeEnum bizCodeEnum) {
        this.code = bizCodeEnum.getCode();
        this.message = bizCodeEnum.getMessage();
    }

}
