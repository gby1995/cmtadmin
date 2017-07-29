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
				<h5>新增LogsLogin</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">loginDate</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="loginDate" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">loginName</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="loginName" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">loginRole</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="loginRole" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">loginContent</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="loginContent" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">corpId</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="corpId" class="form-control" gps="form">
							</div>
						</div>
						
						<div class="form-group ">
				         <button type="button" class="btn btn-default" onclick="add_logsLogin.goback()">返回</button>
				         <button type="button" class="btn btn-primary" onclick="add_logsLogin.submitForm()">保存内容</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/logs/login/js/add_logsLogin.js"></script>
</body>
</html>
