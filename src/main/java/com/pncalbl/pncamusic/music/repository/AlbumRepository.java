package com.pncalbl.pncamusic.music.repository;

import com.pncalbl.pncamusic.music.entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author pncalbl
 * @date 2022/11/7 21:56
 * @e-mail pncalbl@qq.com
 * @description
 **/
public interface AlbumRepository extends JpaRepository<Album, String>, JpaSpecificationExecutor<Album> {
}
