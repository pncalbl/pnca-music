package com.pncalbl.pncamusic.service.impl;

import com.pncalbl.pncamusic.entity.User;
import com.pncalbl.pncamusic.exception.BizException;
import com.pncalbl.pncamusic.exception.ExceptionType;
import com.pncalbl.pncamusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

/**
 * @author pncalbl
 * @date 2022/10/25 16:01
 * @e-mail pncalbl@qq.com
 * @description
 **/

public abstract class BaseService {
	protected UserRepository userRepository;

	protected User getCurrentUserEntity() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		// todo
		return loadUserByUsername(authentication.getName());
	}

	protected User loadUserByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		if (!user.isPresent()) {
			throw new BizException(ExceptionType.USER_NOT_FOUND);
		}
		return user.get();
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
}
