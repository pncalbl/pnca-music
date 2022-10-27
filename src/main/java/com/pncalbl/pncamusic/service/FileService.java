package com.pncalbl.pncamusic.service;

import com.pncalbl.pncamusic.dto.FileUploadDto;
import com.pncalbl.pncamusic.dto.FileUploadRequest;

import java.io.IOException;

/**
 * @author pncalbl
 * @date 2022/10/26 20:30
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface FileService {

	FileUploadDto initUpload(FileUploadRequest fileUploadRequest) throws IOException;
}
