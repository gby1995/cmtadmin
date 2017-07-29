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
				<h5>新增用户管理</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">用户名</label>
							<div class="col-xs-4">
								<input type="text" maxlength="16" placeholder="必须填写姓名，限16字，批量添加SIP号段可为空" name="userName" class="form-control text-muted" gps="form" required>
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">密码</label>
							<div class="col-xs-4">
								<input type="text" placeholder="请输入密码" name="userPassword" class="form-control" gps="form" required>
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">真实名称</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userRealName" class="form-control" gps="form" required>
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">性别</label>
							<div class="col-xs-4">
								<!-- <input type="text" placeholder="请输入性别" name="userSex" class="form-control" gps="form"> -->
								<div class="radio col-xs-4">
                                   <label>
                                      <input style="margin-top:2px" type="radio" name="optionsRadios" id="optionsRadios2" value="option1">男
                                   </label> 
                                 </div>
                                 <div class="radio col-xs-4">
                                   <label>
                                      <input style="margin-top:2px" type="radio" name="optionsRadios" id="optionsRadios2" value="option2" checked>女
                                   </label> 
                                 </div>
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">出生日期</label>
							<div class="col-xs-4">
								<input data-provide="datepicker" data-date-format="mm/dd/yyyy" type="text" placeholder="请输入出生日期" name="userBirth" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">工号</label>
							<div class="col-xs-4">
								<input type="text" maxlength="16" placeholder="由字母，数字，下划线和中划线组成，限16字" name="userNum" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">办公电话</label>
							<div class="col-xs-4">
								<input type="tel" maxlength="16" placeholder="限16（包含）个数字以内" name="userTelWork" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">家庭电话</label>
							<div class="col-xs-4">
								<input type="tel" maxlength="16" placeholder="限16（包含）个数字以内" name="userTelHome" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">手机号码</label>
							<div class="col-xs-4">
								<input type="tel" maxlength="16" placeholder="限16（包含）个数字以内" name="userTelMobile" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">SIP账号</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userSipNum" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">SIP号段</label>
							<div class="col-xs-2">
								<input type="text" placeholder="SIP号段-前" name="userSipFront" class="form-control" gps="form">
							</div>
							<div class="col-xs-2">
								<input type="text" placeholder="SIP号段-后" name="userSipBack" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">号码等级</label>
							<div class="col-xs-4">
								<input type="text" placeholder="高等级号码可以控制低等级号码" name="userSipLevel" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">部门表外键</label>
							<div class="col-xs-4">
								<input type="hidden" placeholder="" name="userDeptId" id="seachValue_userDept" class="form-control" gps="form"
								       class="form-control" value="" >
								<input type="text" placeholder="所属公司" name="userDeptName" id="seachText_userDept" class="form-control" gps="form"
								       class="form-control" value="" readonly onclick="utilButtons.openLayer('department',800,300,'userDept')">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">角色ID</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userRoleId" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">角色名称</label>
							<div class="col-xs-4">
								<input type="text" maxlength="16" placeholder="限16字" name="userRoleName" class="form-control" gps="form" required>
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">职务</label>
							<div class="col-xs-4">
								<input type="text" placeholder="" name="userPost" class="form-control" gps="form">
							</div>
						</div>
						
						<div class="form-group ">
				         <button type="button" class="btn btn-default" onclick="add_systemUser.goback()">返回</button>
				         <button type="submit" class="btn btn-primary" onclick="add_systemUser.submitForm()">保存内容</button>
						</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="common/js/utilValidator.js"></script>
	<script type="text/javascript" src="modules/system/user/js/add_systemUser.js"></script>
</body>
</html>
