package com.pncalbl.pncamusic.music.entity;

import com.pncalbl.pncamusic.core.entity.File;
import com.pncalbl.pncamusic.core.entity.TraceableBaseEntity;
import com.pncalbl.pncamusic.core.enums.GeneralStatus;

import javax.persistence.*;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/1 21:33
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Entity
public class Artist extends TraceableBaseEntity {
	private String name;

	private String remark;

	@OneToOne
	private File photo;

	@ManyToMany
	@JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
	private List<Music> musicList;

	private GeneralStatus status = GeneralStatus.DRAFT;

	private Boolean recommended = false;

	private Integer recommendFactor = 0;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public List<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
	}

	public GeneralStatus getStatus() {
		return status;
	}

	public void setStatus(GeneralStatus status) {
		this.status = status;
	}

	public Boolean getRecommended() {
		return recommended;
	}

	public void setRecommended(Boolean recommended) {
		this.recommended = recommended;
	}

	public Integer getRecommendFactor() {
		return recommendFactor;
	}

	public void setRecommendFactor(Integer recommendFactor) {
		this.recommendFactor = recommendFactor;
	}
}
