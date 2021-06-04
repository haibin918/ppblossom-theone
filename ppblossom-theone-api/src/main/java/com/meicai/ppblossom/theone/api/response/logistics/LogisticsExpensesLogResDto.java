package com.meicai.ppblossom.theone.api.response.logistics;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName LogisticsExpensesLogResDto
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 下午3:17
 * @Version 1.0
 **/

@Data
public class LogisticsExpensesLogResDto implements Serializable {

    private Long operatorId;

    private String operatorName;

    private Integer operatorTime;

    private String operatorText;

}
