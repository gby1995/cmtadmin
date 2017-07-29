/**
 * 系统管理按钮插件
 * 
 * @author baitao 2016/7/10 add edit del 提示 跳转 jqgrid插件初始化等
 */
 var utilButtons = {
	baseUrl : '/cmtadmin/',
	rowNum : 10, // 默认每页10条
	listUrl : '',// 查询页面URL
	addUrl : '',// 跳转新增页面URL
	editUrl : '',// 跳转编辑页面URL
	commonUrl : '',// 跳转通用页面URL
	delUrl : '',// 删除请求参数地址
	moduleName : '',// 模块名称
	oldModuleName : '',// 旧模块名称
	searchWinText: 'seachText', //弹出框搜索栏ID
	searchWinValue: 'seachValue', //弹出框搜索栏值
	layerIndex : '',// layer弹出层
	indexTip :'',// layer Tip弹出层
	selectUrl : 'common/getSelectData',
	text:'',// 搜索条件
	params:'',// 搜索参数
	searchName : '',//搜索字段
	nettingLocation:'',//首次位置需要转换的列
	lastLocation:'',//末次位置需要转换的列
	exportUrl:'',//导出url
	// 跳转新增页面
	addPage : function() {
		utilButtons.winToUrl(utilButtons.addUrl);
	},// 跳转编辑页面(单选)
	editPage : function() {
		var url = utilButtons.editUrl;
		var rows = $('#dtable').getGridParam("selarrrow");
		if (rows.length != 1) {
			layer.msg('只能选择一个!');
		} else {
			url += rows[0];
			utilButtons.winToUrl(url);
		}
	},// 预览(单选)
	commonPage : function(){
		var url = utilButtons.commonUrl;
		var rows = $('#dtable').getGridParam("selarrrow");
		if (rows.length != 1) {
			layer.msg('只能选择一个!');
		} else {
			url += rows[0];
			utilButtons.winToUrl(url);
		}
	},// 多行选择事件
	selectRows : function() {
		var rows = $('#dtable').getGridParam("selarrrow");
		if(rows.length > 0){
			var rowids ="";
			var rowDatas ="";
			for(var i=0;i<rows.length;i++){
				var rowData = $("#dtable").jqGrid("getRowData",rows[i]);
				if(i == 0){
					rowids =   rows[i];
					rowDatas =   rowData[utilButtons.searchName];
				}else{
					rowids += "," + rows[i];
					rowDatas += "," + rowData[utilButtons.searchName];
				}
			}
//			if(utilButtons.oldModuleName != ''){
//				
//				window.parent.$('#'+utilButtons.searchWinValue+"_"+utilButtons.oldModuleName).val(rowids);
//				window.parent.$('#'+utilButtons.searchWinText+"_"+utilButtons.oldModuleName).val(rowDatas);
//			}else{
//				window.parent.$('#'+utilButtons.searchWinValue+"_"+utilButtons.moduleName).val(rowids);
//				window.parent.$('#'+utilButtons.searchWinText+"_"+utilButtons.moduleName).val(rowDatas);
//			}
			window.parent.$('#'+utilButtons.searchWinValue+"_"+utilButtons.moduleName).val(rowids);
			window.parent.$('#'+utilButtons.searchWinText+"_"+utilButtons.moduleName).val(rowDatas);
			 parent.layer.close(parent.layer.getFrameIndex(window.name)); //获取窗口索引
		}else{
			layer.msg('请选择一个!');
		}
	},// 删除(可多选) delUrl:删除参数 delToUrl:删除请求地址
	del : function() {
		var urls = utilButtons.delUrl;
		var rows = $('#dtable').getGridParam("selarrrow");
		if (rows.length > 0) {
			for (var i = 0; i < rows.length; i++) {
				if (i == 0) {
					urls = urls + rows[i];
				} else {
					urls = urls + "," + rows[i];
				}
			}
		} else {
			layer.msg('必须选择一个!');
			return;
		}
		 layer.confirm('确认删除这条信息?', {
             closeBtn: false,
             btn: ['取消', '确认'], 
             btn2 : function () {
                 $.post(urls, function (result) {
                     layer.msg(result.msg);
                     $('#dtable').trigger("reloadGrid");
                 });
             },yes : function(index){
            	 layer.close(index);
             },
             // 按钮
         }, function (index) {
             layer.close(index);
         });
	},// 新增或修改表单提交
	submitForm : function(url, up) {
		var params = up + "={'date':'" + new Date().getTime() + "'";
		$('form input:text[ gps="form"]').each(function() {
			params += ",'" + $(this).attr('name') + "'";
			params += ":'" + $.trim($(this).val()) + "'";
		});
		$('form input:password[ gps="form"]').each(function() {
			params += ",'" + $(this).attr('name') + "'";
			params += ":'" + $.trim($(this).val()) + "'";
		});
		$('form textarea[ gps="form"]').each(function() {
			params += ",'" + $(this).attr('name') + "'";
			params += ":'" + $.trim($(this).val()) + "'";
		});
		$('form input:radio:checked[ gps="form"]').each(function() {
			params += ",'" + $(this).attr('name') + "'";
			params += ":'" + $.trim($(this).val()) + "'";
		});
		$('form select[ gps="form"]').each(function() {
			params += ",'" + $(this).attr('name') + "'";
			params += ":'" + $.trim($(this).val()) + "'";
		});
		$('form input:hidden[ gps="form"]').each(function() {
			params += ",'" + $(this).attr('name') + "'";
			params += ":'" + $.trim($(this).val()) + "'";
		});
		var box_name = '';
		if($('form input:checkbox:checked[ gps="form"]').length>0){
			$('form input:checkbox:checked[ gps="form"]').each(function(index) {
			if(box_name != $(this).attr('name')){
				if(index){
					params += "','";
				}else{
					params += ",'";
				}
				params += $(this).attr('name') + "':'";
				params += $(this).attr('value');
				box_name = $(this).attr('name');
			}else{
				params += ","+ $(this).attr('value');
			}
			});
			params += "'";
		}
		params += "}";
		$.post(url, params, function(result) {
			layer.msg(result.msg, {
				time : 500
			}, function() {
				if(result.success){
					utilButtons.winToUrl(utilButtons.listUrl);
				}else{
					return false;
				}
			});
		});
	},// 搜索
	search : function() {
		utilButtons.text = "";
		utilButtons.params = "";
		 utilButtons.params = this.moduleName + "={'date':'" + new Date().getTime() + "'";
		$('form input[ gps="form"]').each(function() {
			utilButtons.params += ",'" + $(this).attr('name') + "'";
			utilButtons.params += ":'" + $.trim($(this).val()) + "'";
			utilButtons.text += $.trim($(this).val());
		});
		$('form select[ gps="form"]').each(function() {
			utilButtons.params += ",'" + $(this).attr('name') + "'";
			utilButtons.params += ":'" + $.trim($(this).val()) + "'";
			utilButtons.text += $.trim($(this).val());
		});
		$('form input:hidden[ gps="form"]').each(function() {
			utilButtons.params += ",'" + $(this).attr('name') + "'";
			utilButtons.params += ":'" + $.trim($(this).val()) + "'";
			utilButtons.text += $.trim($(this).val());
		});
		utilButtons.params += "}";
		if(utilButtons.text == ""){utilButtons.params = "date=" + new Date().getTime() + "";}
		$("#dtable").jqGrid('setGridParam', {
			url : utilButtons.listUrl+"?"+utilButtons.params,
			datatype : 'json',
			mtype : 'POST',
			page:1 
		}).trigger("reloadGrid"); // 重新载入+
	}, 
	// 导出
	exportExcel:function(){
		utilButtons.text = "";
		utilButtons.params = "";
		 utilButtons.params = this.moduleName + "={'date':'" + new Date().getTime() + "'";
		$('form input[ gps="form"]').each(function() {
			utilButtons.params += ",'" + $(this).attr('name') + "'";
			utilButtons.params += ":'" + $.trim($(this).val()) + "'";
			utilButtons.text += $.trim($(this).val());
		});
		$('form select[ gps="form"]').each(function() {
			utilButtons.params += ",'" + $(this).attr('name') + "'";
			utilButtons.params += ":'" + $.trim($(this).val()) + "'";
			utilButtons.text += $.trim($(this).val());
		});
		$('form input:hidden[ gps="form"]').each(function() {
			utilButtons.params += ",'" + $(this).attr('name') + "'";
			utilButtons.params += ":'" + $.trim($(this).val()) + "'";
			utilButtons.text += $.trim($(this).val());
		});
		utilButtons.params += "}";
		if(utilButtons.text == ""){utilButtons.params = "date=" + new Date().getTime() + "";}
		$.post(utilButtons.exportUrl, utilButtons.params, function(result) {
			var uri = "../" + result;
			window.open(uri, "_self");
		},'text');
	},
	// 窗口跳转
	winToUrl : function(url) {
		window.location.href = this.baseUrl + url;
	},// 集成jqgrid插件 url:查询URL caption:标题 colNames:列名 colModel:列对应实体类名
	tablePlugin : function(caption, colNames, colModel) {
		$("#dtable").jqGrid({
			url : utilButtons.listUrl,
			caption : caption,
			mtype : "POST",
			styleUI : 'Bootstrap',// 设置jqgrid的全局样式为bootstrap样式
			datatype : "json",
			colNames : colNames,
			colModel : colModel,
			viewrecords : true,
			multiselect : true,
			rownumbers : true,
			autowidth : true,
			height : "50%",
			autoScroll: true,   
			rowNum : utilButtons.rowNum,
			rownumbers : true, // 显示行号
			pager : "#jqGridPager",// 分页控件的id
			subGrid : false,
			loadComplete: function() {
                $("tr.jqgrow:odd").css("background", "#F5F5F5");
			}
		// 是否启用子表格
		});
		// jqgrid -- 样式调整
		utilButtons.tableCss();
	},// 集成jqgrid插件 url:查询URL caption:标题 colNames:列名 colModel:列对应实体类名 (数据较多时)
	tablePluginLong : function(caption, colNames, colModel) {
		$("#dtable").jqGrid({
			url : utilButtons.listUrl,
			caption : caption,
			mtype : "POST",
			styleUI : 'Bootstrap',// 设置jqgrid的全局样式为bootstrap样式
			datatype : "json",
			colNames : colNames,
			colModel : colModel,
			viewrecords : true,
			multiselect : true,
			rownumbers : true,
			autowidth : true,
			height : "50%",
			shrinkToFit:false,   
			autoScroll: true,   
			rowNum : utilButtons.rowNum,
			rownumbers : true, // 显示行号
			pager : "#jqGridPager",// 分页控件的id
			subGrid : false
		// 是否启用子表格
		});
		// jqgrid -- 样式调整
		utilButtons.tableCss();
		$(".ui-jqgrid .ui-jqgrid-bdiv").css("overflow-x","scroll");
	},// 集成jqgrid插件 url:查询URL caption:标题 colNames:列名 colModel:列对应实体类名(没有勾选框)
	tablePluginNo : function(caption, colNames, colModel,searchName,multiselect) {
		$("#dtable").jqGrid({
			url : utilButtons.listUrl,
			caption : caption,
			mtype : "POST",
			styleUI : 'Bootstrap',// 设置jqgrid的全局样式为bootstrap样式
			datatype : "json",
			colNames : colNames,
			colModel : colModel,
			viewrecords : true,
			multiselect : multiselect,
			rownumbers : false,
			autowidth : true,
			height : "50%",
			rowNum : utilButtons.rowNum,
			rownumbers : true, // 显示行号
			rownumWidth : 35, // the width of the row numbers columns
			pager : "#jqGridPager",// 分页控件的id
			subGrid : false,
			onSelectRow: function(rowId,status){  //点击事件
				// 如果是多选，显示确认按钮
				if(!multiselect){
					var rowData = $("#dtable").jqGrid("getRowData",rowId);
					setDataForRow(rowId,rowData);
				}else{
					return;
				} 
			}
		});
		// jqgrid -- 样式调整
		utilButtons.tableCss();
	},// 城市弹出框
	city : function(){
		 $('#addressName').click(function(event) {
			 showProvince(this, 'addressName', 'addressCode', 1, true, event);
		 });
	},// 城市弹出框
	city_plugin : function(){
		//iframe窗
		utilButtons.layerIndex = layer.open({
		  type: 2,
		  title: false,
		  closeBtn: 0, //不显示关闭按钮
		  shade: [0],
		  area: ['640px', '415px'],
		  shift: 2,
		  content: ['plugins/cityPlugin/demo.html', 'no'] //iframe的url，no代表不显示滚动条
		});
	}// 获取日期控件
	,getDate : function(id){
		laydate.skin('danlan'); 
		laydate({
		    elem: '#' + id, //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    event: 'click', //响应事件。如果没有传入event，则按照默认的click
		    format: 'YYYY-MM-DD', //日期格式
		    istoday: true//是否显示今天
		});
	}// 获取时间控件
	,getTime : function(id){
		laydate.skin('danlan'); 
		laydate({
		    elem: '#' + id, //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
		    event: 'click', //响应事件。如果没有传入event，则按照默认的click
		    format: 'YYYY-MM-DD hh:mm:ss', //日期格式
		    istime: true, //是否开启时间选择
		    fixed: true //是否固定在可视区域
		});
	},openLayerForRow : function(moduleName,width,height,row){
		utilButtons.layerIndex = layer.open({
			  type: 2,
			  area: [width+'px', height+'px'],
			  fix: false, //不固定
			  closeBtn :0,
			  shadeClose :true,
			  title: false,
			  content: 'common/openWin?row='+row+'&name='+moduleName
			});
	}
	,openLayer : function(moduleName,width,height,id){
		var url = '';
		if (id != '') {
			url = 'common/openWin?name='+moduleName+'&id='+id;
		}else{
			url = 'common/openWin?name='+moduleName;
		}
		utilButtons.layerIndex = layer.open({
			  type: 2,
			  area: [width+'px', height+'px'],
			  fix: false, //不固定
			  closeBtn :0,
			  shadeClose :true,
			  title: false,
			  content: url
			});
	}// 集成jqgrid插件 url:查询URL caption:标题 colNames:列名 colModel:列对应实体类名 --用于弹出框查询 @2016.7.14 baitao
	,tableWinPlugin : function(caption, colNames, colModel,searchName,multiselect) {
		utilButtons.searchName = searchName;
		$("#dtable").jqGrid({
			url : utilButtons.listUrl,
			caption : caption,
			mtype : "POST",
			styleUI : 'Bootstrap',// 设置jqgrid的全局样式为bootstrap样式
			datatype : "json",
			colNames : colNames,
			colModel : colModel,
			viewrecords : true,
			multiselect : multiselect,
			rownumbers : false,
			autowidth : true,
			height : "50%",
			rowNum : utilButtons.rowNum,
			rownumbers : true, // 显示行号
			rownumWidth : 35, // the width of the row numbers columns
			pager : "#jqGridPager",// 分页控件的id
			subGrid : false,
			onSelectRow: function(rowId,status){  //点击事件
				// 如果是多选，显示确认按钮
				if(!multiselect){
					var rowData = $("#dtable").jqGrid("getRowData",rowId);
					 window.parent.$('#'+utilButtons.searchWinValue+"_"+utilButtons.moduleName).val(rowId);
					 window.parent.$('#'+utilButtons.searchWinText+"_"+utilButtons.moduleName).val(rowData[searchName]);
					 parent.layer.close(parent.layer.getFrameIndex(window.name)); //获取窗口索引
				}else{
					return;
				} 
			}
		});
		// jqgrid -- 样式调整
		utilButtons.tableCss();
	}// 集成jqgrid插件 url:查询URL caption:标题 colNames:列名 colModel:列对应实体类名 --用于弹出框查询 @2017.3.2 baitao
	,tableWinPluginForRow : function(caption, colNames, colModel,searchName,colValues,colNamesValues,row) {
		utilButtons.searchName = searchName;
		$("#dtable").jqGrid({
			url : utilButtons.listUrl,
			caption : caption,
			mtype : "POST",
			styleUI : 'Bootstrap',// 设置jqgrid的全局样式为bootstrap样式
			datatype : "json",
			colNames : colNames,
			colModel : colModel,
			viewrecords : true,
			multiselect : false,
			rownumbers : false,
			autowidth : true,
			height : "50%",
			rowNum : utilButtons.rowNum,
			rownumbers : true, // 显示行号
			rownumWidth : 35, // the width of the row numbers columns
			pager : "#jqGridPager",// 分页控件的id
			subGrid : false,
			onSelectRow: function(rowId,status){  //点击事件
				var rowData = $("#dtable").jqGrid("getRowData",rowId);
				// 如果是多选，显示确认按钮
				for(var i =0 ;i < colValues.length;i++){
					 window.parent.$('#'+colNamesValues[i]+row).val(rowData[colValues[i]]);
				}
			}
		});
		// jqgrid -- 样式调整
		utilButtons.tableCss();
	},// 集成jqgrid插件 url:查询URL caption:标题 colNames:列名 colModel:列对应实体类名 --用于弹出框查询 @2016.7.18 baitao(多参数版)
	tableWinPluginArrays : function(caption, colNames, colModel,searchNames,colIdValues,colNameValues) {
		$("#dtable").jqGrid({
			url : utilButtons.listUrl,
			caption : caption,
			mtype : "POST",
			styleUI : 'Bootstrap',// 设置jqgrid的全局样式为bootstrap样式
			datatype : "json",
			colNames : colNames,
			colModel : colModel,
			viewrecords : true,
			multiselect : false,
			rownumbers : true,
			autowidth : true,
			height : "50%",
			rowNum : utilButtons.rowNum,
			rownumbers : false, // 显示行号
//			rownumWidth : 35, // the width of the row numbers columns
			pager : "#jqGridPager",// 分页控件的id
			subGrid : false,
			onSelectRow: function(rowId,status){  //点击事件
				var rowData = $("#dtable").jqGrid("getRowData",rowId);
				for(var i =0 ;i < colIdValues.length;i++){
					 window.parent.$('#'+utilButtons.searchWinValue+"_"+colIdValues[i]).val(rowData[colIdValues[i]]);
					 window.parent.$('#'+utilButtons.searchWinText+"_"+colNameValues[i]).val(rowData[colNameValues[i]]);
				}
				 parent.layer.close(parent.layer.getFrameIndex(window.name)); //获取窗口索引
			}
		});
		// jqgrid -- 样式调整
		utilButtons.tableCss();
	},// 下拉框自动回填
	selectInit : function(){
		//bootstrap-select style seo
		$(".selectpicker").selectpicker({noneSelectedText:'请选择'});
		
	},// jqgrid -- 样式调整
	tableCss : function(){
	// 是否启用子表格
	$("#dtable").jqGrid('navGrid', '#jqGridPager', {
		edit : false,
		add : false,
		del : false,
		search : false,
		refresh : true
	});
	// 设置jqgrid的宽度
	$(window).bind('resize', function() {
		var width = $('.jqGrid_wrapper').width();
		$("#dtable").setGridWidth(width);
	});
	},
	// 日期格式化 yyyy-MM-DD HH:mm:ss 默认带时分秒,false：年月日无时分秒
	dateFormate : function(type){
		var date = new Date();
		var year = date.getFullYear();
		var month = date.getMonth()+1;
		if(month < 10){
			month = "0" + month;
		}
		var day = date.getDate();
		if(day < 10){
			day = "0" + day;
		}
		var hours = date.getHours();
		if(hours < 10){
			hours = "0" + hours;
		}
		var minutes = date.getMinutes();
		if(minutes < 10){
			minutes = "0" + minutes;
		}
		var seconds = date.getSeconds();
		if(seconds < 10){
			seconds = "0" + seconds;
		}
		
		if(type){
			return year+"-"+month+"-"+day + " " + hours +":"+ minutes +":"+ seconds;
		}else{
			return year+"-"+month+"-"+day;
		}
	},
	// 日期格式化 yyyy-MM-DD HH:mm:ss 默认带时分秒,false：年月日无时分秒
	dateStrFormate : function(fmt){
		    var o = {
		        "M+": this.getMonth() + 1, //月份 
		        "d+": this.getDate(), //日 
		        "h+": this.getHours(), //小时 
		        "m+": this.getMinutes(), //分 
		        "s+": this.getSeconds(), //秒 
		        "q+": Math.floor((this.getMonth() + 3) / 3), //季度 
		        "S": this.getMilliseconds() //毫秒 
		    };
		    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
		    for (var k in o)
		    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		    return fmt;
	}// 地图选择弹出框 ---iframe
	,openLocation : function(title,width,height){
		 utilButtons.indexTip = layer.open({
			  type: 2,
			  area: [width+'px', height+'px'],
			  title : title,
			  fix: false, //不固定
			  shadeClose :true,
			  closeBtn: 0,
			  content: "common/jsp/location.jsp"
			});
	 },// 地图选择弹出框 ---div
	openLocationDiv : function(title,width,height){
		 utilButtons.indexTip = layer.open({
			  type: 1,
			  area: [width+'px', height+'px'],
			  title : title,
			  shadeClose :true,
			  closeBtn: 0,
			  content: $('#allmap')
			});
	 },
	// 初始化加载项
	init : function(){
		
		// 初始化城市弹出
		//utilButtons.city();
	}
};
 $(function() {
	 // 加载utilButtons插件
	 utilButtons.init();
 });