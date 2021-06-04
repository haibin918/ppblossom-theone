package com.meicai.ppblossom.theone.api.response.logistics;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName LogisticsBillResDto
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/6/1 下午2:25
 * @Version 1.0
 **/
@Data
public class LogisticsBillResDto implements Serializable {

    private Long billId;

    private Integer groupId;

    private String groupName;

    private Integer status;

    private String statusName;

    private Integer cT;

    private Integer auditTime;

    private BigDecimal amountReceivable;

    private List<LogisticsExpensesDetailResDto> expensesInfo;

}
