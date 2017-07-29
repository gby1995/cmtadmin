/**
 * 区县->乡镇->企业树插件
 * 
 * @author baitao 2017/3/15 区县->乡镇->企业树专用等
 */

var topCorpTree = {
	// 树数据
	corp_url : 'common/gettopCorpTree',
	data_url : 'common/getDeviceTree',
	leaf_url : '',
	data : [],
	topCorpTreeObj : null,
	monitorChart : null,
	// 加载中的layerIndex
	loadingLayer : null,
	// 获取数据加载封装
	dataFilter : function(treeId, parentNode, treeDatas) {
		return treeDatas;
	},
	// 隐藏的 nodes
	hideenNodes : [],
	setting : '',
	// 定时器
	timer : '',
	init : function() {
		var id = $('#corpId').val();
		// 异步加载
		$.post(topCorpTree.corp_url, {
			'id' : id
		}, function(data) {
			var treeObj = $.fn.zTree.getZTreeObj("topCorpTree");
			// treeNode.selected = true;
			// topCorpTree 属性设置
			topCorpTree.setting = {
				check : {
					enable : false
				},
				data : {
					simpleData : {
						enable : true
					}
				},
				view : {
					expandSpeed : ""
				},
				callback : {
					onExpand : topCorpTree.getChildrenData,
					onClick : getData
				}
			};
			// 初始化zTree
			topCorpTree.topCorpTreeObj = $.fn.zTree.init($("#topCorpTree"), topCorpTree.setting, data);
		});
	},
	// 获取数据加载封装
	dataFilter : function(treeId, parentNode, treeDatas) {
		return treeDatas;
	},
	getChildrenData : function(event, treeId, treeNode) {
		if (!treeNode.selected) {
			var url = topCorpTree.data_url;
			// 异步加载
			$.post(url, {
				'id' : treeNode.id,
				'name' : treeNode.name,
				'pid' : treeNode.pId
			}, function(data) {
				var treeObj = $.fn.zTree.getZTreeObj("topCorpTree");
				treeObj.addNodes(treeNode, data);
				treeNode.selected = true;
			});
		}
	}
};
topCorpTree.init();
