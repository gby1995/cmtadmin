/**
 * 通用文件上传插件
 * 
 * @author baitao 2017/2/17 文件上传
 */
var upload = {
	fileFinish : function(data) {
	},
	ajaxFileUpload : function(url, params) {
		// 设置加载图标的显示
		$('#loading').show();

		var fileElementId = "fileToUpload"
		
		if(typeof(params) !== 'undefined'){
			if(params.fileElementId){
				fileElementId = params.fileElementId;
			}
		}
			
		$.ajaxFileUpload({
			url : url,
			secureuri : false,
			fileElementId :  fileElementId ,
			dataType : 'json',
			data : params,
			success : function(data, status) {
				// 清除定时器
				// if(uploadProcessTimer) {
				// }
				$('#loading').hide();
				var message = data['message'];
				// var code = data['code'];
				if (message) {
					// this.fileInfos.push(data);
					layer.msg("上传成功");
					// fileFinish();
					if (typeof add_hazardsApply != "undefined") {
						// // 备案申请
						add_hazardsApply.changeCheckBox(data);
					} else if (typeof edit_hazardsApply != "undefined") {
						// // 备案申请
						edit_hazardsApply.changeCheckBox(data);
					} else if (typeof cancel_hazardsApply != "undefined") {
						// // 备案申请
						cancel_hazardsApply.changeCheckBox(data);
					} else if (typeof add_constructionApply != "undefined") {
						// // 施工附件提交
						add_constructionApply.setValue(data);
					} else if (typeof edit_constructionApply != "undefined") {
						// // 施工附件提交
						edit_constructionApply.setValue(data);
					} else if (typeof add_corpInfo != "undefined") {
						// // 营业执照扫描件提交
						add_corpInfo.setValue(data);
					} else if (typeof edit_corpInfo != "undefined") {
						// // 营业执照扫描件提交
						edit_corpInfo.setValue(data);
					} else if (typeof add_corpLicence != "undefined") {
						// // 证照描件提交
						add_corpLicence.setValue(data);
					} else if (typeof edit_corpLicence != "undefined") {
						// // 证照描件提交
						edit_corpLicence.setValue(data);
					} else if (typeof monitorWarnDetail != "undefined") {
						// 报警处理-相关证据  ,现场确认照片
						if(params.uploadCallBack){
							params.uploadCallBack(params,data);
						}
					}else if (typeof edit_constructionFireworkData != "undefined") {
						// // 动火预警附件提交
						edit_constructionFireworkData.setValue(data);
					} else if (typeof add_constructionFireworkData != "undefined") {
						// // 动火预警附件提交
						add_constructionFireworkData.setValue(data);
					}
					return true;
				}
			},
			error : function(data, status, e) {
				// 清除定时器
				// if(uploadProcessTimer) {
				// }
				$('#loading').hide();
				// 这里处理的是网络异常，返回参数解析异常，DOM操作异常
				layer.msg("上传发生异常");
				return false;
			}
		});

	}
};
