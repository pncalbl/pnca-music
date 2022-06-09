package com.pncalbl.pncamusic.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author pncalbl
 * @date 2022/6/8 20:41
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class UserUpdateRequest {
	@NotBlank(message = "用户名不能为空")
	@Size(min = 4, max = 64, message = "用户名长度应该在4个字符到64个字符之间")
	private String username;

	private String nickname;

	private String gender;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
