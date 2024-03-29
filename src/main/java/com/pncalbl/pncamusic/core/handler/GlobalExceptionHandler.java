package com.pncalbl.pncamusic.core.handler;

import com.pncalbl.pncamusic.core.enums.ExceptionType;
import com.pncalbl.pncamusic.core.exception.BizException;
import com.pncalbl.pncamusic.core.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/6/8 21:25
 * @e-mail pncalbl@qq.com
 * @description 全局异常处理
 **/

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
	@ExceptionHandler(value = BizException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse bizExceptionHandler(BizException e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(e.getCode());
		errorResponse.setMessage(e.getMessage());
		errorResponse.setTrace(e.getStackTrace());
		log.error(e.getMessage());
		return errorResponse;
	}

	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse exceptionHandler(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(ExceptionType.INNER_ERROR.getCode());
		errorResponse.setMessage(ExceptionType.INNER_ERROR.getMessage());
		e.printStackTrace();
		log.error(e.getMessage());
		return errorResponse;
	}


	@ExceptionHandler(value = AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorResponse accessDeniedHandler(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(ExceptionType.FORBIDDEN.getCode());
		errorResponse.setMessage(ExceptionType.FORBIDDEN.getMessage());
		e.printStackTrace();
		log.error(e.getMessage());
		return errorResponse;
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public List<ErrorResponse> bizExceptionHandler(MethodArgumentNotValidException e) {

		List<ErrorResponse> errorResponses = new ArrayList<>();
		e.printStackTrace();
		e.getBindingResult().getAllErrors().forEach((error) -> {
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setCode(ExceptionType.BAD_REQUEST.getCode());
			errorResponse.setMessage(error.getDefaultMessage());
			errorResponses.add(errorResponse);
			log.error(error.getDefaultMessage());
		});

		return errorResponses;
	}
}
