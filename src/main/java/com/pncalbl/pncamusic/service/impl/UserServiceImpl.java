package com.pncalbl.pncamusic.service.impl;

import com.pncalbl.pncamusic.dto.UserDto;
import com.pncalbl.pncamusic.mapper.UserMapper;
import com.pncalbl.pncamusic.repository.UserRepository;
import com.pncalbl.pncamusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pncalbl
 * @date 2022/6/7 22:03
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Service
public class UserServiceImpl implements UserService {

	UserRepository repository;
	UserMapper userMapper;

	@Override
	public List<UserDto> list() {
		return repository.findAll()
				.stream().map(userMapper::toDto)
				.collect(Collectors.toList());
	}


	@Autowired
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
}
