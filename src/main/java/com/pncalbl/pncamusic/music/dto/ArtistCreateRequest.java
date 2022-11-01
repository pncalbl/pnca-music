package com.pncalbl.pncamusic.music.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author pncalbl
 * @date 2022/11/1 21:54
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class ArtistCreateRequest {
	@NotBlank(message = "歌手名字不能为空")
	private String name;

	private String remark;

	@NotBlank(message = "歌手照片必须上传")
	private String photoId;

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

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
}
