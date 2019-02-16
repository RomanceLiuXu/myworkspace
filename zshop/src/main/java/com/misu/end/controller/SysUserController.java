package com.misu.end.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.misu.bean.Role;
import com.misu.bean.SysUser;
import com.misu.common.OperationMessage;
import com.misu.common.PageConstant;
import com.misu.common.SysuserParam;
import com.misu.common.SysuserVo;
import com.misu.service.RoleService;
import com.misu.service.SysUserService;

/**
 *
 * @author LiuXu
 * @version 2018年10月4日上午11:20:51
 */
@Controller
@RequestMapping("backend/sysuser")
public class SysUserController {

	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private OperationMessage message;
	@Autowired
	private RoleService roleService;

	@ModelAttribute("roles")
	public List<Role> selectRoles() {
		return roleService.selectAll();
	}

	@RequestMapping("findAll")
	public String findAllSysuser(Integer pageIndex, Model model, SysuserParam params) {
		System.out.println("----------------------------------------------");
		System.out.println("传入的查询参数:" + params);
		if (ObjectUtils.isEmpty(pageIndex)) {
			pageIndex = PageConstant.pageIndex;
		}
		PageHelper.startPage(pageIndex, PageConstant.pageNum);
		List<SysUser> sysUsers = sysUserService.selectByParams(params);
		for (SysUser sysUser : sysUsers) {
			System.out.println(sysUser);
		}
		PageInfo<SysUser> pageInfo = new PageInfo<>(sysUsers);
		model.addAttribute("pageInfo", pageInfo);
		return "backend/sysuserManager";
	}

	@RequestMapping("addSysuser")
	public String addSysuser(SysuserVo sysuserVo) {
		System.out.println("添加传入参数:"+sysuserVo);
		try {
			sysUserService.insert(sysuserVo);
			message.setStatus(1);
			message.setMessage("添加成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("添加失败");
		}
		System.out.println("massage:"+message);
		return "redirect:findAll";
	}

	@RequestMapping("showSysuser")
	@ResponseBody
	public SysUser showSysuser(Integer id) {
		return sysUserService.selectById(id);
	}

	@RequestMapping("updateSysuser")
	@ResponseBody
	public OperationMessage updateSysuser(SysuserVo sysuserVo) {
		try {
			sysUserService.update(sysuserVo);
			message.setStatus(1);
			message.setMessage("修改成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("修改失败");
		}
		return message;
	}

	@RequestMapping("updateStatus")
	@ResponseBody
	public OperationMessage updateSysuserStatus(Integer id, Integer isValid) {
		try {
			sysUserService.updateStatus(id, isValid);
			message.setStatus(1);
			message.setMessage("更新成功");
		} catch (Exception e) {
			message.setStatus(0);
			message.setMessage("更新失败");
		}
		return message;
	}

}
