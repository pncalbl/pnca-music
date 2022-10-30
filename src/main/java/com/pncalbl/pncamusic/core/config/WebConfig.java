package com.pncalbl.pncamusic.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author pncalbl
 * @date 2022/6/8 21:45
 * @e-mail pncalbl@qq.com
 * @description Web有关的配置
 **/

@Configuration
public class WebConfig {
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
