package com.meicai.ppblossom.theone.biz.logistics.manager.impl;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsBillResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsBillEntity;
import com.meicai.ppblossom.theone.biz.logistics.manager.DgroupLogisticsBillManager;
import com.meicai.ppblossom.theone.biz.logistics.mapper.DgroupLogisticsBillMapper;
import com.meicai.ppblossom.theone.commons.manager.impl.BaseManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DgroupLogisticsBillManagerImpl extends BaseManagerImpl<DgroupLogisticsBillEntity, DgroupLogisticsBillEntity, Long> implements DgroupLogisticsBillManager {

    @Autowired
    private DgroupLogisticsBillMapper dgroupLogisticsBillMapper;

    @Override
    public int insertBillManager(DgroupLogisticsBillEntity entity) {

        return dgroupLogisticsBillMapper.insertBill(entity);
    }

    @Override
    public List<LogisticsBillResDto> queryBillManager(LogisticsBillReqDto dto) {

        if (dto.getPageNumber() != null) {
            dto.setLimit((dto.getPageNumber() - 1) * dto.getPageNumber());
        }

        return dgroupLogisticsBillMapper.queryBill(dto);
    }

    @Override
    public int queryBillCountManager(LogisticsBillReqDto dto) {

        return dgroupLogisticsBillMapper.queryBillCount(dto);
    }

    @Override
    public List<Double> queryBillAmountManager(LogisticsBillReqDto dto) {

        return dgroupLogisticsBillMapper.queryBillAmount(dto);
    }

    @Override
    public LogisticsBillResDto queryBillDetailManager(LogisticsBillReqDto dto) {

        return dgroupLogisticsBillMapper.queryBillDetail(dto);
    }
}
