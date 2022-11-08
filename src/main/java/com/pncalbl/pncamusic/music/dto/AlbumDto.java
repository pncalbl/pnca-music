package com.pncalbl.pncamusic.music.dto;

import com.pncalbl.pncamusic.core.dto.FileDto;
import com.pncalbl.pncamusic.core.dto.TraceableBaseDto;
import com.pncalbl.pncamusic.core.enums.GeneralStatus;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/7 21:55
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class AlbumDto extends TraceableBaseDto {
	private String name;

	private String description;

	private FileDto cover;

	private GeneralStatus status;

	private Boolean recommended;

	private Integer recommendFactor;

	private List<ArtistDto> artists;

	private List<MusicDto> musicList;

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

	public List<ArtistDto> getArtists() {
		return artists;
	}

	public void setArtists(List<ArtistDto> artists) {
		this.artists = artists;
	}

	public List<MusicDto> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<MusicDto> musicList) {
		this.musicList = musicList;
	}
}
