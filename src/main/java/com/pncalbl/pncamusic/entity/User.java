package com.pncalbl.pncamusic.entity;

import com.pncalbl.pncamusic.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author pncalbl
 * @date 2022/6/7 20:15
 * @e-mail pncalbl@qq.com
 * @description 用户实体类
 **/


@Entity
@Data
public class User extends BaseEntity {

	@Column(unique = true)
	private String username;

	private String nickname;

	private String password;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Boolean locked = false;

	private Boolean enabled = true;

	private String lastLoginIp;

	private Date lastLoginTime;
}
