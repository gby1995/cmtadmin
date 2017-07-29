/**
 * 管理明细JS
 * @auther 
 */
	var ${detailJSName} = {
		listUrl : 'modules/system/${parentPackageName}/jsp/list.jsp',
		// 返回按钮事件
		goback : function(){
			utilButtons.winToUrl(this.listUrl);
		}
	};
