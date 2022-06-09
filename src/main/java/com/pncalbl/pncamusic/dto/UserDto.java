package com.pncalbl.pncamusic.dto;

import com.pncalbl.pncamusic.enums.Gender;

import java.util.Date;
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

	private Gender gender;

	private Boolean locked;

	private Boolean enabled;

	private String lastLoginIp;

	private Date lastLoginTime;


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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Boolean getLocked() {
		return locked;
	}

	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getLastLoginIp() {
		return lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}
