package com.liuxu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
*
*@author LiuXu
*@version 2018年10月8日下午3:34:13 
*/
@SpringBootApplication
@Controller
public class App {

	@RequestMapping("hello.do")
	@ResponseBody
	public String hello(){
		return "hello spring boot";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
