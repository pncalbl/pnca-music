package com.pncalbl.pncamusic.music.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/10/25 14:39
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class MusicCreateRequest {
	@NotBlank(message = "歌曲名不能为空")
	private String name;

	private String description;

	private String fileId;

	@NotNull(message = "歌手未选择")
	private List<String> artistIds;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public List<String> getArtistIds() {
		return artistIds;
	}

	public void setArtistIds(List<String> artistIds) {
		this.artistIds = artistIds;
	}

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
}
