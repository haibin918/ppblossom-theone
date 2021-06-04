package com.meicai.ppblossom.theone.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName BaseDto
 * @Description
 * @Author wzj
 * @Date 2020/8/13 10:46
 **/
@Data
public class BaseDto implements Serializable {

    // 操作人ID
    private Long operatorId;

    // 操作人名称
    private String operatorName;

    // 操作人邮箱
    private String operatorEmail;

    /** 页数 **/
    private Integer pageNumber;

    /** 每页展示数 **/
    private Integer pageSize;

    private Integer offset;

    private Integer channel;

    private Integer ruleType;
}
