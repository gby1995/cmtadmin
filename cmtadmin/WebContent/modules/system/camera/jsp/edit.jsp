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
				<h5>修改摄像头</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
					<input type="hidden" placeholder="" name="scId" class="form-control" gps="form" value="${systemCamera.scId}">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">摄像头名称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scName" class="form-control" gps="form" value=" ${systemCamera.scName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">设备序号</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scNum" class="form-control" gps="form" value=" ${systemCamera.scNum}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">所属单位ID</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scCorpId" class="form-control" gps="form" value=" ${systemCamera.scCorpId}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">所属单位名称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scCorpName" class="form-control" gps="form" value=" ${systemCamera.scCorpName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">顶级单位ID</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scTopCorpId" class="form-control" gps="form" value=" ${systemCamera.scTopCorpId}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">顶级单位名称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scTopCorpName" class="form-control" gps="form" value=" ${systemCamera.scTopCorpName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">SIP账号</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scSipNum" class="form-control" gps="form" value=" ${systemCamera.scSipNum}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">WEB链接</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scWebLink" class="form-control" gps="form" value=" ${systemCamera.scWebLink}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">平台网址用户名</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scLoginName" class="form-control" gps="form" value=" ${systemCamera.scLoginName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">平台网址密码</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scLoginPwd" class="form-control" gps="form" value=" ${systemCamera.scLoginPwd}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">NVR网址用户名</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scNvrName" class="form-control" gps="form" value=" ${systemCamera.scNvrName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">NVR网址密码</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scNvrPwd" class="form-control" gps="form" value=" ${systemCamera.scNvrPwd}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">排序号</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scOrder" class="form-control" gps="form" value=" ${systemCamera.scOrder}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">创建时间</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="createTime" class="form-control" gps="form" value=" ${systemCamera.createTime}">
							</div>
						</div>
						
						
						<div class="form-group ">
				         <button type="button" class="btn btn-white" onclick="edit_systemCamera.goback()">返回</button>
				         <button type="button" class="btn btn-primary" onclick="edit_systemCamera.submitForm()">保存内容</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/system/camera/js/edit_systemCamera.js"></script>
</body>
</html>
