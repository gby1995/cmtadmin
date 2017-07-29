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
							<h5>单位管理
							</h5>
						</div>
						<div class="ibox-content">
						    <form class="form-group">
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">公司名称：</label>
									<input type="text" class="input-medium search-query" name="scName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">公司简称：</label>
									<input type="text" class="input-medium search-query" name="scShortName" gps="form">
								</div>
				 				<div class="form-group col-xs-4">
									<label class="control-label" for="input01">上级单位ID：</label>
									<input type="text" class="input-medium search-query" name="scPid" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label text-right" for="input01">上级单位名称：</label>
									<input type="text" class="input-medium search-query" name="scPname" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">顶级单位ID：</label>
									<input type="text" class="input-medium search-query" name="scTopId" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">顶级单位名称：</label>
									<input type="text" class="input-medium search-query" name="scTopName" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">所在城市：</label>
									<input type="text" class="input-medium search-query" name="scCity" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">所在省份：</label>
									<input type="text" class="input-medium search-query" name="scProvince" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">地址：</label>
									<input type="text" class="input-medium search-query" name="scAddress" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">公司简介：</label>
									<input type="text" class="input-medium search-query" name="scInfo" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">员工情况：</label>
									<input type="text" class="input-medium search-query" name="scUserInfo" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">中远海控股情况：</label>
									<input type="text" class="input-medium search-query" name="scHolding" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">是否安全主题责任：</label>
									<input type="text" class="input-medium search-query" name="scSafeResponsib" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">安全中电防控风险：</label>
									<input type="text" class="input-medium search-query" name="scAntiRisk" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">是否涉及危化品：</label>
									<input type="text" class="input-medium search-query" name="scIsChemical" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">所涉及危化品详情：</label>
									<input type="text" class="input-medium search-query" name="scChemicalInfo" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">是否重大危险源：</label>
									<input type="text" class="input-medium search-query" name="scIsHazard" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">危险源详情：</label>
									<input type="text" class="input-medium search-query" name="scHazardInfo" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">经度：</label>
									<input type="text" class="input-medium search-query" name="scLongitude" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">纬度：</label>
									<input type="text" class="input-medium search-query" name="scLatitude" gps="form">
								</div>
				 				<div class="form-group col-xs-4 ">
									<label class="control-label" for="input01">SIP账号：</label>
									<input type="text" class="input-medium search-query" name="scSipNum" gps="form">
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
								<button type="button" class="btn btn-primary btn-sm" onclick="list_systemCorp.search()">
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
	<script type="text/javascript" src="modules/system/corp/js/list_systemCorp.js"></script>
</html>

