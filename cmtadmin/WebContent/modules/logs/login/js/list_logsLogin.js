/**
 * 管理查询JS
 * @auther
 */
	var list_logsLogin = {
		// 用户管理JS
		init:function(){
			// caption:标题
			var caption = "登录信息日志";
			// colNames:列名
			var  colNames = [
			'loginId'
				 ,'日期'
				 ,'时间'
				 ,'用户'
				 ,'角色'
				 ,'操作'
				 ,'corpId'
			];
			// colModel:列对应实体类名
			var colModel = [  
		               { name: 'loginId', index: 'loginId', width: 10, key: true, hidden: true , formatter:'showlink', 
		            	   // 设置点击详情页面URL
		            	   formatoptions:{baseLinkUrl:"logsLogin/get",idName: "loginId"} }
		               ,{ name: 'loginDate', index: 'loginDate', width: 10,
		            	   formatter:function(cellvalue, options, rowObject){
		            		   return cellvalue.substr(0,10);
		            	   }
		               }
		               ,{ name: 'loginDate', index: 'loginDate', width: 10,
		            	   formatter:function(cellvalue, options, rowObject){
		            		   return cellvalue.substring(11,cellvalue.lastIndexOf('.'));
		            	   }
		               }
		               ,{ name: 'loginName', index: 'loginName', width: 10}
		               ,{ name: 'loginRole', index: 'loginRole', width: 10}
		               ,{ name: 'loginContent', index: 'loginContent', width: 10}
		               ,{ name: 'corpId', index: 'corpId', width: 10, hidden: true}
		           ];
			// 设置查询URL
			utilButtons.listUrl = "logsLogin/list"; 
			// 设置新增跳转页面地址
			utilButtons.addUrl = "logsLogin_add";
			// 设置 编辑跳转页面URL
			utilButtons.editUrl = "logsLogin_edit?loginId=";
			// 设置 删除参数URL
			utilButtons.delUrl = "logsLogin/del?loginId=";
			// 设置业务模块名称
			utilButtons.moduleName = "logsLogin";
			// 调用分页插件初始化列表
			utilButtons.tablePlugin(caption,colNames,colModel);
			// 时间控件 参数ID
			utilButtons.getDate('firDate');
			utilButtons.getDate('secDate');

		},// 查询
		search:function(){
			utilButtons.search();
		}
	};
	// 初始化加载
	list_logsLogin.init();