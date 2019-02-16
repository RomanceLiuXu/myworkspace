package com.misu.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.misu.bean.Customer;
import com.misu.common.OperationMessage;
import com.misu.common.PageConstant;
import com.misu.service.CustomerService;

/**
 *
 * @author LiuXu
 * @version 2018年10月3日下午4:41:29
 */
@Controller("customerController")
@RequestMapping("backend/customer")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	@Autowired
	private OperationMessage message;

	@RequestMapping("findAll")
	public String findAllCustomer(Integer pageIndex, Model model,Customer customer) {
		if (ObjectUtils.isEmpty(pageIndex)) {
			pageIndex = PageConstant.pageIndex;
		}
		System.out.println("传入的查询参数："+customer);
		PageHelper.startPage(pageIndex, PageConstant.pageNum);
		List<Customer> customers = cService.findAllCustomer(customer);
		PageInfo<Customer> pageInfo = new PageInfo<>(customers);
		for (Customer c : customers) {
			System.out.println(c);
		}
		model.addAttribute("pageInfo", pageInfo);
		return "backend/customerManager";
	}

	@RequestMapping("showCustomer")
	@ResponseBody
	public Customer findCustomerById(Integer id) {
		Customer customer = cService.findCustomerById(id);
		return customer;
	}

	@RequestMapping("updateCustomerStatus")
	@ResponseBody
	public OperationMessage updateCustomerStatus(Customer customer){
		try {
			cService.updateCustomerStatus(customer);
			message.setStatus(1);
			message.setMessage("更新成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("更新失败");
		}
		return message;
	}

	@RequestMapping("updateCustomer")
	@ResponseBody
	public OperationMessage updateCustomer(Customer customer){
		try {
			System.out.println("要修改的用户:"+customer);
			cService.updateCustomer(customer);
			message.setStatus(1);
			message.setMessage("修改成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("修改失败");
		}
		return message;
	}
	
	@RequestMapping("deleteCustomer")
	@ResponseBody
	public OperationMessage deleteCustomer(Integer id) {
		try {
			cService.deleteCustomer(id);
			message.setStatus(1);
			message.setMessage("删除成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("删除失败");
		}
		return message;
	}
}
