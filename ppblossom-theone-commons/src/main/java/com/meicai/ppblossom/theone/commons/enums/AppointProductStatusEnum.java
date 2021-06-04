package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

/**
 * @program: ppblossom-theone
 * @description: 协议商品枚举
 * @author: hand
 * @date: 2020-09-16 15:15
 **/

@Getter
public enum AppointProductStatusEnum {
    TO_NORMAL(0,"正常"),
    TO_CANCEL(1, "作废");

    private Integer code;
    private String message;

    AppointProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
