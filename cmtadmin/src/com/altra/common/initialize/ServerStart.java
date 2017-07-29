package com.altra.common.initialize;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.altra.common.util.redis.Constants;
import com.altra.secuity.initialize.InitializeCache;
/**
 * 系统初始化开始
 * 
 */
public class ServerStart extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		// 配置文件加载
		Constants.REDIS_IP=Configuration.getReourcesV("redis_ip");
		Constants.REDIS_PORT=Integer.parseInt(Configuration.getReourcesV("redis_port"));
		// 2.配置文件加载
		Constants.uploadServerPath = Configuration.getReourcesV("upload");
		// 业务数据初始化加载
		new InitializeCache().initialize();
	}

}
