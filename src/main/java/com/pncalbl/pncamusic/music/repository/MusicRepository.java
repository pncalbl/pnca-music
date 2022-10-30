package com.pncalbl.pncamusic.music.repository;

import com.pncalbl.pncamusic.music.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author pncalbl
 * @date 2022/10/25 15:03
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface MusicRepository extends JpaRepository<Music, String>, JpaSpecificationExecutor<Music> {
	Optional<Music> findById(String id);
}
