/**
 * 管理明细JS
 * @auther 
 */
	var detail_systemCamera = {
		listUrl : 'modules/system/camera/jsp/list.jsp',
		// 返回按钮事件
		goback : function(){
			utilButtons.winToUrl(this.listUrl);
		}
	};
