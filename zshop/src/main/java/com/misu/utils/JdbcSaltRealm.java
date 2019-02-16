package com.misu.utils;

import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.springframework.stereotype.Component;

/**
*
*@author LiuXu
*@version 2018年10月7日上午12:48:20 
*/
public class JdbcSaltRealm extends JdbcRealm{

	public JdbcSaltRealm(){
		setSaltStyle(SaltStyle.COLUMN);
	}
}
