package com.pncalbl.pncamusic.core.repository;

import com.pncalbl.pncamusic.core.entity.User;
import com.pncalbl.pncamusic.music.entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author pncalbl
 * @date 2022/6/7 20:49
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	User getByUsername(String username);

	Optional<User> findByUsername(String username);

	User getById(String id);
}
