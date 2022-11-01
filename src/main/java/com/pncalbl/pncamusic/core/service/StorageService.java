package com.pncalbl.pncamusic.core.service;

import com.pncalbl.pncamusic.core.dto.FileUploadDto;

import java.io.IOException;

/**
 * @author pncalbl
 * @date 2022/10/26 21:16
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface StorageService {
	FileUploadDto initFileUpload() throws IOException;

	String getFileUri(String fileKey);
}
