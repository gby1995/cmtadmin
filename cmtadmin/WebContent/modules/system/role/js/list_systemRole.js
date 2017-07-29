/**
 * 管理查询JS
 * @auther
 */
	var list_systemRole = {
		// 用户管理JS
		init:function(){
			// caption:标题
			var caption = "角色列表";
			// colNames:列名
			var  colNames = [
			'主键'
				 ,'角色编码'
				 ,'角色名称'
			];
			// colModel:列对应实体类名
			var colModel = [  
		               { name: 'srId', index: 'srId', width: 10, key: true, hidden: false , formatter:'showlink', 
		            	   // 设置点击详情页面URL
		            	   formatoptions:{baseLinkUrl:"systemRole/get",idName: "srId"} }
		               ,{ name: 'srCode', index: 'srCode', width: 10}
		               ,{ name: 'srName', index: 'srName', width: 10}
		           ];
			// 设置查询URL
			utilButtons.listUrl = "systemRole/list"; 
			// 设置新增跳转页面地址
			utilButtons.addUrl = "systemRole_add";
			// 设置 编辑跳转页面URL
			utilButtons.editUrl = "systemRole_edit?srId=";
			// 设置 删除参数URL
			utilButtons.delUrl = "systemRole/del?srId=";
			// 设置业务模块名称
			utilButtons.moduleName = "systemRole";
			// 调用分页插件初始化列表
			utilButtons.tablePlugin(caption,colNames,colModel);
		},// 查询
		search:function(){
			utilButtons.search();
		}
	};
	// 初始化加载
	list_systemRole.init();