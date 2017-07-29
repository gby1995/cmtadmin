/**
 * 管理查询JS
 * @auther
 */
	var ${listJSName} = {
		// 用户管理JS
		init:function(){
			// caption:标题
			var caption = "${simpleclassName}列表";
			// colNames:列名
			var  colNames = [
			'${pid}'
			<#list attrs as a>
				<#if a.field != pid>
				 ,'${a.field}'
				</#if>	
			</#list>
			];
			// colModel:列对应实体类名
			var colModel = [  
		               { name: '${pid}', index: '${pid}', width: 10, key: true, hidden: false , formatter:'showlink', 
		            	   // 设置点击详情页面URL
		            	   formatoptions:{baseLinkUrl:"${simpleclassName?uncap_first}/get",idName: "${pid}"} }
		            	<#list attrs as a>
						  <#if a.field != pid>   
		               ,{ name: '${a.field}', index: '${a.field}', width: 10}
		                  </#if>	
						</#list>
		           ];
			// 设置查询URL
			utilButtons.listUrl = "${simpleclassName?uncap_first}/list"; 
			// 设置新增跳转页面地址
			utilButtons.addUrl = "${simpleclassName?uncap_first}_add";
			// 设置 编辑跳转页面URL
			utilButtons.editUrl = "${simpleclassName?uncap_first}_edit?${pid}=";
			// 设置 删除参数URL
			utilButtons.delUrl = "${simpleclassName?uncap_first}/del?${pid}=";
			// 设置业务模块名称
			utilButtons.moduleName = "${simpleclassName?uncap_first}";
			// 调用分页插件初始化列表
			utilButtons.tablePlugin(caption,colNames,colModel);
		},// 查询
		search:function(){
			utilButtons.search();
		}
	};
	// 初始化加载
	${listJSName}.init();