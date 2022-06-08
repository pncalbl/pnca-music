package com.pncalbl.pncamusic.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pncalbl.pncamusic.config.SecurityConfig;
import com.pncalbl.pncamusic.entity.User;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author pncalbl
 * @date 2022/6/8 22:11
 * @e-mail pncalbl@qq.com
 * @description Jwt鉴权过滤器
 **/

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@SneakyThrows
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		User user = new ObjectMapper().
				readValue(request.getInputStream(), User.class);
		return authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						user.getUsername(),
						user.getPassword(),
						new ArrayList<>()
				)
		);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
		String token = JWT.create()
				.withSubject(((User) authResult.getPrincipal()).getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes(StandardCharsets.UTF_8)));
		response.setHeader(SecurityConfig.HEADER_STRING, SecurityConfig.TOKEN_PREFIX + token);
	}
}
