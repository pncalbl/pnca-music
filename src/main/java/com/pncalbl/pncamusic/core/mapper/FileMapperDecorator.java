package com.pncalbl.pncamusic.core.mapper;

import com.pncalbl.pncamusic.core.dto.FileDto;
import com.pncalbl.pncamusic.core.entity.File;
import com.pncalbl.pncamusic.core.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;

/**
 * @author pncalbl
 * @date 2022/10/26 20:36
 * @e-mail pncalbl@qq.com
 * @description
 **/

public abstract class FileMapperDecorator implements FileMapper {
	@Autowired
	@Qualifier("delegate")
	private FileMapper delegate;

	@Autowired
	private Map<String, StorageService> storageServices;

	@Override
	public FileDto toDto(File file) {
		FileDto fileDto = delegate.toDto(file);

		if (fileDto == null) {
			return null;
		}
		if (fileDto.getStorage() == null) {
			return null;
		}

		fileDto.setUri(storageServices.get(fileDto.getStorage().name()).getFileUri(fileDto.getKey()));
		return fileDto;
	}
}
