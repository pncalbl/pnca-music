package com.pncalbl.pncamusic.music.dto;

import com.pncalbl.pncamusic.core.dto.FileDto;
import com.pncalbl.pncamusic.core.dto.TraceableBaseDto;
import com.pncalbl.pncamusic.music.enums.PlayListStatus;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/1 22:04
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class PlaylistDto extends TraceableBaseDto {
	private String name;

	private String description;

	private FileDto cover;

	private PlayListStatus status;

	private List<MusicDto> musicList;

	private Boolean recommended;

	private Integer recommendFactor;

	private Boolean special;

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

	public FileDto getCover() {
		return cover;
	}

	public void setCover(FileDto cover) {
		this.cover = cover;
	}

	public PlayListStatus getStatus() {
		return status;
	}

	public void setStatus(PlayListStatus status) {
		this.status = status;
	}

	public List<MusicDto> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<MusicDto> musicList) {
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
