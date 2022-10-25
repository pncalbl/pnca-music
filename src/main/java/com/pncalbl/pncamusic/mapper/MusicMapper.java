package com.pncalbl.pncamusic.mapper;

import com.pncalbl.pncamusic.dto.MusicCreateRequest;
import com.pncalbl.pncamusic.dto.MusicDto;
import com.pncalbl.pncamusic.dto.MusicUpdateRequest;
import com.pncalbl.pncamusic.entity.Music;
import com.pncalbl.pncamusic.vo.MusicVo;
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
