package com.pncalbl.pncamusic.music.mapper;

import com.pncalbl.pncamusic.core.mapper.FileMapper;
import com.pncalbl.pncamusic.core.mapper.MapperInterface;
import com.pncalbl.pncamusic.music.dto.AlbumCreateRequest;
import com.pncalbl.pncamusic.music.dto.AlbumDto;
import com.pncalbl.pncamusic.music.dto.AlbumUpdateRequest;
import com.pncalbl.pncamusic.music.entity.Album;
import com.pncalbl.pncamusic.music.vo.AlbumVo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

/**
 * @author pncalbl
 * @date 2022/11/7 21:56
 * @e-mail pncalbl@qq.com
 * @description
 **/
@Mapper(componentModel = "spring",
		uses = {FileMapper.class, ArtistMapper.class, MusicMapper.class},
		nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
		nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface AlbumMapper extends MapperInterface<Album, AlbumDto> {
	@Mapping(source = "coverId", target = "cover.id")
	// @Mapping(source = "artistIds", target = "artists")
	AlbumDto toDto(AlbumCreateRequest albumCreateRequest);

	@Mapping(source = "coverId", target = "cover.id")
	// @Mapping(source = "artistIds", target = "artists")
	AlbumDto toDto(AlbumUpdateRequest albumUpdateRequest);


	AlbumVo toVo(AlbumDto albumDto);
}
