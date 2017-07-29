var main = {
		initTabs : function(index,text,icon,url){
			 //$(function() {
			        //菜单格式
			$.post("common/menu_childs", {pid :index}, function(result) {
				$('.sidebar-menu li').remove();
				if(result.length <= 0){
			    		 $("body").addClass("sidebar-collapse");
			    	}else{
			    		  $("body").removeClass("sidebar-collapse");
			    	}
				var menus=[{
						id:index,
						text:text,
						icon:"fa fa-address-book-o",
						targetType:"iframe-tab",
						isOpen: true,
						url : url,
						children:result
				}]
				$('.sidebar-menu').sidebarMenu({ data: menus, param: { strUser: 'admin' } });
			});
			        return false;
			// });

		},//update pw
		changePw : function(){
		        	 layer.open({
						  type: 1,
						  title: '修改密码',
						  btn: ['确认', '取消'],
						  area: ['600px', '360px'],
						  shadeClose: true, //点击遮罩关闭
						  content:$('#passwordBox')   
							  ,btn2: function(index, layero){
								 
							  }
							  ,get:function getJsonStr() {
									var params = {
											password:$('#inputPassword2').val(),
											oldPassword:$('#inputPassword1').val()
									};
									
									return JSON.stringify(params);
								}
							  ,yes: function(index, layero){
								  
									
								  
									$.post("modifyPWD", "systemUser="+this.get(), function(data){               
										if (data == "1") {
											//$('#loginForm').form('clear');
											layer.msg('修改失败!<br/>密码錯誤!');
										} else {
											var index = layer.index; //获取当前弹层的索引号
											layer.close(index); //关闭当前弹层
										}
									});
									
							  }
							
						  });
		        	 
		        },
		      //cancellation(注销)
		        cancellation : function(){
		        	layer.confirm('您确定要退出登录?', {
		        		title: '提示' ,//不显示标题栏
		        		closeBtn: false,                
		        		 shadeClose: true, //点击遮罩关闭
		        		  btn: ['确定', '取消']             
		        	      ,btnAlign: 'c'
		        	  ,yes: function(index, layero){
		        		  
		        		  $.post("cancellation",function(data){               
								if (data == "1") {
									layer.msg('不能注销');
								} else {
									window.location = "index.jsp";
									var index = layer.index; //获取当前弹层的索引号
									layer.close(index); //关闭当前弹层
								}
							});
		        		    
		        	  }
		        	  , btn2: function(index, layero){
		        		 
		        	  }
		        	});
				}

};
$(function(){
	App.fixIframeCotent();
	//动态添加 上方菜单点击时间
//	$(document).off('click', '.topmenu li a')
//    .on('click', '.topmenu li a', function (e) {
//    	var index = $(this).attr('name');
//    	var text = $(this).attr('text');
//    	var icon = $(this).attr('icon');
//    	var url = $(this).attr('url');
//    	if(index == '1'){
//    		 $("body").addClass("sidebar-collapse");
//    	}else{
//    		  $("body").removeClass("sidebar-collapse");
//    	}
//    	main.initTabs(index,text,icon,url);
//    });
	var index = "1";
	var text = "系统管理";
	var icon = "fa fa-users";
	var url = "cmtadmin/modules/system/user/jsp/list.jsp";
	main.initTabs(index,text,icon,url);
	
	addTabs(({ id: '11', title: '用户管理', close: false, url: 'cmtadmin/modules/system/user/jsp/list.jsp' }));
	  $("body").addClass("sidebar-collapse");
});

