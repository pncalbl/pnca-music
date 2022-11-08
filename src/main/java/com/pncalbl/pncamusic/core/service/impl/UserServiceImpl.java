package com.pncalbl.pncamusic.core.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pncalbl.pncamusic.core.config.SecurityConfig;
import com.pncalbl.pncamusic.core.dto.*;
import com.pncalbl.pncamusic.core.entity.User;
import com.pncalbl.pncamusic.core.exception.BizException;
import com.pncalbl.pncamusic.core.enums.ExceptionType;
import com.pncalbl.pncamusic.core.mapper.UserMapper;
import com.pncalbl.pncamusic.core.repository.UserRepository;
import com.pncalbl.pncamusic.core.repository.specs.SearchCriteria;
import com.pncalbl.pncamusic.core.repository.specs.SearchOperation;
import com.pncalbl.pncamusic.core.repository.specs.UserSpecification;
import com.pncalbl.pncamusic.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;
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
	public Page<UserDto> search(UserSearchFilter userSearchFilter) {
		UserSpecification specs = new UserSpecification();
		specs.add(new SearchCriteria("nickname", userSearchFilter.getNickname(), SearchOperation.MATCH));
		return userRepository.findAll(specs, userSearchFilter.toPageable()).map(userMapper::toDto);
	}

	@Override
	public String createToken(TokenCreateRequest tokenCreateRequest) {
		User user = loadUserByUsername(tokenCreateRequest.getUsername());
		if (!passwordEncoder.matches(tokenCreateRequest.getPassword(), user.getPassword())) {
			throw new BizException(ExceptionType.USER_PASSWORD_NOT_MATCH);
		}
		if (!user.isEnabled()) {
			throw new BizException(ExceptionType.USER_NOT_ENABLED);
		}

		if (!user.isAccountNonLocked()) {
			throw new BizException(ExceptionType.USER_LOCKED);
		}
		String token = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(SecurityConfig.SECRET.getBytes(StandardCharsets.UTF_8)));

		return SecurityConfig.TOKEN_PREFIX + token;
	}

	@Override
	public UserDto getCurrentUser() {
		return userMapper.toDto(getCurrentUserEntity());
	}

	private User getCurrentUserEntity() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		// todo
		return loadUserByUsername(authentication.getName());
	}

	@Override
	public User loadUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (!user.isPresent()) {
			throw new BizException(ExceptionType.USER_NOT_FOUND);
		}
		return user.get();
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
}
