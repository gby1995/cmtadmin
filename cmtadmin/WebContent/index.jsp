﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String webPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<html>
	<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1" />
    <title></title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <!-- Bootstrap 3.3.6 -->
    <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
    <link href="plugins/superui/loginbase/css/layout.css" rel="stylesheet" />
    <link href="modules/common/main/css/login.css" rel="stylesheet"/>
    <!-- 当前系统私有风格  -->
    <link href="plugins/superui/loginbase/css/pri_main_plug.css" rel="stylesheet">
    <style>
        .ibar {
            display: none;
        }
        .see{
	        position: absolute;
		    right: 3px;
		    top: 14px;color:#9C9C9C
        }
        .mark{background:none!important;}
    </style>
</head>

<body class="s-bgBody_img">
    <div class="main ">
        <!--登录-->
        <div class="login-dom login-max" >
            <!-- <div class="logo text-center">
                <a href="#">
                    
                </a>
            </div> -->
            <div class="login container " id="login" >

                <form class="login-form"    autocomplete="off"style="margin-top:130px">
                    <div class="m-loginBox">
                        <div class="m-tabBox">
                            <ul class="list list_float list_2X">
                                <li class="j-tab_li mark "" style="width:100%"><span  class="text_a">后台登录</span></li>
                                <!-- <li class="j-tab_li"><a onclick="index.j_tab_change('.j-tab_box2',this)" class="text_a" href="###">安监登录</a></li> -->
                            </ul>
                        </div>
                        <div class="m-formBox ">
                            <div class="m-formBox_ins j-tab_box j-tab_box1">
                                <div class="login-box border text-small login-btn" id="box">
                                    <div class="name border-bottom">
                                        <input type="text" placeholder="企业账户" id="accountName" name="username" datatype="*" nullmsg="请填写帐号信息" />
                                    </div>
                                    <div class="pwd" style="position: relative;">
                                        <input type="password" placeholder="密码" datatype="*" id="accountPwd" name="password" nullmsg="请填写帐号密码" />
                                        <input type="text" style="position:absolute;left:0px;" class="seeText qytext ibar"/>
                                        <i class="glyphicon glyphicon-eye-open see qysee"></i>
                                    </div>
                                </div>
                                <div class="m-radioBox">
                                    <label>
                                        <input  class="u-radio" type="checkbox" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                                                                                                                   下次自动登录
                                    </label>
                                </div> 
                                <div style=" margin: 0 0; width:; height:50px;">
                                    <input type="button" class="btn_inline_b" style="float:center;margin-top:20px" value="登录" id="logincorp"/>
                                   <!--  <input type="button" class="btn_inline_b" style="float:right;" value="注册"  id="registercorp" /> -->
                                </div>
                            </div>
                            <!-- j-tab_box1 -->
                            <div class="m-formBox_ins j-tab_box j-tab_box2" style="display:none;">
                                <div class="login-box border text-small login-btn" id="box">
                                    <div class="name border-bottom">
                                        <input type="text" placeholder="安监账户" id="username" name="username" datatype="*" nullmsg="帐号信息" />
                                    </div>
                                    <div class="pwd" style="position: relative;">
                                        <input type="password" placeholder="密 码" datatype="*" id="password" name="password" nullmsg="帐号密码" />
                                        <input type="text" style="position:absolute;left:0px;" class="seeText ajtext ibar"/>
                                        <i class="glyphicon glyphicon-eye-open see seeAj"></i>
                                    </div>
                                </div>
                                <div class="m-radioBox">
                                    <label>
                                        <input  class="u-radio" type="checkbox" name="optionsRadios" id="optionsRadios1" value="option1" checked="">
                                                                                                             下次自动登录
                                    </label>
                                </div>
                                <div style=" margin: 0 0; width:; height:50px;">
                                    <input type="button" class="btn" style="float:left;line-height:28px;" value="登 录" id="loginManager"/>
                                </div>
                            </div>
                            <!-- j-tab_box2 -->
                        </div>
                    </div>
                    
                </form>
                
            </div>
        </div>
         <!--<div class="footer text-center text-small ie">
            Copyright 2013-2016 版权所有 ©tzhsweet 2015-2018<a href="#" target="_blank">粤ICP备16024545号-1</a>
            <span class="margin-left margin-right">|</span>
        </div> -->
        <div class="popupDom">
            <div class="popup text-default">
            </div>
        </div>
    </div>
    <input type="hidden" id="webPath" value="<%=webPath%>"/>
</body>
<script type="text/javascript"  src="plugins/jQuery/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="plugins/layer/layer.min.js"></script>
<script type="text/javascript" src="plugins/layer/extend/layer.ext.js"></script>
<script type="text/javascript" src="common/js/index.js"></script>

</html>