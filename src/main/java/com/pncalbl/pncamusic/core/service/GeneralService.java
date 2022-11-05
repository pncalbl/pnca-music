package com.pncalbl.pncamusic.core.service;

import com.pncalbl.pncamusic.core.dto.BaseDto;
import com.pncalbl.pncamusic.core.entity.BaseEntity;
import com.pncalbl.pncamusic.core.enums.ExceptionType;
import com.pncalbl.pncamusic.core.mapper.MapperInterface;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pncalbl
 * @date 2022/10/25 15:55
 * @e-mail pncalbl@qq.com
 * @description
 **/
public interface GeneralService<Entity extends BaseEntity, Dto extends BaseDto> {
	JpaRepository<Entity, String> getRepository();

	MapperInterface<Entity, Dto> getMapper();

	ExceptionType getNotFoundExceptionType();

	Dto create(Dto dto);

	Dto get(String id);

	Dto update(String id, Dto dto);

	void delete(String id);
}
