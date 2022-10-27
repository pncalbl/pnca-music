package com.pncalbl.pncamusic.service.impl;

import com.pncalbl.pncamusic.dto.FileUploadDto;
import com.pncalbl.pncamusic.dto.FileUploadRequest;
import com.pncalbl.pncamusic.entity.File;
import com.pncalbl.pncamusic.enums.Storage;
import com.pncalbl.pncamusic.mapper.FileMapper;
import com.pncalbl.pncamusic.repository.FileRepository;
import com.pncalbl.pncamusic.service.FileService;
import com.pncalbl.pncamusic.service.StorageService;
import com.pncalbl.pncamusic.utils.FileTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Map;

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
		FileUploadDto fileUploadDto = storageServices.get(getDefaultStorage().name()).initFileUpload();

		fileUploadDto.setKey(saveFile.getKey());
		fileUploadDto.setFileId(saveFile.getId());
		return fileUploadDto;
	}

	private Storage getDefaultStorage() {
		return Storage.COS;
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
