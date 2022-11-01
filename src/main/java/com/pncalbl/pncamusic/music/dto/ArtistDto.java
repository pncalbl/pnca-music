package com.pncalbl.pncamusic.music.dto;

import com.pncalbl.pncamusic.core.dto.BaseDto;
import com.pncalbl.pncamusic.core.dto.FileDto;
import com.pncalbl.pncamusic.core.dto.TraceableBaseDto;
import com.pncalbl.pncamusic.core.enums.GeneralStatus;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/1 21:55
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class ArtistDto extends TraceableBaseDto {
	private String name;

	private String remark;

	private FileDto photo;

	private List<MusicDto> musicDtoList;

	private GeneralStatus status;

	private Boolean recommended;

	private Integer recommendFactor;

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

	public FileDto getPhoto() {
		return photo;
	}

	public void setPhoto(FileDto photo) {
		this.photo = photo;
	}

	public List<MusicDto> getMusicDtoList() {
		return musicDtoList;
	}

	public void setMusicDtoList(List<MusicDto> musicDtoList) {
		this.musicDtoList = musicDtoList;
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
