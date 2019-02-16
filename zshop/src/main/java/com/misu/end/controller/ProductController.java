package com.misu.end.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.misu.bean.Product;
import com.misu.bean.ProductType;
import com.misu.common.Item;
import com.misu.common.OperationMessage;
import com.misu.common.PageConstant;
import com.misu.common.ProductInfo;
import com.misu.common.ProductUpload;
import com.misu.service.ProductService;
import com.misu.service.ProductTypeService;
import com.sun.mail.imap.protocol.ID;

/**
 * 商品的controller
 * 
 * @author LiuXu
 * @version 2018年10月2日下午10:18:32
 */
@Controller
@RequestMapping("backend/product")
public class ProductController {

	@Autowired
	private ProductService pService;
	@Autowired
	private ProductTypeService ptService;
	@Autowired
	private Product product;
	@Autowired
	private OperationMessage message;

	@ModelAttribute("productTypes")
	public List<ProductType> loadProductTypes() {
		List<ProductType> productTypes = ptService.findAllProductType();
		return productTypes;
	}

	@RequestMapping("findAll")
	public String findAllProduct(Integer pageIndex, Model model) {
		if (ObjectUtils.isEmpty(pageIndex)) {
			pageIndex = PageConstant.pageIndex;
		}
		PageHelper.startPage(pageIndex, PageConstant.pageNum);
		List<Product> products = pService.findAllProduct();
		for (Product product : products) {
			System.out.println(product.getProductType());
		}
		PageInfo<Product> pageInfo = new PageInfo<>(products);
		model.addAttribute("pageInfo", pageInfo);
		return "backend/productManager";
	}

	@RequestMapping("addProduct")
	public String addProduct(ProductUpload pUpload, HttpSession session) {
		System.out.println(pUpload);
		// 获取文件名
		String fileName = pUpload.getFile().getOriginalFilename();
		// 上传路径
		String realPath = session.getServletContext().getRealPath("/upload");
		System.out.println("文件名:" + fileName + "--" + "上传路径:" + realPath);
		File file = new File(realPath + "//" + fileName);
		try {
			pUpload.getFile().transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		product.setName(pUpload.getName());
		product.setPrice(pUpload.getPrice());
		product.setImage("upload" + "/" + fileName);
		ProductType productType = new ProductType();
		productType.setId(pUpload.getProductTypeId());
		product.setProductType(productType);
		try {
			pService.addProduct(product);
		} catch (Exception e) {
			System.out.println("添加失败");
		}
		return "redirect:findAll";
	}

	@RequestMapping("showProduct")
	@ResponseBody
	public Product findProductById(@Param("id") Integer id) {
		Product product = pService.findProductById(id);
		return product;
	}

	@RequestMapping("updateProduct")
	public OperationMessage updateProduct(Product product) {
		try {
			pService.updateProduct(product);
			message.setStatus(1);
			message.setMessage("更新成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("更新失败");
		}
		return message;
	}

	@RequestMapping("deleteProduct")
	@ResponseBody
	public OperationMessage deleteProduct(@Param("id") Integer id) {
		try {
			pService.deleteProductById(id);
			message.setStatus(1);
			message.setMessage("删除成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("删除失败");
		}
		return message;
	}

	@RequestMapping("selectNum")
	@ResponseBody
	public List<ProductInfo> selectPorductTypeNum() {
		List<ProductInfo> items = pService.selectPorductTypeNum();
		for (ProductInfo productInfo : items) {
			System.out.println(productInfo);
		}
		return items;
	}

	@RequestMapping("selectNumber")
	@ResponseBody
	public List<Item> selectPorductTypeNumber() {
		List<ProductInfo> ps = pService.selectPorductTypeNum();
		List<Item> items = new ArrayList<Item>();
		for (ProductInfo productInfo : ps) {
			Item item = new Item();
			item.setName(productInfo.getProductTypeName());
			item.setValue(productInfo.getNum());
			items.add(item);
		}
		return items;
	}

	@RequestMapping("checkName")
	@ResponseBody
	 public Map<String, Object> checkName(String name){
		Map<String, Object> map = new HashMap<>();
		 Product p = pService.findProductByName(name);
		 if (p!=null) {
			map.put("valid", false);
		}else{
			map.put("valid", true);
		}
		 return map;
	 }

}
