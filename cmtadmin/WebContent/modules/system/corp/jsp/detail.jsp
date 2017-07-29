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
				<h5>单位管理详情</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
					<input type="hidden" placeholder="" name="scId" class="form-control" gps="form" value="${systemCorp.scId}">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">公司名称： ${systemCorp.scName}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">公司简称： ${systemCorp.scShortName}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">上级单位ID： ${systemCorp.scPid}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">上级单位名称： ${systemCorp.scPname}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">顶级单位ID： ${systemCorp.scTopId}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">顶级单位名称： ${systemCorp.scTopName}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">所在城市： ${systemCorp.scCity}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">所在省份： ${systemCorp.scProvince}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">地址： ${systemCorp.scAddress}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">公司简介： ${systemCorp.scInfo}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">员工情况： ${systemCorp.scUserInfo}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">中远海控股情况： ${systemCorp.scHolding}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">是否安全主题责任： ${systemCorp.scSafeResponsib}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">安全中电防控风险： ${systemCorp.scAntiRisk}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">是否涉及危化品： ${systemCorp.scIsChemical}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">所涉及危化品详情： ${systemCorp.scChemicalInfo}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">是否重大危险源： ${systemCorp.scIsHazard}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">危险源详情： ${systemCorp.scHazardInfo}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">经度： ${systemCorp.scLongitude}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">纬度： ${systemCorp.scLatitude}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">SIP账号： ${systemCorp.scSipNum}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">排序号： ${systemCorp.scOrder}</label>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">创建时间： ${systemCorp.createTime}</label>
						</div>
						<div class="form-group ">
				         <button type="button" class="btn btn-white" onclick="detail_systemCorp.goback()">返回</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/system/corp/js/detail_systemCorp.js"></script>
</body>
</html>
