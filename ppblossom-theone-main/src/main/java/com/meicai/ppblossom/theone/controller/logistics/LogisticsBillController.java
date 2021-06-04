package com.meicai.ppblossom.theone.controller.logistics;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsBillReqDto;
import com.meicai.ppblossom.theone.api.response.JsonResult;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsBillResDto;
import com.meicai.ppblossom.theone.api.response.logistics.LogisticsExpensesLogResDto;
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
 * @ClassName LogisticsBillController
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 下午2:11
 * @Version 1.0
 **/

@RestController
@Slf4j
@RequestMapping("/dmallladder/logisticsbill")
public class LogisticsBillController {

    @Autowired
    private GroupLogisticsService groupLogisticsService;

    /**
     * 新增物流账单
     *
     * @param request
     * @return
     */
    @PostMapping("/createBill")
    public JsonResult createBill(@RequestBody LogisticsBillReqDto request) {

        if (ParamUtil.isIntegerEmpty(request.getGroupId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "groupId"));
        }


        if (request.getAmountReceivable() == null) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "amountReceivable"));
        }


        if (ParamUtil.isListEmpty(request.getExpensesIds())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesIds"));
        }

        groupLogisticsService.createBillService(request);

        return JsonResult.success("新增物流账单成功！");
    }

    /**
     * 查询物流账单信息
     *
     * @param request
     * @return
     */
    @PostMapping("/queryBill")
    public JsonResult queryBill(@RequestBody LogisticsBillReqDto request) {

        if (ParamUtil.isIntegerEmpty(request.getPageNumber())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "分页数据"));
        }

        if (ParamUtil.isIntegerEmpty(request.getCreateTimeStart())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "createTimeStart"));
        }


        if (ParamUtil.isIntegerEmpty(request.getPageSize())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "分页数据"));
        }


        if (ParamUtil.isIntegerEmpty(request.getCreateTimeEnd())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "createTimeEnd"));
        }

        Map<String, Object> resMap = groupLogisticsService.queryBillService(request);

        return JsonResult.success(resMap);
    }

    /**
     * 编辑物流账单
     *
     * @param request
     * @return
     */
    @PostMapping("/editBill")
    public JsonResult editBill(@RequestBody LogisticsBillReqDto request) {


        if (ParamUtil.isIntegerEmpty(request.getGroupId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "groupId"));
        }

        if (ParamUtil.isLongEmpty(request.getBillId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "billId"));
        }


        if (request.getAmountReceivable() == null) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "amountReceivable"));
        }


        if (ParamUtil.isListEmpty(request.getExpensesIds())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "expensesIds"));
        }

        groupLogisticsService.editBillService(request);

        return JsonResult.success("编辑物流账单成功！");
    }

    /**
     * 查询物流账单日志信息
     *
     * @param request
     * @return
     */
    @PostMapping("/queryBillLog")
    public JsonResult queryBillLog(@RequestBody LogisticsBillReqDto request) {


        if (ParamUtil.isLongEmpty(request.getBillId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "billId"));
        }

        List<LogisticsExpensesLogResDto> list = groupLogisticsService.queryBillLogService(request);

        return JsonResult.success(list);
    }

    /**
     * 审核物流账单
     *
     * @param request
     * @return
     */
    @PostMapping("/auditBill")
    public JsonResult auditBill(@RequestBody LogisticsBillReqDto request) {


        if (ParamUtil.isLongEmpty(request.getBillId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "billId"));
        }

        groupLogisticsService.auditBillService(request);

        return JsonResult.success("审核物流账单成功");
    }

    /**
     * 查询物流账单明细
     *
     * @param request
     * @return
     */
    @PostMapping("/queryBillDetail")
    public JsonResult queryBillDetail(@RequestBody LogisticsBillReqDto request) {


        if (ParamUtil.isLongEmpty(request.getBillId())) {

            throw new BizException(ResultCodeEnum.PARAM_NULL_ERROR.getEnumValue(), ResultCodeEnum.PARAM_NULL_ERROR.getEnumName().replace("%s", "billId"));
        }

        LogisticsBillResDto logisticsBillResDto = groupLogisticsService.queryBillDetailService(request);

        return JsonResult.success(logisticsBillResDto);
    }
}
