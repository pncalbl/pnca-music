package com.pncalbl.pncamusic.service.impl;

import com.pncalbl.pncamusic.dto.BaseDto;
import com.pncalbl.pncamusic.entity.BaseEntity;
import com.pncalbl.pncamusic.exception.BizException;
import com.pncalbl.pncamusic.service.GeneralService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author pncalbl
 * @date 2022/10/25 15:59
 * @e-mail pncalbl@qq.com
 * @description
 **/

public abstract class GeneralServiceImpl<Entity extends BaseEntity, Dto extends BaseDto> extends BaseService implements GeneralService<Entity, Dto> {

	@Override
	public Dto create(Dto dto) {
		Entity entity = getMapper().toEntity(dto);
		return getMapper().toDto(getRepository().save(entity));
	}

	@Override
	public Dto get(String id) {
		return getMapper().toDto(getEntity(id));
	}


	protected Entity getEntity(String id) {
		Optional<Entity> optionalEntity = getRepository().findById(id);
		if (!optionalEntity.isPresent()) {
			throw new BizException(getNotFoundExceptionType());
		}
		return optionalEntity.get();
	}

	// @Override
	// @Transactional
	// public Dto update(String id, Dto dto) {
	// 	// Todo: dto 可能无法控制更新字段
	// 	Entity existedEntity = getEntity(id);
	// 	Entity updatedEntity = getRepository().save(getMapper().updateEntity(existedEntity, dto));
	// 	return getMapper().toDto(updatedEntity);
	// }

	@Override
	public void delete(String id) {
		Entity existedEntity = getEntity(id);
		getRepository().delete(existedEntity);
	}
}
