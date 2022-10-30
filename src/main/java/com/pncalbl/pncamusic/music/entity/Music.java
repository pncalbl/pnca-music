package com.pncalbl.pncamusic.music.entity;

import com.pncalbl.pncamusic.core.entity.BaseEntity;
import com.pncalbl.pncamusic.music.enums.MusicStatus;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author pncalbl
 * @date 2022/10/24 23:17
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Entity
public class Music extends BaseEntity {
	private String name;

	@Enumerated(EnumType.STRING)
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
