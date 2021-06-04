package com.meicai.ppblossom.theone.commons.enums;

/**
 *  弹窗模块类型的枚举
 */
public enum PopwindowTypeEnum {

    COUPON(1, "coupon"),

    GOODS(2, "goods");


    private int code;

    private String name;

    PopwindowTypeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public String getName(){ return this.name;}

    public boolean is(PopwindowTypeEnum en) {
        return this.equals(en);
    }

}
