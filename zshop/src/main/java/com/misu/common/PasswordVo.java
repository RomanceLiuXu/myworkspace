package com.misu.common;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @version 2018年10月7日上午1:40:06
 */
public class PasswordVo implements Serializable{

	public String password;
	public String salt;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

}
