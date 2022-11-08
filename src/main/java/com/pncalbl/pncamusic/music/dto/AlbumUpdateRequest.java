package com.pncalbl.pncamusic.music.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/7 21:55
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class AlbumUpdateRequest {
	@NotBlank(message = "专辑名字不能为空")
	private String name;

	private String description;

	@NotBlank(message = "专辑封面必须上传")
	private String coverId;

	@NotEmpty(message = "至少选择一名歌手")
	private List<String> artistIds;

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

	public String getCoverId() {
		return coverId;
	}

	public void setCoverId(String coverId) {
		this.coverId = coverId;
	}

	public List<String> getArtistIds() {
		return artistIds;
	}

	public void setArtistIds(List<String> artistIds) {
		this.artistIds = artistIds;
	}
}
