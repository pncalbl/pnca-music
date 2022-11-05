package com.pncalbl.pncamusic.music.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author pncalbl
 * @date 2022/11/5 21:05
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class PlaylistCreateRequest {
	@NotBlank(message = "歌单名不能为空")
	private String name;

	private String description;

	@NotNull(message = "请上传封面")
	private String coverId;

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

	public String getCoverId() {
		return coverId;
	}

	public void setCoverId(String coverId) {
		this.coverId = coverId;
	}
}
