package com.misu.bean;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author LiuXu
 * @version 2018年10月3日下午1:46:07
 */
public class Customer implements Serializable{

	private int id;// 用户id
	private String name;// 用户名
	private String login_name;// 登录名
	private String password;// 用户密码
	private String phone;// 用户手机
	private String address;// 用户地址
	private Integer is_valid;// 用户状态
	private Date regist_date;// 注册时间

	public Customer() {
		super();
	}

	public Customer(int id, String name, String login_name, String password, String phone, String address, Integer is_valid,
			Date regist_date) {
		super();
		this.id = id;
		this.name = name;
		this.login_name = login_name;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.is_valid = is_valid;
		this.regist_date = regist_date;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", login_name=" + login_name + ", password=" + password
				+ ", phone=" + phone + ", address=" + address + ", is_valid=" + is_valid + ", regist_date="
				+ regist_date + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(Integer is_valid) {
		this.is_valid = is_valid;
	}

	public Date getRegist_date() {
		return regist_date;
	}

	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}

}
