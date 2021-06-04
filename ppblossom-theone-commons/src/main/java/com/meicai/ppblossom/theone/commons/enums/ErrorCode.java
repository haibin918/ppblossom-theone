package com.meicai.ppblossom.theone.commons.enums;

public enum ErrorCode {
	// @formatter:off
	SUCCESS(0, "成功"),
	SYSTEM_EXCEPTION(-1,"系统异常"),
	INVALID_PARAM_EXCEPTION(2,"参数不合法");

	// @formatter:on
	private int code;
	private String message;

	ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

}
