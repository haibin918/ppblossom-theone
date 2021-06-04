package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

/**
 * @ClassName AppointStatusEnum
 * @Description
 * @Author wzj
 * @Date 2020/7/28 18:20
 **/

@Getter
public enum AppointStatusEnum {

    TO_BE_EFFECTIVE(1, "待生效"),
    EFFECTIVE(2, "已生效"),
    BE_OVERDUE(3, "过期"),
    TO_VOID(4, "作废");

    private Integer code;
    private String message;

    AppointStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
