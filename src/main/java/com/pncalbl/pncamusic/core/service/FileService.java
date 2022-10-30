package com.pncalbl.pncamusic.core.service;

import com.pncalbl.pncamusic.core.dto.FileDto;
import com.pncalbl.pncamusic.core.dto.FileUploadDto;
import com.pncalbl.pncamusic.core.dto.FileUploadRequest;
import com.pncalbl.pncamusic.core.entity.File;
import com.pncalbl.pncamusic.core.enums.Storage;

import java.io.IOException;

/**
 * @author pncalbl
 * @date 2022/10/26 20:30
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface FileService {

	FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;

	FileDto finishUpload(String id);

	Storage getDefaultStorage();

	File getFileEntity(String id);
}
