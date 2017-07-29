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
		<style>
			.btn-group-sm>.btn, .btn-sm {padding: 6px 10px 11px 10px;}
		</style>
	</head>
	<body class="white-bg">
		<div class="wrapper wrapper-content  animated fadeInRight">
			<div class="row">
				<div class="col-sm-12">
					<div class="ibox ">
						<div class="ibox-title">
							<h5>登录信息
							</h5>
						</div>
						<div class="ibox-content">
						    <form class="form-group">
						        <div class="form-group col-xs-4 form-group-height">
									<label class="control-label" for="input01">用户名：</label>
									<input type="text" class="input-medium search-query" name="loginName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 form-group-height">
									<label class="control-label" for="input01">开始日期：</label>
									<input type="text" class="input-medium search-query" name="firDate" id="firDate" gps="form">
								</div>	
								
								<div class="form-group col-xs-4 form-group-height">
									<label class="control-label" for="input01">结束日期：</label>
									<input type="text" class="input-medium search-query" name="secDate" id="secDate" gps="form">
							    </div>
							   <div class="form-group col-xs-12">
									<button type="button" class="btn btn-primary btn-sm" onclick="list_logsLogin.search()">
									<span class="glyphicon glyphicon-search">查询</span>  
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

	</body>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/logs/login/js/list_logsLogin.js"></script>
</html>

