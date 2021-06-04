package com.meicai.ppblossom.theone.commons.enums;


/**
 * 数据源类型
 */
public enum DatasourceEnum {
    LADDER("ladder","主数据源"),
    KEYCLIENT("keyclient","次数据源");
    private String code;
    private String message;

    DatasourceEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}