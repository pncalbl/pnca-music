package com.pncalbl.pncamusic.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @author pncalbl
 * @date 2022/10/25 0:16
 * @e-mail pncalbl@qq.com
 * @description
 **/

public abstract class BaseVo {
	private String id;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
	private Date createdTime;

	@JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
