package com.misu.front.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misu.bean.Product;
import com.misu.bean.ProductType;
import com.misu.common.ProductParam;
import com.misu.service.ProductService;
import com.misu.service.ProductTypeService;

/**
 * 前段商品展示
 * 
 * @author LiuXu
 * @version 2018年10月5日下午4:17:56
 */
@Controller
@RequestMapping
public class FrontProductController {

	@Autowired
	private ProductService pService;
	@Autowired
	private ProductTypeService ptService;

	/**
	 * 加载之前先加载所有启用商品类型
	 * @return
	 */
	@ModelAttribute("productTypes")
	public List<ProductType> showAllProductTypes() {
		List<ProductType> productTypes = ptService.findAllProductTypeUsing();
		return productTypes;
	}

	/**
	 * 前段展示所有启用的商品
	 * @return
	 */
	@RequestMapping("tomain")
	public String showProducts(Model model) {
		List<Product> products = pService.findAllUsingProduct();
		model.addAttribute("products", products);
		return "main";
	}
     
	@RequestMapping("showByParam")
    public String selectByParam(ProductParam param,Model model){
		System.out.println(param);
		pService.findProductByParam(param);
		List<Product> products = pService.findProductByParam(param);
		model.addAttribute("products", products);
		return "main";
	}
	
	
}
