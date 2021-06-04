package com.meicai.ppblossom.theone.biz.logistics.mapper;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesLogEntity;
import com.meicai.ppblossom.theone.commons.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据库类型：mysql
 * 表所属schema：books
 * 表所属用户：root
 * 表名称：d_group_logistics_expenses_log
 * 表注释：客户物流费用日志表
 * 类型：table
 *
 * @author：guohaibin@meicai.cn
 */
@Mapper
@Component
public interface DgroupLogisticsExpensesLogMapper extends BaseMapper<DgroupLogisticsExpensesLogEntity, DgroupLogisticsExpensesLogEntity, Long> {

    List<LogisticsExpensesLogResDto> queryExpensesLog(LogisticsExpensesReqDto dto);

}
