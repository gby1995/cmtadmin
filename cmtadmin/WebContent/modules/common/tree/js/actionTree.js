/**
 * 菜单树插件
 *
 * @author baitao 2017/2/16 菜单树专用等
 */

var actionTree = {
    // 树数据
    data_url: 'common/getActionTreeAll',
    leaf_url: '',
    data: [],
    actionTreeObj : null,
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
    		// actionTree 属性设置
    	actionTree.setting = {
    			async : {
    				autoParam : [ "id", "checked" ],
    				enable : true,
    				url : actionTree.data_url,
    				dataFilter : actionTree.dataFilter
    			},
    			check : {
    				enable : true
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
    				onCheck:checkedNodes
    			}
    		};
    		// 初始化zTree
    	actionTree.actionTreeObj = $.fn.zTree.init($("#actionTree"), actionTree.setting, new Array());
    },
    // 获取数据加载封装
	dataFilter : function(treeId, parentNode, treeDatas) {
		return treeDatas;
	}
};
actionTree.init();
