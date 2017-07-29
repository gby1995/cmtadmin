package com.altra.secuity.controller.common;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.altra.common.util.error.ErrorCodes;
import com.altra.secuity.services.common.logback.LogBackServiceImpl;

/**
 * 公共模块 --弹出窗口、下拉框查询、树等功能

 * 
 */
@Controller
public class CommonController {
	//日志管理
	@Resource
    private LogBackServiceImpl logBackServiceImpl;
	/**
	 * 弹出窗口
	 * 
	 * @author baitao
	 * @date 2016.7.9
	 * @return 系统管理主界面
	 */
	@RequestMapping(value = "/common/openWin", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String openWin(HttpServletRequest request, String name,String row,String id) {
		try {
			// 根据类型跳转相应弹出界面
			request.setAttribute("name", name);
			// 根据类型跳转相应弹出界面
			request.setAttribute("row", row);
			// 根据类型跳转相应弹出界面
			request.setAttribute("id", id);
			return "/modules/common/wins/jsp/pageWins";
		} catch (Exception e) {
			// 异常返回异常界面
			e.printStackTrace();
			//logback异常日志
			logBackServiceImpl.ExceptionLogBack("公共模块--弹出框异常", e, false);
			return ErrorCodes.EXCEPTION_ERROR;
		}
	}
}
