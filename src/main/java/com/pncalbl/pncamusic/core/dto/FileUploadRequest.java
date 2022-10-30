package com.pncalbl.pncamusic.core.dto;

import javax.validation.constraints.NotBlank;

/**
 * @author pncalbl
 * @date 2022/10/26 20:38
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class FileUploadRequest {
	@NotBlank(message = "文件名不能为空")
	private String name;

	private Long size;

	@NotBlank(message = "后缀名不能为空")
	private String ext;

	@NotBlank(message = "key不能为空")
	private String key;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
