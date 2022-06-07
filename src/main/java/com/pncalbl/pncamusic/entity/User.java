package com.pncalbl.pncamusic.entity;

import com.pncalbl.pncamusic.enums.Gender;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author pncalbl
 * @date 2022/6/7 20:15
 * @e-mail pncalbl@qq.com
 * @description 用户实体类
 **/


@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class User extends BaseEntity {

	@Column(unique = true)
	private String username;

	private String nickname;

	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
	private List<Role> roles;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	private Boolean locked = false;

	private Boolean enabled = true;

	private String lastLoginIp;

	private Date lastLoginTime;
}
