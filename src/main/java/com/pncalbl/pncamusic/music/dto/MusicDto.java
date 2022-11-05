package com.pncalbl.pncamusic.music.dto;

import com.pncalbl.pncamusic.core.dto.BaseDto;
import com.pncalbl.pncamusic.core.dto.FileDto;
import com.pncalbl.pncamusic.music.enums.MusicStatus;
import lombok.ToString;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/10/24 23:43
 * @e-mail pncalbl@qq.com
 * @description
 **/

@ToString(callSuper = true)
public class MusicDto extends BaseDto {
	private String name;

	private MusicStatus status = MusicStatus.DRAFT;

	private String description;

	private FileDto file;

	private List<ArtistDto> artistList;

	public FileDto getFile() {
		return file;
	}

	public void setFile(FileDto file) {
		this.file = file;
	}

	public List<ArtistDto> getArtistList() {
		return artistList;
	}

	public void setArtistList(List<ArtistDto> artistList) {
		this.artistList = artistList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MusicStatus getStatus() {
		return status;
	}

	public void setStatus(MusicStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
