package com.pncalbl.pncamusic.core.repository;

import com.pncalbl.pncamusic.core.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author pncalbl
 * @date 2022/10/26 20:32
 * @e-mail pncalbl@qq.com
 * @description
 **/

public interface FileRepository extends JpaRepository<File, String> {
}
