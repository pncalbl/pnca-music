package com.pncalbl.pncamusic.core.controller;

import com.pncalbl.pncamusic.core.dto.TokenCreateRequest;
import com.pncalbl.pncamusic.core.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pncalbl
 * @date 2022/6/10 19:42
 * @e-mail pncalbl@qq.com
 * @description
 **/

@RestController
@RequestMapping("/tokens")
@Api(tags = "授权")
public class TokenController {
	UserService userService;

	@PostMapping
	@ApiOperation("创建token")
	public String create(@RequestBody TokenCreateRequest tokenCreateRequest) {
		return userService.createToken(tokenCreateRequest);
	}


	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
