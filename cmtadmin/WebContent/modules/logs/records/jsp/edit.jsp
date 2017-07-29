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
				<h5>修改LogsRecords</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
					<input type="hidden" placeholder="" name="reId" class="form-control" gps="form" value="${logsRecords.reId}">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">reDate</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="reDate" class="form-control" gps="form" value=" ${logsRecords.reDate}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">reName</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="reName" class="form-control" gps="form" value=" ${logsRecords.reName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">reRole</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="reRole" class="form-control" gps="form" value=" ${logsRecords.reRole}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">reType</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="reType" class="form-control" gps="form" value=" ${logsRecords.reType}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">reContent</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="reContent" class="form-control" gps="form" value=" ${logsRecords.reContent}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">corpId</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="corpId" class="form-control" gps="form" value=" ${logsRecords.corpId}">
							</div>
						</div>
						
						
						<div class="form-group ">
				         <button type="button" class="btn btn-white" onclick="edit_logsRecords.goback()">返回</button>
				         <button type="button" class="btn btn-primary" onclick="edit_logsRecords.submitForm()">保存内容</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/logs/records/js/edit_logsRecords.js"></script>
</body>
</html>
