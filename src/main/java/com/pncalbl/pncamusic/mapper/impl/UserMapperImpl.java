package com.pncalbl.pncamusic.mapper.impl;

import com.pncalbl.pncamusic.dto.RoleDto;
import com.pncalbl.pncamusic.dto.UserDto;
import com.pncalbl.pncamusic.entity.Role;
import com.pncalbl.pncamusic.entity.User;
import com.pncalbl.pncamusic.mapper.UserMapper;
import com.pncalbl.pncamusic.vo.RoleVo;
import com.pncalbl.pncamusic.vo.UserVo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/6/8 1:00
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Component
public class UserMapperImpl implements UserMapper {

	@Override
	public UserDto toDto(User user) {
		if (user == null) {
			return null;
		}

		UserDto userDto = new UserDto();

		userDto.setId(user.getId());
		userDto.setUsername(user.getUsername());
		userDto.setNickname(user.getNickname());
		userDto.setRoles(roleListToRoleDtoList(user.getRoles()));

		return userDto;
	}

	@Override
	public UserVo toVo(UserDto userDto) {
		if (userDto == null) {
			return null;
		}

		UserVo userVo = new UserVo();

		userVo.setId(userDto.getId());
		userVo.setUsername(userDto.getUsername());
		userVo.setNickname(userDto.getNickname());

		userVo.setRoles(roleDtoListToRoleVoList(userDto.getRoles()));

		return userVo;
	}

	protected RoleDto roleToRoleDto(Role role) {
		if (role == null) {
			return null;
		}

		RoleDto roleDto = new RoleDto();

		roleDto.setId(role.getId());
		roleDto.setName(role.getName());
		roleDto.setTitle(role.getTitle());

		return roleDto;
	}

	protected List<RoleDto> roleListToRoleDtoList(List<Role> list) {
		if (list == null) {
			return null;
		}

		List<RoleDto> list1 = new ArrayList<RoleDto>(list.size());
		for (Role role : list) {
			list1.add(roleToRoleDto(role));
		}

		return list1;
	}

	protected RoleVo roleDtoToRoleVo(RoleDto roleDto) {
		if (roleDto == null) {
			return null;
		}

		RoleVo roleVo = new RoleVo();

		roleVo.setId(roleDto.getId());
		roleVo.setName(roleDto.getName());
		roleVo.setTitle(roleDto.getTitle());

		return roleVo;
	}

	protected List<RoleVo> roleDtoListToRoleVoList(List<RoleDto> list) {
		if (list == null) {
			return null;
		}

		List<RoleVo> list1 = new ArrayList<RoleVo>(list.size());
		for (RoleDto roleDto : list) {
			list1.add(roleDtoToRoleVo(roleDto));
		}

		return list1;
	}
}
