/**
 * 企业->危险源->设备树插件
 *
 * @author baitao 2017/3/8 企业->危险源->设备树专用等
 */

var harzardTree = {
    // 树数据
    data_url: 'common/getHarzardTree',
    leaf_url: '',
    data: [],
    harzardTreeObj : null,
    monitorChart : null,
    // 加载中的layerIndex
    loadingLayer: null,
    // 获取数据加载封装
    dataFilter: function(treeId, parentNode, treeDatas) {
        return treeDatas;
    },
    // 隐藏的 nodes
    hideenNodes: [],
    setting: '',
    // 定时器
    timer: '',
    init : function(){
    	// harzardTree 属性设置
    	harzardTree.setting = {
    			async : {
    				autoParam : [ "id", "checked" ],
    				enable : true,
    				url : harzardTree.data_url,
    				dataFilter : harzardTree.dataFilter
    			},
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
    				onClick: monitorData.getCharsData
    			}
    	};
    		// 初始化zTree
    	harzardTree.harzardTreeObj = $.fn.zTree.init($("#harzardTree"), harzardTree.setting, new Array());
    } 
};
harzardTree.init();
