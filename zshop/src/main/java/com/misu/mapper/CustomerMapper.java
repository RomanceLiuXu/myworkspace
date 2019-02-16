package com.misu.mapper;

import java.util.List;

import com.misu.bean.Customer;

/**
*用户映射接口
*@author LiuXu
*@version 2018年10月3日下午1:53:11 
*/
public interface CustomerMapper {

	/*
	 * 查询所有用户
	 */
	public List<Customer> findAllCustomer(Customer customer);
	
	/**
	 * 根据id查询
	 * @return
	 */
	public Customer findCustomerById(int id);
	
	/**
	 * 是否禁用某个用户
	 * @param customer
	 */
	public void updateCustomerStatus(Customer customer);
	
	/**
	 * 更新用户信息
	 * @param customer
	 */
	public void updateCustomer(Customer customer);
	
	/**
	 * 添加用户
	 * @param customer
	 */
	public void addCustomer(Customer customer);
	
	/**
	 * 删除某个用户
	 * @param id
	 */
	public void deleteCustomer(int id);
	
	
	public Customer findCustomer(Customer customer);
	
	public Customer findCustomerByPhone(String phone);
}
