package com.meicai.ppblossom.theone.biz.logistics.mapper;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesResDto;
import com.meicai.ppblossom.theone.biz.logistics.entity.DgroupLogisticsExpensesEntity;
import com.meicai.ppblossom.theone.commons.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 数据库类型：mysql
 * 表所属schema：books
 * 表所属用户：root
 * 表名称：d_group_logistics_expenses
 * 表注释：客户物流费用表
 * 类型：table
 *
 * @author：guohaibin@meicai.cn
 */
@Mapper
@Component
public interface DgroupLogisticsExpensesMapper extends BaseMapper<DgroupLogisticsExpensesEntity, DgroupLogisticsExpensesEntity, Long> {

    Long insertExpenses(DgroupLogisticsExpensesEntity entity);

    List<LogisticsExpensesResDto> queryExpenses(LogisticsExpensesReqDto dto);

    int queryExpensesCount(LogisticsExpensesReqDto dto);

    LogisticsExpensesResDto queryExpensesDetail(LogisticsExpensesReqDto dto);

    List<Double> queryExpensesAmount(LogisticsExpensesReqDto dto);

    List<LogisticsExpensesResDto> queryExpensesByGroupId(LogisticsExpensesReqDto dto);

    List<LogisticsExpensesResDto> getExpensesStatus(LogisticsBillReqDto dto);

    int updateExpensesStatus(LogisticsBillReqDto dto);

}
