package com.pncalbl.pncamusic.music.vo;

import com.pncalbl.pncamusic.core.enums.GeneralStatus;
import com.pncalbl.pncamusic.core.vo.BaseVo;
import com.pncalbl.pncamusic.core.vo.FileVo;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/7 21:57
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class AlbumVo extends BaseVo {
	private String name;

	private String description;

	private FileVo cover;

	private GeneralStatus status;

	private Boolean recommended;

	private Integer recommendFactor;

	private List<ArtistVo> artists;

	private List<MusicVo> musicList;

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

	public List<ArtistVo> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistVo> artists) {
		this.artists = artists;
	}

	public List<MusicVo> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<MusicVo> musicList) {
		this.musicList = musicList;
	}
}
