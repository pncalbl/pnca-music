package com.pncalbl.pncamusic.music.vo;

import com.pncalbl.pncamusic.core.vo.BaseVo;
import com.pncalbl.pncamusic.core.vo.FileVo;
import com.pncalbl.pncamusic.music.enums.PlayListStatus;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/5 21:07
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class PlaylistVo extends BaseVo {
	private String name;

	private String description;

	private FileVo cover;

	private PlayListStatus status;

	private List<MusicVo> musicList;

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

	public FileVo getCover() {
		return cover;
	}

	public void setCover(FileVo cover) {
		this.cover = cover;
	}

	public PlayListStatus getStatus() {
		return status;
	}

	public void setStatus(PlayListStatus status) {
		this.status = status;
	}

	public List<MusicVo> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<MusicVo> musicList) {
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
