package com.meicai.ppblossom.theone.api.request.logistics;

import com.meicai.ppblossom.theone.api.request.BaseDto;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName LogisticsBillReqDto
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 下午3:35
 * @Version 1.0
 **/

@Data
public class LogisticsBillReqDto extends BaseDto implements Serializable {

    private Long billId;

    private Integer groupId;

    private BigDecimal amountReceivable;

    private String remark;

    private List<Long> expensesIds;

    private Integer createTimeStart;

    private Integer createTimeEnd;

    private Integer status;

    private Integer auditTimeStart;

    private Integer auditTimeEnd;

    private Long ut;

    private Integer limit;


}
