package com.lanou.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.bean.Emp;
import com.lanou.dao.EmpMapper;


/**
*
* @author LiuXu
* @time2018年9月19日下午7:20:27
**/
@Service("empService")
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<Emp> findAll() {
		
		return empMapper.findAll();
	}
	
	
	
	
}
