package com.lanou.utills;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class MyShiroUtil {

	public static Subject getShiroSubject(String iniPath) {
		// 使用init配置文件获取SecurityManager对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory(iniPath);
		// 获取SecurityManager对象
		SecurityManager sm = factory.getInstance();
		// 装配到SecurityUtils中
		SecurityUtils.setSecurityManager(sm);
		// 通过SecurityUtils获取subject对象
		Subject subject = SecurityUtils.getSubject();
		return subject;
	}

}
