package com.meicai.ppblossom.theone.biz.logistics.manager.impl;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesEntity;
import com.meicai.ppblossom.theone.biz.logistics.manager.DgroupLogisticsExpensesManager;
import com.meicai.ppblossom.theone.biz.logistics.mapper.DgroupLogisticsExpensesMapper;
import com.meicai.ppblossom.theone.commons.manager.impl.BaseManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DgroupLogisticsExpensesManagerImpl extends BaseManagerImpl<DgroupLogisticsExpensesEntity, DgroupLogisticsExpensesEntity, Long> implements DgroupLogisticsExpensesManager {

    @Autowired
    private DgroupLogisticsExpensesMapper dgroupLogisticsExpensesMapper;

    @Override
    public Long insertExpensesManager(DgroupLogisticsExpensesEntity entity) {

        return dgroupLogisticsExpensesMapper.insertExpenses(entity);

    }

    @Override
    public List<LogisticsExpensesResDto> queryExpensesManager(LogisticsExpensesReqDto dto) {

        if (dto.getPageNumber() != null) {
            dto.setLimit((dto.getPageNumber() - 1) * dto.getPageNumber());
        }

        return dgroupLogisticsExpensesMapper.queryExpenses(dto);
    }

    @Override
    public int queryExpensesCountManager(LogisticsExpensesReqDto dto) {

        return dgroupLogisticsExpensesMapper.queryExpensesCount(dto);
    }

    @Override
    public LogisticsExpensesResDto queryExpensesDetailManager(LogisticsExpensesReqDto dto) {

        return dgroupLogisticsExpensesMapper.queryExpensesDetail(dto);
    }

    @Override
    public List<Double> queryExpensesAmountManager(LogisticsExpensesReqDto dto) {

        return dgroupLogisticsExpensesMapper.queryExpensesAmount(dto);
    }

    @Override
    public List<LogisticsExpensesResDto> queryExpensesByGroupIdManager(LogisticsExpensesReqDto dto) {

        return dgroupLogisticsExpensesMapper.queryExpensesByGroupId(dto);
    }

    @Override
    public List<LogisticsExpensesResDto> getExpensesStatusManager(LogisticsBillReqDto dto) {

        return dgroupLogisticsExpensesMapper.getExpensesStatus(dto);

    }

    @Override
    public int updateExpensesStatusManager(LogisticsBillReqDto dto) {

        return dgroupLogisticsExpensesMapper.updateExpensesStatus(dto);
    }
}
