package com.misu.bean;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @version 2018年10月4日上午10:35:24
 */
public class Role implements Serializable{
	private Integer id;
	private String roleName;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}
