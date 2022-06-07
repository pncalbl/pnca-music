package com.pncalbl.pncamusic.repository;

import com.pncalbl.pncamusic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pncalbl
 * @date 2022/6/7 20:49
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface UserRepository extends JpaRepository<User, String> {
	User getByUsername(String username);
}
