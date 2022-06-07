package com.pncalbl.pncamusic.mapper;

import com.pncalbl.pncamusic.dto.UserDto;
import com.pncalbl.pncamusic.entity.User;
import com.pncalbl.pncamusic.vo.UserVo;
import org.mapstruct.Mapper;


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
}

