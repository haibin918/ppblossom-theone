package com.meicai.ppblossom.theone.commons.enums;

import lombok.Getter;

/** @ClassName ChannelEnum
 * @Description
 * @Author wzj
 * @Date 2020/7/27 15:19
 **/

@Getter
public enum ChannelEnum {

  BIG_MALL(1, "大客户");

  private Integer code;
  private String message;

  ChannelEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

}
