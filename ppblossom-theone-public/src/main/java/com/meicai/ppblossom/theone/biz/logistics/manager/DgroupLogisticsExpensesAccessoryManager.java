package com.meicai.ppblossom.theone.biz.logistics.manager;


import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesAccessoryEntity;
import com.meicai.ppblossom.theone.commons.manager.BaseManager;

public interface DgroupLogisticsExpensesAccessoryManager extends BaseManager<DgroupLogisticsExpensesAccessoryEntity, DgroupLogisticsExpensesAccessoryEntity, Long> {

    int updateExpensesLogByExpensesIdManager(LogisticsExpensesReqDto dto);
}