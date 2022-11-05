package com.pncalbl.pncamusic.music.service;

import com.pncalbl.pncamusic.core.service.GeneralService;
import com.pncalbl.pncamusic.music.dto.ArtistDto;
import com.pncalbl.pncamusic.music.dto.ArtistSearchFilter;
import com.pncalbl.pncamusic.music.entity.Artist;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author pncalbl
 * @date 2022/11/1 21:52
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface ArtistService extends GeneralService<Artist, ArtistDto> {
	List<ArtistDto> list();

	Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter);

	ArtistDto recommend(String id, Integer recommendFactor);

	ArtistDto cancelRecommendation(String id);
}
