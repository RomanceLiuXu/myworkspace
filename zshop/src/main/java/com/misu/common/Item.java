package com.misu.common;

import java.io.Serializable;

/**
 *
 * @author LiuXu
 * @time2018年9月28日下午2:13:08
 **/
public class Item implements Serializable{

	private String name;//名称
	private int value;//数量
	
	public Item() {
		super();
	}
	public Item(String name, int value) {
		super();
		this.name = name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
