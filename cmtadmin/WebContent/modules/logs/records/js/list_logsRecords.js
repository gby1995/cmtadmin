/**
 * 管理查询JS
 * @auther
 */
	var list_logsRecords = {
		// 用户管理JS
		init:function(){
			// caption:标题
			var caption = "关键操作记录";
			// colNames:列名
			var  colNames = [
			'reId'
				 ,'日期'
				 ,'时间'
				 ,'用户名'
				 ,'角色'
				 ,'日志类型'
				 ,'操作'
				 ,'corpId'
			];
			// colModel:列对应实体类名
			var colModel = [  
		               { name: 'reId', index: 'reId', width: 10, key: true, hidden: true , formatter:'showlink', 
		            	   // 设置点击详情页面URL
		            	   formatoptions:{baseLinkUrl:"logsRecords/get",idName: "reId"} }
		               ,{ name: 'reDate', index: 'reDate', width: 10,
		            	   formatter:function(cellvalue, options, rowObject){
		            		   return cellvalue.substr(0,10);
		            	   }
		                }
		               ,{ name: 'reDate', index: 'reDate', width: 10,
		            	   formatter:function(cellvalue, options, rowObject){
		            		   return cellvalue.substring(11,cellvalue.lastIndexOf('.'));
		            	   }
		                }
		               ,{ name: 'reName', index: 'reName', width: 10}
		               ,{ name: 'reRole', index: 'reRole', width: 10}
		               ,{ name: 'reType', index: 'reType', width: 10}
		               ,{ name: 'reContent', index: 'reContent', width: 10}
		               ,{ name: 'corpId', index: 'corpId', width: 10, hidden: true}
		           ];
			// 设置查询URL
			utilButtons.listUrl = "logsRecords/list"; 
			// 设置新增跳转页面地址
			utilButtons.addUrl = "logsRecords_add";
			// 设置 编辑跳转页面URL
			utilButtons.editUrl = "logsRecords_edit?reId=";
			// 设置 删除参数URL
			utilButtons.delUrl = "logsRecords/del?reId=";
			// 设置业务模块名称
			utilButtons.moduleName = "logsRecords";
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
	list_logsRecords.init();