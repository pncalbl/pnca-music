package com.pncalbl.pncamusic.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * @author pncalbl
 * @date 2022/6/7 21:24
 * @e-mail pncalbl@qq.com
 * @description 角色实体类
 **/

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Role extends BaseEntity {
	private String name;

	private String title;
}
