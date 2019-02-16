package com.misu.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misu.bean.ProductType;
import com.misu.mapper.ProductTypeMapper;

/**
 *
 * @author LiuXu
 * @version 2018年10月2日上午10:54:48
 */
@Service("productTypeService")
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeMapper ptMapper;

	@Override
	public List<ProductType> findAllProductType() {

		return ptMapper.findAllProductType();
	}

	@Override
	public ProductType findProductTypeById(int id) {
		return ptMapper.findProductTypeById(id);
	}

	@Override
	public ProductType findProductTypeByName(String name) {
		return ptMapper.findProductTypeByName(name);
	}

	@Override
	public void addProductType(ProductType productType) throws Exception{
		ptMapper.addProductType(productType);
	}

	@Override
	public void updateProductType(ProductType productType) throws Exception{
		ptMapper.updateProductType(productType);
	}

	@Override
	public void deleteProductType(Integer id) throws Exception{
      ptMapper.deleteProductType(id);
      ptMapper.deleteSameTypeProduct(id);
	}

	@Override
	public void updateProductStatus(ProductType productType) {
		 ptMapper.updateProductStatus(productType);
	}

	@Override
	public List<ProductType> findAllProductTypeUsing() {
		
		return ptMapper.findAllProductTypeUsing();
	}

}
