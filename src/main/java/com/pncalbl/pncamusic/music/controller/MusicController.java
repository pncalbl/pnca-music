package com.pncalbl.pncamusic.music.controller;

import com.pncalbl.pncamusic.music.dto.MusicCreateRequest;
import com.pncalbl.pncamusic.music.dto.MusicSearchFilter;
import com.pncalbl.pncamusic.music.dto.MusicUpdateRequest;
import com.pncalbl.pncamusic.music.mapper.MusicMapper;
import com.pncalbl.pncamusic.music.service.MusicService;
import com.pncalbl.pncamusic.music.vo.MusicVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author pncalbl
 * @date 2022/10/25 14:34
 * @e-mail pncalbl@qq.com
 * @description
 **/

@RestController
@RequestMapping("/musics")
public class MusicController {

	private MusicService musicService;

	private MusicMapper musicMapper;


	@GetMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<MusicVo> list() {
		return musicService.list().stream().map(musicMapper::toVo).collect(Collectors.toList());
	}

	// Todo: post请求; 参数问题
	@PostMapping("/search")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Page<MusicVo> search(@RequestBody(required = false) MusicSearchFilter searchFilter) {
		return musicService.search(searchFilter).map(musicMapper::toVo);
	}


	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public MusicVo create(@Validated @RequestBody MusicCreateRequest musicCreateRequest) {
		return musicMapper.toVo(musicService.create(musicMapper.toDto(musicCreateRequest)));
	}

	@PutMapping("/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public MusicVo update(@PathVariable String id, @Validated @RequestBody MusicUpdateRequest musicUpdateRequest) {
		return musicMapper.toVo(musicService.update(id, musicUpdateRequest));
	}

	@PostMapping("/{id}/publish")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void publish(@PathVariable String id) {
		musicService.publish(id);
	}

	@PostMapping("/{id}/close")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void close(@PathVariable String id) {
		musicService.close(id);
	}

	@Autowired
	public void setMusicService(MusicService musicService) {
		this.musicService = musicService;
	}

	@Autowired
	public void setMusicMapper(MusicMapper musicMapper) {
		this.musicMapper = musicMapper;
	}
}
