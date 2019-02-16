package com.misu.common;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.misu.bean.Role;

/**
 * 前段接受修改或添加系统用户的属性
 * 
 * @author LiuXu
 * @version 2018年10月4日下午5:24:02
 */
@Component
public class SysuserVo {

	private Integer id;
	private String name;
	private String loginName;
	private String password;
	private String phone;
	private String email;
	private Integer isValid;
	private Integer roleId;

	@Override
	public String toString() {
		return "SysuserVo [id=" + id + ", name=" + name + ", loginName=" + loginName + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", isValid=" + isValid + ", roleId=" + roleId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsValid() {
		return isValid;
	}

	public void setIsValid(Integer isValid) {
		this.isValid = isValid;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

}
