/**
 * 管理修改JS
 * @auther 
 */
	var edit_systemCorp = {
		url : 'systemCorp/edit',
		name : 'systemCorp',
		listUrl : 'modules/system/corp/jsp/list.jsp',
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