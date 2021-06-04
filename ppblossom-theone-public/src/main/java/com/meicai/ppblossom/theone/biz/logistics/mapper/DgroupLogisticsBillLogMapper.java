package com.meicai.ppblossom.theone.biz.logistics.mapper;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsBillLogEntity;
import com.meicai.ppblossom.theone.commons.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据库类型：mysql
 * 表所属schema：books
 * 表所属用户：root
 * 表名称：d_group_logistics_bill_log
 * 表注释：客户物流账单日志表
 * 类型：table
 *
 * @author：guohaibin@meicai.cn
 */
@Mapper
@Component
public interface DgroupLogisticsBillLogMapper extends BaseMapper<DgroupLogisticsBillLogEntity, DgroupLogisticsBillLogEntity, Long> {

    List<LogisticsExpensesLogResDto> queryBillLog(LogisticsBillReqDto dto);

}
