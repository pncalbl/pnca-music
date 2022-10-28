package com.pncalbl.pncamusic.mapper;

import com.pncalbl.pncamusic.dto.FileDto;
import com.pncalbl.pncamusic.dto.FileUploadRequest;
import com.pncalbl.pncamusic.entity.File;
import com.pncalbl.pncamusic.vo.FileVo;
import org.mapstruct.Mapper;

/**
 * @author pncalbl
 * @date 2022/10/26 20:34
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Mapper(componentModel = "spring")
public interface FileMapper {
	File createEntity(FileUploadRequest fileUploadRequest);

	FileVo toVo(FileDto fileDto);

	FileDto toDto(File file);

	File toEntity(FileDto fileDto);
}
