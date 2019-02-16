package com.misu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misu.bean.Product;
import com.misu.common.ProductInfo;
import com.misu.common.ProductParam;
import com.misu.mapper.ProductMapper;

/**
*
*@author LiuXu
*@version 2018年10月2日下午10:13:32 
*/
@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductMapper pMapper;
	
	@Override
	public void addProduct(Product product) {
		pMapper.addProduct(product);
	}

	@Override
	public List<Product> findAllProduct() {
		
		return pMapper.findAllProduct();
	}

	@Override
	public List<Product> findAllUsingProduct() {
		return pMapper.findAllUsingProduct();
	}

	@Override
	public List<Product> findAllNotUsingProduct() {
		return pMapper.findAllNotUsingProduct();
	}

	@Override
	public Product findProductById(int id) {
		
		return pMapper.findProductById(id);
	}

	@Override
	public void deleteProductById(int id) {
		pMapper.deleteProductById(id);
	}

	@Override
	public void updateProduct(Product product) {
		pMapper.updateProduct(product);
		
	}

	@Override
	public List<Product> findProductByParam(ProductParam param) {
		
		return pMapper.findProductByParam(param);
	}

	@Override
	public List<ProductInfo> selectPorductTypeNum() {
		
		return pMapper.selectPorductTypeNum();
	}

	@Override
	public Product findProductByName(String name) {
		
		return pMapper.findProductByName(name);
	}

}
