package com.pncalbl.pncamusic.core.entity;

import com.pncalbl.pncamusic.core.enums.FileStatus;
import com.pncalbl.pncamusic.core.enums.FileType;
import com.pncalbl.pncamusic.core.enums.Storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author pncalbl
 * @date 2022/10/26 20:17
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Entity
public class File extends TraceableBaseEntity {
	private String name;

	@Column(name = "file_key")
	private String key;

	private String ext;

	private Integer size;

	@Enumerated(EnumType.STRING)
	private FileType type;

	@Enumerated(EnumType.STRING)
	private Storage storage;

	@Enumerated(EnumType.STRING)
	private FileStatus fileStatus = FileStatus.UPLOADING;

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

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
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

	public FileStatus getFileStatus() {
		return fileStatus;
	}

	public void setFileStatus(FileStatus fileStatus) {
		this.fileStatus = fileStatus;
	}
}
