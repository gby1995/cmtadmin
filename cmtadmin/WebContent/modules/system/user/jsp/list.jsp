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
		<link href="plugins/zTree/css/zTreeStyle/zTreeStyle.css" rel="stylesheet">
		<style>
		.title_list{line-height: 34px;padding-left: 18px;border-bottom: 1px solid #e5e6e7;color: #6b6b6b;font-weight: bold;}
		.overflow-y-box{padding:0px 10px 0px 10px!important;height: 500px;overflow: hidden;overflow-y: auto;}
		</style>
	</head>
	<body class="white-bg">
		<div class="wrapper wrapper-content  animated fadeInRight">
			<div class="row">
				<div class="col-sm-12">
					<div class="ibox ">
						<div class="ibox-title">
							<h5>
								施工监管统计
							</h5>
						</div>
						<div class="ibox-content">
							<div class="col-sm-3"  id="demo1" style="border: 1px solid #e5e6e7;padding:0px;">
								<p class="title_list">单位目录</p>
									<div style="" class="overflow-y-box">
									<ul id="topCorpTree" class="ztree"></ul>
								</div>
							</div>
							<div class="col-sm-9" id="demo2"  >
								<input type="hidden" id="corpId" value="" />
								<form class="form-group">
					 				<div class="form-group col-xs-4 ">
										<label class="control-label" for="input01">用户名：</label>
										<input type="text" class="input-medium search-query" name="userName" gps="form">
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
		</div>
	</body>
	
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="plugins/validator/validator.js"></script>
	
	<!-- zTree -->
	<script type="text/javascript" src="plugins/zTree/js/jquery.ztree.core.js"></script>
	<script type="text/javascript" src="plugins/zTree/js/jquery.ztree.excheck.js"></script>
	<script type="text/javascript" src="plugins/zTree/js/jquery.ztree.exedit.js"></script>
	<script type="text/javascript" src="plugins/zTree/js/jquery.ztree.exhide.js"></script>
	<script type="text/javascript" src="plugins/cityPlugin/city.js"></script>
	<script type="text/javascript" src="modules/common/tree/js/topCorpTree.js"></script>
	
	<script type="text/javascript" src="modules/system/user/js/list_systemUser.js"></script>
	
</html>

