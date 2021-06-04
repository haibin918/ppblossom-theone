package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

/**
 * @Author: guohaibin
 * @Date: 2020/06/03
 * @Version 1.0
 */
@Getter
public enum ModuleTypeEnum {
    POP_WINDOW("pop_window", "弹窗"),
    CAROUSEL("carousel", "轮播图");

    private String type;
    private String desc;

    ModuleTypeEnum(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
}
