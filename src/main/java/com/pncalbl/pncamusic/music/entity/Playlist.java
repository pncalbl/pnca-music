package com.pncalbl.pncamusic.music.entity;

import com.pncalbl.pncamusic.core.entity.File;
import com.pncalbl.pncamusic.core.entity.TraceableBaseEntity;
import com.pncalbl.pncamusic.music.enums.PlayListStatus;

import javax.persistence.*;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/1 21:35
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Entity
public class Playlist extends TraceableBaseEntity {
	private String name;

	private String description;
	@OneToOne
	private File cover;

	@Enumerated(EnumType.STRING)
	private PlayListStatus status = PlayListStatus.DRAFT;


	@ManyToMany
	@JoinTable(name = "playlist_music", joinColumns =
	@JoinColumn(name = "playlist_id", referencedColumnName = "id"),
			inverseJoinColumns =
			@JoinColumn(name = "music_id", referencedColumnName = "id"))
	private List<Music> musicList;

	private Boolean recommended = false;

	private Integer recommendFactor = 0;

	private Boolean special = false;

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

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public PlayListStatus getStatus() {
		return status;
	}

	public void setStatus(PlayListStatus status) {
		this.status = status;
	}

	public List<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
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

	public Boolean getSpecial() {
		return special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}
}

