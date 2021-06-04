package com.meicai.ppblossom.theone.biz.logistics.service.impl;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesAccessoryReqDto;
import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsBillResDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesDetailResDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.*;
import com.meicai.ppblossom.theone.biz.logistics.manager.*;
import com.meicai.ppblossom.theone.biz.logistics.mapper.DgroupLogisticsExpensesAccessoryMapper;
import com.meicai.ppblossom.theone.biz.logistics.mapper.DgroupLogisticsExpensesLogMapper;
import com.meicai.ppblossom.theone.biz.logistics.service.GroupLogisticsService;
import com.meicai.ppblossom.theone.commons.enums.LogisticsBillStatusEnum;
import com.meicai.ppblossom.theone.commons.enums.LogisticsExpensesStatusEnum;
import com.meicai.ppblossom.theone.commons.exception.BizException;
import com.meicai.ppblossom.theone.commons.utils.DateUtil;
import com.meicai.ppblossom.theone.commons.utils.JsonUtilNew;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName GroupLogisticsServiceImpl
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 上午11:12
 * @Version 1.0
 **/

@Service
@Slf4j
public class GroupLogisticsServiceImpl implements GroupLogisticsService {

    @Autowired
    private DgroupLogisticsExpensesAccessoryManager dgroupLogisticsExpensesAccessoryManager;

    @Autowired
    private DgroupLogisticsExpensesLogManager dgroupLogisticsExpensesLogManager;

    @Autowired
    private DgroupLogisticsExpensesManager dgroupLogisticsExpensesManager;

    @Autowired
    private DgroupLogisticsBillManager dgroupLogisticsBillManager;

    @Autowired
    private DgroupLogisticsBillLogManager dgroupLogisticsBillLogManager;

    @Override
    @Transactional
    public void createExpensesService(LogisticsExpensesReqDto dto) {


        if (dto.getRemark() == null) {
            dto.setRemark("");
        }

        DgroupLogisticsExpensesEntity dgroupLogisticsExpensesEntity = new DgroupLogisticsExpensesEntity();
        dgroupLogisticsExpensesEntity.setAmountReceivable(dto.getAmountReceivable());
        dgroupLogisticsExpensesEntity.setBillId(0L);
        dgroupLogisticsExpensesEntity.setBusinessEnd(dto.getBusinessEnd());
        dgroupLogisticsExpensesEntity.setBusinessStart(dto.getBusinessStart());
        dgroupLogisticsExpensesEntity.setCt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsExpensesEntity.setExpensesClassId(dto.getExpensesClassId());
        dgroupLogisticsExpensesEntity.setExpensesClassName(dto.getExpensesClassName());
        dgroupLogisticsExpensesEntity.setExpensesName(dto.getExpensesName());
        dgroupLogisticsExpensesEntity.setExpensesNameId(dto.getExpensesNameId());
        dgroupLogisticsExpensesEntity.setGroupId(dto.getGroupId());
        dgroupLogisticsExpensesEntity.setIsDeleted(0);
        dgroupLogisticsExpensesEntity.setRemark(dto.getRemark());
        dgroupLogisticsExpensesEntity.setStatus(0);
        dgroupLogisticsExpensesEntity.setUt(DateUtil.getCurrentTimeStamp());

        dgroupLogisticsExpensesManager.insertExpensesManager(dgroupLogisticsExpensesEntity);
        if (dgroupLogisticsExpensesEntity.getId() == null) {
            throw new BizException(-1, "创建物流费用错误！");
        }
        Long expensesId = dgroupLogisticsExpensesEntity.getId();

        List<DgroupLogisticsExpensesAccessoryEntity> dgroupLogisticsExpensesAccessoryEntityList = this.getDgroupLogisticsExpensesAccessoryEntity(dto, expensesId);

        dgroupLogisticsExpensesAccessoryManager.insertBatch(dgroupLogisticsExpensesAccessoryEntityList, DgroupLogisticsExpensesAccessoryMapper.class);

        DgroupLogisticsExpensesLogEntity dgroupLogisticsExpensesLogEntity = new DgroupLogisticsExpensesLogEntity();
        dgroupLogisticsExpensesLogEntity.setOperatorParam(JsonUtilNew.writeValueAsString(dto));
        dgroupLogisticsExpensesLogEntity.setOperatorName(dto.getOperatorName());
        dgroupLogisticsExpensesLogEntity.setOperatorId(dto.getOperatorId());
        dgroupLogisticsExpensesLogEntity.setIsDeleted(0);
        dgroupLogisticsExpensesLogEntity.setExpensesId(expensesId);
        dgroupLogisticsExpensesLogEntity.setCt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsExpensesLogEntity.setOperatorText("创建新的物流费用单");
        dgroupLogisticsExpensesLogEntity.setOperatorType(1);
        dgroupLogisticsExpensesLogEntity.setUt(DateUtil.getCurrentTimeStamp());

        dgroupLogisticsExpensesLogManager.insert(dgroupLogisticsExpensesLogEntity);


    }

