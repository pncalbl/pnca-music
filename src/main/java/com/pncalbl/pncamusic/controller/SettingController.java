package com.pncalbl.pncamusic.controller;

import com.pncalbl.pncamusic.mapper.SiteSettingMapper;
import com.pncalbl.pncamusic.service.SettingService;
import com.pncalbl.pncamusic.vo.SiteSettingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pncalbl
 * @date 2022/10/28 21:34
 * @e-mail pncalbl@qq.com
 * @description
 **/

@RestController
@RequestMapping("/settings")
public class SettingController {

	private SettingService settingService;

	private SiteSettingMapper siteSettingMapper;

	@GetMapping("/site")
	public SiteSettingVo getSiteSetting() {
		return siteSettingMapper.toVo(settingService.getSiteSetting());
	}

	@Autowired
	public void setSettingService(SettingService settingService) {
		this.settingService = settingService;
	}

	@Autowired
	public void setSiteSettingMapper(SiteSettingMapper siteSettingMapper) {
		this.siteSettingMapper = siteSettingMapper;
	}
}
