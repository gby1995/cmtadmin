package com.altra.secuity.model.system;

import java.io.Serializable;

public class SystemAction implements Serializable{
	/**
	 * 权限管理实体类
	 * @author benben 2016-02-13
	 */
	
	private static final long serialVersionUID = -9163100173344475239L;
	
	private Long actId;//功能权限id
	
	private String actName;//功能权限名称；
	
	private Long actParentId;//功能父节点；
	
	private Long actOrder;//功能顺序；
	
	private String actUrl;//菜单地址；
	
	private String actCommon;//功能备注；
	
	private Integer actType;//类型（0：企业 1：安监）
	
	private String actIcon;//菜单图标
	
	public SystemAction() {
	}

	public Long getActId() {
		return actId;
	}

	public void setActId(Long actId) {
		this.actId = actId;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public Long getActParentId() {
		return actParentId;
	}

	public void setActParentId(Long actParentId) {
		this.actParentId = actParentId;
	}

	public Long getActOrder() {
		return actOrder;
	}

	public void setActOrder(Long actOrder) {
		this.actOrder = actOrder;
	}

	public String getActUrl() {
		return actUrl;
	}

	public void setActUrl(String actUrl) {
		this.actUrl = actUrl;
	}

	public String getActCommon() {
		return actCommon;
	}

	public void setActCommon(String actCommon) {
		this.actCommon = actCommon;
	}

	public Integer getActType() {
		return actType;
	}

	public void setActType(Integer actType) {
		this.actType = actType;
	}

	public String getActIcon() {
		return actIcon;
	}

	public void setActIcon(String actIcon) {
		this.actIcon = actIcon;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
