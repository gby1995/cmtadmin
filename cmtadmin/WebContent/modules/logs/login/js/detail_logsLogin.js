/**
 * 管理明细JS
 * @auther 
 */
	var detail_logsLogin = {
		listUrl : 'modules/logs/login/jsp/list.jsp',
		// 返回按钮事件
		goback : function(){
			utilButtons.winToUrl(this.listUrl);
		}
	};
