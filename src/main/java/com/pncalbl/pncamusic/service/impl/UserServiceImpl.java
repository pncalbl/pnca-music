package com.pncalbl.pncamusic.service.impl;

import com.pncalbl.pncamusic.dto.UserCreateRequest;
import com.pncalbl.pncamusic.dto.UserDto;
import com.pncalbl.pncamusic.dto.UserUpdateRequest;
import com.pncalbl.pncamusic.entity.User;
import com.pncalbl.pncamusic.exception.BizException;
import com.pncalbl.pncamusic.exception.ExceptionType;
import com.pncalbl.pncamusic.mapper.UserMapper;
import com.pncalbl.pncamusic.repository.UserRepository;
import com.pncalbl.pncamusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
	public UserDto create(UserCreateRequest userCreateRequest) {
		checkUsername(userCreateRequest.getUsername());
		User user = userMapper.createEntity(userCreateRequest);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userMapper.toDto(userRepository.save(user));
	}

	@Override
	public UserDto get(String id) {
		return userMapper.toDto(userRepository.getById(id));
	}

	@Override
	public UserDto update(String id, UserUpdateRequest userUpdateRequest) {
		return userMapper.toDto(userRepository.save(userMapper.updateEntity(getById(id), userUpdateRequest)));
	}

	private User getById(String id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new BizException(ExceptionType.USER_NOT_FOUND);
		}
		return user.get();
	}

	@Override
	public void delete(String id) {
		userRepository.deleteById(id);
	}

	@Override
	public Page<UserDto> search(Pageable pageable) {
		return userRepository.findAll(pageable).map(userMapper::toDto);
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
