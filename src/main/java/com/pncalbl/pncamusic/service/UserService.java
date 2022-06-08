package com.pncalbl.pncamusic.service;

import com.pncalbl.pncamusic.dto.UserCreateRequest;
import com.pncalbl.pncamusic.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/6/7 22:03
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface UserService extends UserDetailsService {
	List<UserDto> list();

	UserDto create(UserCreateRequest userCreateRequest);
}
