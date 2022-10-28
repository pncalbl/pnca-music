package com.pncalbl.pncamusic.service.impl;

import com.pncalbl.pncamusic.dto.SiteSettingDto;
import com.pncalbl.pncamusic.service.FileService;
import com.pncalbl.pncamusic.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author pncalbl
 * @date 2022/10/28 21:37
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Service
public class SettingServiceImpl implements SettingService {

	@Value("${cos.bucket}")
	private String bucket;


	@Value("${cos.region}")
	private String region;


	private FileService fileService;

	@Override
	public SiteSettingDto getSiteSetting() {
		SiteSettingDto siteSettingDto = new SiteSettingDto();
		siteSettingDto.setBucket(bucket);
		siteSettingDto.setRegion(region);
		siteSettingDto.setStorage(fileService.getDefaultStorage());
		return siteSettingDto;
	}

	@Autowired
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}
}
