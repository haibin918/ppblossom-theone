package com.meicai.ppblossom.theone.biz.logistics.manager.impl;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesAccessoryEntity;
import com.meicai.ppblossom.theone.biz.logistics.manager.DgroupLogisticsExpensesAccessoryManager;
import com.meicai.ppblossom.theone.biz.logistics.mapper.DgroupLogisticsExpensesAccessoryMapper;
import com.meicai.ppblossom.theone.commons.manager.impl.BaseManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DgroupLogisticsExpensesAccessoryManagerImpl extends BaseManagerImpl<DgroupLogisticsExpensesAccessoryEntity, DgroupLogisticsExpensesAccessoryEntity, Long> implements DgroupLogisticsExpensesAccessoryManager {

    @Autowired
    private DgroupLogisticsExpensesAccessoryMapper dgroupLogisticsExpensesAccessoryMapper;

    @Override
    public int updateExpensesLogByExpensesIdManager(LogisticsExpensesReqDto dto) {

        return dgroupLogisticsExpensesAccessoryMapper.updateExpensesLogByExpensesId(dto);
    }
}
