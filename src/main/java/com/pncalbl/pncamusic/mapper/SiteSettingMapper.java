package com.pncalbl.pncamusic.mapper;

import com.pncalbl.pncamusic.dto.SiteSettingDto;
import com.pncalbl.pncamusic.vo.SiteSettingVo;
import org.mapstruct.Mapper;

/**
 * @author pncalbl
 * @date 2022/10/28 21:37
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Mapper(componentModel = "spring")
public interface SiteSettingMapper {
	SiteSettingVo toVo(SiteSettingDto siteSettingDto);
}
