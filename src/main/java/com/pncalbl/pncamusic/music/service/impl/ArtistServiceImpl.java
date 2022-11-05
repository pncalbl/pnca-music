package com.pncalbl.pncamusic.music.service.impl;

import com.pncalbl.pncamusic.core.enums.ExceptionType;
import com.pncalbl.pncamusic.core.mapper.MapperInterface;
import com.pncalbl.pncamusic.core.repository.specs.SearchCriteria;
import com.pncalbl.pncamusic.core.repository.specs.SearchOperation;
import com.pncalbl.pncamusic.core.service.impl.TraceableGeneralServiceImpl;
import com.pncalbl.pncamusic.music.dto.ArtistDto;
import com.pncalbl.pncamusic.music.dto.ArtistSearchFilter;
import com.pncalbl.pncamusic.music.entity.Artist;
import com.pncalbl.pncamusic.music.mapper.ArtistMapper;
import com.pncalbl.pncamusic.music.repository.ArtistRepository;
import com.pncalbl.pncamusic.music.repository.specs.ArtistSpecification;
import com.pncalbl.pncamusic.music.service.ArtistService;
import com.sun.jndi.toolkit.dir.SearchFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pncalbl
 * @date 2022/11/1 21:53
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Service
@Slf4j
public class ArtistServiceImpl extends TraceableGeneralServiceImpl<Artist, ArtistDto> implements ArtistService {
	private ArtistMapper mapper;

	private ArtistRepository repository;


	@Autowired
	public void setMapper(ArtistMapper mapper) {
		this.mapper = mapper;
	}

	@Autowired
	public void setRepository(ArtistRepository repository) {
		this.repository = repository;
	}

	@Override
	public JpaRepository<Artist, String> getRepository() {
		return repository;
	}

	@Override
	public MapperInterface<Artist, ArtistDto> getMapper() {
		return mapper;
	}

	@Override
	public ExceptionType getNotFoundExceptionType() {
		return ExceptionType.ARTIST_NOT_FOUND;
	}

	@Override
	public List<ArtistDto> list() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@Override
	public Page<ArtistDto> search(ArtistSearchFilter artistSearchFilter) {
		ArtistSpecification specs = new ArtistSpecification();
		specs.add(new SearchCriteria("name", artistSearchFilter.getName(), SearchOperation.MATCH));
		if (artistSearchFilter.getRecommended() != null) {
			specs.add(new SearchCriteria("recommended", artistSearchFilter.getRecommended(), SearchOperation.EQUAL));
		}
		return repository.findAll(specs, artistSearchFilter.toPageable()).map(mapper::toDto);
	}

	@Override
	public ArtistDto recommend(String id, Integer recommendFactor) {
		Artist artist = getEntity(id);
		artist.setRecommended(true);
		artist.setRecommendFactor(recommendFactor);
		return mapper.toDto(repository.save(artist));
	}

	@Override
	public ArtistDto cancelRecommendation(String id) {
		Artist artist = getEntity(id);
		artist.setRecommended(false);
		artist.setRecommendFactor(0);
		return mapper.toDto(repository.save(artist));
	}
}
