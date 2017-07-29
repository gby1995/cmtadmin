package com.altra.secuity.model.system;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SystemCorp implements Serializable{
	
	private Long scId;//	主键	bigint(20)
	private String scName;//	公司名称	varchar(100)
	private String scShortName;//	公司简称	varchar(100)
	private String scPid;//	上级单位id	bigint(20)
	private String scPname;//	上级单位名称	varchar(100)
	private String scTopId;//	顶级单位id	bigint(20)
	private String scTopName;//	顶级单位名称	varchar(100)
	private String scCity;//	所在城市	varchar(100)
	private String scProvince;//	所在省份	varchar(100)
	private String scAddress;//	地址	varchar(200)
	private String scInfo;//	公司简介	varchar(5000)
	private String scUserInfo;//	员工情况	varchar(100)
	private String scHolding;//	中远海控股情况	varchar(100)
	private String scSafeResponsib;//	是否安全主题责任	varchar(100)
	private String scAntiRisk;//	安全中电防控风险	varchar(100)
	private String scIsChemical;//	是否涉及危化品 0 否  1是	varchar(10)
	private String scChemicalInfo;//	所涉及危化品详情	varchar(200)
	private String scIsHazard;//	是否重大危险源 0 否  1是	varchar(10)
	private String scHazardInfo;//	危险源详情	varchar(200)
	private String scLongitude;//	经度	varchar(50)
	private String scLatitude;//	纬度	varchar(50)
	private String scSipNum;//	sip账号	varchar(50)
	private String scOrder;//	排序号	int(11)
	private String createTime;//	创建时间	datetime
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
	public String getScShortName() {
		return scShortName;
	}
	public void setScShortName(String scShortName) {
		this.scShortName = scShortName;
	}
	public String getScPid() {
		return scPid;
	}
	public void setScPid(String scPid) {
		this.scPid = scPid;
	}
	public String getScPname() {
		return scPname;
	}
	public void setScPname(String scPname) {
		this.scPname = scPname;
	}
	public String getScTopId() {
		return scTopId;
	}
	public void setScTopId(String scTopId) {
		this.scTopId = scTopId;
	}
	public String getScTopName() {
		return scTopName;
	}
	public void setScTopName(String scTopName) {
		this.scTopName = scTopName;
	}
	public String getScCity() {
		return scCity;
	}
	public void setScCity(String scCity) {
		this.scCity = scCity;
	}
	public String getScProvince() {
		return scProvince;
	}
	public void setScProvince(String scProvince) {
		this.scProvince = scProvince;
	}
	public String getScAddress() {
		return scAddress;
	}
	public void setScAddress(String scAddress) {
		this.scAddress = scAddress;
	}
	public String getScInfo() {
		return scInfo;
	}
	public void setScInfo(String scInfo) {
		this.scInfo = scInfo;
	}
	public String getScUserInfo() {
		return scUserInfo;
	}
	public void setScUserInfo(String scUserInfo) {
		this.scUserInfo = scUserInfo;
	}
	public String getScHolding() {
		return scHolding;
	}
	public void setScHolding(String scHolding) {
		this.scHolding = scHolding;
	}
	public String getScSafeResponsib() {
		return scSafeResponsib;
	}
	public void setScSafeResponsib(String scSafeResponsib) {
		this.scSafeResponsib = scSafeResponsib;
	}
	public String getScAntiRisk() {
		return scAntiRisk;
	}
	public void setScAntiRisk(String scAntiRisk) {
		this.scAntiRisk = scAntiRisk;
	}
	public String getScIsChemical() {
		return scIsChemical;
	}
	public void setScIsChemical(String scIsChemical) {
		this.scIsChemical = scIsChemical;
	}
	public String getScChemicalInfo() {
		return scChemicalInfo;
	}
	public void setScChemicalInfo(String scChemicalInfo) {
		this.scChemicalInfo = scChemicalInfo;
	}
	public String getScIsHazard() {
		return scIsHazard;
	}
	public void setScIsHazard(String scIsHazard) {
		this.scIsHazard = scIsHazard;
	}
	public String getScHazardInfo() {
		return scHazardInfo;
	}
	public void setScHazardInfo(String scHazardInfo) {
		this.scHazardInfo = scHazardInfo;
	}
	public String getScLongitude() {
		return scLongitude;
	}
	public void setScLongitude(String scLongitude) {
		this.scLongitude = scLongitude;
	}
	public String getScLatitude() {
		return scLatitude;
	}
	public void setScLatitude(String scLatitude) {
		this.scLatitude = scLatitude;
	}
	public String getScSipNum() {
		return scSipNum;
	}
	public void setScSipNum(String scSipNum) {
		this.scSipNum = scSipNum;
	}
	public String getScOrder() {
		return scOrder;
	}
	public void setScOrder(String scOrder) {
		this.scOrder = scOrder;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
