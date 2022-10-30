package com.pncalbl.pncamusic.core.mapper;

import com.pncalbl.pncamusic.core.dto.UserCreateRequest;
import com.pncalbl.pncamusic.core.dto.UserDto;
import com.pncalbl.pncamusic.core.dto.UserUpdateRequest;
import com.pncalbl.pncamusic.core.entity.User;
import com.pncalbl.pncamusic.core.vo.UserVo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


/**
 * @author pncalbl
 * @date 2022/6/7 21:59
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserDto toDto(User user);

	UserVo toVo(UserDto userDto);

	User createEntity(UserCreateRequest userCreateRequest);

	User updateEntity(@MappingTarget User user, UserUpdateRequest userUpdateRequest);
}

