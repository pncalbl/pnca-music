package com.pncalbl.pncamusic.dto;

/**
 * @author pncalbl
 * @date 2022/6/8 20:41
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class UserCreateRequest {


	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
