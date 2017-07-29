/**
 * 管理查询JS
 * @auther
 */
	function getData(event, treeId, treeNode){
		$("#corpId").val(treeNode.id);
	}

	var list_systemUser = {
		// 用户管理JS
		init:function(){
			// caption:标题
			var caption = "用户管理列表";
			// colNames:列名
			var  colNames = [
			'用户主键'
				 ,'用户名'
				 ,'密码'
				 ,'真实名称'
				 ,'性别'
				 ,'出生日期'
				 ,'工号'
				 ,'办公电话'
				 ,'家庭电话'
				 ,'手机号码'
				 ,'SIP账号'
				 ,'SIP号段-前'
				 ,'SIP号段-后'
				 ,'号码等级'
				 ,'部门表外键'
				 ,'部门名称'
				 ,'角色ID'
				 ,'角色名称'
				 ,'职务'
			];
			// colModel:列对应实体类名
			var colModel = [  
		               { name: 'userId', index: 'userId', width: 8, key: true, hidden: true  }
		               ,{ name: 'userName', index: 'userName', formatter:'showlink', 
		            	   // 设置点击详情页面URL
		            	   formatoptions:{baseLinkUrl:"systemUser/get",idName: "userId"}, width: 10}
		               ,{ name: 'userPassword', index: 'userPassword', width: 10}
		               ,{ name: 'userRealName', index: 'userRealName', width: 12}
		               ,{ name: 'userSex', index: 'userSex', width: 10, hidden: true }
		               ,{ name: 'userBirth', index: 'userBirth', width: 12}
		               ,{ name: 'userNum', index: 'userNum', width: 8}
		               ,{ name: 'userTelWork', index: 'userTelWork', width: 12}
		               ,{ name: 'userTelHome', index: 'userTelHome', width: 10, hidden: true }
		               ,{ name: 'userTelMobile', index: 'userTelMobile', width: 12 }
		               ,{ name: 'userSipNum', index: 'userSipNum', width: 11}
		               ,{ name: 'userSipFront', index: 'userSipFront', width: 10, hidden: true }
		               ,{ name: 'userSipBack', index: 'userSipBack', width: 10, hidden: true }
		               ,{ name: 'userSipLevel', index: 'userSipLevel', width: 10, hidden: true }
		               ,{ name: 'userDeptId', index: 'userDeptId', width: 12, hidden: true}
		               ,{ name: 'userDeptName', index: 'userDeptName', width: 12}
		               ,{ name: 'userRoleId', index: 'userRoleId', width: 10}
		               ,{ name: 'userRoleName', index: 'userRoleName', width: 10, hidden: true }
		               ,{ name: 'userPost', index: 'userPost', width: 8}
		           ];
			// 设置查询URL
			utilButtons.listUrl = "systemUser/list"; 
			// 设置新增跳转页面地址
			utilButtons.addUrl = "systemUser_add";
			// 设置 编辑跳转页面URL
			
			utilButtons.editUrl = "systemUser_edit?userId=";
			// 设置 删除参数URL
			utilButtons.delUrl = "systemUser/del?userId=";
			// 设置业务模块名称
			utilButtons.moduleName = "systemUser";
			// 调用分页插件初始化列表
			utilButtons.tablePlugin(caption,colNames,colModel);
		},// 查询
		search:function(){
			utilButtons.search();
		}
	};
	// 初始化加载
	list_systemUser.init();