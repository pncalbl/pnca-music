package com.pncalbl.pncamusic.service;

import com.pncalbl.pncamusic.dto.FileUploadDto;

import java.io.IOException;

/**
 * @author pncalbl
 * @date 2022/10/26 21:16
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface StorageService {
	FileUploadDto initFileUpload() throws IOException;
}
