package com.meicai.ppblossom.theone.controller.logistics;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesReqDto;

import com.meicai.ppblossom.theone.api.response.JsonResult;

import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesResDto;
import com.meicai.ppblossom.theone.biz.logistics.service.GroupLogisticsService;
import com.meicai.ppblossom.theone.commons.enums.ResultCodeEnum;
import com.meicai.ppblossom.theone.commons.exception.BizException;
import com.meicai.ppblossom.theone.commons.utils.ParamUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


/**
 * @ClassName LogisticsExpensesController
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 下午2:10
 * @Version 1.0
 **/

@RestController
@Slf4j
@RequestMapping("/dmallladder/logisticsexpenses")
public class LogisticsExpensesController {

    @Autowired
    private GroupLogisticsService groupLogisticsService;

    /**
     * 查询物流费用信息
     *
     * @param request
     * @return
     */
    @PostMapping("/queryExpenses")
    public JsonResult queryExpenses(@RequestBody LogisticsExpensesReqDto request) {

        if (ParamUtil.isIntegerEmpty(request.getPageNumber())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "分页数据"));
        }


        if (ParamUtil.isIntegerEmpty(request.getCreateTimeStart())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "createTimeStart"));
        }

        if (ParamUtil.isIntegerEmpty(request.getCreateTimeEnd())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "createTimeEnd"));
        }

        if (ParamUtil.isIntegerEmpty(request.getPageSize())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "分页数据"));
        }

        Map<String, Object> resMap = groupLogisticsService.queryExpensesService(request);

        return JsonResult.success(resMap);
    }

    /**
     * 新增物流费用
     *
     * @param request
     * @return
     */
    @PostMapping("/createExpenses")
    public JsonResult createExpenses(@RequestBody LogisticsExpensesReqDto request) {

        if (ParamUtil.isIntegerEmpty(request.getGroupId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "groupId"));
        }

        if (ParamUtil.isIntegerEmpty(request.getExpensesClassId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesClassId"));
        }


        if (ParamUtil.isStringEmpty(request.getExpensesClassName())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesClassName"));
        }

        if (ParamUtil.isIntegerEmpty(request.getExpensesNameId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesNameId"));
        }


        if (ParamUtil.isStringEmpty(request.getExpensesName())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesName"));
        }

        if (request.getAmountReceivable() == null) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "amountReceivable"));
        }

        if (ParamUtil.isIntegerEmpty(request.getBusinessStart())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "businessStart"));
        }

        if (ParamUtil.isIntegerEmpty(request.getBusinessEnd())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "businessEnd"));
        }

        if (ParamUtil.isListEmpty(request.getAccessory())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "accessory"));
        }

        if (ParamUtil.isLongEmpty(request.getOperatorId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "operatorId"));
        }


        if (ParamUtil.isStringEmpty(request.getOperatorName())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "operatorName"));
        }


        groupLogisticsService.createExpensesService(request);

        return JsonResult.success("新增物流费用成功！");
    }

    /**
     * 编辑物流费用
     *
     * @param request
     * @return
     */
    @PostMapping("/editExpenses")
    public JsonResult editExpenses(@RequestBody LogisticsExpensesReqDto request) {

        if (ParamUtil.isIntegerEmpty(request.getGroupId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "groupId"));
        }

        if (ParamUtil.isLongEmpty(request.getExpensesId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesId"));
        }

        if (ParamUtil.isStringEmpty(request.getExpensesClassName())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesClassName"));
        }

        if (ParamUtil.isIntegerEmpty(request.getExpensesClassId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesClassId"));
        }

        if (request.getAmountReceivable() == null) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "amountReceivable"));
        }

        if (ParamUtil.isIntegerEmpty(request.getExpensesNameId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesNameId"));
        }


        if (ParamUtil.isStringEmpty(request.getExpensesName())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesName"));
        }

        if (ParamUtil.isIntegerEmpty(request.getBusinessEnd())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "businessEnd"));
        }


        if (ParamUtil.isIntegerEmpty(request.getBusinessStart())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "businessStart"));
        }

        if (ParamUtil.isListEmpty(request.getAccessory())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "accessory"));
        }

        groupLogisticsService.editExpensesService(request);

        return JsonResult.success("编辑物流费用成功！");
    }

    /**
     * 查询物流费用信息操作日志
     *
     * @param request
     * @return
     */
    @PostMapping("/queryExpensesLog")
    public JsonResult queryExpensesLog(@RequestBody LogisticsExpensesReqDto request) {

        if (ParamUtil.isLongEmpty(request.getExpensesId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesId"));
        }

        List<LogisticsExpensesLogResDto> list = groupLogisticsService.queryExpensesLogService(request);

        return JsonResult.success(list);
    }

    /**
     * 查询客户未结算物流费用
     *
     * @param request
     * @return
     */
    @PostMapping("/queryExpensesByGroupId")
    public JsonResult queryExpensesByGroupId(@RequestBody LogisticsExpensesReqDto request) {


        if (ParamUtil.isIntegerEmpty(request.getGroupId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "groupId"));
        }

        List<LogisticsExpensesResDto> list = groupLogisticsService.queryExpensesByGroupIdService(request);

        return JsonResult.success(list);
    }

    /**
     * 查询物流费用明细
     *
     * @param request
     * @return
     */
    @PostMapping("/queryExpensesDetail")
    public JsonResult queryExpensesDetail(@RequestBody LogisticsExpensesReqDto request) {


        if (ParamUtil.isLongEmpty(request.getExpensesId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesId"));
        }

        LogisticsExpensesResDto logisticsExpensesResDto = groupLogisticsService.queryExpensesDetailService(request);

        return JsonResult.success(logisticsExpensesResDto);
    }

}
