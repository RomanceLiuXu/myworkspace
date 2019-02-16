package com.misu.common;

import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @version 2018年10月5日下午6:34:05
 */
@Component
public class ProductParam implements Serializable{

	private String name;
	private Double minPrice;
	private Double maxPrice;
	private Integer productTypeId;

	
	@Override
	public String toString() {
		return "ProductParam [name=" + name + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", productTypeId="
				+ productTypeId + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Integer getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

}
