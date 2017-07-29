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
				<h5>修改单位管理</h5>
			</div>
			<div class="ibox-content  text-center">
				<form class="form-horizontal  m-t" role="form">
					<input type="hidden" placeholder="" name="scId" class="form-control" gps="form" value="${systemCorp.scId}">
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">公司名称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scName" class="form-control" gps="form" value=" ${systemCorp.scName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">公司简称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scShortName" class="form-control" gps="form" value=" ${systemCorp.scShortName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">上级单位ID</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scPid" class="form-control" gps="form" value=" ${systemCorp.scPid}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">上级单位名称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scPname" class="form-control" gps="form" value=" ${systemCorp.scPname}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">顶级单位ID</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scTopId" class="form-control" gps="form" value=" ${systemCorp.scTopId}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">顶级单位名称</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scTopName" class="form-control" gps="form" value=" ${systemCorp.scTopName}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">所在城市</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scCity" class="form-control" gps="form" value=" ${systemCorp.scCity}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">所在省份</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scProvince" class="form-control" gps="form" value=" ${systemCorp.scProvince}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">地址</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scAddress" class="form-control" gps="form" value=" ${systemCorp.scAddress}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">公司简介</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scInfo" class="form-control" gps="form" value=" ${systemCorp.scInfo}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">员工情况</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scUserInfo" class="form-control" gps="form" value=" ${systemCorp.scUserInfo}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">中远海控股情况</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scHolding" class="form-control" gps="form" value=" ${systemCorp.scHolding}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">是否安全主题责任</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scSafeResponsib" class="form-control" gps="form" value=" ${systemCorp.scSafeResponsib}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">安全中电防控风险</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scAntiRisk" class="form-control" gps="form" value=" ${systemCorp.scAntiRisk}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">是否涉及危化品</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scIsChemical" class="form-control" gps="form" value=" ${systemCorp.scIsChemical}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">所涉及危化品详情</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scChemicalInfo" class="form-control" gps="form" value=" ${systemCorp.scChemicalInfo}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">是否重大危险源 </label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scIsHazard" class="form-control" gps="form" value=" ${systemCorp.scIsHazard}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">危险源详情</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scHazardInfo" class="form-control" gps="form" value=" ${systemCorp.scHazardInfo}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">经度</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scLongitude" class="form-control" gps="form" value=" ${systemCorp.scLongitude}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">纬度</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scLatitude" class="form-control" gps="form" value=" ${systemCorp.scLatitude}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">SIP账号</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scSipNum" class="form-control" gps="form" value=" ${systemCorp.scSipNum}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">排序号</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="scOrder" class="form-control" gps="form" value=" ${systemCorp.scOrder}">
							</div>
						</div>
						<div class="form-group">
							<!-- Text input-->
							<label class="col-xs-offset-2 col-xs-2" for="input01">创建时间</label>
							<div class="col-xs-5">
								<input type="text" placeholder="" name="createTime" class="form-control" gps="form" value=" ${systemCorp.createTime}">
							</div>
						</div>
						
						
						<div class="form-group ">
				         <button type="button" class="btn btn-white" onclick="edit_systemCorp.goback()">返回</button>
				         <button type="button" class="btn btn-primary" onclick="edit_systemCorp.submitForm()">保存内容</button>
						</div>

				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="common/js/utilButtons.js"></script>
	<script type="text/javascript" src="modules/system/corp/js/edit_systemCorp.js"></script>
</body>
</html>
