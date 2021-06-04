package com.meicai.ppblossom.theone.biz.logistics.manager;


import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsBillLogEntity;
import com.meicai.ppblossom.theone.commons.manager.BaseManager;

import java.util.List;

public interface DgroupLogisticsBillLogManager extends BaseManager<DgroupLogisticsBillLogEntity, DgroupLogisticsBillLogEntity, Long> {

    List<LogisticsExpensesLogResDto> queryBillLogManager(LogisticsBillReqDto dto);
}