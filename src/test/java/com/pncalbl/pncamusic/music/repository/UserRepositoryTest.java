package com.pncalbl.pncamusic.music.repository;

import com.pncalbl.pncamusic.core.entity.User;
import com.pncalbl.pncamusic.core.enums.Gender;
import com.pncalbl.pncamusic.core.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author pncalbl
 * @date 2022/6/7 20:57
 * @e-mail pncalbl@qq.com
 * @description
 **/

@SpringBootTest
public class UserRepositoryTest {

	@Autowired
	UserRepository repository;

	@Test
	void getByUsername() {
		User user = new User();
		user.setUsername("pncalbl");
		user.setNickname("programmer-pncalbl");
		user.setEnabled(true);
		user.setLocked(false);
		user.setPassword("$2a$10$t/9Fu1/5zDt/0XUbxoFYP.bzaLNOz5Apr8J6QIFDh9IDsaKSGB7xa");
		user.setGender(Gender.MALE);
		user.setLastLoginIp("127.0.0.1");
		user.setLastLoginTime(new Date());

		User save = repository.save(user);
		User pncalbl = repository.getByUsername("pncalbl");
		System.out.println(pncalbl.getId());
	}
}
