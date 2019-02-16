package com.misu.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.misu.bean.ProductType;

/**
*商品类型映射接口
*@author LiuXu
*@version 2018年10月2日上午10:07:42 
*/
@Repository
public interface ProductTypeMapper {

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
	public void addProductType(ProductType productType);
	
	/**
	 * 更新商品类型
	 * @param productType
	 */
	public void updateProductType(ProductType productType);
	
	/**
	 * 删除商品类型
	 * @param id
	 */
	public void deleteProductType(int id);
	
	/**
	 * 删除商品类型下的所有商品
	 * @param id
	 */
	public void deleteSameTypeProduct(int id);
	/**
	 * 是否启用某类商品
	 * @param productType
	 */
	public void updateProductStatus(ProductType productType);
	
}
