package com.pncalbl.pncamusic.service.impl;

import com.pncalbl.pncamusic.dto.UserCreateRequest;
import com.pncalbl.pncamusic.dto.UserDto;
import com.pncalbl.pncamusic.entity.User;
import com.pncalbl.pncamusic.exception.ExceptionType;
import com.pncalbl.pncamusic.exception.BizException;
import com.pncalbl.pncamusic.mapper.UserMapper;
import com.pncalbl.pncamusic.repository.UserRepository;
import com.pncalbl.pncamusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author pncalbl
 * @date 2022/6/7 22:03
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	UserMapper userMapper;
	PasswordEncoder passwordEncoder;

	@Override
	public List<UserDto> list() {
		return userRepository.findAll()
				.stream().map(userMapper::toDto)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto create(UserCreateRequest userCreateRequest) {
		checkUsername(userCreateRequest.getUsername());
		User user = userMapper.createEntity(userCreateRequest);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userMapper.toDto(userRepository.save(user));
	}

	private void checkUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent()) {
			throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
		}
	}


	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Autowired
	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if (!user.isPresent()) {
			throw new BizException(ExceptionType.USER_NOT_FOUND);
		}
		return user.get();
	}
}
