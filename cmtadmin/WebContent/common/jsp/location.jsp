<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<jsp:include page="/modules/common/main/jsp/linkSrc.jsp"/> 
<style type="text/css">
	body, html,#allmap {width: 100%;height: 100%;overflow: hidden;margin:0;font-family:"微软雅黑";}
	</style>
</head>
<body>
<div id="allmap"></div>
</body>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=AE01cf80f7e34194eb200a42443ed923"></script>
<script type="text/javascript" src="common/js/utilLocation.js"></script>
</html>