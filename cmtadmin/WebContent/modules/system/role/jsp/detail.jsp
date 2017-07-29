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
				<h5>角色详情</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
					<input type="hidden" placeholder="" name="srId" class="form-control" gps="form" value="${systemRole.srId}">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">角色编码： ${systemRole.srCode}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">角色名称： ${systemRole.srName}</label>
						</div>
						<div class="form-group ">
				         <button type="button" class="btn btn-white" onclick="detail_systemRole.goback()">返回</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/system/role/js/detail_systemRole.js"></script>
</body>
</html>