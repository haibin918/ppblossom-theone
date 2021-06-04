package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

/**
 * @ClassName AppointOperateEnum
 * @Description
 * @Author wzj
 * @Date 2020/7/27 15:26
 **/
@Getter
public enum AppointOperateEnum {

  VERIFY("verifyPassed", "审核通过"),
  NULLIFY("nullify", "作废"),
  MODIFY("modify", "修改");

  private String code;
  private String message;

  AppointOperateEnum(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
