package com.pncalbl.pncamusic.core.dto;

import com.pncalbl.pncamusic.core.enums.Gender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author pncalbl
 * @date 2022/6/8 20:41
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class UserCreateRequest {

	@NotBlank(message = "用户名不能为空")
	@Size(min = 4, max = 64, message = "用户名长度应该在4~64个字符之间")
	private String username;
	@NotBlank(message = "密码不能为空")
	@Size(min = 6, max = 24, message = "密码长度应该在6~24个字符之间")
	private String password;

	private String nickname;

	private Gender gender;

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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
}
