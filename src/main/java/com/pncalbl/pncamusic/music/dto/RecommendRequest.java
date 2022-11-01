package com.pncalbl.pncamusic.music.dto;

/**
 * @author pncalbl
 * @date 2022/11/1 22:05
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class RecommendRequest {
	private Integer recommendFactor = 0;

	public Integer getRecommendFactor() {
		return recommendFactor;
	}

	public void setRecommendFactor(Integer recommendFactor) {
		this.recommendFactor = recommendFactor;
	}
}
