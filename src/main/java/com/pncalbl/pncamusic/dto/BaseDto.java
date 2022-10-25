package com.pncalbl.pncamusic.dto;

import java.util.Date;

/**
 * @author pncalbl
 * @date 2022/10/24 23:44
 * @e-mail pncalbl@qq.com
 * @description
 **/

public abstract class BaseDto {
	protected String id;

	protected Date createdTime;

	protected Date updateTime;

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
