package com.altra.secuity.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.altra.common.util.page.Json;
import com.altra.common.util.spring.RequestUtil;
import com.altra.secuity.model.system.SystemUser;
import com.altra.secuity.services.common.logback.LogBackServiceImpl;
import com.altra.secuity.services.common.tree.ActionTreeServiceImpl;
import com.altra.secuity.services.common.tree.MonitorTreeServiceImpl;

/**
 * 通用模块
 * 树模块
 * 
 */
@Controller
public class TreeController {
	// 系统管理/权限管理service层
	// 权限菜单树
	@Resource
	private ActionTreeServiceImpl actionTreeServiceImpl;
	@Resource
	private MonitorTreeServiceImpl monitorTreeServiceImpl;
	//日志管理
	@Resource
	private LogBackServiceImpl logBackServiceImpl;
	
	
	/**
	 * 角色树查询-全部加载
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/common/getActionTreeAll", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String getCarTreeAll(HttpServletRequest request) {
		//取出所选角色id
		String key = String.valueOf(request.getSession().getAttribute("ROLEID"));
		
		if(key!=null && !(key.equals("")) && !(key.equals("null"))){
			request.getSession().removeAttribute("ROLEID");
		}else{
		}
		String json = "";
		try {  
			// 获取当前用户
			SystemUser account = RequestUtil.getAccount(request);
			json =  actionTreeServiceImpl.selectTreeNodeByUser(account);
		} catch (Exception e) {
			Json result = new Json();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			json = JSONObject.toJSONString(result);
			//logback异常日志
			logBackServiceImpl.ExceptionLogBack("获取权限树菜单异常", e, false);
			e.printStackTrace();
		}
		return json;	
	}
	
	/**
	 * 企业->危险源->设备树查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/common/getHarzardTree", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String getHarzardTreeAll(HttpServletRequest request,String id) {
		String json = "";
		try {  
			if(id != null && !"".equals(id)){
				// 获取二级设备树
				json = monitorTreeServiceImpl.getDevTree(Long.parseLong(id));
			}else{
//				// 获取当前公司ID
//				CorpInfo corp  =(CorpInfo) request.getSession().getAttribute("corpInfo");
//				// 获取一级危险源树
//				json = monitorTreeServiceImpl.getHarzardTree(corp.getCorpId());
			}
		} catch (Exception e) {
			Json result = new Json();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			json = JSONObject.toJSONString(result);
			//logback异常日志
			logBackServiceImpl.ExceptionLogBack("获取设备树异常", e, false);
			e.printStackTrace();
		}
		return json;	
	}
	
	/**
	 * 企业树查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/common/gettopCorpTree", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String gettopCorpTree(HttpServletRequest request,String id) {
		String json = "";
		try {  
			// 获取企业树
			json = monitorTreeServiceImpl.gettopCorpTree(0l);
		} catch (Exception e) {
			Json result = new Json();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			json = JSONObject.toJSONString(result);
			//logback日志
			logBackServiceImpl.ExceptionLogBack("企业树查询异常", e, false);
			e.printStackTrace();
		}
		return json;	
	}
	
	/**
	 * 企业->危险源->设备树查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/common/getDeviceTree", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String getDeviceTreeAll(HttpServletRequest request,String id,String pid) {
		String json = "";
		try {  
			json = monitorTreeServiceImpl.gettopCorpTree(Long.parseLong(id));
		} catch (Exception e) {
			Json result = new Json();
			result.setMsg(Json.EXCEPTION);
			result.setSuccess(false);
			json = JSONObject.toJSONString(result);
			//logback日志
			logBackServiceImpl.ExceptionLogBack("树查询异常", e, false);
			e.printStackTrace();
		}
		return json;	
	}
}
