package com.misu.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;

import com.misu.bean.SysUser;
import com.misu.common.SysuserParam;
import com.misu.common.SysuserVo;

/**
*
*@author LiuXu
*@version 2018年10月4日上午11:11:38 
*/
public interface SysUserService {


	/**
	 * 查询所有系统用户
	 * @return
	 */
	public List<SysUser> selectAll();
    /**
     * 根据id查询一个系统用户
     * @param id
     * @return
     */
	public SysUser selectById(int id);

	/**
	 * 添加系统用户
	 * @param sysuser
	 */
	public void insert(SysuserVo sysuserVo) throws Exception;

	/**
	 * 修改系统用户
	 * @param sysuser
	 */
	public void update(SysuserVo sysuserVo) throws Exception;

	/**
	 * 更新系统用户状态
	 * @param id
	 * @param isValid
	 */
	public void updateStatus(int id, int isValid) throws Exception;
    
	/**
	 * 条件查找用户
	 * @param sysuserParam
	 * @return
	 */
	public List<SysUser> selectByParams(SysuserParam sysuserParam);
    
	/**
	 * 系统用户登录
	 * @param loginName
	 * @param password
	 * @param isValid
	 * @return
	 */
	SysUser selectByLoginNameAndPassword(String loginName, String password,
			int isValid);
	
	public int selectStatus(@Param("loginName") String loginName);
}
