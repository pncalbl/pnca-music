package com.pncalbl.pncamusic.core.controller;

import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author pncalbl
 * @date 2022/6/13 21:15
 * @e-mail pncalbl@qq.com
 * @description
 **/

@RestController
@RequestMapping("/weixin")
public class WeiXinController {

	private WxMpService wxMpService;

	@GetMapping("/auth_url")
	public String getAuthUrl(@PathParam("redirectUrl") String redirectUrl) {
		return wxMpService.getOAuth2Service().buildAuthorizationUrl(
				redirectUrl,
				WxConsts.OAuth2Scope.SNSAPI_USERINFO,
				null
		);
	}

	@Autowired
	public void setWxMpService(WxMpService wxMpService) {
		this.wxMpService = wxMpService;
	}

}
