package com.misu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.misu.bean.SysUser;
import com.misu.common.SysuserParam;

/**
 *
 * @author LiuXu
 * @version 2018年10月4日上午10:39:34
 */
public interface SysUserMapper {

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
	public void insert(SysUser sysuser);

	/**
	 * 修改系统用户
	 * @param sysuser
	 */
	public void update(SysUser sysuser);

	/**
	 * 更新系统用户状态
	 * @param id
	 * @param isValid
	 */
	public void updateStatus(@Param("id") int id, @Param("isValid") int isValid);
    
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
	SysUser selectByLoginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password,
			@Param("isValid") int isValid);
      
	
	public int selectStatus(@Param("loginName") String loginName);
}
