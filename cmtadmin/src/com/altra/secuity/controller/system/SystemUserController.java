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
import com.altra.secuity.model.system.SystemUser;
import com.altra.secuity.services.system.SystemUserServiceImpl;

@Controller
public class SystemUserController{
	@Resource
	private SystemUserServiceImpl systemUserServiceImpl;
	/**
	 * ADD管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemUser_add", method = RequestMethod.GET)
	public String systemUserAddIndex(HttpServletRequest request) {
		return "/modules/system/user/jsp/add";
	}

	/**
	 * EDIT管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemUser_edit", method = RequestMethod.GET)
	public String systemUserIndex(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("userId"));
		SystemUser systemUser;
		try {
			systemUser = systemUserServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("systemUser", systemUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/user/jsp/edit";
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/systemUser/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String listSystemUser(HttpServletRequest request, String pagination, String systemUser) {
		String json = "";
		try {
			SystemUser systemUserO = new SystemUser();
			// 判断是否有查询条�?
			if (ValidateUtil.isNullAndIsStr(systemUser)) {
				 systemUserO = JSON.parseObject(systemUser, SystemUser.class);
			}
			// 条件+分页查询
			json = systemUserServiceImpl.selectSystemUserByPage(systemUserO,PageUtil.getPageBean(request));
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
	@RequestMapping(value = "/systemUser/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String addSystemUser(HttpServletRequest request, String systemUser) {
		Json result = new Json();
		try {
			SystemUser systemUserO = JSON.parseObject(systemUser, SystemUser.class);
			result = systemUserServiceImpl.insertSelective(systemUserO);
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
	@RequestMapping(value = "/systemUser/edit", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String editSystemUser(HttpServletRequest request, String systemUser) {
		Json result = new Json();
		SystemUser systemUserO = JSON.parseObject(systemUser, SystemUser.class);
		try {
			result = systemUserServiceImpl.updateByPrimaryKeySelective(systemUserO);
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
	@RequestMapping(value = "/systemUser/del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String delSystemUser(HttpServletRequest request) {
		Json result = new Json();
		String key = request.getParameter("userId");
		try {
			result = systemUserServiceImpl.deleteBatchByPrimaryKey(key);
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
	@RequestMapping(value = "/systemUser/get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getSystemUser(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("userId"));
		SystemUser systemUser;
		try {
			systemUser = systemUserServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("systemUser", systemUser);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/user/jsp/detail";
	}

}