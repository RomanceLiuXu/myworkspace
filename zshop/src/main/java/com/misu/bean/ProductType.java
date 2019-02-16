package com.misu.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * 商品类型
 * @author LiuXu
 * @version 2018年10月2日上午9:29:04
 */
@Component
public class ProductType implements Serializable{
	private int id;//类型id
	private String name;//类型名称
	private int status;//商品状态 0-禁用 1-启用
	private List<Product> productList;//商品集合

	public ProductType() {
		super();
	}

	public ProductType(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public ProductType(int id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	@Override
	public String toString() {
		return "ProductType [id=" + id + ", name=" + name + ", status=" + status + "]";
	}
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
