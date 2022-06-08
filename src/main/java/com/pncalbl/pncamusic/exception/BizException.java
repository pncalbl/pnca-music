package com.pncalbl.pncamusic.exception;

import com.pncalbl.pncamusic.enums.ExceptionType;

/**
 * @author pncalbl
 * @date 2022/6/8 21:14
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class BizException extends RuntimeException {
	private final Integer code;

	public BizException(ExceptionType exceptionType) {
		super(exceptionType.getMessage());
		this.code = exceptionType.getCode();
	}

	public Integer getCode() {
		return code;
	}
}
