package com.pncalbl.pncamusic.mapper;

import com.pncalbl.pncamusic.dto.UserCreateRequest;
import com.pncalbl.pncamusic.dto.UserDto;
import com.pncalbl.pncamusic.dto.UserUpdateRequest;
import com.pncalbl.pncamusic.entity.User;
import com.pncalbl.pncamusic.vo.UserVo;
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

