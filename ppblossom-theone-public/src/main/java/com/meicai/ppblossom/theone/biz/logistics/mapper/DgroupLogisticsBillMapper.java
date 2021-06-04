package com.meicai.ppblossom.theone.biz.logistics.mapper;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsBillResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsBillEntity;
import com.meicai.ppblossom.theone.commons.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据库类型：mysql
 * 表所属schema：books
 * 表所属用户：root
 * 表名称：d_group_logistics_bill
 * 表注释：客户物流账单表
 * 类型：table
 *
 * @author：guohaibin@meicai.cn
 */
@Mapper
@Component
public interface DgroupLogisticsBillMapper extends BaseMapper<DgroupLogisticsBillEntity, DgroupLogisticsBillEntity, Long> {

    int insertBill(DgroupLogisticsBillEntity entity);

    List<LogisticsBillResDto> queryBill(LogisticsBillReqDto dto);

    int queryBillCount(LogisticsBillReqDto dto);

    List<Double> queryBillAmount(LogisticsBillReqDto dto);

    LogisticsBillResDto queryBillDetail(LogisticsBillReqDto dto);

}
