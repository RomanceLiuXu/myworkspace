package com.lanou.controller;

import java.util.List;

import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.Emp;
import com.lanou.service.EmpService;
import com.lanou.utills.MyShiroUtil;

/**
 *
 * @author LiuXu
 * @time2018年9月20日上午9:53:40
 **/
@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String tolist(Model model){
		List<Emp> emps = empService.findAll();
		model.addAttribute("emps", emps);
		for (Emp emp : emps) {
			System.out.println(emp);
		}
		return "list";
	}
	
	@RequestMapping("/login")
	public String shiroLogin(String username,String password){
		Subject subject = MyShiroUtil.getShiroSubject("classpath:shiro.ini");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		try {
			System.out.println("是否认证:"+subject.isAuthenticated());
			subject.login(token);
			System.out.println("是否认证:"+subject.isAuthenticated());
			System.out.println("登录成功");
		} catch (IncorrectCredentialsException e) {
			System.out.println("登录密码错误");
		} catch (UnknownAccountException e) {
			System.out.println("帐号不存在");
		}catch (Exception e) {
			System.out.println("其他错误");
		}
		return "redirect:list";
	}
	
}