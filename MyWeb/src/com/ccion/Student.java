package com.ccion;

public class Student {

	private int id;
	private String name;
	private String psw;

	public Student() {
		super();
	}

	public Student(String name, String psw) {
		super();
		this.name = name;
		this.psw = psw;
	}

	public Student(int id, String name, String psw) {
		super();
		this.id = id;
		this.name = name;
		this.psw = psw;
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

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}
