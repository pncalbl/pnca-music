package com.pncalbl.pncamusic.core.dto;

/**
 * @author pncalbl
 * @date 2022/11/8 20:59
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class UserSearchFilter extends BaseSearchFilter {
	private String nickname = "";

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}
