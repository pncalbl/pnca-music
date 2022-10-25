package com.pncalbl.pncamusic.vo;

import com.pncalbl.pncamusic.enums.MusicStatus;

/**
 * @author pncalbl
 * @date 2022/10/25 0:16
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class MusicVo extends BaseVo {
	private String name;

	private MusicStatus status;

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
