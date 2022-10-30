package com.pncalbl.pncamusic.core.dto;

import com.pncalbl.pncamusic.core.enums.Storage;

/**
 * @author pncalbl
 * @date 2022/10/28 21:36
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class SiteSettingDto {
	private String bucket;

	private String region;

	private Storage storage;

	public String getBucket() {
		return bucket;
	}

	public void setBucket(String bucket) {
		this.bucket = bucket;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}
}
