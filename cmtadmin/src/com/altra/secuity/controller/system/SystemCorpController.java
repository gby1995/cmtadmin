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
import com.altra.secuity.model.system.SystemCorp;
import com.altra.secuity.services.system.SystemCorpServiceImpl;


@Controller
public class SystemCorpController{
	@Resource
	private SystemCorpServiceImpl systemCorpServiceImpl;
	/**
	 * ADD管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemCorp_add", method = RequestMethod.GET)
	public String systemCorpAddIndex(HttpServletRequest request) {
		return "/modules/system/corp/jsp/add";
	}

	/**
	 * EDIT管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemCorp_edit", method = RequestMethod.GET)
	public String systemCorpIndex(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("scId"));
		SystemCorp systemCorp;
		try {
			systemCorp = systemCorpServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("systemCorp", systemCorp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/corp/jsp/edit";
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/systemCorp/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String listSystemCorp(HttpServletRequest request, String pagination, String systemCorp) {
		String json = "";
		try {
			SystemCorp systemCorpO = new SystemCorp();
			// 判断是否有查询条�?
			if (ValidateUtil.isNullAndIsStr(systemCorp)) {
				 systemCorpO = JSON.parseObject(systemCorp, SystemCorp.class);
			}
			// 条件+分页查询
			json = systemCorpServiceImpl.selectSystemCorpByPage(systemCorpO,PageUtil.getPageBean(request));
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
	@RequestMapping(value = "/systemCorp/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String addSystemCorp(HttpServletRequest request, String systemCorp) {
		Json result = new Json();
		try {
			SystemCorp systemCorpO = JSON.parseObject(systemCorp, SystemCorp.class);
			result = systemCorpServiceImpl.insertSelective(systemCorpO);
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
	@RequestMapping(value = "/systemCorp/edit", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String editSystemCorp(HttpServletRequest request, String systemCorp) {
		Json result = new Json();
		SystemCorp systemCorpO = JSON.parseObject(systemCorp, SystemCorp.class);
		try {
			result = systemCorpServiceImpl.updateByPrimaryKeySelective(systemCorpO);
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
	@RequestMapping(value = "/systemCorp/del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String delSystemCorp(HttpServletRequest request) {
		Json result = new Json();
		String key = request.getParameter("scId");
		try {
			result = systemCorpServiceImpl.deleteBatchByPrimaryKey(key);
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
	@RequestMapping(value = "/systemCorp/get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getSystemCorp(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("scId"));
		SystemCorp systemCorp;
		try {
			systemCorp = systemCorpServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("systemCorp", systemCorp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/corp/jsp/detail";
	}

}