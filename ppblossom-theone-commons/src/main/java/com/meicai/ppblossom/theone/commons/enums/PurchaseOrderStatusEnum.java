package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PurchaseOrderStatusEnum
 * @Description
 * @Author wzj
 * @Date 2020/9/2 10, 46
 **/
@Getter
public enum PurchaseOrderStatusEnum {

    DSP(0, "待审批"),
    WQR(1, "未确认"),
    QRYH(2, "确认有货"),
    YRK(3, "已入库"),
    QRWH(4, "确认无货"),
    YFK(5, "已付款"),
    QX(6, "取消"),
    CSWQR(7, "超时未确认"),
    YCGB(8, "异常关闭"),
    CSWRK(9, "超时未入库"),
    SPBTG(20, "审批不通过");

    private int status;

    private String desc;

    PurchaseOrderStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public static Map<Integer, String> getStatusAndNameMap() {
        Map<Integer, String> map = new HashMap<>();
        for (PurchaseOrderStatusEnum orderType : PurchaseOrderStatusEnum.values()) {
            map.put(orderType.getStatus(), orderType.getDesc());
        }
        return map;
    }
}
