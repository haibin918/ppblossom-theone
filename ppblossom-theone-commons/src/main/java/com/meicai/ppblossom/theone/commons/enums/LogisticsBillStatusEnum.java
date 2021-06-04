package com.meicai.ppblossom.theone.commons.enums;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum LogisticsBillStatusEnum {

    DSH(0, "待审核"),
    YSH(1, "已审核");

    private Integer status;

    private String name;

    LogisticsBillStatusEnum(Integer status, String name) {

        this.status = status;

        this.name = name;
    }

    public static Map<Integer, String> getLogisticsBillStatusEnumMap() {

        Map<Integer, String> resMap = new HashMap<>();

        for (LogisticsBillStatusEnum logisticsBillStatusEnum : LogisticsBillStatusEnum.values()) {

            resMap.put(logisticsBillStatusEnum.status, logisticsBillStatusEnum.name);
        }

        return resMap;
    }

    public static String getLogisticsBillStatusName(Integer status) {

        for (LogisticsBillStatusEnum logisticsBillStatusEnum : LogisticsBillStatusEnum.values()) {

            if (logisticsBillStatusEnum.status.equals(status)) {

                return logisticsBillStatusEnum.name;
            }
        }
        return "";
    }

}
