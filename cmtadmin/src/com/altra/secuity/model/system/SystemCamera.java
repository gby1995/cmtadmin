package com.altra.secuity.model.system;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SystemCamera implements Serializable{
	private Long scId;//	主键	bigint(20)
	private String scName;//	摄像头名称	varchar(100)
	private String scNum;//	设备序号	varchar(100)
	private Long scCorpId;//	所属单位id	bigint(20)
	private String scCorpName;//	所属单位名称	varchar(100)
	private Long scTopCorpId;//	顶级单位id	bigint(20)
	private String scTopCorpName;//	顶级单位名称	varchar(100)
	private String scSipNum;//	sip账号	varchar(100)
	private String scWebLink;//	web链接	varchar(300)
	private String scLoginName;//	平台网址用户名	varchar(100)
	private String scLoginPwd;//	平台网址密码	varchar(100)
	private String scNvrName;//	nvr网址用户名	varchar(100)
	private String scNvrPwd;//	nvr网址密码	varchar(100)
	private Integer scOrder;//	排序号	int(11)
	private String createTime;//	创建时间	datetime
	private SystemCorp corp_id;
	public SystemCorp getCorp_id() {
		return corp_id;
	}
	public void setCorp_id(SystemCorp corp_id) {
		this.corp_id = corp_id;
	}
	public Long getScId() {
		return scId;
	}
	public void setScId(Long scId) {
		this.scId = scId;
	}
	public String getScName() {
		return scName;
	}
	public void setScName(String scName) {
		this.scName = scName;
	}
	public String getScNum() {
		return scNum;
	}
	public void setScNum(String scNum) {
		this.scNum = scNum;
	}
	public Long getScCorpId() {
		return scCorpId;
	}
	public void setScCorpId(Long scCorpId) {
		this.scCorpId = scCorpId;
	}
	public String getScCorpName() {
		return scCorpName;
	}
	public void setScCorpName(String scCorpName) {
		this.scCorpName = scCorpName;
	}
	public Long getScTopCorpId() {
		return scTopCorpId;
	}
	public void setScTopCorpId(Long scTopCorpId) {
		this.scTopCorpId = scTopCorpId;
	}
	public String getScTopCorpName() {
		return scTopCorpName;
	}
	public void setScTopCorpName(String scTopCorpName) {
		this.scTopCorpName = scTopCorpName;
	}
	public String getScSipNum() {
		return scSipNum;
	}
	public void setScSipNum(String scSipNum) {
		this.scSipNum = scSipNum;
	}
	public String getScWebLink() {
		return scWebLink;
	}
	public void setScWebLink(String scWebLink) {
		this.scWebLink = scWebLink;
	}
	public String getScLoginName() {
		return scLoginName;
	}
	public void setScLoginName(String scLoginName) {
		this.scLoginName = scLoginName;
	}
	public String getScLoginPwd() {
		return scLoginPwd;
	}
	public void setScLoginPwd(String scLoginPwd) {
		this.scLoginPwd = scLoginPwd;
	}
	public String getScNvrName() {
		return scNvrName;
	}
	public void setScNvrName(String scNvrName) {
		this.scNvrName = scNvrName;
	}
	public String getScNvrPwd() {
		return scNvrPwd;
	}
	public void setScNvrPwd(String scNvrPwd) {
		this.scNvrPwd = scNvrPwd;
	}
	public Integer getScOrder() {
		return scOrder;
	}
	public void setScOrder(Integer scOrder) {
		this.scOrder = scOrder;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
	
}
