package com.meicai.ppblossom.theone.biz.logistics.manager;


import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesLogEntity;
import com.meicai.ppblossom.theone.commons.manager.BaseManager;

import java.util.List;


public interface DgroupLogisticsExpensesLogManager extends BaseManager<DgroupLogisticsExpensesLogEntity, DgroupLogisticsExpensesLogEntity, Long> {

    List<LogisticsExpensesLogResDto> queryExpensesLogManager(LogisticsExpensesReqDto dto);

}