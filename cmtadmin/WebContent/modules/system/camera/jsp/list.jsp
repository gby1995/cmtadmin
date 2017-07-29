<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
	  <base href="<%=basePath%>">
		<meta charset="UTF-8">
		<jsp:include page="/modules/common/main/jsp/linkSrc.jsp"/> 
	</head>
	<body class="white-bg">
		<div class="wrapper wrapper-content  animated fadeInRight">
			<div class="row">
				<div class="col-sm-12">
					<div class="ibox ">
						<div class="ibox-title">
							<h5>摄像头管理
							</h5>
						</div>
						<div class="ibox-content">
						    <form class="form-group">
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">摄像头名称：</label>
									<input type="text" class="input-medium search-query" name="scName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">设备序号：</label>
									<input type="text" class="input-medium search-query" name="scNum" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">所属单位ID：</label>
									<input type="text" class="input-medium search-query" name="scCorpId" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">所属单位名称：</label>
									<input type="text" class="input-medium search-query" name="scCorpName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">顶级单位ID：</label>
									<input type="text" class="input-medium search-query" name="scTopCorpId" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">顶级单位名称：</label>
									<input type="text" class="input-medium search-query" name="scTopCorpName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">SIP账号：</label>
									<input type="text" class="input-medium search-query" name="scSipNum" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">WEB链接：</label>
									<input type="text" class="input-medium search-query" name="scWebLink" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">平台网址用户名：</label>
									<input type="text" class="input-medium search-query" name="scLoginName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">平台网址密码：</label>
									<input type="text" class="input-medium search-query" name="scLoginPwd" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">NVR网址用户名：</label>
									<input type="text" class="input-medium search-query" name="scNvrName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">NVR网址密码：</label>
									<input type="text" class="input-medium search-query" name="scNvrPwd" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">排序号：</label>
									<input type="text" class="input-medium search-query" name="scOrder" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">创建时间：</label>
									<input type="text" class="input-medium search-query" name="createTime" gps="form">
								</div>
							<div class="form-group col-xs-12">
								<button type="button" id="toAdd" class="btn btn-primary btn-sm" onclick="utilButtons.addPage()">
									<span class="glyphicon glyphicon-ok"></span> 新增
								</button>
								<button type="button" id="toEdit" class="btn btn-primary btn-sm" onclick="utilButtons.editPage()">
									<span class="glyphicon glyphicon-file"></span> 修改
								</button>
								<button type="button" id="toDel" class="btn btn-primary btn-sm" onclick="utilButtons.del()">
									<span class="glyphicon glyphicon-trash"></span> 删除
								</button>
								<button type="button" class="btn btn-primary btn-sm" onclick="list_systemCamera.search()">
								<span class="glyphicon glyphicon-search"></span>  查询
								</button>
							</div>
						    </form>
						    <div class="form-group col-xs-12">
								<div class="jqGrid_wrapper">
									<table id="dtable"></table>
									<div id="jqGridPager"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/system/camera/js/list_systemCamera.js"></script>
</html>

