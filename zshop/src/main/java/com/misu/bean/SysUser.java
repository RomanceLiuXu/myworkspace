package com.misu.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
*系统用户
*@author LiuXu
*@version 2018年10月4日上午10:34:03 
*/
@Component
public class SysUser implements Serializable{
	private Integer id;
    private String name;
    private String loginName;
    private String password;
    private String phone;
    private String email;
    private Integer isValid;
    private Date createDate;
    private Role role;
    
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", name=" + name + ", loginName=" + loginName + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", isValid=" + isValid + ", createDate=" + createDate + "]";
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
	public void setIsvalid(Integer isValid) {
		this.isValid = isValid;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
    
    
}
