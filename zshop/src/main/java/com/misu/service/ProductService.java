package com.misu.service;

import java.util.List;

import com.misu.bean.Product;
import com.misu.common.ProductInfo;
import com.misu.common.ProductParam;
/**
 * 
 * @author asus
 *  
 */
public interface ProductService {
	/**
	 * 添加商品
	 * @param product
	 */
	public void addProduct(Product product) throws Exception;
	
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
	public void deleteProductById(int id) throws Exception;
	
	/**
	 * 更新某个产品
	 * @param product
	 */
	public void updateProduct(Product product) throws Exception;	

	
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
