package com.pncalbl.pncamusic.core.service.impl;

import com.pncalbl.pncamusic.core.dto.FileDto;
import com.pncalbl.pncamusic.core.dto.FileUploadDto;
import com.pncalbl.pncamusic.core.dto.FileUploadRequest;
import com.pncalbl.pncamusic.core.entity.File;
import com.pncalbl.pncamusic.core.enums.FileStatus;
import com.pncalbl.pncamusic.core.enums.Storage;
import com.pncalbl.pncamusic.core.exception.BizException;
import com.pncalbl.pncamusic.core.enums.ExceptionType;
import com.pncalbl.pncamusic.core.mapper.FileMapper;
import com.pncalbl.pncamusic.core.repository.FileRepository;
import com.pncalbl.pncamusic.core.service.FileService;
import com.pncalbl.pncamusic.core.service.StorageService;
import com.pncalbl.pncamusic.core.utils.FileTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author pncalbl
 * @date 2022/10/26 20:30
 * @e-mail pncalbl@qq.com
 * @description
 **/

@Service
public class FileServiceImpl extends BaseService implements FileService {

	private Map<String, StorageService> storageServices;

	private FileRepository repository;

	private FileMapper mapper;


	@Override
	@Transactional
	public FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException {
		// 创建 File 实体
		File file = mapper.createEntity(fileUploadRequest);
		file.setType(FileTypeTransformer.getFileTypeFromExt(fileUploadRequest.getExt()));
		file.setStorage(getDefaultStorage());
		file.setCreatedBy(getCurrentUserEntity());
		file.setUpdatedBy(getCurrentUserEntity());
		File saveFile = repository.save(file);
		// 通过接口获取 STS 令牌
		FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();
		fileUploadDto.setKey(saveFile.getKey());
		fileUploadDto.setFileId(saveFile.getId());
		return fileUploadDto;
	}

	@Override
	public FileDto finishUpload(String id) {
		File file = getFileEntity(id);
		// Todo: 是否是SUPER_ADMIN
		if (!Objects.equals(file.getCreatedBy().getId(), getCurrentUserEntity().getId())) {
			throw new BizException(ExceptionType.FILE_NOT_PERMISSION);
		}

		// Todo: 验证远程文件是否存在

		file.setFileStatus(FileStatus.UPLOADED);
		return mapper.toDto(repository.save(file));
	}

	@Override
	public Storage getDefaultStorage() {
		return Storage.COS;
	}

	@Override
	public File getFileEntity(String id) {
		Optional<File> fileOptional = repository.findById(id);
		if (!fileOptional.isPresent()) {
			throw new BizException(ExceptionType.FILE_NOT_FOUND);
		}
		return fileOptional.get();
	}


	@Autowired
	public void setStorageServices(Map<String, StorageService> storageServices) {
		this.storageServices = storageServices;
	}

	@Autowired
	public void setRepository(FileRepository repository) {
		this.repository = repository;
	}

	@Autowired
	public void setMapper(FileMapper mapper) {
		this.mapper = mapper;
	}
}
