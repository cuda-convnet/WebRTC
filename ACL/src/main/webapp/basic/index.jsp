<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.free4lab.webrtc.common.APIConstants"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
				
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>WebRTC企业总机</title>
	<link rel="stylesheet" type="text/css" href="css/pc/base.css"/>
	<link rel="stylesheet" type="text/css" href="css/pc/switchboard.css"/>
	
	<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
	<link rel="stylesheet" type="text/css" href="bootstrap/css/front.css"/>
	<link rel="stylesheet" type="text/css" href="css/pc/front.css"/>
	<link rel="stylesheet" type="text/css" href="css/pc/rtc_list.css"/>
	<link rel="stylesheet" type="text/css" href="css/pc/bottom_operation.css"/>
	<link rel="stylesheet" type="text/css" href="css/pc/common_rtc.css"/>

</head>

<body>

    <input id="userName" type="hidden" value="<s:property value='#session.userName'/>"/>
	<input id="access_token" type="hidden" value="<s:property value='#session.accessToken'/>"/>
	
	<!--导航栏start-->
	<div class="rtc_head_box">
		<div class="rtc_head">

			<!--用户信息start-->
			<div class="user_info">
				<div class="portrait">
					<img src="css/pc/images/img/portrait65_1.jpg" width="65"
						height="65" />
				</div>
				<h1 class="user_name">临时用户</h1>
			</div>
			<!--用户信息end-->

			<!--右侧操作start-->
			<div class="rtc_head_right">
				<ul>
					<li class="head_exit" onclick="logout1()" style="float:right;"><a href="javascript:void(0)">退出</a></li>
				</ul>
			</div>
			<!--右侧操作end-->

		</div>
	</div>
	<!--导航栏end-->
	
	<!--主体-->
	<div class="rtc_box">
		<!--左-->
		<div class="rtc_box_left">

			<!--左 菜单-->
			<div class="rtc_menu">
				<ul>
					<s:iterator value="enterprises" var="enterprise">
				    <li><i><img src="css/pc/images/rtc_menu_icon0.png" width="50" height="50" /></i>
				            <a href="enterauto?eid=<s:property value="#enterprise.eid"/>&ename=<s:property value="#enterprise.name"/>"><s:property value="#enterprise.name"/></a></li>
				    </s:iterator>
				</ul>
			</div>
			<!--左 菜单 end-->
		</div>
		<!--左 end-->
		
		<div id="web" class="rtc_box_center" style="text-align: center;">
<%-- 			<br>
			<ul>
				<s:iterator value="enterprises" var="enterprise">
				<li><a href="enterauto?eid=<s:property value="#enterprise.eid"/>&ename=<s:property value="#enterprise.name"/>" style="font-size:24px;"><s:property value="#enterprise.name"/></a></li>
				</s:iterator>
			</ul> --%>
		</div>
	</div>
	<!-- 主体end -->

	<!--底部-->
	<div class="rtc_foot_box">
		<div class="foot">
			<p>值电信业务经营许可证A2.B1.B2-20040001 [京网文[2011]0814-291号] |
				京ICP备09031924号</p>
			<p>Copyright © 中国电信集团 版权所有</p>
		</div>
	</div>
	<!--底部 end-->

    <script type="text/javascript" src="js/plugin_video/org/cometd.js"></script> 
    <script type="text/javascript" src="js/plugin_webim/jquery-1.11.1.js"></script>
    <script type="text/javascript" src="js/plugin_video/jquery/jquery.md5.js"></script>
    <script type="text/javascript" src="js/plugin_video/jquery/jquery.cookie.js"></script>
    <script type="text/javascript" src="js/plugin_video/jquery/jquery.cometd.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-modal.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap-modalmanager.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/front.js"></script>
    <script type='text/javascript' src='js/begin.js'></script>
    <script type='text/javascript' src="js/pclogout.js"></script>
    
</body>
</html>