    @Override
    public Map<String, Object> queryExpensesService(LogisticsExpensesReqDto dto) {

        Map<String, Object> resMap = new HashMap<>();

        List<LogisticsExpensesResDto> logisticsExpensesResDtoList = new ArrayList<>();

        Double amountReceivableTotal = 0d;

        int count = dgroupLogisticsExpensesManager.queryExpensesCountManager(dto);
        if (count > 0) {
            logisticsExpensesResDtoList = dgroupLogisticsExpensesManager.queryExpensesManager(dto);

            if (CollectionUtils.isNotEmpty(logisticsExpensesResDtoList)) {
                logisticsExpensesResDtoList.forEach(logisticsExpensesResDto -> {
                    logisticsExpensesResDto.setStatusName(LogisticsExpensesStatusEnum.getValueByStatus(logisticsExpensesResDto.getStatus()));
                });
            }

            List<Double> amountReceivableList = dgroupLogisticsExpensesManager.queryExpensesAmountManager(dto);
            if (CollectionUtils.isNotEmpty(amountReceivableList)) {
                BigDecimal temp = new BigDecimal(0);
                for (Double amountReceivable : amountReceivableList) {
                    temp = temp.add(new BigDecimal(amountReceivable));
                }
                amountReceivableTotal = temp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
        }


        resMap.put("amountReceivableTotal", amountReceivableTotal);
        resMap.put("items", logisticsExpensesResDtoList);
        resMap.put("totalCount", count);
        return resMap;


    }

    @Override
    public LogisticsExpensesResDto queryExpensesDetailService(LogisticsExpensesReqDto dto) {

        LogisticsExpensesResDto logisticsExpensesResDto = dgroupLogisticsExpensesManager.queryExpensesDetailManager(dto);


        if (logisticsExpensesResDto != null) {

            DgroupLogisticsExpensesAccessoryEntity dgroupLogisticsExpensesAccessoryEntity = new DgroupLogisticsExpensesAccessoryEntity();
            dgroupLogisticsExpensesAccessoryEntity.setExpensesId(dto.getExpensesId());
            dgroupLogisticsExpensesAccessoryEntity.setIsDeleted(0);

            List<DgroupLogisticsExpensesAccessoryEntity> dgroupLogisticsExpensesAccessoryEntityList = dgroupLogisticsExpensesAccessoryManager.select(dgroupLogisticsExpensesAccessoryEntity);
            if (CollectionUtils.isNotEmpty(dgroupLogisticsExpensesAccessoryEntityList)) {
                List<LogisticsExpensesAccessoryReqDto> logisticsExpensesAccessoryReqDtoList = new ArrayList<>();

                dgroupLogisticsExpensesAccessoryEntityList.forEach(dgroupLogisticsExpensesAccessoryEntity1 -> {

                    LogisticsExpensesAccessoryReqDto logisticsExpensesAccessoryReqDto = new LogisticsExpensesAccessoryReqDto();
                    logisticsExpensesAccessoryReqDto.setFileName(dgroupLogisticsExpensesAccessoryEntity1.getAccessoryName());
                    logisticsExpensesAccessoryReqDto.setFileUrl(dgroupLogisticsExpensesAccessoryEntity1.getAccessoryPath());
                    logisticsExpensesAccessoryReqDtoList.add(logisticsExpensesAccessoryReqDto);
                });

                logisticsExpensesResDto.setAccessory(logisticsExpensesAccessoryReqDtoList);

            }
        }

        return logisticsExpensesResDto;

    }


    @Override
    @Transactional
    public void editExpensesService(LogisticsExpensesReqDto dto) {

        if (dto.getRemark() == null) {
            dto.setRemark("");
        }

        LogisticsExpensesResDto logisticsExpensesResDto = dgroupLogisticsExpensesManager.queryExpensesDetailManager(dto);

        if (logisticsExpensesResDto == null) {
            throw new BizException(-1, "物流费用ID有误！");
        }
        if (logisticsExpensesResDto.getStatus().equals(1)) {
            throw new BizException(-1, "当前费用结算中不能修改");
        }
        if (logisticsExpensesResDto.getStatus().equals(2)) {
            throw new BizException(-1, "当前费用已结算不能修改");
        }


        DgroupLogisticsExpensesEntity dgroupLogisticsExpensesEntity = new DgroupLogisticsExpensesEntity();
        dgroupLogisticsExpensesEntity.setUt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsExpensesEntity.setExpensesClassId(dto.getExpensesClassId());
        dgroupLogisticsExpensesEntity.setExpensesClassName(dto.getExpensesClassName());
        dgroupLogisticsExpensesEntity.setExpensesName(dto.getExpensesName());
        dgroupLogisticsExpensesEntity.setExpensesNameId(dto.getExpensesNameId());
        dgroupLogisticsExpensesEntity.setAmountReceivable(dto.getAmountReceivable());
        dgroupLogisticsExpensesEntity.setBillId(0L);
        dgroupLogisticsExpensesEntity.setBusinessEnd(dto.getBusinessEnd());
        dgroupLogisticsExpensesEntity.setBusinessStart(dto.getBusinessStart());

        dgroupLogisticsExpensesEntity.setGroupId(dto.getGroupId());
        dgroupLogisticsExpensesEntity.setRemark(dto.getRemark());


        dgroupLogisticsExpensesManager.updateById(dgroupLogisticsExpensesEntity, dto.getExpensesId());

        dto.setUT(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsExpensesAccessoryManager.updateExpensesLogByExpensesIdManager(dto);

        List<DgroupLogisticsExpensesAccessoryEntity> dgroupLogisticsExpensesAccessoryEntityList = this.getDgroupLogisticsExpensesAccessoryEntity(dto, dto.getExpensesId());

        dgroupLogisticsExpensesAccessoryManager.insertBatch(dgroupLogisticsExpensesAccessoryEntityList, DgroupLogisticsExpensesAccessoryMapper.class);

        DgroupLogisticsExpensesLogEntity dgroupLogisticsExpensesLogEntity = new DgroupLogisticsExpensesLogEntity();
        dgroupLogisticsExpensesLogEntity.setOperatorParam(JsonUtilNew.writeValueAsString(dto));
        dgroupLogisticsExpensesLogEntity.setOperatorName(dto.getOperatorName());
        dgroupLogisticsExpensesLogEntity.setOperatorId(dto.getOperatorId());
        dgroupLogisticsExpensesLogEntity.setIsDeleted(0);
        dgroupLogisticsExpensesLogEntity.setExpensesId(dto.getExpensesId());
        dgroupLogisticsExpensesLogEntity.setCt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsExpensesLogEntity.setOperatorText("编辑物流费用单");
        dgroupLogisticsExpensesLogEntity.setOperatorType(2);
        dgroupLogisticsExpensesLogEntity.setUt(DateUtil.getCurrentTimeStamp());

        dgroupLogisticsExpensesLogManager.insert(dgroupLogisticsExpensesLogEntity);


    }

    @Override
    public List<LogisticsExpensesLogResDto> queryExpensesLogService(LogisticsExpensesReqDto dto) {

        return dgroupLogisticsExpensesLogManager.queryExpensesLogManager(dto);

    }

    @Override
    public List<LogisticsExpensesResDto> queryExpensesByGroupIdService(LogisticsExpensesReqDto dto) {

        return dgroupLogisticsExpensesManager.queryExpensesByGroupIdManager(dto);
    }

    @Override
    @Transactional
    public void createBillService(LogisticsBillReqDto dto) {


        List<LogisticsExpensesResDto> logisticsExpensesResDtoList = dgroupLogisticsExpensesManager.getExpensesStatusManager(dto);
        if (CollectionUtils.isEmpty(logisticsExpensesResDtoList) || logisticsExpensesResDtoList.size() != dto.getExpensesIds().size()) {
            throw new BizException(-1, "费用信息有误");
        }
        logisticsExpensesResDtoList.forEach(logisticsExpensesResDto -> {
            if (!logisticsExpensesResDto.getStatus().equals(0)) {
                throw new BizException(-1, "该费用已在其他账单结算");
            }
        });

        if (dto.getRemark() == null) {
            dto.setRemark("");
        }

        BigDecimal amountReceivableTotal = new BigDecimal(0);


        for (LogisticsExpensesResDto logisticsExpensesResDto : logisticsExpensesResDtoList) {
            amountReceivableTotal = amountReceivableTotal.add(logisticsExpensesResDto.getAmountReceivable());
        }
        amountReceivableTotal = amountReceivableTotal.setScale(2, BigDecimal.ROUND_HALF_UP);


        DgroupLogisticsBillEntity dgroupLogisticsBillEntity = new DgroupLogisticsBillEntity();
        dgroupLogisticsBillEntity.setAmountReceivable(amountReceivableTotal);
        dgroupLogisticsBillEntity.setCt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsBillEntity.setGroupId(dto.getGroupId());
        dgroupLogisticsBillEntity.setRemark(dto.getRemark());
        dgroupLogisticsBillEntity.setUt(DateUtil.getCurrentTimeStamp());

        dgroupLogisticsBillManager.insertBillManager(dgroupLogisticsBillEntity);

        if (dgroupLogisticsBillEntity.getId() == null) {
            throw new BizException(-1, "创建物流账单错误！");
        }
        dto.setBillId(dgroupLogisticsBillEntity.getId());
        dto.setUt(DateUtil.getCurrentTimeStamp());
        dto.setStatus(1);
        dgroupLogisticsExpensesManager.updateExpensesStatusManager(dto);

        List<DgroupLogisticsExpensesLogEntity> dgroupLogisticsExpensesLogEntityEntityList = this.getDgroupLogisticsExpensesLogEntity(dto);


        dgroupLogisticsExpensesLogManager.insertBatch(dgroupLogisticsExpensesLogEntityEntityList, DgroupLogisticsExpensesLogMapper.class);


        DgroupLogisticsBillLogEntity dgroupLogisticsBillLogEntity = new DgroupLogisticsBillLogEntity();
        dgroupLogisticsBillLogEntity.setBillId(dto.getBillId());
        dgroupLogisticsBillLogEntity.setCt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsBillLogEntity.setIsDeleted(0);
        dgroupLogisticsBillLogEntity.setOperatorId(dto.getOperatorId());
        dgroupLogisticsBillLogEntity.setOperatorName(dto.getOperatorName());
        dgroupLogisticsBillLogEntity.setOperatorParam(JsonUtilNew.writeValueAsString(dto));
        dgroupLogisticsBillLogEntity.setOperatorText("创建物流账单");
        dgroupLogisticsBillLogEntity.setOperatorType(1);
        dgroupLogisticsBillLogEntity.setUt(DateUtil.getCurrentTimeStamp());

        dgroupLogisticsBillLogManager.insert(dgroupLogisticsBillLogEntity);


    }

    @Override
    public Map<String, Object> queryBillService(LogisticsBillReqDto dto) {

        Map<String, Object> resMap = new HashMap<>();

        List<LogisticsBillResDto> logisticsBillResDtoList = new ArrayList<>();

        Double amountReceivableTotal = 0d;

        int count = dgroupLogisticsBillManager.queryBillCountManager(dto);
        if (count > 0) {
            logisticsBillResDtoList = dgroupLogisticsBillManager.queryBillManager(dto);

            if (CollectionUtils.isNotEmpty(logisticsBillResDtoList)) {
                logisticsBillResDtoList.forEach(logisticsBillResDto -> {
                    logisticsBillResDto.setStatusName(LogisticsBillStatusEnum.getLogisticsBillStatusName(logisticsBillResDto.getStatus()));
                    if (logisticsBillResDto.getAuditTime().equals(0)) {
                        logisticsBillResDto.setAuditTime(null);
                    }
                });
            }

            List<Double> amountReceivableList = dgroupLogisticsBillManager.queryBillAmountManager(dto);
            if (CollectionUtils.isNotEmpty(amountReceivableList)) {
                BigDecimal temp = new BigDecimal(0);
                for (Double amountReceivable : amountReceivableList) {
                    temp = temp.add(new BigDecimal(amountReceivable));
                }
                amountReceivableTotal = temp.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
        }


        resMap.put("amountReceivableTotal", amountReceivableTotal);
        resMap.put("items", logisticsBillResDtoList);
        resMap.put("totalCount", count);
        return resMap;

    }

    @Override
    @Transactional
    public void editBillService(LogisticsBillReqDto dto) {

        DgroupLogisticsBillEntity DgroupLogisticsBillEntity = new DgroupLogisticsBillEntity();
        DgroupLogisticsBillEntity.setId(dto.getBillId());

        List<DgroupLogisticsBillEntity> dgroupLogisticsBillEntityList = dgroupLogisticsBillManager.select(DgroupLogisticsBillEntity);

        if (CollectionUtils.isEmpty(dgroupLogisticsBillEntityList)) {

            throw new BizException(-1, "物流账单ID有误！");
        }
        if (dgroupLogisticsBillEntityList.get(0).getStatus().equals(1)) {
            throw new BizException(-1, "账单已审核不能修改");
        }


        List<LogisticsExpensesResDto> logisticsExpensesResDtoList = dgroupLogisticsExpensesManager.getExpensesStatusManager(dto);
        if (CollectionUtils.isEmpty(logisticsExpensesResDtoList) || logisticsExpensesResDtoList.size() != dto.getExpensesIds().size()) {
            throw new BizException(-1, "费用信息有误");
        }
        logisticsExpensesResDtoList.forEach(logisticsExpensesResDto -> {
            if (!logisticsExpensesResDto.getBillId().equals(dto.getBillId()) && !logisticsExpensesResDto.getStatus().equals(0)) {
                throw new BizException(-1, "该费用已在其他账单结算");
            }
        });


        if (dto.getRemark() == null) {
            dto.setRemark("");
        }

        BigDecimal amountReceivableTotal = new BigDecimal(0);


        for (LogisticsExpensesResDto logisticsExpensesResDto : logisticsExpensesResDtoList) {
            amountReceivableTotal = amountReceivableTotal.add(logisticsExpensesResDto.getAmountReceivable());
        }
        amountReceivableTotal = amountReceivableTotal.setScale(2, BigDecimal.ROUND_HALF_UP);

        DgroupLogisticsBillEntity dgroupLogisticsBillEntity = new DgroupLogisticsBillEntity();
        dgroupLogisticsBillEntity.setAmountReceivable(amountReceivableTotal);
        dgroupLogisticsBillEntity.setGroupId(dto.getGroupId());
        dgroupLogisticsBillEntity.setRemark(dto.getRemark());
        dgroupLogisticsBillEntity.setUt(DateUtil.getCurrentTimeStamp());

        dgroupLogisticsBillManager.updateById(dgroupLogisticsBillEntity, dto.getBillId());

        DgroupLogisticsBillLogEntity dgroupLogisticsBillLogEntity = new DgroupLogisticsBillLogEntity();
        dgroupLogisticsBillLogEntity.setOperatorType(2);
        dgroupLogisticsBillLogEntity.setBillId(dto.getBillId());
        dgroupLogisticsBillLogEntity.setCt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsBillLogEntity.setIsDeleted(0);
        dgroupLogisticsBillLogEntity.setOperatorId(dto.getOperatorId());
        dgroupLogisticsBillLogEntity.setOperatorName(dto.getOperatorName());
        dgroupLogisticsBillLogEntity.setOperatorParam(JsonUtilNew.writeValueAsString(dto));
        dgroupLogisticsBillLogEntity.setOperatorText("编辑物流账单");
        dgroupLogisticsBillLogEntity.setUt(DateUtil.getCurrentTimeStamp());

        dgroupLogisticsBillLogManager.insert(dgroupLogisticsBillLogEntity);


        DgroupLogisticsExpensesEntity dgroupLogisticsExpensesEntity = new DgroupLogisticsExpensesEntity();
        dgroupLogisticsExpensesEntity.setBillId(dto.getBillId());
        dgroupLogisticsExpensesEntity.setIsDeleted(0);

        List<DgroupLogisticsExpensesEntity> dgroupLogisticsExpensesEntityList = dgroupLogisticsExpensesManager.select(dgroupLogisticsExpensesEntity);

        if (CollectionUtils.isNotEmpty(dgroupLogisticsExpensesEntityList)) {
            List<Long> expensesIds = new ArrayList<>();
            dgroupLogisticsExpensesEntityList.forEach(dleEntity -> {
                expensesIds.add(dleEntity.getId());
            });

            LogisticsBillReqDto logisticsBillReqDto = new LogisticsBillReqDto();
            logisticsBillReqDto.setUt(DateUtil.getCurrentTimeStamp());
            logisticsBillReqDto.setBillId(0L);
            logisticsBillReqDto.setStatus(0);
            logisticsBillReqDto.setExpensesIds(expensesIds);

            dgroupLogisticsExpensesManager.updateExpensesStatusManager(logisticsBillReqDto);

            List<DgroupLogisticsExpensesLogEntity> dgroupLogisticsExpensesLogEntityEntityList = this.getDgroupLogisticsExpensesLogEntity(dto, expensesIds);

            dgroupLogisticsExpensesLogManager.insertBatch(dgroupLogisticsExpensesLogEntityEntityList, DgroupLogisticsExpensesLogMapper.class);

        }


        dto.setUt(DateUtil.getCurrentTimeStamp());
        dto.setStatus(1);
        dgroupLogisticsExpensesManager.updateExpensesStatusManager(dto);

        List<DgroupLogisticsExpensesLogEntity> dgroupLogisticsExpensesLogEntityEntityList = this.getDgroupLogisticsExpensesLogEntity(dto);

        dgroupLogisticsExpensesLogManager.insertBatch(dgroupLogisticsExpensesLogEntityEntityList, DgroupLogisticsExpensesLogMapper.class);


    }

    @Override
    public List<LogisticsExpensesLogResDto> queryBillLogService(LogisticsBillReqDto dto) {

        return dgroupLogisticsBillLogManager.queryBillLogManager(dto);
    }

    @Override
    @Transactional
    public void auditBillService(LogisticsBillReqDto dto) {

        DgroupLogisticsBillEntity DgroupLogisticsBillEntity = new DgroupLogisticsBillEntity();
        DgroupLogisticsBillEntity.setId(dto.getBillId());

        List<DgroupLogisticsBillEntity> dgroupLogisticsBillEntityList = dgroupLogisticsBillManager.select(DgroupLogisticsBillEntity);

        if (CollectionUtils.isEmpty(dgroupLogisticsBillEntityList)) {

            throw new BizException(-1, "物流账单ID有误！");
        }
        if (dgroupLogisticsBillEntityList.get(0).getStatus().equals(1)) {
            throw new BizException(-1, "账单已审核不能重复审核");
        }

        DgroupLogisticsBillEntity dgroupLogisticsBillEntity = new DgroupLogisticsBillEntity();
        dgroupLogisticsBillEntity.setStatus(1);
        dgroupLogisticsBillEntity.setUt(DateUtil.getCurrentTimeStamp());

        dgroupLogisticsBillManager.updateById(dgroupLogisticsBillEntity, dto.getBillId());


        DgroupLogisticsBillLogEntity dgroupLogisticsBillLogEntity = new DgroupLogisticsBillLogEntity();
        dgroupLogisticsBillLogEntity.setBillId(dto.getBillId());
        dgroupLogisticsBillLogEntity.setCt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsBillLogEntity.setIsDeleted(0);
        dgroupLogisticsBillLogEntity.setOperatorType(3);
        dgroupLogisticsBillLogEntity.setOperatorId(dto.getOperatorId());
        dgroupLogisticsBillLogEntity.setOperatorName(dto.getOperatorName());
        dgroupLogisticsBillLogEntity.setOperatorParam(JsonUtilNew.writeValueAsString(dto));
        dgroupLogisticsBillLogEntity.setOperatorText("审核物流账单");
        dgroupLogisticsBillLogEntity.setUt(DateUtil.getCurrentTimeStamp());
        dgroupLogisticsBillLogManager.insert(dgroupLogisticsBillLogEntity);

        DgroupLogisticsExpensesEntity dgroupLogisticsExpensesEntity = new DgroupLogisticsExpensesEntity();
        dgroupLogisticsExpensesEntity.setIsDeleted(0);
        dgroupLogisticsExpensesEntity.setBillId(dto.getBillId());
        List<DgroupLogisticsExpensesEntity> dgroupLogisticsExpensesEntityList = dgroupLogisticsExpensesManager.select(dgroupLogisticsExpensesEntity);
        if (CollectionUtils.isEmpty(dgroupLogisticsExpensesEntityList)) {

            throw new BizException(-1, "账单没有绑定费用单");
        }

        dto.setUt(DateUtil.getCurrentTimeStamp());
        dto.setStatus(1);
        List<Long> expensesIds = new ArrayList<>();
        dgroupLogisticsExpensesEntityList.forEach(dgroupLogisticsExpensesEntity1 -> {
            expensesIds.add(dgroupLogisticsExpensesEntity1.getId());
        });
        dto.setExpensesIds(expensesIds);
        dgroupLogisticsExpensesManager.updateExpensesStatusManager(dto);

        List<DgroupLogisticsExpensesLogEntity> dgroupLogisticsExpensesLogEntityEntityList = this.getDgroupLogisticsExpensesLogEntityAudit(dto);

        dgroupLogisticsExpensesLogManager.insertBatch(dgroupLogisticsExpensesLogEntityEntityList, DgroupLogisticsExpensesLogMapper.class);
    }

    @Override
    public LogisticsBillResDto queryBillDetailService(LogisticsBillReqDto dto) {

        LogisticsBillResDto logisticsBillResDto = dgroupLogisticsBillManager.queryBillDetailManager(dto);
        if (logisticsBillResDto == null) {
            throw new BizException(-1, "账单ID有误");
        }

        DgroupLogisticsExpensesEntity dgroupLogisticsExpensesEntity = new DgroupLogisticsExpensesEntity();
        dgroupLogisticsExpensesEntity.setIsDeleted(0);
        dgroupLogisticsExpensesEntity.setBillId(dto.getBillId());
        List<DgroupLogisticsExpensesEntity> dgroupLogisticsExpensesEntityList = dgroupLogisticsExpensesManager.select(dgroupLogisticsExpensesEntity);
        if (CollectionUtils.isNotEmpty(dgroupLogisticsExpensesEntityList)) {
            List<LogisticsExpensesDetailResDto> logisticsExpensesDetailResDtoList = new ArrayList<>();
            dgroupLogisticsExpensesEntityList.forEach(dgroupLogisticsExpensesEntity1 -> {
                LogisticsExpensesDetailResDto logisticsExpensesDetailResDto = new LogisticsExpensesDetailResDto();
                logisticsExpensesDetailResDto.setAmountReceivable(dgroupLogisticsExpensesEntity1.getAmountReceivable());
                logisticsExpensesDetailResDto.setBusinessEnd(dgroupLogisticsExpensesEntity1.getBusinessEnd());
                logisticsExpensesDetailResDto.setBusinessStart(dgroupLogisticsExpensesEntity1.getBusinessStart());
                logisticsExpensesDetailResDto.setExpensesClassId(dgroupLogisticsExpensesEntity1.getExpensesClassId());
                logisticsExpensesDetailResDto.setExpensesClassName(dgroupLogisticsExpensesEntity1.getExpensesClassName());
                logisticsExpensesDetailResDto.setExpensesId(dgroupLogisticsExpensesEntity1.getId());
                logisticsExpensesDetailResDto.setExpensesName(dgroupLogisticsExpensesEntity1.getExpensesName());
                logisticsExpensesDetailResDto.setExpensesNameId(dgroupLogisticsExpensesEntity1.getExpensesNameId());
                logisticsExpensesDetailResDtoList.add(logisticsExpensesDetailResDto);
            });
            logisticsBillResDto.setExpensesInfo(logisticsExpensesDetailResDtoList);
        }

        return logisticsBillResDto;
    }


    private List<DgroupLogisticsExpensesAccessoryEntity> getDgroupLogisticsExpensesAccessoryEntity(LogisticsExpensesReqDto dto, Long expensesId) {

        List<DgroupLogisticsExpensesAccessoryEntity> dgroupLogisticsExpensesAccessoryEntityList = new ArrayList<>();

        dto.getAccessory().forEach(logisticsExpensesAccessoryReqDto -> {
            DgroupLogisticsExpensesAccessoryEntity dgroupLogisticsExpensesAccessoryEntity = new DgroupLogisticsExpensesAccessoryEntity();
            dgroupLogisticsExpensesAccessoryEntity.setAccessoryName(logisticsExpensesAccessoryReqDto.getFileName());
            dgroupLogisticsExpensesAccessoryEntity.setAccessoryPath(logisticsExpensesAccessoryReqDto.getFileUrl());
            dgroupLogisticsExpensesAccessoryEntity.setCt(DateUtil.getCurrentTimeStamp());
            dgroupLogisticsExpensesAccessoryEntity.setExpensesId(expensesId);
            dgroupLogisticsExpensesAccessoryEntity.setIsDeleted(0);
            dgroupLogisticsExpensesAccessoryEntity.setUt(DateUtil.getCurrentTimeStamp());
            dgroupLogisticsExpensesAccessoryEntityList.add(dgroupLogisticsExpensesAccessoryEntity);
        });


        return dgroupLogisticsExpensesAccessoryEntityList;
    }

    private List<DgroupLogisticsExpensesLogEntity> getDgroupLogisticsExpensesLogEntity(LogisticsBillReqDto dto) {

        List<DgroupLogisticsExpensesLogEntity> dgroupLogisticsExpensesLogEntityEntityList = new ArrayList<>();

        dto.getExpensesIds().forEach(expensesId -> {
            DgroupLogisticsExpensesLogEntity dgroupLogisticsExpensesLogEntity = new DgroupLogisticsExpensesLogEntity();
            dgroupLogisticsExpensesLogEntity.setOperatorParam(JsonUtilNew.writeValueAsString(dto));
            dgroupLogisticsExpensesLogEntity.setOperatorId(dto.getOperatorId());
            dgroupLogisticsExpensesLogEntity.setOperatorName(dto.getOperatorName());
            dgroupLogisticsExpensesLogEntity.setIsDeleted(0);
            dgroupLogisticsExpensesLogEntity.setExpensesId(expensesId);
            dgroupLogisticsExpensesLogEntity.setCt(DateUtil.getCurrentTimeStamp());
            dgroupLogisticsExpensesLogEntity.setOperatorText("绑定物流账单");
            dgroupLogisticsExpensesLogEntity.setOperatorType(3);
            dgroupLogisticsExpensesLogEntity.setUt(DateUtil.getCurrentTimeStamp());
            dgroupLogisticsExpensesLogEntityEntityList.add(dgroupLogisticsExpensesLogEntity);
        });


        return dgroupLogisticsExpensesLogEntityEntityList;
    }

    private List<DgroupLogisticsExpensesLogEntity> getDgroupLogisticsExpensesLogEntity(LogisticsBillReqDto dto, List<Long> expensesIds) {

        List<DgroupLogisticsExpensesLogEntity> dgroupLogisticsExpensesLogEntityEntityList = new ArrayList<>();

        expensesIds.forEach(expensesId -> {
            DgroupLogisticsExpensesLogEntity dgroupLogisticsExpensesLogEntity = new DgroupLogisticsExpensesLogEntity();
            dgroupLogisticsExpensesLogEntity.setIsDeleted(0);
            dgroupLogisticsExpensesLogEntity.setOperatorParam(JsonUtilNew.writeValueAsString(dto));
            dgroupLogisticsExpensesLogEntity.setOperatorId(dto.getOperatorId());
            dgroupLogisticsExpensesLogEntity.setOperatorName(dto.getOperatorName());
            dgroupLogisticsExpensesLogEntity.setExpensesId(expensesId);
            dgroupLogisticsExpensesLogEntity.setCt(DateUtil.getCurrentTimeStamp());
            dgroupLogisticsExpensesLogEntity.setOperatorText("解绑物流账单");
            dgroupLogisticsExpensesLogEntity.setOperatorType(4);
            dgroupLogisticsExpensesLogEntity.setUt(DateUtil.getCurrentTimeStamp());
            dgroupLogisticsExpensesLogEntityEntityList.add(dgroupLogisticsExpensesLogEntity);
        });


        return dgroupLogisticsExpensesLogEntityEntityList;
    }

    private List<DgroupLogisticsExpensesLogEntity> getDgroupLogisticsExpensesLogEntityAudit(LogisticsBillReqDto dto) {

        List<DgroupLogisticsExpensesLogEntity> dgroupLogisticsExpensesLogEntityEntityList = new ArrayList<>();

        dto.getExpensesIds().forEach(expensesId -> {
            DgroupLogisticsExpensesLogEntity dgroupLogisticsExpensesLogEntity = new DgroupLogisticsExpensesLogEntity();
            dgroupLogisticsExpensesLogEntity.setIsDeleted(0);
            dgroupLogisticsExpensesLogEntity.setExpensesId(expensesId);
            dgroupLogisticsExpensesLogEntity.setOperatorParam(JsonUtilNew.writeValueAsString(dto));
            dgroupLogisticsExpensesLogEntity.setOperatorId(dto.getOperatorId());
            dgroupLogisticsExpensesLogEntity.setOperatorName(dto.getOperatorName());
            dgroupLogisticsExpensesLogEntity.setCt(DateUtil.getCurrentTimeStamp());
            dgroupLogisticsExpensesLogEntity.setOperatorText("审核物流账单");
            dgroupLogisticsExpensesLogEntity.setOperatorType(5);
            dgroupLogisticsExpensesLogEntity.setUt(DateUtil.getCurrentTimeStamp());
            dgroupLogisticsExpensesLogEntityEntityList.add(dgroupLogisticsExpensesLogEntity);
        });


        return dgroupLogisticsExpensesLogEntityEntityList;
    }
}
