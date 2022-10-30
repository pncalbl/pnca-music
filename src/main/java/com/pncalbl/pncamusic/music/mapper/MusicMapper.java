package com.pncalbl.pncamusic.music.mapper;

import com.pncalbl.pncamusic.core.mapper.MapperInterface;
import com.pncalbl.pncamusic.music.dto.MusicCreateRequest;
import com.pncalbl.pncamusic.music.dto.MusicDto;
import com.pncalbl.pncamusic.music.dto.MusicUpdateRequest;
import com.pncalbl.pncamusic.music.entity.Music;
import com.pncalbl.pncamusic.music.vo.MusicVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/**
 * @author pncalbl
 * @date 2022/10/25 14:46
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Mapper(componentModel = "spring")
public interface MusicMapper extends MapperInterface<Music, MusicDto> {

	MusicDto toDto(MusicCreateRequest musicCreateRequest);

	MusicDto toDto(MusicUpdateRequest musicUpdateRequest);

	MusicVo toVo(MusicDto musicDto);

	Music updateEntity(@MappingTarget Music music, MusicUpdateRequest musicUpdateRequest);
}
