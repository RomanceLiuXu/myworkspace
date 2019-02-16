package com.misu.service;

import java.util.List;

import com.misu.bean.Customer;

/**
*
*@author LiuXu
*@version 2018年10月3日下午4:35:12 
*/
public interface CustomerService {

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
	public void updateCustomerStatus(Customer customer) throws Exception;
	
	/**
	 * 更新用户信息
	 * @param customer
	 */
	public void updateCustomer(Customer customer) throws Exception;
	
	/**
	 * 添加用户
	 * @param customer
	 */
	public void addCustomer(Customer customer) throws Exception;
	
	/**
	 * 删除某个用户
	 * @param id
	 */
	public void deleteCustomer(int id) throws Exception;
	
    public Customer findCustomer(Customer customer);
	
	public Customer findCustomerByPhone(String phone);
	
}
