package com.pncalbl.pncamusic.core.config;

import com.pncalbl.pncamusic.core.exception.RestAuthenticationEntryPoint;
import com.pncalbl.pncamusic.core.filter.JwtAuthorizationFilter;
import com.pncalbl.pncamusic.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

/**
 * @author pncalbl
 * @date 2022/6/8 22:00
 * @e-mail pncalbl@qq.com
 * @description 安全有关的配置
 **/

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		prePostEnabled = true,
		securedEnabled = true,
		jsr250Enabled = true
)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	public static final String SECRET = "PncaMusic";
	public static final long EXPIRATION_TIME = 864000000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String CREATE_TOKEN_URL = "/tokens/**";
	public static final String SITE_SETTING_URL = "/settings/site";

	UserService userService;
	RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.authorizeRequests()
				.antMatchers(CREATE_TOKEN_URL).permitAll()
				.antMatchers(SITE_SETTING_URL).permitAll()
				.anyRequest().authenticated()
				.and()
				.addFilter(new JwtAuthorizationFilter(authenticationManager(), userService))
				.exceptionHandling()
				.authenticationEntryPoint(restAuthenticationEntryPoint)
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/swagger**/**")
				.antMatchers("/webjars/**")
				.antMatchers("/v3/**")
				.antMatchers("/doc.html")
				.antMatchers("/weixin/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setRestAuthenticationEntryPoint(RestAuthenticationEntryPoint restAuthenticationEntryPoint) {
		this.restAuthenticationEntryPoint = restAuthenticationEntryPoint;
	}
}
