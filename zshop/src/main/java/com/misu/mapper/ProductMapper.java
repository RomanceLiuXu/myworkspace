package com.misu.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.misu.bean.Product;
import com.misu.common.ProductInfo;
import com.misu.common.ProductParam;

/**
*商品映射接口
*@author LiuXu
*@version 2018年10月2日下午9:14:51 
*/
@Repository
public interface ProductMapper {

	/**
	 * 添加商品
	 * @param product
	 */
	public void addProduct(Product product);
	
	/**
	 * 查找所有商品
	 * @return
	 */
	public List<Product> findAllProduct();
	
	/**
	 * 查找所有启用的商品
	 * @return
	 */
	public List<Product> findAllUsingProduct();
	
	/**
	 * 查找所有未启用的商品
	 * @return
	 */
	public List<Product> findAllNotUsingProduct();
	
	/**
	 * 根据id查找某个商品
	 * @param id
	 * @return
	 */
	public Product findProductById(int id);
	
	/**
	 * 根据id删除某个商品
	 * @param id
	 */
	public void deleteProductById(int id);
	
	/**
	 * 更新某个产品
	 * @param product
	 */
	public void updateProduct(Product product);
	
	/**
	 * 根据参数动态查询
	 * @return
	 */
	public List<Product> findProductByParam(ProductParam param);
	
	/**
	 * 查询商品类型对应的商品数量
	 * @return
	 */
	public List<ProductInfo> selectPorductTypeNum();
	
	/**
	 * 根据名称查找某商品
	 * @return
	 */
    public Product findProductByName(String name);
	
}
