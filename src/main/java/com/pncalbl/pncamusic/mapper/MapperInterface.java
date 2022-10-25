package com.pncalbl.pncamusic.mapper;

import com.pncalbl.pncamusic.dto.BaseDto;
import com.pncalbl.pncamusic.entity.BaseEntity;
import org.mapstruct.MappingTarget;

/**
 * @author pncalbl
 * @date 2022/10/25 15:52
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface MapperInterface<Entity extends BaseEntity, Dto extends BaseDto> {
	Dto toDto(Entity entity);

	Entity toEntity(Dto dto);

	// Entity updateEntity(@MappingTarget Entity entity, Dto dto);
}
