package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ContractType
 * @Description
 * @Author wzj
 * @Date 2020/8/20 13:46
 **/

@Getter
public enum ContractTypeEnum {

    TRIPARTITE(1, "三方合同"),

    SUPPLY(2, "供货合同"),

    SIDE_AGREEMENT(3, "补充协议");

    private Integer type;

    private String name;

    ContractTypeEnum(Integer type, String name) {
        this.type = type;
        this.name = name;
    }

    public static Map<Integer, String> getContractTypeMap() {

        Map<Integer, String> map = new HashMap<>();

        for (ContractTypeEnum contractType : ContractTypeEnum.values()) {

            map.put(contractType.getType(), contractType.getName());
        }
        return map;
    }

    public static ContractTypeEnum getType(int value) {
        for (ContractTypeEnum type : ContractTypeEnum.values()) {
            if (type.type == value) {
                return type;
            }
        }
        return null;
    }
}
