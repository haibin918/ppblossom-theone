package com.meicai.ppblossom.theone.commons.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ContractStatusEnum
 * @Description 合同状态
 * @Author wzj
 * @Date 2020/8/26 15:33
 * <p>
 * 目前没有 0:创建中 1:创建失败 这两个状态
 *
 * 合同二期将签署完成拆分为待生效、有效、临期三种
 * 新增已过期、已作废状态
 **/

public enum ContractStatusEnum {

    CJZ(0, "创建中"),

    CJSB(1, "创建失败"),

    DSH(2, "待审核"),

    SHZ(3, "审核中"),

    BBH(4, "被驳回"),

    QSZ(5, "签署中"),

    QSWC(6, "签署完成"),

    JQ(7, "拒签"),

    //=======中间枚举作为签署完成的衍生，不存入库中=======
    DSX(8, "待生效"),
    YX(9, "有效"),
    LQ(10, "临期"),
    YGQ(11, "已过期"),
    //=======中间枚举作为签署完成的衍生，不存入库中=======

    YZF(12, "已作废");

    public Integer getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    private Integer status;

    private String name;

    ContractStatusEnum(Integer status, String name) {

        this.status = status;
        this.name = name;

    }

    /**
     * 根据状态根据状态名称
     * @param status
     * @return
     */
    public static String getByStatus(Integer status) {

        for (ContractStatusEnum contractStatusEnum : ContractStatusEnum.values()) {

            if (status == contractStatusEnum.status) {

                return contractStatusEnum.name;

            }
        }

        return null;

    }

    /**
     * 根据状态根据状态名称
     * @param status
     * @return
     */
    public static ContractStatusEnum getEnumByStatus(Integer status) {

        for (ContractStatusEnum contractStatusEnum : ContractStatusEnum.values()) {

            if (status == contractStatusEnum.status) {

                return contractStatusEnum;

            }
        }

        return null;

    }

    public static Map<Integer, String> getContractStatusMap() {

        Map<Integer, String> map = new HashMap<>();

        for (ContractStatusEnum contractStatus : ContractStatusEnum.values()) {

            map.put(contractStatus.getStatus(), contractStatus.getName());
        }

        return map;
    }

    /**
     根据状态和开始、结束时间获取对应的状态
     @param status
     @param startTime
     @param endTime
     @return
     */
    public static ContractStatusEnum changeStatus(int status, long startTime, long endTime) {

        if (status != ContractStatusEnum.QSWC.getStatus()) {
            return ContractStatusEnum.getEnumByStatus(status);
        }

        ContractStatusEnum contractStatus = null;

        long currentTime = System.currentTimeMillis() / 1000;

        long validateTime = 30 * 24 * 3600L; //30天

        if (currentTime < startTime) {

            //当前时间小于合同开始时间，状态为待生效
            contractStatus = ContractStatusEnum.DSX;

        } else if (currentTime >= endTime) {

            //当前时间大于合同结束时间，状态为已过期
            contractStatus = ContractStatusEnum.YGQ;

        } else if ((endTime - currentTime) > validateTime) {

            // 如果有效期之间的间隔大于30天，状态为有效
            contractStatus = ContractStatusEnum.YX;

        } else {

            // 有效期的间隔小于30天，状态为临期
            contractStatus = ContractStatusEnum.LQ;

        }

        return contractStatus;
    }

    /**
     * @Description: 判断合同状态是否是虚拟状态
     * @param status 合同状态
     * @return Boolean 是否虚拟状态
     */
    public static Boolean isVirtualStatus(Integer status) {
        if (status == null) {
            return false;
        }
        if (status.equals(ContractStatusEnum.DSX.getStatus())
                || status.equals(ContractStatusEnum.YX.getStatus())
                || status.equals(ContractStatusEnum.LQ.getStatus())
                || status.equals(ContractStatusEnum.YGQ.getStatus())) {
            return true;
        } else {
            return false;
        }
    }

}
