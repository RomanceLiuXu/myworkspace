package com.lanou.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lanou.annotation.MyBatisAnnotation;
import com.lanou.bean.Emp;

/**
 *
 * @author LiuXu
 * @time2018年9月19日下午5:48:23
 **/
@MyBatisAnnotation
@Repository("empMapper")
public interface EmpMapper {

	public List<Emp> findAll();
	
}
