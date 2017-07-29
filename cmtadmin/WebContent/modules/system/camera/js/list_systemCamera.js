/**
 * 管理查询JS
 * @auther
 */
	var list_systemCamera = {
		// 用户管理JS
		init:function(){
			// caption:标题
			var caption = "摄像头列表";
			// colNames:列名
			var  colNames = [
			'主键'
				 ,'摄像头名称'
				 ,'设备序号'
				 ,'所属单位ID'
				 ,'所属单位名称'
				 ,'顶级单位ID'
				 ,'顶级单位名称'
				 ,'SIP账号'
				 ,'WEB链接'
				 ,'平台网址用户名'
				 ,'平台网址密码'
				 ,'NVR网址用户名'
				 ,'NVR网址密码'
				 ,'排序号'
				 ,'创建时间'
			];
			// colModel:列对应实体类名
			var colModel = [  
		               { name: 'scId', index: 'scId', width: 5, key: true, hidden: false , formatter:'showlink', 
		            	   // 设置点击详情页面URL
		            	   formatoptions:{baseLinkUrl:"systemCamera/get",idName: "scId"} }
		               ,{ name: 'scName', index: 'scName', width: 10}
		               ,{ name: 'scNum', index: 'scNum', width: 8}
		               ,{ name: 'scCorpId', index: 'scCorpId', width: 10}
		               ,{ name: 'scCorpName', index: 'scCorpName', width: 11}
		               ,{ name: 'scTopCorpId', index: 'scTopCorpId', width: 10}
		               ,{ name: 'scTopCorpName', index: 'scTopCorpName', width: 10, hidden: true}
		               ,{ name: 'scSipNum', index: 'scSipNum', width: 7}
		               ,{ name: 'scWebLink', index: 'scWebLink', width: 8}
		               ,{ name: 'scLoginName', index: 'scLoginName', width: 10, hidden: true}
		               ,{ name: 'scLoginPwd', index: 'scLoginPwd', width: 11}
		               ,{ name: 'scNvrName', index: 'scNvrName', width: 10, hidden: true}
		               ,{ name: 'scNvrPwd', index: 'scNvrPwd', width: 11}
		               ,{ name: 'scOrder', index: 'scOrder', width: 7}
		               ,{ name: 'createTime', index: 'createTime', width: 8}
		           ];
			// 设置查询URL
			utilButtons.listUrl = "systemCamera/list"; 
			// 设置新增跳转页面地址
			utilButtons.addUrl = "systemCamera_add";
			// 设置 编辑跳转页面URL
			utilButtons.editUrl = "systemCamera_edit?scId=";
			// 设置 删除参数URL
			utilButtons.delUrl = "systemCamera/del?scId=";
			// 设置业务模块名称
			utilButtons.moduleName = "systemCamera";
			// 调用分页插件初始化列表
			utilButtons.tablePlugin(caption,colNames,colModel);
		},// 查询
		search:function(){
			utilButtons.search();
		}
	};
	// 初始化加载
	list_systemCamera.init();