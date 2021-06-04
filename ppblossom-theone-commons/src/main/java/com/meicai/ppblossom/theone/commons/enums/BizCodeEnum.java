package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

@Getter
public enum BizCodeEnum {
    //2001011 2001012 已占用
    APPOINT_BASIC_INVALID(2001001, "协议基础信息校验不通过"),
    APPOINT_PRODUCT_INVALID(2001002, "协议商品信息校验不通过"),
    APPOINT_NOT_EXISTS(2001003, "协议不存在或当前客户无权限查看该协议"),
    APPOINT_PURCHASE_INVALID(2001010, "一次最多关联 10 个采购单");

    private Integer code;
    private String message;

    BizCodeEnum(Integer code, String message) {
        this.code       = code;
        this.message    = message;
    }
}
