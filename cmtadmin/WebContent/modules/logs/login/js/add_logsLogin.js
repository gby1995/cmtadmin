/**
 * 管理新增JS
 * @auther 
 */
	var add_logsLogin = {
		url : 'logsLogin/add',
		name : 'logsLogin',
		listUrl : 'modules/logs/login/jsp/list.jsp',
		// 提交按钮事件
		submitForm : function(){
			// 设置查询URL
			utilButtons.listUrl = this.listUrl; 
			// 调用分页插件初始化列表
			utilButtons.submitForm(this.url,this.name);
		},
		// 返回按钮事件
		goback : function(){
			utilButtons.winToUrl(this.listUrl);
		}
	};
