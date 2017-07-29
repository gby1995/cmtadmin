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
							<h5>用户管理
							</h5>
						</div>
						<div class="ibox-content">
						    <form class="form-group">
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">用户名：</label>
									<input type="text" class="input-medium search-query" name="userName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">密码：</label>
									<input type="text" class="input-medium search-query" name="userPassword" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">真实名称：</label>
									<input type="text" class="input-medium search-query" name="userRealName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">性别：</label>
									<input type="text" class="input-medium search-query" name="userSex" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">出生日期：</label>
									<input type="text" class="input-medium search-query" name="userBirth" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">工号：</label>
									<input type="text" class="input-medium search-query" name="userNum" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">办公电话：</label>
									<input type="text" class="input-medium search-query" name="userTelWork" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">家庭电话：</label>
									<input type="text" class="input-medium search-query" name="userTelHome" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">手机号码：</label>
									<input type="text" class="input-medium search-query" name="userTelMobile" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">SIP号段：</label>
									<input type="text" class="input-medium search-query" name="userSipNum" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">SIP号段-前：</label>
									<input type="text" class="input-medium search-query" name="userSipFront" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">SIP号段-后：</label>
									<input type="text" class="input-medium search-query" name="userSipBack" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">号码等级：</label>
									<input type="text" class="input-medium search-query" name="userSipLevel" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">部门表外键：</label>
									<input type="text" class="input-medium search-query" name="userDeptId" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">部门名称：</label>
									<input type="text" class="input-medium search-query" name="userDeptName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">角色ID：</label>
									<input type="text" class="input-medium search-query" name="userRoleId" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">角色名称：</label>
									<input type="text" class="input-medium search-query" name="userRoleName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">职务：</label>
									<input type="text" class="input-medium search-query" name="userPost" gps="form">
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
								<button type="button" class="btn btn-primary btn-sm" onclick="list_systemUser.search()">
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
	<script type="text/javascript" src="modules/system/user/js/list_systemUser.js"></script>
</html>

