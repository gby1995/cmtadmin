<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String uploadPath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+  "/uploadFiles/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>姜堰区安全生产信息化管理系统</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="modules/common/main/css/font-awesome.css"/>
    <!-- Theme style -->
    <link rel="stylesheet" href="modules/common/main/css/AdminLTE_pri.css"> 
    <link rel="stylesheet" href="modules/common/main/css/_all-skins.min.css">
    <link rel="stylesheet" href="modules/common/main/css/supershopui.common.min.css" />
    <link href="plugins/layer/skin/layer.css" rel="stylesheet">
	<link href="plugins/layer/skin/layer.ext.css" rel="stylesheet">
    <style type="text/css">
        html {                               
            overflow: hidden;
        }
        
        .layui-layer-title{
            background: #3C8DBC!important;color: #fff!important;
        }
        .layui-layer-setwin {top: 12px!important;}	
        .layui-layer-setwin a{color: #fff!important;font-size: 16px!important;}            
        .form-horizontal .form-group {
		  margin-right:0px!important; 
		  margin-left:0px!important; 
		}   
		.layui-layer-btn .layui-layer-btn0 {
		    border-color: #3C8DBC!important;
		    background-color: #3C8DBC!important;
		    color: #fff!important;
		}
		.layui-layer-btn {border-top: 1px solid #dedede!important;}
		label {
	    font-weight: normal!important;
		}
		
		
		.m-menuBox {background-color: #fff;}
		.nav > li > a:hover, .nav > li > a:active, .nav > li > a:focus {
		    color: #fff;
		    background: #1A6DAE;
		}
		.actives{
		    color: #fff;
		    background: #1A6DAE;
		}
		.navbar-collapse {padding-left:0px;}
		.main-header .navbar{         
		      min-height: 75px;position: relative
		           
		}
		.main-header .logo{height: 75px;line-height: 75px;background-color: #1A6DAE!important;}
		.main-sidebar, .left-side{padding-top:125px;}
		.fixed .content-wrapper, .fixed .right-side{padding-top: 75px;}
		.main-header .sidebar-toggle{margin-top: 13px;}
		.navbar-custom-menu{margin-top: 13px;}
		.skin-blue-light .sidebar-menu>li:hover>a, .skin-blue-light .sidebar-menu>li.active>a {
	    color: #5f5f5f;
	    background: #f4f4f5;
	}
	.skin-blue-light .sidebar a {
    color: #737373;
}
.skin-blue-light .treeview-menu>li.active>a, .skin-blue-light .treeview-menu>li>a:hover {
    color: #5f5f5f;
}
.slimScrollDiv{border-top: 1px solid #3c8dbc;border-right: 1px solid #e4e4e4;}
.content-tabs{border-top: 1px solid #3c8dbc;}
#content-wrapper{border-left:none;}
#navbar-collapse{background:#F4F4F5}
.sidebar-menu .treeview-menu > li[data-level="1"] a{padding-left: 31px!important;}
.sidebar-menu .treeview-menu > li[data-level="2"] a{padding-left: 45px!important;}
.main-sidebar{background-color: #f4f4f5!important;}
.layui-layer-btn{
   padding-top:4%!important;           
}        
.navbar-nav li{cursor:pointer}
    </style>                                    
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
| SKINS         | skin-blue                               |
|               | skin-black                              |
|               | skin-purple                             |
|               | skin-yellow                             |
|               | skin-red                                |
|               | skin-green                              |
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue-light sidebar-mini fixed">
    <div class="wrapper">
        <!-- Main Header -->
        <header class="main-header">
            <!-- Logo -->
            <a href="" class="logo " style="position:relative;">
            	<!--  -->
            	<img src="/cmtadmin/plugins/superui/loginbase/img/logo_bg1.png" style="position: absolute;width: 100%;height: 75px;left:0px;">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                
                <!-- <span class="logo-mini" style="position: absolute;"><img class="img_logo" src="/cmtadmin/plugins/superui/loginbase/img/img_logo.png"></span> -->
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg" style="position:relative;">
                    <!-- <img class="img_logo_s" src="/cmtadmin/plugins/superui/loginbase/img/img_logo.png"> -->
                    <!-- <b>企业端</b> -->
                </span>
            </a>
            <!-- Header Navbar -->
            <div id="logOff" style="display:none;">
            	<p>您确定要退出登录吗？</p>
            </div>
            
            <nav class="navbar  navbar-static-top" role="navigation">
               <img src="/cmtadmin/plugins/superui/loginbase/img/logo_bg.png" style="position: absolute;width: 100%;height: 75px;">
                <!-- Sidebar navbar-custom-menu-->
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li class="dropdown messages-menu"></li>
                        <li>
                            <a title="退出" onclick="main.cancellation()"><i class="glyphicon glyphicon-off"></i></a>
                        </li>
                    </ul>
                </div>
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas"  role="button"  style="position: absolute;">
                    <span class="sr-only">切换导航</span>
                </a>
                <p class="text_logo" style="position: absolute;left: 3%;top: 31%;">姜堰区安全生产信息化管理系统</p> 
                
                <!-- Navbar Right Menu -->
                
            </nav>
        </header>
        <!-- Left side column. contains the logo and sidebar -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar Menu -->
                <ul class="sidebar-menu"></ul>
                <!-- /.sidebar-menu -->
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper" id="content-wrapper">
        		<!--  上方导航菜单那
        		<div class="collapse navbar-collapse m-menuBox" id="navbar-collapse" style="display: none">
                    <ul class="nav navbar-nav topmenu">
                   	<c:forEach var="menu" items="${menus}">  
                   		<li  ><a  href='javascript:void(0)' icon="${menu.icon}" text="${menu.text}" name="${menu.id}" url="${menu.url }">${menu.text}</a></li>
                  	</c:forEach> 
                    </ul>
                </div>
         		-->
            <div class="content-tabs">
                <button class="roll-nav roll-left tabLeft" onclick="scrollTabLeft()">
                    <i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs menuTabs tab-ui-menu" id="tab-menu">
                    <div class="page-tabs-content" style="margin-left: 0px;">

                    </div>
                </nav>
                <button class="roll-nav roll-right tabRight" onclick="scrollTabRight()">
                    <i class="fa fa-forward" style="margin-left: 3px;"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown tabClose" data-toggle="dropdown">
                        页签操作<i class="fa fa-caret-down" style="padding-left: 3px;"></i>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right" style="min-width: 128px;">
                        <li><a class="tabReload" href="javascript:refreshTab();">刷新当前</a></li>
                        <li><a class="tabCloseCurrent" href="javascript:closeCurrentTab();">关闭当前</a></li>
                        <li><a class="tabCloseAll" href="javascript:closeOtherTabs(true);">全部关闭</a></li>
                        <li><a class="tabCloseOther" href="javascript:closeOtherTabs();">除此之外全部关闭</a></li>
                    </ul>
                </div>
                <button class="roll-nav roll-right fullscreen"><i class="fa fa-arrows-alt"></i></button>
            </div>
            <div class="content-iframe " style="background-color: #ffffff; ">
                <div class="tab-content " id="tab-content">
       
                </div>
            </div>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
        <!-- Main Footer -->
        <footer class="main-footer">
            <!-- To the right -->
            <div class="pull-right hidden-xs">
                	项目组
            </div>
            <!-- Default to the left -->
           		 版权所有
        </footer>
        <!-- Control Sidebar -->
        <aside class="control-sidebar control-sidebar-dark">
            <!-- Create the tabs -->
            <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
                <li><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
                <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
            </ul>
            <!-- Tab panes -->
            <div class="tab-content">
                <!-- Home tab content -->
                <div class="tab-pane" id="control-sidebar-home-tab">
                    <h3 class="control-sidebar-heading">Recent Activity</h3>
                    <ul class="control-sidebar-menu">
                        <li>
                            <a href="javascript:void(0)">
                                <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                                <div class="menu-info">
                                    <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                                    <p>Will be 23 on April 24th</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)">
                                <i class="menu-icon fa fa-user bg-yellow"></i>
                                <div class="menu-info">
                                    <h4 class="control-sidebar-subheading">Frodo Updated His Profile</h4>
                                    <p>New phone +1(800)555-1234</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)">
                                <i class="menu-icon fa fa-envelope-o bg-light-blue"></i>
                                <div class="menu-info">
                                    <h4 class="control-sidebar-subheading">Nora Joined Mailing List</h4>
                                    <p>nora@example.com</p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)">
                                <i class="menu-icon fa fa-file-code-o bg-green"></i>
                                <div class="menu-info">
                                    <h4 class="control-sidebar-subheading">Cron Job 254 Executed</h4>
                                    <p>Execution time 5 seconds</p>
                                </div>
                            </a>
                        </li>
                    </ul>
                    <!-- /.control-sidebar-menu -->
                    <h3 class="control-sidebar-heading">Tasks Progress</h3>
                    <ul class="control-sidebar-menu">
                        <li>
                            <a href="javascript:void(0)">
                                <h4 class="control-sidebar-subheading">
                                    Custom Template Design
                                    <span class="label label-danger pull-right">70%</span>
                                </h4>
                                <div class="progress progress-xxs">
                                    <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)">
                                <h4 class="control-sidebar-subheading">
                                    Update Resume
                                    <span class="label label-success pull-right">95%</span>
                                </h4>
                                <div class="progress progress-xxs">
                                    <div class="progress-bar progress-bar-success" style="width: 95%"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)">
                                <h4 class="control-sidebar-subheading">
                                    Laravel Integration
                                    <span class="label label-warning pull-right">50%</span>
                                </h4>
                                <div class="progress progress-xxs">
                                    <div class="progress-bar progress-bar-warning" style="width: 50%"></div>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="javascript:void(0)">
                                <h4 class="control-sidebar-subheading">
                                    Back End Framework
                                    <span class="label label-primary pull-right">68%</span>
                                </h4>
                                <div class="progress progress-xxs">
                                    <div class="progress-bar progress-bar-primary" style="width: 68%"></div>
                                </div>
                            </a>
                        </li>
                    </ul>
                    <!-- /.control-sidebar-menu -->
                </div>
                <!-- /.tab-pane -->
                <!-- Stats tab content -->
                <div class="tab-pane" id="control-sidebar-stats-tab">状态面板设置</div>
                <!-- /.tab-pane -->
                <!-- Settings tab content -->
                <div class="tab-pane" id="control-sidebar-settings-tab">
                    <form method="post">
                        <h3 class="control-sidebar-heading">常规设置</h3>
                        <div class="form-group">
                            <label class="control-sidebar-subheading">
                                Report panel usage
                                <input type="checkbox" class="pull-right" checked>
                            </label>
                            <p>
                                Some information about this general settings option
                            </p>
                        </div>
                        <!-- /.form-group -->
                        <div class="form-group">
                            <label class="control-sidebar-subheading">
                                Allow mail redirect
                                <input type="checkbox" class="pull-right" checked>
                            </label>
                            <p>
                                Other sets of options are available
                            </p>
                        </div>
                        <!-- /.form-group -->
                        <div class="form-group">
                            <label class="control-sidebar-subheading">
                                Expose author name in posts
                                <input type="checkbox" class="pull-right" checked>
                            </label>
                            <p>
                                Allow the user to show his name in blog posts
                            </p>
                        </div>
                        <!-- /.form-group -->
                        <h3 class="control-sidebar-heading">Chat Settings</h3>
                        <div class="form-group">
                            <label class="control-sidebar-subheading">
                                Show me as online
                                <input type="checkbox" class="pull-right" checked>
                            </label>
                        </div>
                        <!-- /.form-group -->
                        <div class="form-group">
                            <label class="control-sidebar-subheading">
                                Turn off notifications
                                <input type="checkbox" class="pull-right">
                            </label>
                        </div>
                        <!-- /.form-group -->
                        <div class="form-group">
                            <label class="control-sidebar-subheading">
                                Delete chat history
                                <a href="javascript:void(0)" class="text-red pull-right"><i class="fa fa-trash-o"></i></a>
                            </label>
                        </div>
                        <!-- /.form-group -->
                    </form>
                </div>
                <!-- /.tab-pane -->
            </div>
        </aside>
        <!-- /.control-sidebar -->
        <!-- Add the sidebar's background. This div must be placed
        immediately after the control sidebar -->
        <div class="control-sidebar-bg"></div>
         <form class="form-horizontal" id="passwordBox" style="display:none;margin-top: 9%;">
				  <div class="form-group">
					    <label for="inputPassword1" class="col-sm-3 control-label">原密码</label>
					    <div class="col-sm-7">
					      <input type="password" class="form-control" id="inputPassword1" placeholder=" ">
					    </div>
				  </div>
				  <div class="form-group">
					    <label for="inputPassword2" class="col-sm-3 control-label">新密码</label>
					    <div class="col-sm-7">
					      <input type="password" class="form-control" id="inputPassword2" placeholder=" ">
					    </div>
				  </div>
			      <div class="form-group">
					    <label for="inputPassword3" class="col-sm-3 control-label">确认密码</label>
					    <div class="col-sm-7">
					      <input type="password" class="form-control" id="inputPassword3" placeholder=" ">
					    </div>
				  </div>
				  
				  <div class="line_bottom"> </div>
				  	
			</form>
    </div>
	<input type="hidden" id="uploadPath"  value="<%=uploadPath%>">
	<input type="hidden" id="basePath"  value="<%=basePath%>">
	<input type="hidden" id="path"  value="<%=path%>">
    <!-- ./wrapper -->
    <!-- REQUIRED JS SCRIPTS -->
    <!-- jQuery 2.2.3 -->
    <script  type="text/javascript" src="plugins/jQuery/jquery-2.2.3.min.js"></script>
    <!-- Bootstrap 3.3.6 -->
    <script type="text/javascript" src="plugins/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="plugins/layer/layer.min.js"></script>
	<script type="text/javascript" src="plugins/layer/extend/layer.ext.js"></script>
    <script type="text/javascript" src="modules/common/main/js/supershopui.common.js"></script>
    <script type="text/javascript" src="common/js/utils.js"></script>
    <script type="text/javascript" src="modules/common/main/js/main.js"></script>
    <script>
     $(function(){
        $(".navbar-nav li a").click(function() {
        	$(".navbar-nav li a").removeClass('actives');
            $(this).addClass('actives');    
        });
		
    });  
    </script>
</body>
</html>
