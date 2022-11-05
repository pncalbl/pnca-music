package com.pncalbl.pncamusic.music.service;

import com.pncalbl.pncamusic.core.service.GeneralService;
import com.pncalbl.pncamusic.music.dto.PlaylistDto;
import com.pncalbl.pncamusic.music.dto.PlaylistSearchFilter;
import com.pncalbl.pncamusic.music.entity.Playlist;
import org.springframework.data.domain.Page;

/**
 * @author pncalbl
 * @date 2022/11/1 21:53
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface PlaylistService extends GeneralService<Playlist, PlaylistDto> {
	Page<PlaylistDto> search(PlaylistSearchFilter playlistSearchFilter);

	PlaylistDto recommend(String id, Integer recommendFactor);

	PlaylistDto cancelRecommendation(String id);

	PlaylistDto makeSpecial(String id);

	PlaylistDto cancelSpecial(String id);
}
