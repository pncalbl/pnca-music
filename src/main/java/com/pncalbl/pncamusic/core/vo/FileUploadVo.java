package com.pncalbl.pncamusic.core.vo;

/**
 * @author pncalbl
 * @date 2022/10/26 21:05
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class FileUploadVo {
	private String secretId;

	private String secretKey;

	private String sessionToken;

	private String key;

	private String fileId;

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getSessionToken() {
		return sessionToken;
	}

	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
}
