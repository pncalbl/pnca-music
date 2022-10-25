package com.pncalbl.pncamusic.dto;

import com.pncalbl.pncamusic.enums.MusicStatus;

/**
 * @author pncalbl
 * @date 2022/10/24 23:43
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class MusicDto extends BaseDto {
	private String name;

	private MusicStatus status = MusicStatus.DRAFT;

	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MusicStatus getStatus() {
		return status;
	}

	public void setStatus(MusicStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}