package com.meicai.ppblossom.theone.api.request.logistics;

import com.meicai.ppblossom.theone.api.request.BaseDto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName LogisticsExpensesReqDto
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 下午2:17
 * @Version 1.0
 **/

@Data
public class LogisticsExpensesReqDto extends BaseDto implements Serializable {

    private Long expensesId;

    private Integer groupId;

    private Integer expensesClassId;

    private String expensesClassName;

    private Integer expensesNameId;

    private String expensesName;

    private String remark;

    private BigDecimal amountReceivable;

    private Integer businessStart;

    private Integer businessEnd;

    private List<LogisticsExpensesAccessoryReqDto> accessory;

    private Integer status;

    private Integer createTimeStart;

    private Integer createTimeEnd;

    private Integer limit;

    private Long uT;

}
