package com.pncalbl.pncamusic.core.dto;

/**
 * @author pncalbl
 * @date 2022/11/1 22:02
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class TraceableBaseDto extends BaseDto {
	private UserDto createdBy;

	private UserDto updatedBy;

	public UserDto getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(UserDto createdBy) {
		this.createdBy = createdBy;
	}

	public UserDto getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(UserDto updatedBy) {
		this.updatedBy = updatedBy;
	}
}
