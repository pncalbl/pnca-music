package com.pncalbl.pncamusic.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author pncalbl
 * @date 2022/6/7 20:35
 * @e-mail pncalbl@qq.com
 * @description
 **/

@MappedSuperclass
public abstract class BaseEntity {
	@Id
	@GeneratedValue(generator = "ksuid")
	@GenericGenerator(name = "ksuid", strategy = "com.pncalbl.pncamusic.utils.KsuidIdentifierGenerator")
	private String id;

	@CreationTimestamp
	private Date createdTime;

	@UpdateTimestamp
	private Date updatedTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
}
