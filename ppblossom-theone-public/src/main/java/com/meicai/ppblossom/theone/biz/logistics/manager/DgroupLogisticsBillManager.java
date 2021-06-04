package com.meicai.ppblossom.theone.biz.logistics.manager;


import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsBillResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsBillEntity;
import com.meicai.ppblossom.theone.commons.manager.BaseManager;

import java.util.List;

public interface DgroupLogisticsBillManager extends BaseManager<DgroupLogisticsBillEntity, DgroupLogisticsBillEntity, Long> {

    int insertBillManager(DgroupLogisticsBillEntity entity);

    List<LogisticsBillResDto> queryBillManager(LogisticsBillReqDto dto);

    int queryBillCountManager(LogisticsBillReqDto dto);

    List<Double> queryBillAmountManager(LogisticsBillReqDto dto);

    LogisticsBillResDto queryBillDetailManager(LogisticsBillReqDto dto);

}