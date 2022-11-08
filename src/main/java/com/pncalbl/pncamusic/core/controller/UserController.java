package com.pncalbl.pncamusic.core.controller;

import com.pncalbl.pncamusic.core.dto.UserCreateRequest;
import com.pncalbl.pncamusic.core.dto.UserSearchFilter;
import com.pncalbl.pncamusic.core.dto.UserUpdateRequest;
import com.pncalbl.pncamusic.core.mapper.UserMapper;
import com.pncalbl.pncamusic.core.service.UserService;
import com.pncalbl.pncamusic.core.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author pncalbl
 * @date 2022/6/7 21:41
 * @e-mail pncalbl@qq.com
 * @description
 **/

@RestController
@RequestMapping("/users")
@CrossOrigin
@Api(tags = "用户")
public class UserController {

	UserService userService;
	UserMapper userMapper;

	@GetMapping
	@ApiOperation("用户检索")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	Page<UserVo> search(@Validated UserSearchFilter userSearchFilter) {
		return userService.search(userSearchFilter).map(userMapper::toVo);
	}

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	UserVo create(@Validated @RequestBody UserCreateRequest userCreateRequest) {
		return userMapper.toVo(userService.create(userCreateRequest));
	}

	@GetMapping("/{id}")
	UserVo get(@PathVariable String id) {
		return userMapper.toVo(userService.get(id));
	}


	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	UserVo update(@PathVariable String id,
	              @Validated @RequestBody UserUpdateRequest userUpdateRequest) {
		return userMapper.toVo(userService.update(id, userUpdateRequest));
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(@PathVariable String id) {
		userService.delete(id);
	}

	@GetMapping("/me")
	UserVo me() {
		return userMapper.toVo(userService.getCurrentUser());
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
