package com.pncalbl.pncamusic.music.dto;

import com.pncalbl.pncamusic.core.dto.BaseSearchFilter;

/**
 * @author pncalbl
 * @date 2022/11/1 22:05
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class PlaylistSearchFilter extends BaseSearchFilter {
	private String name = "";

	private Boolean recommended;

	private Boolean special;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRecommended() {
		return recommended;
	}

	public void setRecommended(Boolean recommended) {
		this.recommended = recommended;
	}

	public Boolean getSpecial() {
		return special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}
}
