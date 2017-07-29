package com.altra.secuity.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.altra.common.util.page.Json;
import com.altra.secuity.model.system.SystemUser;
import com.altra.secuity.services.common.logback.LogBackServiceImpl;
import com.altra.secuity.services.common.menu.MenuServiceImpl;

/**
 * 菜单树功能
 */
@Controller
public class MenuController {
	@Resource
	private MenuServiceImpl menuServiceImpl;
	//日志管理
	@Resource
	private LogBackServiceImpl logBackServiceImpl;
	/**
	 * 获取二级菜单
	 * @return 系统管理主界面
	 */
	@ResponseBody
	@RequestMapping(value = "/common/menu_childs", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	public String menuChilds(HttpServletRequest request, String pid) {
		String json = "";
			try {  
				// 根据类型跳转相应弹出界面
				SystemUser systemUser = (SystemUser) request.getSession().getAttribute("systemUser");
				json =menuServiceImpl.selectChildMenusByUser(systemUser, pid);
			} catch (Exception e) {
				Json result = new Json();
				result.setMsg(Json.EXCEPTION);
				result.setSuccess(false);
				json = JSONObject.toJSONString(result);
				//logback异常日志
				logBackServiceImpl.ExceptionLogBack("获取二级菜单异常", e, false);
				e.printStackTrace();
			}
			return json;
	}
}
