package com.pncalbl.pncamusic.core.mapper;

import com.pncalbl.pncamusic.core.dto.FileUploadDto;
import com.pncalbl.pncamusic.core.vo.FileUploadVo;
import org.mapstruct.Mapper;

/**
 * @author pncalbl
 * @date 2022/10/26 21:04
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Mapper(componentModel = "spring")
public interface FileUploadMapper {
	FileUploadVo toVo(FileUploadDto fileUploadDto);
}
