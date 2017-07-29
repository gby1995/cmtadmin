package com.altra.secuity.model.logs;

import java.io.Serializable;

/**
 * 登陆记录实体类
 * @author liuben 2017-03-21
 */
public class LogsRecords implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long reId;//主键
	
	private String reDate;//操作日期
	
	private String reName;//操作用户
	
	private String reRole;//操作角色
	
	private String reType;//操作类型
	
	private String reContent;//操作内容
	
	private Long corpId;//企业主键
	
	private String firDate;//开始日期
	
	private String secDate;//结束日期
	
	public LogsRecords() {
	}

	public Long getReId() {
		return reId;
	}

	public void setReId(Long reId) {
		this.reId = reId;
	}

	public String getReDate() {
		return reDate;
	}

	public void setReDate(String reDate) {
		this.reDate = reDate;
	}

	public String getReName() {
		return reName;
	}

	public void setReName(String reName) {
		this.reName = reName;
	}

	public String getReRole() {
		return reRole;
	}

	public void setReRole(String reRole) {
		this.reRole = reRole;
	}

	public String getReType() {
		return reType;
	}

	public void setReType(String reType) {
		this.reType = reType;
	}

	public String getReContent() {
		return reContent;
	}

	public void setReContent(String reContent) {
		this.reContent = reContent;
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
	
	

}
