package com.pncalbl.pncamusic.music.repository;

import com.pncalbl.pncamusic.music.entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author pncalbl
 * @date 2022/11/1 21:50
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface PlaylistRepository extends JpaRepository<Playlist, String>, JpaSpecificationExecutor<Playlist> {

}
