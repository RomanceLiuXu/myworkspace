package com.lanou.utills;

import java.util.Random;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 邮箱验证工具类
 * 
 * @author LiuXu
 * @time2018年8月11日下午2:56:13
 **/
public class MailValidate {

	// 随机生成验证码的方法
	public static String createnNum(int n) {
		String str = "";
		for (char i = 'a'; i <= 'z'; i++) {
			str += i;
		}
		for (char i = 'A'; i <= 'Z'; i++) {
			str += i;
		}
		for (int i = 0; i <= 9; i++) {
			str += i;
		}
		String verCode = "";
		char[] ch = str.toCharArray();
		Random random = new Random();
		for (int i = 0; i < 4; i++) {
			int nextInt = random.nextInt(ch.length);
			verCode += ch[nextInt];
		}

		return verCode;

	}

	/**
	 * 
	 * @param to
	 *            接收邮件的账号
	 * @param code
	 *            需要发送的验证码
	 */
	public static boolean sendEmail(String to, String code) {
		// 创建一个邮件对象
		HtmlEmail email = new HtmlEmail();
		// 指定邮箱服务器地址
		email.setHostName("smtp.163.com");
		// 指定邮箱服务器账号和客户端授权码
		email.setAuthentication("liuxu043@163.com", "liuxu12345");
		// 统一设置邮件内容编码
		email.setCharset("UTF-8");
		// 设置发件人地址和名称
		try {
			email.setFrom("liuxu043@163.com", "小米科技");
			// 设置收件人地址
			email.addTo(to);
			// 设置标题
			email.setSubject("来自神秘东方的邮件");
			// 设置邮件内容
			email.setMsg("<h1 style='color:red'>恭喜您被选为神秘东方的接班人，验证码：" + code + "</h1>");
			// 发送邮件
			email.send();
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			return false;
		}

	}

}
