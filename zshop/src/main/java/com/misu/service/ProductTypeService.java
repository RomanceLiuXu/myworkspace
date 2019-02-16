package com.misu.service;

import java.util.List;

import com.misu.bean.ProductType;

/**
*
*@author LiuXu
*@version 2018年10月2日上午10:54:19 
*/
public interface ProductTypeService {
	/**
	 * 查询所有商品类型
	 * @return
	 */
	public List<ProductType> findAllProductType();
	
	/**
	 * 查询所有启用商品类型
	 * @return
	 */
	public List<ProductType> findAllProductTypeUsing();
	
	/**
	 * 根据id查询商品类型
	 * @return
	 */
	public ProductType findProductTypeById(int id);
	
	/**
	 * 根据name查询商品类型
	 * @return
	 */
	public ProductType findProductTypeByName(String name);
	
	/**
	 * 新增商品类型
	 * @param productType
	 */
	public void addProductType(ProductType productType) throws Exception;
	
	/**
	 * 更新商品类型
	 * @param productType
	 */
	public void updateProductType(ProductType productType) throws Exception;
	
	/**
	 * 删除商品类型
	 * @param productTyp id
	 */
	public void deleteProductType(Integer id) throws Exception;
	
	/**
	 * 是否启用某类商品
	 * @param productType
	 */
	public void updateProductStatus(ProductType productType);
}
