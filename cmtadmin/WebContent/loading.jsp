<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
	<head>
	  <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <title>姜堰区安全生产信息化管理系统</title>
    <meta name="keywords" content="姜堰区安全生产信息化管理系统" />
    <meta name="description" content="姜堰区安全生产信息化管理系统" />
    <link href="plugins/superui/loginbase/css/layout.css" rel="stylesheet" />
    <link href="modules/common/main/css/login.css" rel="stylesheet"/>
    <!-- 当前系统私有风格  -->
    <link href="plugins/superui/loginbase/css/pri_main_plug.css" rel="stylesheet">
    <style>
        .ibar {
            display: none;
        }
        .m-loginBox {
		    margin: 0 30px;
		    padding: 0;
		    overflow: hidden;
		     border:none;
		    border-radius: 8px;
		    background:none; 
		}
		.login{
		    margin: 12% auto;width: 568px!important;
		}
		.m-login_logoText .text_span{
		    text-shadow:none;
		    font-size: 15px!important;
		    color: #adadad!important;
		}
		.m-login_logoText{margin-bottom:0px!important;}
    </style>
</head>

<body style="background:#F4F4F5">
    <div class="main ">
        <!--登录-->
        <div class="login-dom login-max">
            <div class="login container " id="login">
                <div class="m-login_logoText">
                    <span class="text_span">正在进入系统，请稍后...</span>
                </div>
                <form class="login-form"   id="loginForm" onsubmit="return index.undoSubmit()" method="post" autocomplete="off">
                    <div class="m-loginBox">
                    	<img class="m-login_logoImg" src="plugins/superui/loginbase/img/load.gif" style="width:33%;height: auto;"/>
                    </div>
                    
                </form>
                
            </div>
        </div>
        
        <div class="popupDom">
            <div class="popup text-default">
            </div>
        </div>
    </div>
</body>
<script type="text/javascript"  src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="common/js/index.js"></script>

<script type="text/javascript">
	 $(function(){
		setTimeout(function () {
			 window.location = "main_index";
		 }, 1200);    
	});  
</script>       
							 




</html>