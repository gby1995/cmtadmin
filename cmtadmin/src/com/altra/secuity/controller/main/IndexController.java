package com.altra.secuity.controller.main;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.altra.common.util.error.ErrorCodes;
import com.altra.common.util.error.LoginErrorCodes;
import com.altra.common.util.spring.RequestUtil;
import com.altra.secuity.model.common.MenuBean;
import com.altra.secuity.model.system.SystemUser;
import com.altra.secuity.services.common.logback.LogBackServiceImpl;
import com.altra.secuity.services.common.menu.MenuServiceImpl;
import com.altra.secuity.services.logs.LogsLoginServiceImpl;
import com.altra.secuity.services.system.SystemUserServiceImpl;

/**
 * 主模块 --登录入口、主界面跳转等功能
 *
 */
@Controller
public class IndexController {

	// 系统管理/用户管理service层
	@Resource
	private SystemUserServiceImpl systemUserServiceImpl;
	@Resource
	private MenuServiceImpl menuServiceImpl;
	// 登录日志service层
	@Resource
	private LogsLoginServiceImpl logsLoginServiceImpl;
	//日志管理
	@Resource
    private LogBackServiceImpl logBackServiceImpl;

	/**
	 * 登录方法
	 * @return 系统管理主界面
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, String systemUser) {
		SystemUser systemUser2 = null;
		try {
			SystemUser systemUser1 = JSON.parseObject(systemUser, SystemUser.class);
			systemUser1.setUserPassword(systemUser1.getPassword());
			// 根据密码登录,返回用户对象，判断密码和用户名是否正确
			systemUser2 = systemUserServiceImpl.selectUserByPwd(systemUser1);
			if (systemUser2 != null) {
				// 登录后加入登录缓存 1.一级菜单缓存 2.二级菜单缓存
				// 动态获取一级菜单
				List<MenuBean> menus = menuServiceImpl.selectMenusByUser(systemUser2);
				request.getSession().setAttribute("menus", menus);
				//登录成功通过登录信息查询该用户所属企业
				request.getSession().setAttribute("systemUser", systemUser2);
				
				// 登录成功跳转系统管理主界面
				return "main_index";
			} else {
				// 用户名错误
				return LoginErrorCodes.USERNAME_ERROR;
			}
		} catch (Exception e) {
			//  异常返回异常界面
			e.printStackTrace();
			//logback异常日志
			logBackServiceImpl.ExceptionLogBack("登录异常", e, false);
			return ErrorCodes.EXCEPTION_ERROR;
		}
	}
	/**
	 * 登录成功跳转
	 * @return 系统管理主界面
	 */
	@RequestMapping(value = "main_index", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String main_index(HttpServletRequest request, String account) {
		 return "modules/common/main/jsp/main";
	}
	
	
	/**
	 * 用户注销
	 * @return 系统管理主界面
	 */
	@SuppressWarnings("unused")
	@RequestMapping(value = "cancellation", method = RequestMethod.POST)
	public String cancellation(HttpServletRequest request, String account) {
		//取出用户信息
		
		SystemUser systemUser = RequestUtil.getAccount(request);
		try {
			
			request.getSession().removeAttribute("systemUser");
			return "index";
		} catch (Exception e) {
			e.printStackTrace();
			//logback异常日志
			logBackServiceImpl.ExceptionLogBack("用户注销异常", e, false);
			return ErrorCodes.EXCEPTION_ERROR;
		}

	}
}
