package com.altra.secuity.controller.logs;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.altra.common.util.page.Json;
import com.altra.common.util.page.PageUtil;
import com.altra.common.util.page.ValidateUtil;
import com.altra.secuity.model.logs.LogsLogin;
import com.altra.secuity.services.common.logback.LogBackServiceImpl;
import com.altra.secuity.services.logs.LogsLoginServiceImpl;

@Controller
public class LogsLoginController{
	//日志管理
	@Resource
    private LogBackServiceImpl logBackServiceImpl;
	@Resource
	private LogsLoginServiceImpl logsLoginServiceImpl;
	/**
	 * ADD管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logsLogin_add", method = RequestMethod.GET)
	public String logsLoginAddIndex(HttpServletRequest request) {
		return "/modules/logs/login/jsp/add";
	}

	/**
	 * EDIT管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logsLogin_edit", method = RequestMethod.GET)
	public String logsLoginIndex(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("loginId"));
		LogsLogin logsLogin;
		try {
			logsLogin = logsLoginServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("logsLogin", logsLogin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/logs/login/jsp/edit";
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logsLogin/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String listLogsLogin(HttpServletRequest request, String pagination, String logsLogin) {
		String json = "";
		try {
			LogsLogin logsLoginO = new LogsLogin();
			// 判断是否有查询条�?
			if (ValidateUtil.isNullAndIsStr(logsLogin)) {
				 logsLoginO = JSON.parseObject(logsLogin, LogsLogin.class);
			}
			
			// 条件+分页查询
			json = logsLoginServiceImpl.selectLogsLoginByPage(logsLoginO,PageUtil.getPageBean(request));
		} catch (Exception e) {
			Json result = new Json();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			json = JSONObject.toJSONString(result);
			//logback异常日志
			logBackServiceImpl.ExceptionLogBack("查询登录记录异常", e, false);
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * 修改
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logsLogin/edit", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String editLogsLogin(HttpServletRequest request, String logsLogin) {
		Json result = new Json();
		LogsLogin logsLoginO = JSON.parseObject(logsLogin, LogsLogin.class);
		try {
			result = logsLoginServiceImpl.updateByPrimaryKeySelective(logsLoginO);
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
	@RequestMapping(value = "/logsLogin/del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String delLogsLogin(HttpServletRequest request) {
		Json result = new Json();
		String key = request.getParameter("loginId");
		try {
			result = logsLoginServiceImpl.deleteBatchByPrimaryKey(key);
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
	@RequestMapping(value = "/logsLogin/get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getLogsLogin(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("loginId"));
		LogsLogin logsLogin;
		try {
			logsLogin = logsLoginServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("logsLogin", logsLogin);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/system/login/jsp/detail";
	}

}