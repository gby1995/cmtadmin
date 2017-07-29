package com.altra.secuity.model.system;

import java.io.Serializable;

public class SystemUser implements Serializable{
	
	private static final long serialVersionUID = -1749527906682694498L;
	
	private Long userId;//	用户主键	bigint(20)
	private String userName;//	用户名	varchar(50)
	private String userPassword;//	密码	varchar(50)
	private String userRealName;//	真实名称	varchar(50)
	private String userSex;//	性别	varchar(10)
	private String userBirth;//	出生日期	varchar(50)
	private String userNum;//	工号	varchar(50)
	private String userTelWork;//	办公电话	varchar(20)
	private String userTelHome;//	家庭电话	varchar(20)
	private String userTelMobile;//	手机号码	varchar(20)
	private String userSipNum;//	sip账号;//	varchar(20)
	private String userSipFront;//	SIP号段-前	varchar(20)
	private String userSipBack;//	SIP号段-后	varchar(20)
	private Integer userSipLevel;//	号码等级	int(11)
	private Long userDeptId;//	部门表外键	bigint(20)
	private String userDeptName;//	部门名称	varchar(100)
	private Long userRoleId;//	角色id	bigint(20)
	private String userRoleName;//	角色名称	varchar(100)
	private String userPost;//	职务	varchar(50)
	
	private String password;//虚拟字段页面传值用的
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserBirth() {
		return userBirth;
	}
	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}
	public String getUserNum() {
		return userNum;
	}
	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}
	public String getUserTelWork() {
		return userTelWork;
	}
	public void setUserTelWork(String userTelWork) {
		this.userTelWork = userTelWork;
	}
	public String getUserTelHome() {
		return userTelHome;
	}
	public void setUserTelHome(String userTelHome) {
		this.userTelHome = userTelHome;
	}
	public String getUserTelMobile() {
		return userTelMobile;
	}
	public void setUserTelMobile(String userTelMobile) {
		this.userTelMobile = userTelMobile;
	}
	public String getUserSipNum() {
		return userSipNum;
	}
	public void setUserSipNum(String userSipNum) {
		this.userSipNum = userSipNum;
	}
	public String getUserSipFront() {
		return userSipFront;
	}
	public void setUserSipFront(String userSipFront) {
		this.userSipFront = userSipFront;
	}
	public String getUserSipBack() {
		return userSipBack;
	}
	public void setUserSipBack(String userSipBack) {
		this.userSipBack = userSipBack;
	}
	public Integer getUserSipLevel() {
		return userSipLevel;
	}
	public void setUserSipLevel(Integer userSipLevel) {
		this.userSipLevel = userSipLevel;
	}
	public Long getUserDeptId() {
		return userDeptId;
	}
	public void setUserDeptId(Long userDeptId) {
		this.userDeptId = userDeptId;
	}
	public String getUserDeptName() {
		return userDeptName;
	}
	public void setUserDeptName(String userDeptName) {
		this.userDeptName = userDeptName;
	}
	public Long getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserRoleName() {
		return userRoleName;
	}
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
	}
	public String getUserPost() {
		return userPost;
	}
	public void setUserPost(String userPost) {
		this.userPost = userPost;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
