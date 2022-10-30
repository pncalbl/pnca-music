package com.pncalbl.pncamusic.core.vo;

import com.pncalbl.pncamusic.core.enums.FileStatus;
import com.pncalbl.pncamusic.core.enums.FileType;
import com.pncalbl.pncamusic.core.enums.Storage;

/**
 * @author pncalbl
 * @date 2022/10/26 20:33
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class FileVo {
	private String name;

	private String key;

	private String uri;

	private Storage storage;

	private String ext;

	private Long size;

	private FileType type;

	private FileStatus status;

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

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
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

	public FileStatus getStatus() {
		return status;
	}

	public void setStatus(FileStatus status) {
		this.status = status;
	}
}
