<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta charset="UTF-8">
<jsp:include page="/modules/common/main/jsp/linkSrc.jsp"/> 
</head>
<body>
	<div style="width: 100%; height: 100%;">
		<div class="ibox float-e-margins">
			<div class="ibox-title">
				<h5>修改用户管理</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
					<input type="hidden" placeholder="" name="userId" class="form-control" gps="form" value="${systemUser.userId}">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">用户名</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userName" class="form-control" gps="form" value=" ${systemUser.userName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">密码</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userPassword" class="form-control" gps="form" value=" ${systemUser.userPassword}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">真实名称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="userRealName" class="form-control" gps="form" value=" ${systemUser.userRealName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">性别</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userSex" class="form-control" gps="form" value=" ${systemUser.userSex}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">出生日期</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userBirth" class="form-control" gps="form" value=" ${systemUser.userBirth}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">工号</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userNum" class="form-control" gps="form" value=" ${systemUser.userNum}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">办公电话</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userTelWork" class="form-control" gps="form" value=" ${systemUser.userTelWork}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">家庭电话</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userTelHome" class="form-control" gps="form" value=" ${systemUser.userTelHome}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">手机号码</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userTelMobile" class="form-control" gps="form" value=" ${systemUser.userTelMobile}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">SIP账号</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userSipNum" class="form-control" gps="form" value=" ${systemUser.userSipNum}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">SIP号段</label>
							<div class="col-xs-2">
								<input type="text" placeholder="" name="userSipFront" class="form-control" gps="form" value=" ${systemUser.userSipFront}">
							</div>
							<div class="col-xs-2">
								<input type="text" placeholder="" name="userSipBack" class="form-control" gps="form" value=" ${systemUser.userSipBack}">
							</div>
						</div>
						<%-- <div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">SIP号段-后</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="userSipBack" class="form-control" gps="form" value=" ${systemUser.userSipBack}">
							</div>
						</div> --%>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">号码等级</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userSipLevel" class="form-control" gps="form" value=" ${systemUser.userSipLevel}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">部门表外键</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userDeptId" class="form-control" gps="form" value=" ${systemUser.userDeptId}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">部门名称</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userDeptName" class="form-control" gps="form" value=" ${systemUser.userDeptName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">角色ID</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userRoleId" class="form-control" gps="form" value=" ${systemUser.userRoleId}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">角色名称</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userRoleName" class="form-control" gps="form" value=" ${systemUser.userRoleName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">职务</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userPost" class="form-control" gps="form" value=" ${systemUser.userPost}">
							</div>
						</div>
						
						
						<div class="form-group ">
				         <button type="button" class="btn btn-white" onclick="edit_systemUser.goback()">返回</button>
				         <button type="button" class="btn btn-primary" onclick="edit_systemUser.submitForm()">保存内容</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/system/user/js/edit_systemUser.js"></script>
</body>
</html>
