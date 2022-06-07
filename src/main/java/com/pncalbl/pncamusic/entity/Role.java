package com.pncalbl.pncamusic.entity;



import javax.persistence.Entity;

/**
 * @author pncalbl
 * @date 2022/6/7 21:24
 * @e-mail pncalbl@qq.com
 * @description 角色实体类
 **/

@Entity
public class Role extends BaseEntity {
	private String name;

	private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
