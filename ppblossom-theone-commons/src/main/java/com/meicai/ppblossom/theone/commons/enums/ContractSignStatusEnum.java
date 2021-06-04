package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ContractSignStatusEnum
 * @Description TODO
 * @Author guohaibin
 * @Date 2020/9/14 15:30
 * @Version 1.0
 **/

@Getter
public enum ContractSignStatusEnum {

    CLZ(-1, "处理中"),
    XJ(1, "新建"),
    WQRW(2, "未确认（待我确认）"),
    WQRT(3, "未确认（待他人确认）"),
    TYQR(4, "同意确认"),
    JJQR(5, "拒绝确认（被驳回）"),
    QSZA(6, "签署中（待甲方签署）"),
    QSZB(7, "签署中（待乙方签署）"),
    QSWC(8, "签署完成"),
    QSJJ(9, "签署拒绝（被拒签）"),
    ZF(10, "作废"),
    YCH(13, "已撤回"),
    QSZC(14, "签署中（待丙方签署）"),
    GB(15, "关闭");

    private Integer status;

    private String name;

    ContractSignStatusEnum(Integer status, String name) {

        this.status = status;

        this.name = name;
    }

    public static String getValueByStatus(Integer status) {

        for (ContractSignStatusEnum contractSignStatusEnum : ContractSignStatusEnum.values()) {

            if (status == contractSignStatusEnum.status) {

                return contractSignStatusEnum.name;
            }

        }
        return null;
    }

    public static Map<Integer, String> getContractSignStatusMap() {

        Map<Integer, String> resMap = new HashMap<>();

        for (ContractSignStatusEnum contractSignStatusEnum : ContractSignStatusEnum.values()) {

            resMap.put(contractSignStatusEnum.status, contractSignStatusEnum.name);
        }

        return resMap;
    }
}
