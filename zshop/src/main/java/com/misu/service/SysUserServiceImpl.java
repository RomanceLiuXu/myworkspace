package com.misu.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misu.bean.Role;
import com.misu.bean.SysUser;
import com.misu.common.PasswordVo;
import com.misu.common.SysuserParam;
import com.misu.common.SysuserVo;
import com.misu.mapper.SysUserMapper;
import com.misu.utils.ShiroPasswordServiceImpl;

/**
 *
 * @author LiuXu
 * @version 2018年10月4日上午11:13:07
 */
@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysMapper;
	@Autowired
	private SysUser sysUser;
	@Autowired
	private ShiroPasswordServiceImpl shiroPassword;

	@Override
	public List<SysUser> selectAll() {

		return sysMapper.selectAll();
	}

	@Override
	public SysUser selectById(int id) {

		return sysMapper.selectById(id);
	}

	@Override
	public void insert(SysuserVo sysuserVo) throws Exception {
		// 对象间属性的复制
		PropertyUtils.copyProperties(sysUser, sysuserVo);
		// 对系统用户的密码进行加密
		PasswordVo passwordVo = new PasswordVo();
		passwordVo.setPassword(sysuserVo.getPassword());
		passwordVo.setSalt(sysuserVo.getLoginName());
		String encryptPassword = shiroPassword.encryptPassword(passwordVo);
		sysUser.setPassword(encryptPassword);
		System.out.println("加密后的密码："+encryptPassword);
		// 注册日期默认为当时
		sysUser.setCreateDate(new Date());
		// 默认用户可用
		sysUser.setIsvalid(1);
		Role role = new Role();
		role.setId(sysuserVo.getRoleId());
		sysUser.setRole(role);
		sysMapper.insert(sysUser);
	}

	@Override
	public void update(SysuserVo sysuserVo) throws Exception {
		PropertyUtils.copyProperties(sysUser, sysuserVo);
		Role role = new Role();
		role.setId(sysuserVo.getRoleId());
		sysUser.setRole(role);
		sysMapper.update(sysUser);
	}

	@Override
	public void updateStatus(int id, int isValid) throws Exception {
		isValid = isValid == 0 ? 1 : 0;
		sysMapper.updateStatus(id, isValid);

	}

	@Override
	public List<SysUser> selectByParams(SysuserParam sysuserParam) {

		return sysMapper.selectByParams(sysuserParam);
	}

	@Override
	public SysUser selectByLoginNameAndPassword(String loginName, String password, int isValid) {

		return sysMapper.selectByLoginNameAndPassword(loginName, password, isValid);
	}

	@Override
	public int selectStatus(String loginName) {

		return sysMapper.selectStatus(loginName);
	}

}
