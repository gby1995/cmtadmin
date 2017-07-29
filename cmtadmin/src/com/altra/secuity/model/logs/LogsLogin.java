package com.altra.secuity.model.logs;

import java.io.Serializable;
/**
 * 登陆记录实体类
 * @author liuben 2017-03-21
 */
public class LogsLogin implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long loginId;//主键
	
	private String loginDate;//登陆日期
	
	private String loginName;//用户登录名
	
	private String loginRole;//登录角色
	
	private String loginContent;//登录内容
	
	private Long corpId;//企业主键
	
	private String firDate;//开始时间
	
	private String secDate;//结束时间
	
	private final static String LOGIN = "登录";
	
	private final static String LEAVE= "离开";
	
	public LogsLogin() {
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(String loginDate) {
		this.loginDate = loginDate;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginRole() {
		return loginRole;
	}

	public void setLoginRole(String loginRole) {
		this.loginRole = loginRole;
	}

	public String getLoginContent() {
		return loginContent;
	}

	public void setLoginContent(String loginContent) {
		this.loginContent = loginContent;
	}

	public Long getCorpId() {
		return corpId;
	}

	public void setCorpId(Long corpId) {
		this.corpId = corpId;
	}

	public String getFirDate() {
		return firDate;
	}

	public void setFirDate(String firDate) {
		this.firDate = firDate;
	}

	public String getSecDate() {
		return secDate;
	}

	public void setSecDate(String secDate) {
		this.secDate = secDate;
	}

	public static String getLogin() {
		return LOGIN;
	}

	public static String getLeave() {
		return LEAVE;
	}
	
	
	
	

}
