package com.pncalbl.pncamusic.controller;

import com.pncalbl.pncamusic.dto.UserCreateRequest;
import com.pncalbl.pncamusic.mapper.UserMapper;
import com.pncalbl.pncamusic.service.UserService;
import com.pncalbl.pncamusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pncalbl
 * @date 2022/6/7 21:41
 * @e-mail pncalbl@qq.com
 * @description
 **/

@RestController
@RequestMapping("/users")
public class UserController {

	UserService userService;
	UserMapper userMapper;

	@GetMapping("/")
	List<UserVo> list() {
		return userService.list().stream()
				.map(userMapper::toVo)
				.collect(Collectors.toList());
	}

	@PostMapping("/")
	UserVo create(@RequestBody UserCreateRequest userCreateRequest) {
		return userMapper.toVo(userService.create(userCreateRequest));
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
