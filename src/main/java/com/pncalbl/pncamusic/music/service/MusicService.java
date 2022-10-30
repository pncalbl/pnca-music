package com.pncalbl.pncamusic.music.service;

import com.pncalbl.pncamusic.core.service.GeneralService;
import com.pncalbl.pncamusic.music.dto.MusicDto;
import com.pncalbl.pncamusic.music.dto.MusicUpdateRequest;
import com.pncalbl.pncamusic.music.entity.Music;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/10/25 14:45
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface MusicService extends GeneralService<Music, MusicDto> {
	void publish(String id);

	void close(String id);

	MusicDto update(String id, MusicUpdateRequest musicUpdateRequest);

	List<MusicDto> list();
}
