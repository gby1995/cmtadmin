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
				<h5>修改角色</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
					<input type="hidden" placeholder="" name="srId" class="form-control" gps="form" value="${systemRole.srId}">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">角色编码</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="srCode" class="form-control" gps="form" value=" ${systemRole.srCode}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">角色名称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="srName" class="form-control" gps="form" value=" ${systemRole.srName}">
							</div>
						</div>
						
						
						<div class="form-group ">
				         <button type="button" class="btn btn-white" onclick="edit_systemRole.goback()">返回</button>
				         <button type="button" class="btn btn-primary" onclick="edit_systemRole.submitForm()">保存内容</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/system/role/js/edit_systemRole.js"></script>
</body>
</html>
