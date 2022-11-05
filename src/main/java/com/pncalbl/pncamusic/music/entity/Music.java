package com.pncalbl.pncamusic.music.entity;

import com.pncalbl.pncamusic.core.entity.BaseEntity;
import com.pncalbl.pncamusic.core.entity.File;
import com.pncalbl.pncamusic.music.enums.MusicStatus;

import javax.persistence.*;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/10/24 23:17
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Entity
public class Music extends BaseEntity {
	private String name;

	@Enumerated(EnumType.STRING)
	private MusicStatus status;

	private String description;

	@ManyToMany
	@JoinTable(name = "artist_music", joinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
	private List<Artist> artistList;

	@OneToOne
	private File file;

	public List<Artist> getArtistList() {
		return artistList;
	}

	public void setArtistList(List<Artist> artistList) {
		this.artistList = artistList;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
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
