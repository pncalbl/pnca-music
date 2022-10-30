package com.pncalbl.pncamusic.core.exception;

import cn.hutool.json.JSONUtil;
import com.pncalbl.pncamusic.core.enums.ExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author pncalbl
 * @date 2022/6/8 23:47
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Cache-Control", "no-cache");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());

		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(ExceptionType.UNAUTHORIZED.getCode());
		errorResponse.setMessage(ExceptionType.UNAUTHORIZED.getMessage());
		response.getWriter().println(JSONUtil.parse(errorResponse));
		response.getWriter().flush();
	}
}
