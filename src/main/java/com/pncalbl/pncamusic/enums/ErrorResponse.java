package com.pncalbl.pncamusic.enums;

/**
 * @author pncalbl
 * @date 2022/6/8 21:26
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class ErrorResponse {
	private Integer code;

	private String message;

	private Object trace;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getTrace() {
		return trace;
	}

	public void setTrace(Object trace) {
		this.trace = trace;
	}
}
