package com.altra.secuity.model.system;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SystemRole implements Serializable{
	
	private Long srId;//	主键	bigint(20)
	private String srCode;//	角色编码	varchar(100)
	private String srName;//	角色名称	varchar(100)
	
	public Long getSrId() {
		return srId;
	}
	public void setSrId(Long srId) {
		this.srId = srId;
	}
	public String getSrCode() {
		return srCode;
	}
	public void setSrCode(String srCode) {
		this.srCode = srCode;
	}
	public String getSrName() {
		return srName;
	}
	public void setSrName(String srName) {
		this.srName = srName;
	}
	
	
}
