package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ContractSignTypeEnum
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/9/11 17:10
 * @Version 1.0
 **/

@Getter
public enum ContractSignTypeEnum {

    SIGN_NOT(0, "不是签署状态"),

    SIGN_A(1, "甲方签署"),

    SIGN_B(2, "乙方签署"),

    SIGN_C(3, "丙方签署");

    private Integer type;

    private String name;

    ContractSignTypeEnum(Integer type, String name) {

        this.type = type;
        this.name = name;
    }

    public static Map<Integer, String> getContractSignTypeMap() {

        Map<Integer, String> map = new HashMap<>();

        for (ContractSignTypeEnum contractSignTypeEnum : ContractSignTypeEnum.values()) {

            map.put(contractSignTypeEnum.getType(), contractSignTypeEnum.getName());
        }

        return map;
    }

    public static ContractSignTypeEnum getType(int value) {

        for (ContractSignTypeEnum type : ContractSignTypeEnum.values()) {

            if (type.type == value) {

                return type;
            }
        }

        return null;
    }
}
