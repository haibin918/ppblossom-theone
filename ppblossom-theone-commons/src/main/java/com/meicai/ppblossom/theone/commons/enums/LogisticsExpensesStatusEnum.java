package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


@Getter
public enum LogisticsExpensesStatusEnum {


    WJS(0, "未结算"),

    JSZ(1, "结算中"),

    YJS(2, "已结算");


    private Integer status;

    private String name;

    LogisticsExpensesStatusEnum(Integer status, String name) {

        this.status = status;
        this.name = name;
    }

    public static Map<Integer, String> getLogisticsExpensesStatusMap() {

        Map<Integer, String> resMap = new HashMap<>();

        for (LogisticsExpensesStatusEnum logisticsExpensesStatusEnum : LogisticsExpensesStatusEnum.values()) {

            resMap.put(logisticsExpensesStatusEnum.status, logisticsExpensesStatusEnum.getName());
        }

        return resMap;
    }

    public static String getValueByStatus(Integer status) {

        for (LogisticsExpensesStatusEnum logisticsExpensesStatusEnum : LogisticsExpensesStatusEnum.values()) {

            if (status.equals(logisticsExpensesStatusEnum.status)) {

                return logisticsExpensesStatusEnum.name;
            }

        }
        return "";
    }
}