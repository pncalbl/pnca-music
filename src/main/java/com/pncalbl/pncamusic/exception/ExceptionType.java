package com.pncalbl.pncamusic.exception;

/**
 * @author pncalbl
 * @date 2022/6/8 21:16
 * @e-mail pncalbl@qq.com
 * @description 错误类型
 **/
public enum ExceptionType {

	INNER_ERROR(500, "系统内部错误"),
	BAD_REQUEST(400, "请求错误"),
	UNAUTHORIZED(401, "未登录"),
	FORBIDDEN(403, "无权操作"),
	USER_NAME_DUPLICATE(40001001, "用户名重复"),
	USER_NOT_FOUND(40401002, "用户不存在");

	private final Integer code;
	private final String message;

	ExceptionType(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}
}