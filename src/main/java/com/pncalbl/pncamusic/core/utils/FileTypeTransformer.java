package com.pncalbl.pncamusic.core.utils;

import com.pncalbl.pncamusic.core.enums.FileType;

/**
 * @author pncalbl
 * @date 2022/10/26 21:20
 * @e-mail pncalbl@qq.com
 * @description
 **/

public class FileTypeTransformer {
	public static FileType getFileTypeFromExt(String ext) {
		if (isAudio(ext)) {
			return FileType.AUDIO;
		}

		if (isImage(ext)) {
			return FileType.IMAGE;
		}

		if (isVideo(ext)) {
			return FileType.VIDEO;
		}

		return FileType.OTHER;
	}

	private static Boolean isVideo(String ext) {
		String[] videoExt = {"vob", "mp4", "avi",
				"flv", "f4v", "wmv", "mov", "rmvb",
				"mkv", "mpg", "m4v", "webm", "rm",
				"mpeg", "asf", "ts", "mts"};
		for (String perExt : videoExt) {
			if (perExt.equals(ext))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	private static Boolean isAudio(String ext) {
		String[] videoExt = {"mp3", "wav"};
		for (String perExt : videoExt) {
			if (perExt.equals(ext))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}


	private static Boolean isImage(String ext) {
		String[] videoExt = {"png", "jpg", "jpeg"};
		for (String perExt : videoExt) {
			if (perExt.equals(ext))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
