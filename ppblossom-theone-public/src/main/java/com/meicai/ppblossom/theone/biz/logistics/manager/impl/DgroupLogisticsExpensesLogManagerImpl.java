package com.meicai.ppblossom.theone.biz.logistics.manager.impl;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesLogEntity;
import com.meicai.ppblossom.theone.biz.logistics.manager.DgroupLogisticsExpensesLogManager;
import com.meicai.ppblossom.theone.biz.logistics.mapper.DgroupLogisticsExpensesLogMapper;
import com.meicai.ppblossom.theone.commons.manager.impl.BaseManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DgroupLogisticsExpensesLogManagerImpl extends BaseManagerImpl<DgroupLogisticsExpensesLogEntity, DgroupLogisticsExpensesLogEntity, Long> implements DgroupLogisticsExpensesLogManager {

    @Autowired
    private DgroupLogisticsExpensesLogMapper dgroupLogisticsExpensesLogMapper;

    @Override
    public List<LogisticsExpensesLogResDto> queryExpensesLogManager(LogisticsExpensesReqDto dto) {

        return dgroupLogisticsExpensesLogMapper.queryExpensesLog(dto);

    }
}
