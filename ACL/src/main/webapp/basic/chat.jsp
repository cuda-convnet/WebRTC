<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.free4lab.webrtc.common.APIConstants"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<base
		href="<%=request.getScheme() //协议：如http
		        + "://" 
				+ request.getServerName() //请求服务器IP：如localhost、10.109.112.49
				+ ":" 
				+ request.getServerPort() //请求服务器端口号Port:如8088
				+ request.getContextPath()%>/"/><!-- 工程上下文名称:如ACL、WCLnew、WMS --> 
				
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>${param.ename}-呼叫转接</title>
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
	<input id="pagename" type="hidden" value="chat"/>
	<input id="eid" type="hidden" value="${param.eid}"/>
	<input id="ename" type="hidden" value="${param.ename}"/>
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
				    <li><i><img src="css/pc/images/rtc_menu_icon0.png" width="50" height="50" /></i>
				            <a href="enterswitchboard">选择企业</a></li>
					<li><i><img src="css/pc/images/rtc_menu_icon1.png" width="50" height="50" /></i>
							<a href="enterauto?eid=${param.eid}&ename=${param.ename}">自动总机</a></li>
					<li><i><img src="css/pc/images/rtc_menu_icon1.png" width="50" height="50" /></i>
							<a href="enterarti?eid=${param.eid}&ename=${param.ename}">人工总机</a></li>
				</ul>
			</div>
			<!--左 菜单 end-->
		</div>
		<!--左 end-->
		
		<div id="web" class="rtc_box_center">
			<div class="chat_head">
				<h2 onclick="FriendModalFunctionArea('${param.chatFriendId}')">${param.chatFriendId}</h2>
				<div class="chat_head_operation">
					<ul>
						<li class="operation_close" onclick="exitChatWindow('${param.chatFriendId}')">关闭</li>
	                    <li class="operation_video" onclick="createCallVideoPageBefore('${param.chatFriendId}')">发起视频</li>
	                    <li class="operation_audio" onclick="createCallAudioPageBefore('${param.chatFriendId}')">发起音频</li>
	                    <li class="operation_file"><input type="file" name="files[]" onchange="CallFilesBefore(this,this.files,'${param.chatFriendId}');" multiple></li>
                    </ul>
               	</div>
			</div>
			
			<div class='chat_list_box'></div>
			
			<div class="input_chat_box">
				<textarea id="input_box" onkeydown="checkChatBoxEnterDown('${param.chatFriendId}')" name="" cols="" rows="" class="input_text"></textarea>
				<div class="input_chat_edit">
					<ul class="input_chat_edit_l"><li class="icon_history">查看历史对话</li>
                  		<li class="icon_face">选择表情</li>
                  		<li class="icon_font_size">文字大小</li>
                  		<li class="icon_color">文字颜色</li>
                  	</ul>
	                <div class="input_chat_edit_r">
	                	<input id="${param.chatFriendId}sendBtn" type="button" onclick="sendText('${param.chatFriendId}')" value="发送" class="send_out btn_blue"/>
	                </div>
               </div>		
			</div>
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
    <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/bootstrap-modal.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap-modalmanager.min.js"></script>
    <script type="text/javascript" src="bootstrap/js/front.js"></script>
    
    <!-- 环信API -->
    <script type="text/javascript" src="js/plugin_webim/strophe-custom-2.0.0.js"></script>
	<script type="text/javascript" src="js/plugin_webim/json2.js"></script>
    <script type="text/javascript" src="js/plugin_webim/easemob.im-1.0.5.js"></script>
    
    <script type="text/javascript" src="js/plugin_video/libcometd.js"></script>
    <script type="text/javascript" src="js/plugin_video/libwebrtc.js"></script>
  
    <script type="text/javascript" src="js/plugin_video/hashme.js"></script>
    <script type="text/javascript" src="js/plugin_video/md5.js"></script>
    <script type='text/javascript' src='js/plugin_video/init.js'></script>
    <script type="text/javascript" src="js/plugin_video/rtcprotocol.js"></script>
    <script type="text/javascript" src="js/plugin_video/configs.js"></script>

	<script type="text/javascript" src="js/plugin_video/fileSystem/protocolMessage.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/base64.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/file.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/lang_ext.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/queue.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/FSio.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/Block.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/BlockMap.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/BlockCache.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/AvailabilityMap.js"></script>
	<script type="text/javascript" src="js/plugin_video/fileSystem/binaryProtocol.js"></script>

	<script type="text/javascript" src="js/plugin_video/app.js"></script>
	<script type="text/javascript" src="js/plugin_video/SigSession.js"></script>
	<script type="text/javascript" src="js/plugin_video/WConnection.js"></script>
	<script type="text/javascript" src="js/plugin_video/WUserSessionBase.js"></script>
	<script type="text/javascript" src="js/plugin_video/AudioModule.js"></script>
	<script type="text/javascript" src="js/plugin_video/VideoModule.js"></script>
	<script type="text/javascript" src="js/plugin_video/FileModule.js"></script>
	<script type='text/javascript' src="js/plugin_video/MeetingVideoModule.js"></script>
	<script type='text/javascript' src="js/plugin_video/MeetingAudioModule.js"></script>
	<script type="text/javascript" src="js/plugin_video/WOTTSession.js"></script>
	<script type="text/javascript" src="js/plugin_video/WIMSSession.js"></script>
	<script type='text/javascript' src="js/plugin_video/WMeetingSession.js"></script>
	<script type='text/javascript' src="js/plugin_video/udpclient.js"></script>

	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type='text/javascript' src='js/begin.js'></script>
	<script type='text/javascript' src="js/startwebrtcPc.js"></script>
	<script type='text/javascript' src='js/impc.js'></script>
	<script type='text/javascript' src="js/pclogout.js"></script>
	<script type='text/javascript' src='js/initAll.js'></script>
	<script type='text/javascript' src='js/pc/webrtc_pc/RtcFileArea.js'></script>
	<script type='text/javascript' src='js/pc/webrtc_pc/Utils.js'></script>
	<script type='text/javascript' src='js/pc/webrtc_pc/RtcVideoAudio.js'></script>
	
  	<!-- by yck 自动总机 -->
  	<script type='text/javascript' src='js/pc/webrtc_pc/ChatUI.js'></script>
</body>
</html>