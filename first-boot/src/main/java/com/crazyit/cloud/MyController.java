package com.crazyit.cloud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*
*@author LiuXu
*@version 2018年10月31日下午9:33:17 
*/
@Controller
public class MyController {

	@RequestMapping("/hello")
	@ResponseBody
	public String toHello(){
		return "Hello SpringBoot";
	}
	
	@RequestMapping("/tohtml")
	public String helloHtml(){
		return "/my";
	}
	
	
}
