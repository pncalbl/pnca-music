package com.pncalbl.pncamusic.core.mapper;

import com.pncalbl.pncamusic.core.dto.FileDto;
import com.pncalbl.pncamusic.core.dto.FileUploadRequest;
import com.pncalbl.pncamusic.core.entity.File;
import com.pncalbl.pncamusic.core.vo.FileVo;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

/**
 * @author pncalbl
 * @date 2022/10/26 20:34
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Mapper(componentModel = "spring")
@DecoratedWith(FileMapperDecorator.class)
public interface FileMapper {
	File createEntity(FileUploadRequest fileUploadRequest);

	FileVo toVo(FileDto fileDto);

	FileDto toDto(File file);

	File toEntity(FileDto fileDto);
}
