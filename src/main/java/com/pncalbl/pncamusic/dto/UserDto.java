package com.pncalbl.pncamusic.dto;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/6/7 21:43
 * @e-mail pncalbl@qq.com
 * @description 从外部向内输入-用户
 **/

public class UserDto {
	private String id;

	private String username;

	private String nickname;

	private List<RoleDto> roles;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}
}
