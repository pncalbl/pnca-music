package com.pncalbl.pncamusic.service.impl;

import com.pncalbl.pncamusic.dto.MusicDto;
import com.pncalbl.pncamusic.dto.MusicUpdateRequest;
import com.pncalbl.pncamusic.entity.Music;
import com.pncalbl.pncamusic.enums.MusicStatus;
import com.pncalbl.pncamusic.exception.ExceptionType;
import com.pncalbl.pncamusic.mapper.MapperInterface;
import com.pncalbl.pncamusic.mapper.MusicMapper;
import com.pncalbl.pncamusic.repository.MusicRepository;
import com.pncalbl.pncamusic.service.MusicService;
import com.pncalbl.pncamusic.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pncalbl
 * @date 2022/10/25 14:55
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Service
public class MusicServiceImpl extends GeneralServiceImpl<Music, MusicDto> implements MusicService {

	private MusicRepository repository;

	private MusicMapper mapper;

	@Override
	public void publish(String id) {
		Music music = getEntity(id);
		music.setStatus(MusicStatus.PUBLISHED);
		repository.save(music);
	}


	@Override
	public void close(String id) {
		Music music = getEntity(id);
		music.setStatus(MusicStatus.CLOSED);
		repository.save(music);
	}

	@Override
	public MusicDto update(String id, MusicUpdateRequest musicUpdateRequest) {
		Music oldEntity = getEntity(id);
		Music music = mapper.updateEntity(oldEntity, musicUpdateRequest);
		return getMapper().toDto(getRepository().save(music));
	}

	@Override
	public List<MusicDto> list() {
		return repository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
	}

	@Autowired
	public void setRepository(MusicRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public void setMapper(MusicMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public JpaRepository<Music, String> getRepository() {
		return repository;
	}

	@Override
	public MapperInterface<Music, MusicDto> getMapper() {
		return mapper;
	}

	@Override
	public ExceptionType getNotFoundExceptionType() {
		return ExceptionType.MUSIC_NOT_FOUND;
	}
}
