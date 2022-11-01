package com.pncalbl.pncamusic.music.repository;

import com.pncalbl.pncamusic.music.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

/**
 * @author pncalbl
 * @date 2022/11/1 21:49
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface ArtistRepository extends JpaRepository<Artist, String>, JpaSpecificationExecutor<Artist> {
	Optional<Artist> findById(String id);
}
