package com.pncalbl.pncamusic.service;

import com.pncalbl.pncamusic.dto.TokenCreateRequest;
import com.pncalbl.pncamusic.dto.UserCreateRequest;
import com.pncalbl.pncamusic.dto.UserDto;
import com.pncalbl.pncamusic.dto.UserUpdateRequest;
import com.pncalbl.pncamusic.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author pncalbl
 * @date 2022/6/7 22:03
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface UserService extends UserDetailsService {

	UserDto create(UserCreateRequest userCreateRequest);

	// @Override
	User loadUserByUsername(String username);

	UserDto get(String id);

	UserDto update(String id, UserUpdateRequest userUpdateRequest);

	void delete(String id);

	Page<UserDto> search(Pageable pageable);

	String createToken(TokenCreateRequest tokenCreateRequest);

	UserDto getCurrentUser();

}
