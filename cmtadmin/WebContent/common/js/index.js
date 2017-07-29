/**
 * 登录JS
 * @auther
 */
	var index = {
			//企业、安监登录选择
			j_tab_change : function (text,obj){
			        var loc_obj = $(text);
			        var loc_this = $(obj).parent();
			        $(".j-tab_box").hide(0);
			        $(loc_obj).show(0);
			        $(".j-tab_li").removeClass("mark");
			        $(loc_this).addClass("mark");
			    },
			    validate : function(type){
			    	var name ;
					var password ;
					if(type == 0){
						 name = 'accountName';
						 password = 'accountPwd';
					}else{
						 name = 'username';
						 password = 'password';
					}
		                if ('' == $.trim($('#'+name).val())) {
		                    layer.msg("请填写完整信息！");
		                    return false;
		                }
		                if ('' == $.trim($('#'+password).val())) {
		                	layer.msg("请填写完整信息！");
		                    return false;
		                }
		                return true;
			    },
              //登录
				submitForm : function (type) {
					//校验
					if(this.validate(type)){
						
					var url;
					var loading ;
					if(type == 0){
						 url = 'cmtadmin/login';
						 loading = 'cmtadmin/loading.jsp';
					}else{
						 url = 'cmtadmin/login';
						 loading = 'cmtadmin/loading.jsp';
					}
					var webPath = $('#webPath').val();
					//加载层-风格4
					layer.msg('加载中', {
						//icon: 1
					});
					var index = layer.index; //获取当前弹层的索引号
					$.post(webPath+url, "systemUser=" + this.getJsonStr(type), function(data){
						if (data == "1") {
							layer.close(index); //关闭当前弹层
							//$('#loginForm').form('clear');
							layer.msg('登录失败!<br/>用户名或密码錯誤!');
							
						} else {
							window.location.href = webPath +  loading;
						}
					});
					}
				},

               //获取帐号密码
				getJsonStr : function(type) {
					var name ;
					var password ;
					if(type == 0){
						 name = 'accountName';
						 password = 'accountPwd';
					}else{
						 name = 'username';
						 password = 'password';
					}
					var params = {
							userName:$('#'+name).val(),
							password:$('#'+password).val()
					};
					
					return JSON.stringify(params);
				}
        
	};
	// 初始化加载
	$(function(){
	    $(".qysee").click(function(){
	         var val=$("#accountPwd").val();
	         var val2=$(".qytext").val();
	         var dp=$(".ibar").css("display");
	        if(dp=="none"){
	             $(this).css("color","#333");
	             $(".qytext").val(val);
	             $("#accountPwd").hide();
	             $(".qytext").show();
	         }else{
	             $("#accountPwd").val(val2);
	        	 $("#accountPwd").show();
	             $(".qytext").hide();
	             $(this).css("color","#9C9C9C");                  
	         }
	    });
	    
	    $(".seeAj").click(function(){
	        var dp=$(".ibar").css("display");
	        var ajval=$("#password").val();
	        var ajval2=$(".ajtext").val();
	       if(dp=="none"){
	            $(this).css("color","#333");
	            $(".ajtext").val(ajval);
	            $("#password").hide();
	            $(".ajtext").show();
	        }else{           
	            $("#password").val(ajval2);
	      	 	$("#password").show();
	            $(".ajtext").hide();
	            $(this).css("color","#9C9C9C");                  
	        }
	   });
	    
	    // 企业登录
	    $('#logincorp').click(function(){
	    	index.submitForm(0);
	    });
	    // 企业注册
	    $('#registercorp').click(function(){
	    	var webPath = $('#webPath').val();
	    	window.location.href = webPath + "/cmtadmin/modules/corp/register/registerExplain.html";
	    });
	    // 安监登录
	    $('#loginManager').click(function(){
	    	index.submitForm(1);
	    });
	    
	    
	  });