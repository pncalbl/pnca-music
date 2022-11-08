package com.pncalbl.pncamusic.music.service.impl;

import com.pncalbl.pncamusic.core.enums.ExceptionType;
import com.pncalbl.pncamusic.core.mapper.MapperInterface;
import com.pncalbl.pncamusic.core.repository.specs.SearchCriteria;
import com.pncalbl.pncamusic.core.repository.specs.SearchOperation;
import com.pncalbl.pncamusic.core.service.impl.TraceableGeneralServiceImpl;
import com.pncalbl.pncamusic.music.dto.AlbumDto;
import com.pncalbl.pncamusic.music.dto.AlbumSearchFilter;
import com.pncalbl.pncamusic.music.entity.Album;
import com.pncalbl.pncamusic.music.mapper.AlbumMapper;
import com.pncalbl.pncamusic.music.repository.AlbumRepository;
import com.pncalbl.pncamusic.music.repository.specs.AlbumSpecification;
import com.pncalbl.pncamusic.music.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * @author pncalbl
 * @date 2022/11/7 21:56
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Service
public class AlbumServiceImpl extends TraceableGeneralServiceImpl<Album, AlbumDto> implements AlbumService {

	private AlbumRepository repository;

	private AlbumMapper mapper;

	@Override
	public JpaRepository<Album, String> getRepository() {
		return repository;
	}

	@Override
	public MapperInterface<Album, AlbumDto> getMapper() {
		return mapper;
	}

	@Override
	public ExceptionType getNotFoundExceptionType() {
		return ExceptionType.ALBUM_NOT_FOUND;
	}

	@Override
	public Page<AlbumDto> search(AlbumSearchFilter albumSearchFilter) {
		AlbumSpecification specs = new AlbumSpecification();
		specs.add(new SearchCriteria("name", albumSearchFilter.getName(), SearchOperation.MATCH));
		if (albumSearchFilter.getRecommended() != null) {
			specs.add(new SearchCriteria("recommended", albumSearchFilter.getRecommended(), SearchOperation.EQUAL));
		}
		return repository.findAll(specs, albumSearchFilter.toPageable()).map(mapper::toDto);
	}

	@Override
	public AlbumDto recommend(String id, Integer recommendFactor) {
		Album album = getEntity(id);
		album.setRecommended(true);
		album.setRecommendFactor(recommendFactor);
		return mapper.toDto(repository.save(album));
	}

	@Override
	public AlbumDto cancelRecommendation(String id) {
		Album album = getEntity(id);
		album.setRecommended(false);
		album.setRecommendFactor(0);
		return mapper.toDto(repository.save(album));
	}

	@Autowired
	public void setRepository(AlbumRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public void setMapper(AlbumMapper mapper) {
		this.mapper = mapper;
	}
}
