package com.misu.end.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.misu.bean.ProductType;
import com.misu.common.OperationMessage;
import com.misu.common.PageConstant;
import com.misu.service.ProductTypeService;
import com.misu.utils.PoiUtil;

/**
 *
 * @author LiuXu
 * @version 2018年10月2日上午10:58:43
 */
@Controller("productTypeController")
@RequestMapping("/backend/productType")
public class ProductTypeController {

	@Autowired
	private ProductTypeService ptService;
	@Autowired
	private OperationMessage message;

	/**
	 * 分页查询商品类型
	 * 
	 * @param pageIndex
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("findAll")
	public String findAllProductType(Integer pageIndex, Model model, HttpSession session) throws IOException {
		if (ObjectUtils.isEmpty(pageIndex)) {
			pageIndex = PageConstant.pageIndex;
		}
		// 设置分页
		PageHelper.startPage(pageIndex, PageConstant.pageNum);
		List<ProductType> productTypes = ptService.findAllProductType();
		String iniPath = session.getServletContext().getRealPath("/");
		System.out.println("上传路径:"+iniPath);
		String[] header = {"商品编号","商品类型名称","商品状态"};
		for (ProductType p : productTypes) {
			System.out.println(p);
		}
		// 生成表格
		PoiUtil.getSheet(header, productTypes, iniPath+"product.xlsx");
		// 将查询结果封装到pageInfo中
		PageInfo<ProductType> pageInfo = new PageInfo<>(productTypes);
		model.addAttribute("pageInfo", pageInfo);
		return "backend/productTypeManager";
	}

	@RequestMapping("addProductType")
	@ResponseBody
	public OperationMessage addProductType(ProductType productType) {
		try {
			System.out.println(productType.getName());
			ptService.addProductType(productType);
			message.setStatus(1);
			message.setMessage("添加成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("商品类型已存在");
		}
		return message;
	}

	@RequestMapping("showProductType")
	@ResponseBody
	public ProductType findProductTypeById(@Param("id") Integer id) {
		System.out.println("id" + id);
		ProductType productType = ptService.findProductTypeById(id);
		return productType;
	}

	@RequestMapping("updateProductType")
	@ResponseBody
	public OperationMessage updateProductType(ProductType productType) {
		try {
			ptService.updateProductType(productType);
			message.setStatus(1);
			message.setMessage("更新成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("更新失败");
		}
		return message;
	}

	@RequestMapping("updateProductStatus")
	@ResponseBody
	public OperationMessage updateProductStatus(ProductType productType) {
		try {
			ptService.updateProductStatus(productType);
			message.setStatus(1);
			message.setMessage("状态更新成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("状态更新失败");
		}
		return message;
	}

	@RequestMapping("deleteProductType")
	@ResponseBody
	public OperationMessage deleteProductType(@Param("id") Integer id) {
		try {
			ptService.deleteProductType(id);
			message.setStatus(1);
			message.setMessage("删除成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("删除失败");
		}
		return message;
	}

}
