package com.misu.common;

/**
 *
 * @author LiuXu
 * @version 2018年10月6日下午4:53:11
 */
public class ProductInfo {

	private int productTypeId;// 商品类型id
	private String productTypeName;// 商品名称
	private int status;// 商品状态
	private int num;// 对应商品的数量

	
	@Override
	public String toString() {
		return "ProductInfo [productTypeId=" + productTypeId + ", productTypeName=" + productTypeName + ", status="
				+ status + ", num=" + num + "]";
	}

	public int getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
