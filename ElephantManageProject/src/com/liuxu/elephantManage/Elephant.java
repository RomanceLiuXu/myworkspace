package com.liuxu.elephantManage;

//大象类
public class Elephant {
	
	
	//属性
	private int sum;
	private String name;
	private double weight;
	private int bloodVolume;

	// 构造器
	public Elephant() {
	}

	public Elephant(int sum, String name, double weight, int bloodVolume) {
		super();
		this.sum = sum;
		this.name = name;
		this.weight = weight;
		this.bloodVolume = bloodVolume;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getBloodVolume() {
		return bloodVolume;
	}

	public void setBloodVolume(int bloodVolume) {
		this.bloodVolume = bloodVolume;
	}

}
