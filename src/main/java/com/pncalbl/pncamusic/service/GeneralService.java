package com.pncalbl.pncamusic.service;

import com.pncalbl.pncamusic.dto.BaseDto;
import com.pncalbl.pncamusic.entity.BaseEntity;
import com.pncalbl.pncamusic.exception.ExceptionType;
import com.pncalbl.pncamusic.mapper.MapperInterface;
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

	// Dto update(String id, Dto dto);

	void delete(String id);
}
