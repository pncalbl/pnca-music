package com.pncalbl.pncamusic.controller;

import com.pncalbl.pncamusic.dto.FileUploadRequest;
import com.pncalbl.pncamusic.mapper.FileUploadMapper;
import com.pncalbl.pncamusic.service.FileService;
import com.pncalbl.pncamusic.vo.FileUploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author pncalbl
 * @date 2022/10/26 20:28
 * @e-mail pncalbl@qq.com
 * @description
 **/

@PreAuthorize("hasRole('ROLE_ADMIN')")
@RestController
@RequestMapping("/files")
public class FileController {
	private FileService fileService;

	private FileUploadMapper fileUploadMapper;

	@PostMapping("/upload_init")
	public FileUploadVo initUpload(@Validated @RequestBody FileUploadRequest fileUploadRequest) throws IOException {
		return fileUploadMapper.toVo(fileService.initUpload(fileUploadRequest));
	}

	@Autowired
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}


	@Autowired
	public void setFileUploadMapper(FileUploadMapper fileUploadMapper) {
		this.fileUploadMapper = fileUploadMapper;
	}
}
