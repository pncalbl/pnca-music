package com.pncalbl.pncamusic.music.entity;

import com.pncalbl.pncamusic.core.entity.File;
import com.pncalbl.pncamusic.core.entity.TraceableBaseEntity;
import com.pncalbl.pncamusic.core.enums.GeneralStatus;

import javax.persistence.*;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/7 21:56
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Entity
public class Album extends TraceableBaseEntity {
	private String name;

	private String description;

	private GeneralStatus status;

	private Boolean recommended = false;

	private Integer recommendFactor = 0;

	@OneToOne
	private File cover;

	@ManyToMany
	@JoinTable(name = "album_artist", joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "artist_id", referencedColumnName = "id"))
	private List<Artist> artists;

	@ManyToMany
	@JoinTable(name = "album_music", joinColumns = @JoinColumn(name = "album_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"))
	private List<Music> musicList;

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

	public File getCover() {
		return cover;
	}

	public void setCover(File cover) {
		this.cover = cover;
	}

	public List<Artist> getArtists() {
		return artists;
	}

	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}

	public List<Music> getMusicList() {
		return musicList;
	}

	public void setMusicList(List<Music> musicList) {
		this.musicList = musicList;
	}
}
