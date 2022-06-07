package com.pncalbl.pncamusic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pncalbl
 * @date 2022/5/30 23:56
 * @e-mail pncalbl@qq.com
 * @description 测试 Controller
 **/

@RestController
@RequestMapping("/hello")
public class DefaultController {

	@GetMapping
	public String sayHello() {
		return "欢迎程序猿pnca的音乐盒";
	}
}
