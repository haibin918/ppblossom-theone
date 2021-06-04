package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * @Author: guohaibin
 * @Date: 2020/06/03
 * @Version 1.0
 */
@Getter
public enum ElementTypeEnum {
    COUPON("coupon", "couponDataParser", "优惠券"),
    GOODS("goods", "goodDataParser", "商品"),
    TEXT("text", "staticDataParser", "文本"),
    IMG("img", "staticDataParser", "图片");

    private String type;
    private String dataParse;
    private String desc;

    ElementTypeEnum(String type, String dataParse, String desc) {
        this.type = type;
        this.dataParse = dataParse;
        this.desc = desc;
    }

    public static String getParserByType(String type) {
        for (ElementTypeEnum elementTypeEnum : ElementTypeEnum.values()) {
            if (StringUtils.equals(elementTypeEnum.type, type)) {
                return elementTypeEnum.dataParse;
            }
        }
        return StringUtils.EMPTY;
    }
}
