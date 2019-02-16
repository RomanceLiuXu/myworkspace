package com.liuxu.ssas.model;

public class Student {

	private String name;// 姓名
	private Integer sid;// 学号

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String name, Integer sid) {
		super();
		this.name = name;
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

}
