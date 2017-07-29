package com.altra.secuity.controller.logs;

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
import com.altra.secuity.model.logs.LogsRecords;
import com.altra.secuity.services.common.logback.LogBackServiceImpl;
import com.altra.secuity.services.logs.LogsRecordsServiceImpl;

@Controller
public class LogsRecordsController{
	@Resource
	private LogsRecordsServiceImpl logsRecordsServiceImpl;
	//日志管理
	@Resource
    private LogBackServiceImpl logBackServiceImpl;
	/**
	 * ADD管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logsRecords_add", method = RequestMethod.GET)
	public String logsRecordsAddIndex(HttpServletRequest request) {
		return "/modules/logs/records/jsp/add";
	}

	/**
	 * EDIT管理跳转
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logsRecords_edit", method = RequestMethod.GET)
	public String logsRecordsIndex(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("reId"));
		LogsRecords logsRecords;
		try {
			logsRecords = logsRecordsServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("logsRecords", logsRecords);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/logs/records/jsp/edit";
	}

	/**
	 * 查询
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/logsRecords/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String listLogsRecords(HttpServletRequest request, String pagination, String logsRecords) {
		String json = "";
		try {
			LogsRecords logsRecordsO = new LogsRecords();
			// 判断是否有查询条�?
			if (ValidateUtil.isNullAndIsStr(logsRecords)) {
				 logsRecordsO = JSON.parseObject(logsRecords, LogsRecords.class);
			}
			// 条件+分页查询
			json = logsRecordsServiceImpl.selectLogsRecordsByPage(logsRecordsO,PageUtil.getPageBean(request));
		} catch (Exception e) {
			Json result = new Json();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			json = JSONObject.toJSONString(result);
			//logback异常日志
			logBackServiceImpl.ExceptionLogBack("查询关键操作记录异常", e, false);
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
	@RequestMapping(value = "/logsRecords/edit", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String editLogsRecords(HttpServletRequest request, String logsRecords) {
		Json result = new Json();
		LogsRecords logsRecordsO = JSON.parseObject(logsRecords, LogsRecords.class);
		try {
			result = logsRecordsServiceImpl.updateByPrimaryKeySelective(logsRecordsO);
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
	@RequestMapping(value = "/logsRecords/del", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String delLogsRecords(HttpServletRequest request) {
		Json result = new Json();
		String key = request.getParameter("reId");
		try {
			result = logsRecordsServiceImpl.deleteBatchByPrimaryKey(key);
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
	@RequestMapping(value = "/logsRecords/get", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getLogsRecords(HttpServletRequest request) {
		long key = Long.parseLong(request.getParameter("reId"));
		LogsRecords logsRecords;
		try {
			logsRecords = logsRecordsServiceImpl.selectByPrimaryKey(key);
			request.setAttribute("logsRecords", logsRecords);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/modules/logs/records/jsp/detail";
	}

}