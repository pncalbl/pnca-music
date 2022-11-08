package com.pncalbl.pncamusic.music.controller;

import com.pncalbl.pncamusic.music.dto.AlbumCreateRequest;
import com.pncalbl.pncamusic.music.dto.AlbumSearchFilter;
import com.pncalbl.pncamusic.music.dto.AlbumUpdateRequest;
import com.pncalbl.pncamusic.music.dto.RecommendRequest;
import com.pncalbl.pncamusic.music.mapper.AlbumMapper;
import com.pncalbl.pncamusic.music.service.AlbumService;
import com.pncalbl.pncamusic.music.vo.AlbumVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author pncalbl
 * @date 2022/11/7 21:55
 * @e-mail pncalbl@qq.com
 * @description
 **/

@RestController
@RequestMapping("/albums")
public class AlbumController {
	private AlbumService albumService;

	private AlbumMapper albumMapper;

	@PostMapping
	public AlbumVo create(@Validated @RequestBody AlbumCreateRequest albumCreateRequest) {
		return albumMapper.toVo(albumService.create(albumMapper.toDto(albumCreateRequest)));
	}

	@PostMapping("/{id}")
	public AlbumVo update(@PathVariable String id, @Validated @RequestBody AlbumUpdateRequest albumUpdateRequest) {
		return albumMapper.toVo(albumService.update(id, albumMapper.toDto(albumUpdateRequest)));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable String id) {
		albumService.delete(id);
	}

	@GetMapping
	public Page<AlbumVo> search(@Validated AlbumSearchFilter albumSearchFilter) {
		return albumService.search(albumSearchFilter).map(albumMapper::toVo);
	}

	@PostMapping("/{id}/recommend")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public AlbumVo recommend(@PathVariable String id, @Validated @RequestBody RecommendRequest recommendRequest) {
		return albumMapper.toVo(albumService.recommend(id, recommendRequest.getRecommendFactor()));
	}

	@PostMapping("/{id}/cancel_recommendation")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public AlbumVo cancelRecommendation(@PathVariable String id) {
		return albumMapper.toVo(albumService.cancelRecommendation(id));
	}

	@Autowired
	public void setAlbumMapper(AlbumMapper albumMapper) {
		this.albumMapper = albumMapper;
	}

	@Autowired
	public void setAlbumService(AlbumService albumService) {
		this.albumService = albumService;
	}

}
