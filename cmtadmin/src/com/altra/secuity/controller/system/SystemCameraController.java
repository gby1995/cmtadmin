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
import com.altra.secuity.model.system.SystemCamera;
import com.altra.secuity.services.system.SystemCameraServiceImpl;

@Controller
public class SystemCameraController{
	@Resource
	private SystemCameraServiceImpl systemCameraServiceImpl;
	/**
	 * ADD管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemCamera_add", method = RequestMethod.GET)
	public String systemCameraAddIndex(HttpServletRequest request) {
		return "/modules/system/camera/jsp/add";
	}

	/**
	 * EDIT管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/systemCamera_edit", method = RequestMethod.GET)
	public String systemCameraIndex(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("scId"));
		SystemCamera systemCamera;
		try {
			systemCamera = systemCameraServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("systemCamera", systemCamera);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/camera/jsp/edit";
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/systemCamera/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String listSystemCamera(HttpServletRequest request, String pagination, String systemCamera) {
		String json = "";
		try {
			SystemCamera systemCameraO = new SystemCamera();
			// 判断是否有查询条�?
			if (ValidateUtil.isNullAndIsStr(systemCamera)) {
				 systemCameraO = JSON.parseObject(systemCamera, SystemCamera.class);
			}
			// 条件+分页查询
			json = systemCameraServiceImpl.selectSystemCameraByPage(systemCameraO,PageUtil.getPageBean(request));
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
	@RequestMapping(value = "/systemCamera/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String addSystemCamera(HttpServletRequest request, String systemCamera) {
		Json result = new Json();
		try {
			SystemCamera systemCameraO = JSON.parseObject(systemCamera, SystemCamera.class);
			result = systemCameraServiceImpl.insertSelective(systemCameraO);
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
	@RequestMapping(value = "/systemCamera/edit", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String editSystemCamera(HttpServletRequest request, String systemCamera) {
		Json result = new Json();
		SystemCamera systemCameraO = JSON.parseObject(systemCamera, SystemCamera.class);
		try {
			result = systemCameraServiceImpl.updateByPrimaryKeySelective(systemCameraO);
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
	@RequestMapping(value = "/systemCamera/del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String delSystemCamera(HttpServletRequest request) {
		Json result = new Json();
		String key = request.getParameter("scId");
		try {
			result = systemCameraServiceImpl.deleteBatchByPrimaryKey(key);
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
	@RequestMapping(value = "/systemCamera/get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getSystemCamera(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("scId"));
		SystemCamera systemCamera;
		try {
			systemCamera = systemCameraServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("systemCamera", systemCamera);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/camera/jsp/detail";
	}

}