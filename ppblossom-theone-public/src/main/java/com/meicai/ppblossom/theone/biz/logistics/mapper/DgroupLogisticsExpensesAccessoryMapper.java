package com.meicai.ppblossom.theone.biz.logistics.mapper;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesAccessoryEntity;
import com.meicai.ppblossom.theone.commons.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 数据库类型：mysql
 * 表所属schema：books
 * 表所属用户：root
 * 表名称：d_group_logistics_expenses_accessory
 * 表注释：客户物流费用附件信息表
 * 类型：table
 *
 * @author：guohaibin@meicai.cn
 */
@Mapper
@Component
public interface DgroupLogisticsExpensesAccessoryMapper extends BaseMapper<DgroupLogisticsExpensesAccessoryEntity, DgroupLogisticsExpensesAccessoryEntity, Long> {

    int updateExpensesLogByExpensesId(LogisticsExpensesReqDto dto);
}
