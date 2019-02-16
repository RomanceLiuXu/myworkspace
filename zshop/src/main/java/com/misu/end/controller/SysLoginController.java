package com.misu.end.controller;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.misu.common.OperationMessage;
import com.misu.service.SysUserService;
import com.misu.utils.MyShiroUtil;

/**
 * 系统用户登录
 * 
 * @author LiuXu
 * @version 2018年10月4日下午6:47:43
 */
@Controller
@RequestMapping("/manager")
public class SysLoginController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private OperationMessage message;
    
	@RequestMapping("tologin")
	public String showLogin(){
		return "manager/login";
	}
	
	@RequestMapping("login")
	public String syslogin(String loginName, String password, HttpSession session, Model model) {
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
		try {
			subject.login(token);
			System.out.println("登录成功");
			int n = sysUserService.selectStatus(loginName);
			System.out.println(n);
			if (n==0) {
				model.addAttribute("msg", "账户为不可用状态，请联系管理员!");
				return "manager/login";
			}
			session.setAttribute("loginName", loginName);
			return "backend/main";
		} catch (IncorrectCredentialsException e) {
			System.out.println("登录密码错误");
			model.addAttribute("msg", "登录密码错误");
		} catch (UnknownAccountException e) {
			System.out.println("帐号不存在");
			model.addAttribute("msg", "帐号不存在");
		} catch (Exception e) {
			model.addAttribute("msg", "登录错误");
		}
		return "manager/login";
	}
	
	@RequestMapping("loginout")
	public String loginOut(){
		SecurityUtils.getSubject().logout();
		return "redirect:tologin";
	}

}
