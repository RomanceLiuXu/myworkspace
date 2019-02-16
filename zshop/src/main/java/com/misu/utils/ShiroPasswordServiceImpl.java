package com.misu.utils;

import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.crypto.hash.SimpleHashRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.misu.common.PasswordVo;

/**
 *
 * @author LiuXu
 * @version 2018年10月6日下午11:35:23
 */
@Service
public class ShiroPasswordServiceImpl implements PasswordService {

	@Value("${shiro.hashAlgorithm}")
	private String algorithmName;// 算法名称
	// private String salt;//盐值
	@Value("${shiro.hashIterations}")
	private int hashIterations;// 散列次数

	/*
	 * 用来对明文密码进行加密 (non-Javadoc)
	 * 
	 * @see
	 * org.apache.shiro.authc.credential.PasswordService#encryptPassword(java.
	 * lang.Object)
	 */
	@Override
	public String encryptPassword(Object passwordVo) throws IllegalArgumentException {
		PasswordVo vo = (PasswordVo) passwordVo;
		// SimpleHash:shiro提供的散列加密工具类
		return new SimpleHash(algorithmName, vo.getPassword(), vo.getSalt(), hashIterations).toHex();
	}

	/**
	 * 用于密码匹配
	 */
	@Override
	public boolean passwordsMatch(Object plaintextPassword, String encrypted) {
		String encryptPassword = encryptPassword(plaintextPassword);
		return encryptPassword.equals(encrypted);
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}

}
