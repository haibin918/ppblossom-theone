package com.meicai.ppblossom.theone.biz.logistics.manager.impl;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsBillLogEntity;
import com.meicai.ppblossom.theone.biz.logistics.manager.DgroupLogisticsBillLogManager;
import com.meicai.ppblossom.theone.biz.logistics.mapper.DgroupLogisticsBillLogMapper;
import com.meicai.ppblossom.theone.commons.manager.impl.BaseManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DgroupLogisticsBillLogManagerImpl extends BaseManagerImpl<DgroupLogisticsBillLogEntity, DgroupLogisticsBillLogEntity, Long> implements DgroupLogisticsBillLogManager {

    @Autowired
    private DgroupLogisticsBillLogMapper dgroupLogisticsBillLogMapper;

    @Override
    public List<LogisticsExpensesLogResDto> queryBillLogManager(LogisticsBillReqDto dto) {

        return dgroupLogisticsBillLogMapper.queryBillLog(dto);
    }
}
