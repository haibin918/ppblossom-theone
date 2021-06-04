package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PurchaseOrderTypeEnum
 * @Description
 * @Author wzj
 * @Date 2020/9/2 10, 46
 **/
@Getter
public enum PurchaseOrderTypeEnum {

    YC(1, "预采"),
    CC(2, "晨采"),
    BC(3, "补采"),
    ZC(4, "机会商品（直采）"),
    POPYC(5, "pop预采"),
    FX(6, "分销"),
    POPZC(7, "POP带转采"),
    SOPZC(8, "SOP转采"),
    LLCC(9, "冷链晨采"),
    LLYC(10, "冷链预采"),
    SJBC(31, "司机补采"),
    MNGS(20, "美农蔬果"),
    MNRQ(21, "美农肉禽"),
    MNDL(22, "美农蛋类"),
    STDL(23, "生态蛋类");

    private int type;

    private String desc;

    PurchaseOrderTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static Map<Integer, String> getTypeAndNameMap() {
        Map<Integer, String> map = new HashMap<>();
        for (PurchaseOrderTypeEnum orderType : PurchaseOrderTypeEnum.values()) {
            map.put(orderType.getType(), orderType.getDesc());
        }
        return map;
    }
}
