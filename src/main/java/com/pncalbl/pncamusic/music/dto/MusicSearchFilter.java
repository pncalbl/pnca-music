package com.pncalbl.pncamusic.music.dto;

import com.pncalbl.pncamusic.core.dto.BaseSearchFilter;

/**
 * @author pncalbl
 * @date 2022/11/5 20:42
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class MusicSearchFilter extends BaseSearchFilter {
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
