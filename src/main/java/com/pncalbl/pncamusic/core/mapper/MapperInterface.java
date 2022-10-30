package com.pncalbl.pncamusic.core.mapper;

import com.pncalbl.pncamusic.core.dto.BaseDto;
import com.pncalbl.pncamusic.core.entity.BaseEntity;

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
