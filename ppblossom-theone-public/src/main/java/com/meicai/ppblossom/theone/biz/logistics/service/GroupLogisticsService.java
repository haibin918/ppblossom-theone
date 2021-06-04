package com.meicai.ppblossom.theone.biz.logistics.service;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsBillResDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesResDto;


import java.util.List;
import java.util.Map;

/**
 * @ClassName GroupLogisticsService
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 上午11:11
 * @Version 1.0
 **/
public interface GroupLogisticsService {

    /**
     * 新增物流费用
     *
     * @param dto
     * @return
     */
    void createExpensesService(LogisticsExpensesReqDto dto);

    /**
     * 查询物流费用信息
     *
     * @param dto
     * @return
     */
    Map<String, Object> queryExpensesService(LogisticsExpensesReqDto dto);

    /**
     * 查询物流费用信息明细
     *
     * @param dto
     * @return
     */
    LogisticsExpensesResDto queryExpensesDetailService(LogisticsExpensesReqDto dto);

    /**
     * 编辑物流费用
     *
     * @param dto
     * @return
     */
    void editExpensesService(LogisticsExpensesReqDto dto);

    /**
     * 查询物流费用信息操作日志
     *
     * @param dto
     * @return
     */
    List<LogisticsExpensesLogResDto> queryExpensesLogService(LogisticsExpensesReqDto dto);

    /**
     * 查询客户未结算物流费用
     *
     * @param dto
     * @return
     */
    List<LogisticsExpensesResDto> queryExpensesByGroupIdService(LogisticsExpensesReqDto dto);

    /**
     * 新增物流账单
     *
     * @param dto
     * @return
     */
    void createBillService(LogisticsBillReqDto dto);

    /**
     * 查询物流账单信息
     *
     * @param dto
     * @return
     */
    Map<String, Object> queryBillService(LogisticsBillReqDto dto);

    /**
     * 编辑物流账单
     *
     * @param dto
     * @return
     */

    void editBillService(LogisticsBillReqDto dto);

    /**
     * 查询物流账单日志信息
     *
     * @param dto
     * @return
     */

    List<LogisticsExpensesLogResDto> queryBillLogService(LogisticsBillReqDto dto);

    /**
     * 审核物流账单
     *
     * @param dto
     * @return
     */
    void auditBillService(LogisticsBillReqDto dto);

    /**
     * 查询物流账单明细
     *
     * @param dto
     * @return
     */
    LogisticsBillResDto queryBillDetailService(LogisticsBillReqDto dto);

}
