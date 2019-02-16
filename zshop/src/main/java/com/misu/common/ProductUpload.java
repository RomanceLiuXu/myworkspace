package com.misu.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 商品上传时传入的对象 用于接受上传数据
 * 
 * @author LiuXu
 * @version 2018年10月3日上午9:48:54
 */
@Component("productUpload")
public class ProductUpload {

	private String name;
	private Double price;
	private MultipartFile file;
	private int productTypeId;
	
	@Override
	public String toString() {
		return "ProductUpload [name=" + name + ", price=" + price + ", file=" + file + ", productTypeId="
				+ productTypeId + "]";
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

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

}
