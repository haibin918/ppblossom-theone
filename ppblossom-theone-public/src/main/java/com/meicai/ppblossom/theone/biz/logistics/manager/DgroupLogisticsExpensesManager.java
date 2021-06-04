package com.meicai.ppblossom.theone.biz.logistics.manager;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesEntity;
import com.meicai.ppblossom.theone.commons.manager.BaseManager;

import java.util.List;


public interface DgroupLogisticsExpensesManager extends BaseManager<DgroupLogisticsExpensesEntity, DgroupLogisticsExpensesEntity, Long> {

    Long insertExpensesManager(DgroupLogisticsExpensesEntity entity);

    List<LogisticsExpensesResDto> queryExpensesManager(LogisticsExpensesReqDto dto);

    int queryExpensesCountManager(LogisticsExpensesReqDto dto);

    LogisticsExpensesResDto queryExpensesDetailManager(LogisticsExpensesReqDto dto);

    List<Double> queryExpensesAmountManager(LogisticsExpensesReqDto dto);

    List<LogisticsExpensesResDto> queryExpensesByGroupIdManager(LogisticsExpensesReqDto dto);

    List<LogisticsExpensesResDto> getExpensesStatusManager(LogisticsBillReqDto dto);

    int updateExpensesStatusManager(LogisticsBillReqDto dto);

}