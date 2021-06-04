package com.meicai.ppblossom.theone.api.response.logistics;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @ClassName LogisticsExpensesDetailResDto
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/6/1 下午7:02
 * @Version 1.0
 **/

@Data
public class LogisticsExpensesDetailResDto implements Serializable {

    private Long expensesId;

    private Integer expensesClassId;

    private String expensesClassName;

    private Integer expensesNameId;

    private String expensesName;

    private BigDecimal amountReceivable;

    private Integer businessStart;

    private Integer businessEnd;

}
