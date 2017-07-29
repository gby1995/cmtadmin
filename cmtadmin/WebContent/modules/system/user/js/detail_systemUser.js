/**
 * 管理明细JS
 * @auther 
 */
	var detail_systemUser = {
		listUrl : 'modules/system/user/jsp/list.jsp',
		// 返回按钮事件
		goback : function(){
			utilButtons.winToUrl(this.listUrl);
		}
	};
