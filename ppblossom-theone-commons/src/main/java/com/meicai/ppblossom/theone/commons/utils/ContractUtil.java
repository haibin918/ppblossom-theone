package com.meicai.ppblossom.theone.commons.utils;

import com.meicai.ppblossom.theone.commons.enums.ContractStatusEnum;

public class ContractUtil {

    /**
     * 合同审批状态转化---根据审批mcq返回的状态修改合同审批表的状态
     * @param status
     * @return
     */
    public static Integer getContractApprovalStatusByApproval(Integer status) {
        Integer approvalStatus = null;
        if (status == 3) {//结束（同意）
            //审批通过
            approvalStatus = 2;
        } else if (status == 4) {//结束（拒绝）
            //被驳回
            approvalStatus = 1;
        }
        return approvalStatus;
    }

    /**
     *合同状态转化---根据审批mcq返回的状态修改合同表的状态
     * @param status
     * @return
     */
    public static Integer getContractStatusByApproval(Integer status) {
        Integer contractStatus = null;
        if (status == 3) { //结束（同意）
            //签署中
            contractStatus = 5;
        } else if (status == 4) { //结束（拒绝）
            //被驳回
            contractStatus = 4;
        }
        return contractStatus;
    }

    /**
     * 根据合同状态变更mcq更新合同的状态
     @param status
     @return
     */
    public static Integer getContractStatusByContract(Integer status) {

        Integer contractStatus = null;

        if (status == null) {
            return contractStatus;
        }

        if (status == 9) {//签署拒绝

            //拒签
            return ContractStatusEnum.JQ.getStatus();

        } else if (status == 8) {//签署完成

            //签署完成
            contractStatus = ContractStatusEnum.QSWC.getStatus();
//
//            long currentTime = System.currentTimeMillis() / 1000;
//
//            long validateTime = 30 * 24 * 3600L; //30天
//
//            if (currentTime < startTime) {
//
//                //当前时间小于合同开始时间，状态为待生效
//                contractStatus = ContractStatusEnum.DSX.getStatus();
//
//            } else if (currentTime >= endTime) {
//
//                //当前时间大于合同结束时间，状态为已过期
//                contractStatus = ContractStatusEnum.YGQ.getStatus();
//
//            } else if ((endTime - startTime) > validateTime) {
//
//                // 如果有效期之间的间隔大于30天，状态为有效
//                contractStatus = ContractStatusEnum.YX.getStatus();
//
//            } else {
//
//                // 有效期的间隔小于30天，状态为临期
//                contractStatus = ContractStatusEnum.LQ.getStatus();
//
//            }

        }// status == 8

        return contractStatus;
    }

}
