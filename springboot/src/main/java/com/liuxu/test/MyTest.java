package com.liuxu.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
*
*@author LiuXu
*@version 2018年10月8日下午7:04:06 
*/
@Controller
public class MyTest {

	@RequestMapping("/tolist.do")
	public ModelAndView testThymeleaf(){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		return mav;
	}
	
	
}
