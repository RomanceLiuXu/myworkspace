package com.misu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.misu.bean.Role;
import com.misu.mapper.RoleMapper;

/**
 *
 * @author LiuXu
 * @version 2018年10月4日上午11:19:17
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;

	@Override
	public List<Role> selectAll() {

		return roleMapper.selectAll();
	}

}
