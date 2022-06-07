package com.pncalbl.pncamusic.vo;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/6/7 21:42
 * @e-mail pncalbl@qq.com
 * @description 对外输出-用户
 **/


public class UserVo {
	private String id;

	private String username;

	private String nickname;

	private List<RoleVo> roles;


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

	public List<RoleVo> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleVo> roles) {
		this.roles = roles;
	}
}
