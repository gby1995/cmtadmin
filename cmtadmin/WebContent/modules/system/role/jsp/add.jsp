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
				<h5>新增角色</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">角色编码</label>
							<div class="col-xs-5">
								<input type="text" placeholder="输入角色编码" name="srCode" class="form-control" gps="form">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2 control-label" for="input01">角色名称</label>
							<div class="col-xs-5">
								<input type="text" maxlength="8" placeholder="必填，限8字" name="srName" class="form-control" gps="form" required>
							</div>
						</div>
						
						<div class="form-group ">
				         <button type="button" class="btn btn-default" onclick="add_systemRole.goback()">返回</button>
				         <button type="submit" class="btn btn-primary" onclick="add_systemRole.submitForm()">保存内容</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/system/role/js/add_systemRole.js"></script>
</body>
</html>
