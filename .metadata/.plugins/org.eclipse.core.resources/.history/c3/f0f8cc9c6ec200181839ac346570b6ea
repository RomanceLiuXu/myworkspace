package com.lanou.mysql;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.lanou.util.MyBatisUtil;
import com.liuxu.bean.Emp;

import oracle.net.aso.f;



/**
 *
 * @author LiuXu
 * @time2018年9月18日上午9:31:55
 **/
public class TestCase1 {

	SqlSessionFactory factory;

	@Before
	public void InitialContext() {
		factory = MyBatisUtil.getSqlSessionFactory();
	}
	
	@Test
	public void test1(){
		SqlSession session = factory.openSession();
		List<Emp> emps = session.selectList("usepro");
		for (Emp emp : emps) {
			System.out.println(emp.toString());
		}
	}
	
	@Test
	public void test2(){
		SqlSession session = factory.openSession();
		int insert = session.insert("pro_int",15);
		System.out.println(insert);
	}
	
}
