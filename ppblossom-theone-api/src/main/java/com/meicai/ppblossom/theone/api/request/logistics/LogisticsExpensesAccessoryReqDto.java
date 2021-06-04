package com.meicai.ppblossom.theone.api.request.logistics;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName LogisticsExpensesAccessoryReqDto
 * @Description TODO
 * @Author guohaibin
 * @Date 2021/5/28 下午2:26
 * @Version 1.0
 **/

@Data
public class LogisticsExpensesAccessoryReqDto implements Serializable {

    private String fileName;

    private String fileUrl;
}
