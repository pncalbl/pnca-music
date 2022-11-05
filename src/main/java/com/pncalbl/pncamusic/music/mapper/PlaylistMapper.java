package com.pncalbl.pncamusic.music.mapper;

import com.pncalbl.pncamusic.core.mapper.FileMapper;
import com.pncalbl.pncamusic.core.mapper.MapperInterface;
import com.pncalbl.pncamusic.music.dto.PlaylistCreateRequest;
import com.pncalbl.pncamusic.music.dto.PlaylistDto;
import com.pncalbl.pncamusic.music.entity.Playlist;
import com.pncalbl.pncamusic.music.vo.PlaylistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author pncalbl
 * @date 2022/11/5 21:06
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Mapper(componentModel = "spring", uses = {FileMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PlaylistMapper extends MapperInterface<Playlist, PlaylistDto> {

	@Mapping(source = "coverId", target = "cover.id")
	PlaylistDto toDto(PlaylistCreateRequest playlistCreateRequest);

	PlaylistVo toVo(PlaylistDto playlistDto);
}