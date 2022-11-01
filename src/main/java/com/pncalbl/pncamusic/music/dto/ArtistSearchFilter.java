package com.pncalbl.pncamusic.music.dto;

import com.pncalbl.pncamusic.core.dto.BaseSearchFilter;

/**
 * @author pncalbl
 * @date 2022/11/1 21:55
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class ArtistSearchFilter extends BaseSearchFilter {
	private String name = "";

	private Boolean recommended;

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
}
