package com.altra.secuity.controller.system;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.altra.common.util.page.ValidateUtil;
import com.altra.common.util.page.PageUtil;
import com.altra.common.util.page.Json;
import com.altra.secuity.model.system.SystemRole;
import com.altra.secuity.services.system.SystemRoleServiceImpl;

@Controller
public class SystemRoleController{
	@Resource
	private SystemRoleServiceImpl systemRoleServiceImpl;
	/**
	 * ADD管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemRole_add", method = RequestMethod.GET)
	public String systemRoleAddIndex(HttpServletRequest request) {
		return "/modules/system/role/jsp/add";
	}

	/**
	 * EDIT管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemRole_edit", method = RequestMethod.GET)
	public String systemRoleIndex(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("srId"));
		SystemRole systemRole;
		try {
			systemRole = systemRoleServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("systemRole", systemRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/role/jsp/edit";
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/systemRole/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String listSystemRole(HttpServletRequest request, String pagination, String systemRole) {
		String json = "";
		try {
			SystemRole systemRoleO = new SystemRole();
			// 判断是否有查询条�?
			if (ValidateUtil.isNullAndIsStr(systemRole)) {
				 systemRoleO = JSON.parseObject(systemRole, SystemRole.class);
			}
			// 条件+分页查询
			json = systemRoleServiceImpl.selectSystemRoleByPage(systemRoleO,PageUtil.getPageBean(request));
		} catch (Exception e) {
			Json result = new Json();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			json = JSONObject.toJSONString(result);
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 新增
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/systemRole/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String addSystemRole(HttpServletRequest request, String systemRole) {
		Json result = new Json();
		try {
			SystemRole systemRoleO = JSON.parseObject(systemRole, SystemRole.class);
			result = systemRoleServiceImpl.insertSelective(systemRoleO);
		} catch (Exception e) {
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			e.printStackTrace();
		}
		return JSONObject.toJSONString(result);
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/systemRole/edit", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String editSystemRole(HttpServletRequest request, String systemRole) {
		Json result = new Json();
		SystemRole systemRoleO = JSON.parseObject(systemRole, SystemRole.class);
		try {
			result = systemRoleServiceImpl.updateByPrimaryKeySelective(systemRoleO);
		} catch (Exception e) {
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			e.printStackTrace();
		}
		return JSONObject.toJSONString(result);
	}

	/**
	 * 删除
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/systemRole/del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String delSystemRole(HttpServletRequest request) {
		Json result = new Json();
		String key = request.getParameter("srId");
		try {
			result = systemRoleServiceImpl.deleteBatchByPrimaryKey(key);
		} catch (Exception e) {
			e.printStackTrace();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			e.printStackTrace();
		}
		return JSONObject.toJSONString(result);
	}

	/**
	 * 获取
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemRole/get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getSystemRole(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("srId"));
		SystemRole systemRole;
		try {
			systemRole = systemRoleServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("systemRole", systemRole);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/role/jsp/detail";
	}
	
	/**
	 * 查询角色(与用户，权限联查)
	 * @author liuben
	 * @date 2016.02.14
	 * @return json
	 */
	@ResponseBody
	@RequestMapping(value = "/systemRole/listAction", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String listSystemRoleByAction(HttpServletRequest request, String pagination, String systemRole, String role) {
		String json = "";
		String likeName = null;
		try {
			if (role != null && role.length() > 5) {
				likeName = JSON.parseObject(role).getString("likeName");
			}
			
			SystemRole systemRoleO = new SystemRole();
			// 判断是否有查询条�?
			if (ValidateUtil.isNullAndIsStr(systemRole)) {
				 systemRoleO = JSON.parseObject(systemRole, SystemRole.class);
			}
			systemRoleO.setSrCode(likeName);
			systemRoleO.setSrName(likeName);
			// 条件+分页查询
			json = systemRoleServiceImpl.selectSystemRoleByPageByAction(systemRoleO,PageUtil.getPageBean(request));
		} catch (Exception e) {
			Json result = new Json();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			json = JSONObject.toJSONString(result);
			e.printStackTrace();
		}
		return json;
	}

}