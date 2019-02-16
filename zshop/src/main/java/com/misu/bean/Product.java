package com.misu.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * 具体商品
 * @author LiuXu
 * @version 2018年10月2日上午9:56:34
 */
@Component
public class Product implements Serializable{

	private int id;// 商品id
	private String name;// 商品名称
	private Double price;// 商品价格
	private String info;// 商品信息介绍
	private String image;// 商品图片
	private ProductType productType;// 商品类型

	public Product() {
		super();
	}

	public Product(int id, String name, Double price, String info, String image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.info = info;
		this.image = image;
	}

	public Product(int id, String name, Double price, String info, String image, ProductType productType) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.info = info;
		this.image = image;
		this.productType = productType;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", info=" + info + ", image=" + image
				+ "]";
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

}
