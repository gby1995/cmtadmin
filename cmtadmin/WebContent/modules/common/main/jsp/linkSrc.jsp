<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String uploadPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+  "/uploadFiles/";
%>
<title>姜堰区安全生产信息化管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="plugins/bootstrap/css/font-awesome.min.css" rel="stylesheet">
<link href="plugins/bootstrap/css/animate.min.css" rel="stylesheet">
<link href="modules/common/main/css/style.min.css" rel="stylesheet">
<link href="plugins/jqgrid/ui.jqgrid.css" rel="stylesheet">
<link href="plugins/layer/skin/layer.css" rel="stylesheet">
<link href="plugins/layer/skin/layer.ext.css" rel="stylesheet">
<link href="modules/common/main/css/basicStyle.css" rel="stylesheet">
        
<script type="text/javascript" src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="plugins/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="plugins/jqgrid/grid.locale-cn.js"></script>
<script type="text/javascript" src="plugins/jqgrid/jquery.jqGrid.min.js"></script>
<script type="text/javascript" src="plugins/layer/layer.min.js"></script>
<script type="text/javascript" src="plugins/layer/extend/layer.ext.js"></script>
<script type="text/javascript" src="plugins/laydate/laydate.js"></script>
<script type="text/javascript" src="common/js/jQuery.extend.js"></script>
<script type="text/javascript" src="common/js/utils.js"></script>
<input type="hidden" id="uploadPath"  value="<%=uploadPath%>">
<input type="hidden" id="basePath"  value="<%=basePath%>">
<input type="hidden" id="path"  value="<%=path%>">
     