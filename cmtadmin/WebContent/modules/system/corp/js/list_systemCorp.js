/**
 * 管理查询JS
 * @auther
 */
	var list_systemCorp = {
		// 用户管理JS
		init:function(){
			// caption:标题
			var caption = "单位管理列表";
			// colNames:列名
			var  colNames = [
			'主键'
				 ,'公司名称'
				 ,'公司简称'
				 ,'上级单位ID'
				 ,'上级单位名称'
				 ,'顶级单位ID'
				 ,'顶级单位名称'
				 ,'所在城市'
				 ,'所在省份'
				 ,'地址'
				 ,'公司简介'
				 ,'员工情况'
				 ,'中远海控股情况'
				 ,'是否安全主题责任'
				 ,'安全中电防控风险'
				 ,'是否涉及危化品 '
				 ,'所涉及危化品详情'
				 ,'是否重大危险源'
				 ,'危险源详情'
				 ,'经度'
				 ,'纬度'
				 ,'SIP账号'
				 ,'排序号'
				 ,'创建时间'
			];
			// colModel:列对应实体类名
			var colModel = [  
		               { name: 'scId', index: 'scId', width: 5, key: true, hidden: false , formatter:'showlink', 
		            	   // 设置点击详情页面URL
		            	   formatoptions:{baseLinkUrl:"systemCorp/get",idName: "scId"} }
		               ,{ name: 'scName', index: 'scName', width: 8}
		               ,{ name: 'scShortName', index: 'scShortName', width: 8}
		               ,{ name: 'scPid', index: 'scPid', width: 12, hidden: true}
		               ,{ name: 'scPname', index: 'scPname', width: 11}
		               ,{ name: 'scTopId', index: 'scTopId', width: 9}
		               ,{ name: 'scTopName', index: 'scTopName', width: 12}
		               ,{ name: 'scCity', index: 'scCity', width: 10, hidden: true}
		               ,{ name: 'scProvince', index: 'scProvince', width: 10, hidden: true}
		               ,{ name: 'scAddress', index: 'scAddress', width: 6}
		               ,{ name: 'scInfo', index: 'scInfo', width: 10, hidden: true}
		               ,{ name: 'scUserInfo', index: 'scUserInfo', width: 8}
		               ,{ name: 'scHolding', index: 'scHolding', width: 10, hidden: true}
		               ,{ name: 'scSafeResponsib', index: 'scSafeResponsib', width: 10, hidden: true}
		               ,{ name: 'scAntiRisk', index: 'scAntiRisk', width: 13, hidden: true}
		               ,{ name: 'scIsChemical', index: 'scIsChemical', width: 13, hidden: true}
		               ,{ name: 'scChemicalInfo', index: 'scChemicalInfo', width: 10, hidden: true}
		               ,{ name: 'scIsHazard', index: 'scIsHazard', width: 13}
		               ,{ name: 'scHazardInfo', index: 'scHazardInfo', width: 10, hidden: true}
		               ,{ name: 'scLongitude', index: 'scLongitude', width: 5, hidden: true}
		               ,{ name: 'scLatitude', index: 'scLatitude', width: 5}
		               ,{ name: 'scSipNum', index: 'scSipNum', width: 7, hidden: true}
		               ,{ name: 'scOrder', index: 'scOrder', width: 7}
		               ,{ name: 'createTime', index: 'createTime', width: 16}
		           ];
			// 设置查询URL
			utilButtons.listUrl = "systemCorp/list"; 
			// 设置新增跳转页面地址
			utilButtons.addUrl = "systemCorp_add";
			// 设置 编辑跳转页面URL
			utilButtons.editUrl = "systemCorp_edit?scId=";
			// 设置 删除参数URL
			utilButtons.delUrl = "systemCorp/del?scId=";
			// 设置业务模块名称
			utilButtons.moduleName = "systemCorp";
			// 调用分页插件初始化列表
			utilButtons.tablePlugin(caption,colNames,colModel);
		},// 查询
		search:function(){
			utilButtons.search();
		}
	};
	// 初始化加载
	list_systemCorp.init();