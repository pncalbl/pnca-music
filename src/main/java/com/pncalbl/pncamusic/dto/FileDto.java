package com.pncalbl.pncamusic.dto;

import com.pncalbl.pncamusic.enums.FileStatus;
import com.pncalbl.pncamusic.enums.FileType;
import com.pncalbl.pncamusic.enums.Storage;

import java.util.Date;

/**
 * @author pncalbl
 * @date 2022/10/26 20:37
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class FileDto {
	private String id;

	private String name;

	private String key;

	private String uri;

	private String ext;

	private Long size;

	private FileType type;

	private Storage storage;

	private FileStatus status;

	private Date createdTime;

	private Date updatedTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public FileStatus getStatus() {
		return status;
	}

	public void setStatus(FileStatus status) {
		this.status = status;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
