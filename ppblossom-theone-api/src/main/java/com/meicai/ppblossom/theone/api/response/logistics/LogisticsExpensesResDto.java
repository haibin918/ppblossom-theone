package com.meicai.ppblossom.theone.api.response.logistics;

import com.meicai.ppblossom.theone.api.request.logistics.LogisticsExpensesAccessoryReqDto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName LogisticsExpensesResDto
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 下午2:59
 * @Version 1.0
 **/

@Data
public class LogisticsExpensesResDto implements Serializable {

    private Long expensesId;

    private Integer groupId;

    private String groupName;

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

    private String statusName;

    private Integer cT;

    private Long billId;

    // private BigDecimal amountReceivableTotal;

}
