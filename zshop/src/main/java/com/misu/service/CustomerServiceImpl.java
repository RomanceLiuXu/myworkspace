package com.misu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misu.bean.Customer;
import com.misu.mapper.CustomerMapper;

/**
*
*@author LiuXu
*@version 2018年10月3日下午4:35:57 
*/
@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerMapper cMapper;
	@Override
	public List<Customer> findAllCustomer(Customer customer) {
		
		return cMapper.findAllCustomer(customer);
	}

	@Override
	public Customer findCustomerById(int id) {
	
		return cMapper.findCustomerById(id);
	}

	@Override
	public void updateCustomerStatus(Customer customer) {
		cMapper.updateCustomerStatus(customer);
	}

	@Override
	public void updateCustomer(Customer customer) {
		cMapper.updateCustomer(customer);
	}

	@Override
	public void addCustomer(Customer customer) {
		customer.setIs_valid(1);
		customer.setRegist_date(new Date());
		cMapper.addCustomer(customer);
	}

	@Override
	public void deleteCustomer(int id) {
		cMapper.deleteCustomer(id);
	}

	@Override
	public Customer findCustomer(Customer customer) {
		
		return cMapper.findCustomer(customer);
	}

	@Override
	public Customer findCustomerByPhone(String phone) {
		
		return cMapper.findCustomerByPhone(phone);
	}
  
     
}
