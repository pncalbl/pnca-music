package com.pncalbl.pncamusic.music.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author pncalbl
 * @date 2022/10/25 14:39
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class MusicCreateRequest {
	@NotBlank(message = "歌曲名不能为空")
	private String name;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
