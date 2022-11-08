package com.pncalbl.pncamusic.music.service;

import com.pncalbl.pncamusic.core.service.GeneralService;
import com.pncalbl.pncamusic.music.dto.AlbumDto;
import com.pncalbl.pncamusic.music.dto.AlbumSearchFilter;
import com.pncalbl.pncamusic.music.entity.Album;
import org.springframework.data.domain.Page;

/**
 * @author pncalbl
 * @date 2022/11/7 21:57
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface AlbumService extends GeneralService<Album, AlbumDto> {
	Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter);

	AlbumDto recommend(String id, Integer recommendFactor);

	AlbumDto cancelRecommendation(String id);
}
