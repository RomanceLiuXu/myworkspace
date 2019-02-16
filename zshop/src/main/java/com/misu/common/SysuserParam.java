package com.misu.common;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
*系统用户条件查询
*@author LiuXu
*@version 2018年10月4日上午10:57:17 
*/
@Component
public class SysuserParam implements Serializable{

	private String name;
    private String loginName;
    private String phone;
    private Integer role;
    private Integer isValid;
    
    @Override
	public String toString() {
		return "SysuserParam [name=" + name + ", loginName=" + loginName + ", phone=" + phone + ", role=" + role
				+ ", isValid=" + isValid + "]";
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
    }
	
}
