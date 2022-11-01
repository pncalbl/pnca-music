package com.pncalbl.pncamusic.music.mapper;

import com.pncalbl.pncamusic.core.mapper.FileMapper;
import com.pncalbl.pncamusic.core.mapper.MapperInterface;
import com.pncalbl.pncamusic.music.dto.ArtistCreateRequest;
import com.pncalbl.pncamusic.music.dto.ArtistDto;
import com.pncalbl.pncamusic.music.dto.ArtistUpdateRequest;
import com.pncalbl.pncamusic.music.entity.Artist;
import com.pncalbl.pncamusic.music.vo.ArtistVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author pncalbl
 * @date 2022/11/1 21:59
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Mapper(componentModel = "spring", uses = {FileMapper.class, MusicMapper.class}, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ArtistMapper extends MapperInterface<Artist, ArtistDto> {
	@Mapping(source = "photoId", target = "photo.id")
	ArtistDto toDto(ArtistCreateRequest artistCreateRequest);

	ArtistDto toDto(ArtistUpdateRequest artistUpdateRequest);

	ArtistVo toVo(ArtistDto artistDto);
}
