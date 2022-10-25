package com.pncalbl.pncamusic.service;

import com.pncalbl.pncamusic.dto.MusicDto;
import com.pncalbl.pncamusic.dto.MusicUpdateRequest;
import com.pncalbl.pncamusic.entity.Music;
import com.pncalbl.pncamusic.vo.MusicVo;

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
