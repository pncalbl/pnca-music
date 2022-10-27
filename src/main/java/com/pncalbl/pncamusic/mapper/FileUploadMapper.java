package com.pncalbl.pncamusic.mapper;

import com.pncalbl.pncamusic.dto.FileUploadDto;
import com.pncalbl.pncamusic.vo.FileUploadVo;
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
