package com.pncalbl.pncamusic.music.vo;

import com.pncalbl.pncamusic.core.enums.GeneralStatus;
import com.pncalbl.pncamusic.core.vo.BaseVo;
import com.pncalbl.pncamusic.core.vo.FileVo;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/1 21:55
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class ArtistVo extends BaseVo {
	private String name;

	private String remark;

	private FileVo photo;

	private List<MusicVo> musicDtoList;

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

	public FileVo getPhoto() {
		return photo;
	}

	public void setPhoto(FileVo photo) {
		this.photo = photo;
	}

	public List<MusicVo> getMusicDtoList() {
		return musicDtoList;
	}

	public void setMusicDtoList(List<MusicVo> musicDtoList) {
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
