var VIDEO_URL;
var LOGOUT_FLAG=false;
//var VIDEO_URL = "http://mysparkweb.free4lab.com/http-bind:8888";
//填写IM的一些回调函数,待替换
$(document).ready(function(){
//	//视频相关-------------------------------------------------
//	//连接建立成功的回调函数
//	com.webrtc.onConnectionOpened = function(){
//		$("#socketconnected").val("true");
//		var  tipContent = "websocket连接建立成功！可以支持音视频会话";
//		fillTipBox('success',tipContent);
//	}
//	
//	//连接建立失败的回调函数
//	com.webrtc.onConnectionError = function(){
//		$("#socketconnected").val("false");
//		var  tipContent = "websocket连接建立失败！";
//		fillTipBox('error',tipContent);
//	};
//	
//	com.webrtc.onNotsupport = function(){
//		var  tipContent = "您的浏览器不支持音视频通话，请更换chrome_dev浏览器！";
//		fillTipBox('error',tipContent);
//		$("#browersupport").val("false");
//	};
//	
//	
//	//由前端实现，提供用户选择功能，弹出对应的选择是否答应的窗口
//	//以下onResponse 适应中兴项目需求！！！
//	com.webrtc.onResponse= function(remoteMediaType, originID){
//		//originID is like jxk143-163.com@WebRTC 或 alice@open-ims.com 或11111111
//		var src = originID
//		console.log("originID="+originID+"remoteMediaType="+remoteMediaType); 
//
//		var srcId=[];
//		srcId=src.split('@');     // 
//		console.log("srcId:"+srcId);
//		if(srcId[1]=="open-ims.com" ||srcId[1] == "gd.ctcims.cn"){     //ims   
//			//IMS callee
//			var IMSIdSignal = src;			
//			var IMSIdShow=src;		
//		    var obj={"id" : IMSIdShow,"avatar" : undefined,"name" : IMSIdSignal};   //id = alice@open-ims.com  name= alice@open-ims.com
//		    
//		    createIMSDialogDiv(obj,true);
//		    		   
//		    var divIdname='chat'+IMSIdShow;
//		    var CHAT = $(document.getElementById(divIdname));
//		    		    
//			if(remoteMediaType == "video"){
//				//视频
//				CHAT.find('.video').removeClass('hidden').attr('src', 'images/videoing.png');
//				CHAT.find('.audio').addClass('hidden');
//				CHAT.find('.hang').removeClass('hidden');
//				
//				$('#hiddenDivId').val(IMSIdShow);
//				$('#CurrentRemoteUserNameID').val(originID);
//				$('#videoresponsehref').attr('title', '来自 IMS <b> '+src+' </b>的视频会话请求');
//				$('#videoresponsehref').click();	
//				
//			}else if(remoteMediaType == "audio"){
//				//语音
//				CHAT.find('.audio').removeClass('hidden').attr('src', 'images/audioing.png');
//				CHAT.find('.video').addClass('hidden');
//				CHAT.find('.hang').removeClass('hidden');
//				
//				$('#hiddenDivId').val(IMSIdShow);
//				$('#CurrentRemoteUserNameID').val(originID);
//				$('#audioresponsehref').attr('title', '来自 IMS <b> '+src+' </b>的音频会话请求');
//				$('#audioresponsehref').click();	
//			}
//			else
//			{
//				console.log("remoteMediaType is error! remoteMediaType="+remoteMediaType);				
//			}
//						
//			
//
//		}
//		
//		else if(srcId[1]=="WebRTC"){               //  src=jxk143-163.com@WebRTC    srcID = [jxk143-163.com,WebRTC]   
//			console.log("flag5");
//			//文件传输对应的显示框
//			if(remoteMediaType == "file"){
//				console.log("begin to fileTransfer");
//				$('#filetranseferresponsehref').attr('title', '来自<b> '+src+' </b>的文件传输请求');
//				$('#filetranseferresponsehref').attr('value',src);			
//				$('#CurrentRemoteUserNameID').val(originID);
//				$('#filetranseferresponsehref').click();  
//			}
//			
//			//音视频对应弹窗
//			else if(remoteMediaType == "audio" || remoteMediaType == "video" || remoteMediaType == "screen"){
//				var divId = emailToUserId(srcId[0].replace('-','@'));
//								console.log("divId:" + divId);
//								if (remoteMediaType == "audio"
//										|| remoteMediaType == "video") {
//
//									if (divId != undefined) {
//										if ($('#chat' + divId).length > 0) {
//											$('#talking' + divId).dblclick();
//										} else {
//											$('#' + divId).dblclick();
//										}
//									} else {
//										divId=srcId[0].replace('-','@');
//										divId=divId.replace('@', '-').replace(
//												'.', '-');
//										var showid =srcId[0].replace('-','@')
//										
//										var src = showid.replace('#', '@');
//										var obj = {
//											id : src.replace('@', '-').replace(
//													'.', '-'),
//											avatar : undefined,
//											name : src
//										};
//										var member = [ obj ];
//										optionSpecialGroup('会话中', 'talking',
//												'add', member);
////										$('#talking' + obj.id).dblclick();
////									     var obj={"id" : showid,"avatar" : undefined,"name" : originId};
////											var member = [ obj ];
////											optionSpecialGroup('会话中', 'talking', 'add', member);
//											
//											$(document.getElementById("talking"+obj.id)).dblclick();
//											
//									}
//								}
//							
//				  
//					var localUserId = $('.pub_banner').attr("userId");
//				    var remoteMedia = 'video' + divId, localMedia = 'video' + localUserId + '_' + divId;
//				    com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
//				
//				    var divIdname='chat'+divId;
//				    
//				    var CHAT = $(document.getElementById(divIdname));
//				    if(remoteMediaType == "video"){
//					//视频
//				    	
//				    	CHAT.find('.video').removeClass('hidden').attr('src', 'images/videoing.png');
//				    	CHAT.find('.audio').addClass('hidden');
//				    	CHAT.find('.hang').removeClass('hidden');
//					 
//						$('#myfriendgb').click();
//						$('#hiddenDivId').val(divId);
//						$('#CurrentRemoteUserNameID').val(originID);
//						$('#videoresponsehref').attr('title', '来自<b> '+src+' </b>的视频会话请求');
//						$('#videoresponsehref').click();
//						
//				     }else if(remoteMediaType == "audio"){
//					//语音
//				    	 CHAT.find('.audio').removeClass('hidden').attr('src', 'images/audioing.png');
//				    	 CHAT.find('.video').addClass('hidden');
//				    	 CHAT.find('.hang').removeClass('hidden');
//					
//					$('#myfriendgb').click();
//					$('#hiddenDivId').val(divId);
//				    $('#CurrentRemoteUserNameID').val(originID);
//					$('#audioresponsehref').attr('title', '来自<b> '+src+' </b>的音频会话请求');
//					$('#audioresponsehref').click();
//					
//				   }
//				     else if (remoteMediaType == "screen")
//				    	 {
//				    	  var divIdname='chatscreen'+divId;
//				    		//屏幕共享
//				    	var name= formatRechange(originID);
//				    	var	obj = {"id" : divId,"avatar" : undefined,"name" : name};
//				    	
//				    	console.log("var obj id="+divId+"name="+name);
//				    	 createScreenshareDiv(obj, true);
//				    	 
//				    	 
//				    	 
//				    	 console.log("createScreenshareDiv success!!!")
//				    	 
//				    	 $('#'+divIdname+' .video').removeClass('hidden').attr('src', 'images/videoing.png');
//							//	 $('#'+divIdname+' .audio').addClass('hidden');
//								 $('#'+divIdname+' .hang').removeClass('hidden');
//						 
//							
//			
//							$('#hiddenDivId').val(divId);
//							$('#CurrentRemoteUserNameID').val(originID);
//							$('#screenresponsehref').attr('title', '来自<b> '+src+' </b>的屏幕共享请求');
//							$('#screenresponsehref').click();
//				    	 }
//			}
//		}
//		else
//			{ //目前else里是会议
//			
//			//IMS callee
//			var IMSIdSignal = originID;			
//			var IMSIdShow=originID;		
//		    var obj={"id" : IMSIdShow,"avatar" : undefined,"name" : IMSIdSignal};   //id = alice@open-ims.com  name= alice@open-ims.com		    
//		    
//		    IMSmeeting();
//		    loadmeetingVideoNew(IMSIdSignal);		    		   
//		
//		    var CHAT = $(document.getElementById("Meeting"));
//		    		    
//			
//		    console.log("in meeting response remoteMediaType = "+remoteMediaType);
//		    
//		    
//		    if(typeof remoteMediaType == "undefined" || remoteMediaType == null)
//		    {
//		    	console.log("begin to jump to Meetingvideooraudioresponsehref");
//		    	$('#hiddenDivId').val(IMSIdShow);
//				$('#CurrentRemoteUserNameID').val(originID);
//				$('#Meetingvideooraudioresponsehref').attr('title', '来自<b> '+src+' </b>的会议请求');
//				$('#Meetingvideooraudioresponsehref').click();
//		    	
//		    }
//		    
//		
//		    	
//		    	
//		    if(remoteMediaType == "video"){
//				//视频
//				CHAT.find('.video').removeClass('hidden').attr('src', 'images/videoing.png');
//				CHAT.find('.audio').addClass('hidden');
//				CHAT.find('.hang').removeClass('hidden');
//				$('#hiddenDivId').val(IMSIdShow);
//				$('#CurrentRemoteUserNameID').val(originID);
//				$('#Meetingvideoresponsehref').attr('title', '来自<b> '+src+' </b>的视频会议请求');
//				$('#Meetingvideoresponsehref').click();
//				
//				
//			}else if(remoteMediaType == "audio"){
//				//语音
//				CHAT.find('.audio').removeClass('hidden').attr('src', 'images/audioing.png');
//				CHAT.find('.video').addClass('hidden');
//				CHAT.find('.hang').removeClass('hidden');
//				
//				$('#hiddenDivId').val(IMSIdShow);
//				$('#CurrentRemoteUserNameID').val(originID);
//				$('#Meetingaudioresponsehref').attr('title', '来自<b> '+src+' </b>的音频会议请求');
//				$('#Meetingaudioresponsehref').click();
//			}
//			else
//			{
//				console.log("remoteMediaType is error! remoteMediaType="+remoteMediaType);				
//			}
//						
//		
//					
//			}
//	}
//	
//	//媒体流连通失败的回调函数
//	com.webrtc.onCallFailed = function(errCode,MediaType){
//		/* 1 ：对端拒绝请求；
//           2 ：对端不在线；
//           3 ：请求超时（现在设的是120s，如果对方没有接受请求会触发超时）；
//           4 ：会话冲突，对方正在会话中；
//           5 ：获取本地媒体流失败；
//           6 ：其他错误；
//         */
//
//		if(errCode == this.Session.SESSION_ERROR["refused"]){
//			alert('媒体流连通失败:对端拒绝请求');
//			console.log("User refused!");
//		} else if(errCode == this.Session.SESSION_ERROR["offline"]){
//			console.log(MediaType);
//			if(MediaType == "file")
//			{
//				alert('文件传输失败:对端不在线或对方的浏览器不支持webrtc文件传输');
//			}
//			else
//			{
//				alert('媒体流连通失败:对端不在线或对方的浏览器不支持webrtc多媒体会话');
//			}
//			console.log("User offline!");
//		} else if(errCode == this.Session.SESSION_ERROR["timeout"]){
//			alert('媒体流连通失败:请求超时');
//			console.log("Session timeout!");
//		} else if(errCode == this.Session.SESSION_ERROR["conflict"]){
//			alert('媒体流连通失败:会话冲突，对方正在会话中');
//			console.log("Session conflict!");
//		} else if(errCode == this.Session.SESSION_ERROR["local-stream-failed"]){
//			alert('媒体流连通失败:获取本地媒体流失败');
//			console.log("Local-stream-failed error!");
//		} else if(errCode == this.Session.SESSION_ERROR["remote-stream-failed"]){
//			alert('媒体流连通失败:获取远端媒体流失败');
//			console.log("Remote-stream-failed error!");
//		} else if(errCode == this.Session.SESSION_ERROR["other"]){
//			alert('媒体流连通失败:其他错误');
//			console.log("Other error!");
//		}
//		$(document).trigger('close.facebox');
//	}
//	
//	//媒体流连通成功的回调函数
//	com.webrtc.onCallActive = function(originID,mediaType){
//		
//		if(mediaType == "file")
//		{
//			if(typeof com.webrtc.gPeerConnections[originID + "file"] !=  "undefined"  &&   com.webrtc.gPeerConnections[originID + "file"]!=null)
//			{
//				 tipContent = "文件传输通道建立成功，正在传输文件";
//				 fillTipBox('success',tipContent);
//				 if(com.webrtc.gPeerConnections[originID + "file"].gCaller == true)
//				 {
//						com.webrtc.showprocessbar();
//				 }
//			}
//		}
//		else
//		{
//			if(typeof com.webrtc.gPeerConnections[originID] !=  "undefined"  &&   com.webrtc.gPeerConnections[originID]!=null)
//			{
//				var  tipContent = "媒体流连接成功，正在接通会话";
//				fillTipBox('success',tipContent);
//			}
//		}
//
//		
//	}
//	
//	//远端挂断会话的回调函数
//	com.webrtc.onRemoteHangUp = function(originID,MediaType){
//				
//		var srcId=[];
//		srcId=originID.split('@');		
//		if(srcId[1]=="open-ims.com" || srcId[1] == "gd.ctcims.cn"){ 
//						
//			 var IMSCHAT=$(document.getElementById('chat'+originID));			
//			 IMSCHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
//			 IMSCHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
//			 IMSCHAT.find('.hang').addClass('hidden');
//			 IMSCHAT.find("img[id^=bigaudiopicture]").hide();			
//			$(document).trigger('close.facebox');
//			var  tipContent = '远端用户已经挂断会话';
//			fillTipBox('error',tipContent);
//			alert('远端用户已经挂断会话');
//		
//		}
//		else if(srcId[1]=="WebRTC")
//		{
//			var divId = emailToUserId(srcId[0].replace('-','@'));		
//
//			if(divId != undefined){
//				var CHAT;
//				if(MediaType == "screen")
//				{
//					CHAT=$(document.getElementById('chatscreen'+divId));		
//				}
//				else
//				{
//					CHAT=$(document.getElementById('chat'+divId));	
//				}
//					CHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
//					CHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
//					CHAT.find('.hang').addClass('hidden');
//					CHAT.find("img[id^=bigaudiopicture]").hide();	
//				$(document).trigger('close.facebox');
//				var  tipContent;
//				if(MediaType == "screen")
//				{
//					tipContent= '远端用户已经关闭屏幕共享';
//					fillTipBox('error',tipContent);
//					alert('远端用户已经关闭屏幕共享');
//				}
//				else
//				{
//					tipContent= '远端用户已经挂断会话';
//					fillTipBox('error',tipContent);
//					alert('远端用户已经已经挂断会话');
//				}
//				
//
//			}
//			else
//			{
//				divId=srcId[0].replace('-','@');
//				divId=divId.replace('@', '-').replace('.', '-');
//				var CHAT=$(document.getElementById('chat'+divId));		
//				CHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
//				CHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
//				CHAT.find('.hang').addClass('hidden');
//				 CHAT.find("img[id^=bigaudiopicture]").hide();	
//				$(document).trigger('close.facebox');
//				var  tipContent = '远端用户已经挂断会话';
//				fillTipBox('error',tipContent);
//				alert('远端用户已经挂断会话');
//			}
//
//		}
//		else
//			{//会议			
//			 var IMSCHAT=$(document.getElementById('Meeting'));
//			
//			 IMSCHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
//			 IMSCHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
//			 IMSCHAT.find('.hang').addClass('hidden');				 			
//			 IMSCHAT.find("img[id^=bigaudiopicture]").hide();	
//			//	$('#dtmfclick').attr('style',"height\: 47px\; color\: grey \!important");
//			//	$("#DTMFflag").hide();
//			 
//			 
//			$(document).trigger('close.facebox');
//			var  tipContent = '会议结束';
//			fillTipBox('error',tipContent);
//			alert('会话结束');
//			
//			}
//	}
//		
//	//视频流不通或错误时，界面回调函数
//	com.webrtc.recoverinterface=function(originID,MediaType)
//	{
//		var srcId=[];
//		srcId=originID.split('@');
//		
//		if(srcId[1]=="open-ims.com"){ 
//					
//			 var IMSCHAT=$(document.getElementById('chat'+originID));			
//			 IMSCHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
//			 IMSCHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
//			 IMSCHAT.find('.hang').addClass('hidden');
//                         IMSCHAT.find("img[id^=bigaudiopicture]").hide();
//					
//		}
//		else if(srcId[1]=="WebRTC")
//		{
//				
//				var divId = emailToUserId(srcId[0].replace('-','@'));
//		
//				if(MediaType == "screen")
//				{
//					var CHAT=$(document.getElementById('chatscreen'+divId));					
//					CHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
//					CHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
//					CHAT.find('.hang').addClass('hidden');
//					CHAT.find("img[id^=bigaudiopicture]").hide();
//				}
//				else
//				{
//					var CHAT=$(document.getElementById('chat'+divId));					
//					CHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
//					CHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
//					CHAT.find('.hang').addClass('hidden');
//					CHAT.find("img[id^=bigaudiopicture]").hide();
//				}
//				
//		
//			}
//		else
//			{//会议
//						
//			 var IMSCHAT=$(document.getElementById('Meeting'));
//			
//			 IMSCHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
//			 IMSCHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
//			 IMSCHAT.find('.hang').addClass('hidden');	
//			 IMSCHAT.find("img[id^=bigaudiopicture]").hide();	
//			//	$('#dtmfclick').attr('style',"height\: 47px\; color\: grey \!important");
//			//	$("#DTMFflag").hide();
//			 
//			
//			}
//		
//		
//	}
//	
//	//会话切换 主叫的视频弹出函数
//	com.webrtc.startChangeView = function(originID)
//	{
//		var userID=formatRechange(originID);
//		
//		var divID=emailToUserId(userID);
//		
//		startFriendDialog(divID,'undefined');
//		beginVideo(userID,divID);
//	}
//	
//
//	com.webrtc.refreshMeetingList = function(list) {
//
//		console.log("refreshMeetingList");
//		var member = list.split(",");	
//		var localname = $('.pub_banner').attr("user");	
//		localname = formatChange(localname);
//		
//		for (var i = 0; i <= member.length - 1; i++) {
//			if (member[i] == localname) {
//				member.splice(i, 1);
//			}
//		}
//		console.log(member);
//		
//		$("#ullist").children().remove();	
//		for (var i = 0; i <= member.length - 1; i++) {	
//			if(member[i].indexOf("WebRTC")>=0)
//			{
//				var temp = formatRechange(member[i]);
//				loadmeetingmemberList(temp,member[i]);
//			}
//			else if(member[i].indexOf("open-ims.com")>=0)
//			{
//				loadmeetingmemberList(member[i],member[i]);
//			}
//			else
//			{
//				loadmeetingmemberList(member[i],member[i]);
//			}
//		}
//	}
//	
//	
//	com.webrtc.sendfullfile = function(){
//		 $("#filetransflag").html("已成功发送文件");
//	}
//	
//	com.webrtc.receivefullfile = function(){
//
//		 $("#filetransflag").html("已成功接收文件");		
//	}
//	
//	com.webrtc.receiving = function(numOfVerifiedChunks,numOfChunks){
//		//console.log(numOfVerifiedChunks+""+numOfChunks);
//
//		
//		$("#bar").css("width",(numOfVerifiedChunks/numOfChunks)*100+"%");
//	}
//	
//	com.webrtc.sending = function(iter,allchunkIDslength,pre){
//		  $("#bar").css("width",((iter+pre)/allchunkIDslength)*100+"%");
//	
//	}
//	
//	com.webrtc.showprocessbar = function()
//	{
//		 $("#Button1").click();
//		 console.log("hehehe");
//	}
	
//	
//	//IM相关--------------------------------------------------
//	//获取好友列表
//	com.xmpp.onRoster = function(user_list) {
//		
//		$("#addlistgb").unbind();
//		$('#addlistgb').click(function(){ShowAddListOnRoster()});					
//	//	console.log("userlist:"+user_list);	
//
//		$("#realfriend").html('');
//		if (user_list.length > 0 && $('#myfriendgb').hasClass('selected')) {
//			var markExistFriend = false;
//			for(var i=0; i<user_list.length; i++){
//				var groupName = user_list[i].group_name;
//				var is_root = user_list[i].is_root;
//				var group_member = user_list[i].group_member;
//				var groupMember = [];
//				//记录是否有好友
//				if( group_member.length > 0 ){
//					markExistFriend = true;
//				}
//				for(var j = 0; j < group_member.length; j++){
//								
//					groupMember[j] = {
//							userName:group_member[j].email_id,
//							userId:group_member[j].name,
//							status:group_member[j].status
//							};
//				
//				console.log(user_list[i].group_member[j].name);
//				
//				
//				}
//				showGroup(groupName, groupMember,is_root);
//			}
//			$(".webwidget_vertical_menu_temp").webwidget_vertical_menu();
//			$(".webwidget_vertical_menu_temp").removeClass('webwidget_vertical_menu_temp').addClass('webwidget_vertical_menu');
//			$('a[rel=facebox]').facebox();
//			$('a[rel=facebox]').attr('rel','faceboxready');
//			$('#friendadd').removeClass('hidden');
//			//没有好友的提醒
//			if(!markExistFriend){
//				var tipContent = "您还没有好友，赶紧添加吧";
//				fillTipBox('success',tipContent);
//			}
//		}
//		$("#addlistgb").unbind();
//		$('#addlistgb').click(function(){showAddListFn()});
//		
//		$("#myroomgb").unbind();
//		$('#myroomgb').click(function(){showRoomListFn()});
//		
//		//$('#addlistgb').attr('onclick','showAddListFn()');
//	};
//	
//	
////创建不存在的聊天室	
//com.xmpp.onRoomNotExist = function(room_list){
//	
//	var roomName= room_list.roomJID.split('@')[0];
////	showRoom(roomName);
//	
//}
//
////显示聊天室列表	
//com.xmpp.onRoomJoined = function(room_list) {
//	$("#addlistgb").unbind();
//	$('#addlistgb').click(function(){ShowAddListOnRoster()});
//	console.log("fer");	
//	console.log(room_list);	
//    console.log("der");
////	$("#realroom").html('');
//  
//	$("#frroom").hide();
////	if ($('#myroomgb').hasClass('selected')) {
//		var markExistFriend = false;
//		
//		    console.log("ert");
////		for(var i=0;i<room_list.length;i++){
//		
//			var roomName = room_list.roomJID.split('@')[0];
//			console.log("roomJID:"+room_list.roomJID);
//			console.log("roomname:");
//			console.log(roomName);
//			
//            showRoom(roomName);
//
//			console.log("dada");
//			
////		}
//		
//		$(".webwidget_vertical_menu_temp").webwidget_vertical_menu();
//		$(".webwidget_vertical_menu_temp").removeClass('webwidget_vertical_menu_temp').addClass('webwidget_vertical_menu');
//		$('a[rel=facebox]').facebox();
//		$('a[rel=facebox]').attr('rel','faceboxready');
//		$('#roomadd').removeClass('hidden');
//		//没有聊天室的提醒
//	    
////		if(!markExistFriend){
////			var tipContent = "您还没有聊天室，赶紧添加吧";
////			fillTipBox('success',tipContent);
////		}
//
//		$("#addlistgb").unbind();
//		$('#addlistgb').click(function(){showAddListFn()});
//		
//		$("#myfriendgb").unbind();
////		$('#myfriendgb').click(function(){showRoomListFn()});
//		
////	}
//	};
//		
//	//改变状态：在线、离线、离开
//	com.xmpp.onPresenceStatusChanged = function(data) {
//		console.log(data.email_id);
//		var divId = emailToUserId(data.email_id);
//		console.log(divId);
//		if(divId != undefined){
//			if($('#'+divId+' div:first').find('.status').attr('src') == "images/onlinemessage.gif" || $('#'+divId+' div:first').find('.status').attr('src') == "images/offlinemessage.gif"){
//				data.status = data.status + "message.gif";
//			}
//			$('#'+divId+' div:first').html('<img class=\'status leftfloat rightmargin_5\' src=\'images/'+data.status+'.gif\' /> <div class=\'leftfloat\'> '+data.email_id.split('/')[0])+'</div>';
//			$('#talking'+divId+' div:first').html('<img class=\'status leftfloat rightmargin_5\' src=\'images/'+data.status+'.gif\' /> <div class=\'leftfloat\'>  '+data.email_id.split('/')[0])+'</div>';
//			//添加会话窗口的在线状态
//			$("#chat"+divId+' .drag'+divId).html('<img class=\'status\' src=\'images/'+data.status+'.gif\' />  '+data.email_id.split('/')[0]);
//		}
//		console.log('jid === ' + data.email_id + ' status === ' + data.status);
//		
//		if(data.status == "offline" && data.email_id == com.user.email_id)
//		{
//			com.xmpp.connection.send($pres());
//		}
//  	  
//	};
//	//查找好友(添加好友前的查找功能)结果的回调函数，显示在某个服务器上查询好友的结果，返回值是一个由Object组成的数组
//	//其中Object包括email_id，name，jid和email四个属性，其中email_id和name为主要属性
//	com.xmpp.onSearchFriendResult = function(friendList){
//		$("#searchFriend").attr('disabled',false);
//		$("#searchFriend").attr('value','搜索');
//		if(friendList.length > 0 ){
//			$("#noSearchResult").attr('class','hidden');
//			$("#showSearchResult").attr('class','lheight');
//			var resultHtml="";
//			resultHtml += "<tr><td></td><td>用户账号</td></tr>";
//			for(var i=0; i<friendList.length; i++){
//				resultHtml += "<tr onclick=\"makeItSelectedFn('searchFriend"+ friendList[i].name +"','searchFriendList')\"><td><input id=\"searchFriend"+ friendList[i].name +"\" type=\"radio\" name=\"searchFriendList\" value=\""+ friendList[i].email_id +"\" onclick=\"stopBubble(event)\"/></td><td>"+ friendList[i].email_id +"</td></tr>";
//			}
//			$("#searchResultTable").html(resultHtml);
//			getStyle();
//		}else{
//			$("#noSearchResult").attr('class','lheight grey1border greybg');
//			$("#showSearchResult").attr('class','hidden');			
//			$("#noSearchResult div").attr('class','centeralign middleveralign redletter ');
//			$("#noSearchResult div").html('没有匹配的用户，请重新查询');
//		}		
//	}
//	//有好友email_id想订阅你的状态，需要弹框等待用户确定
//	com.xmpp.onPresenceSubscribe = function(email_id){
//		var oirList = $("#applyFriendId").val();
//		$("#applyFriendId").val(oirList+","+email_id);
//		$("#applyfriendhref").click();
//	}
//	com.xmpp.onPresenceUnsubscribe = function (email_id){
//		fillTipBox('success',email_id+'已经和您解除好友关系');
//	}
//	com.xmpp.onAddFriendSucceed = function(email_id){
//		fillTipBox('success','添加好友'+ email_id +'成功');
//	}
//	com.xmpp.onPresenceDenySubscribe = function(email_id){
//		fillTipBox('success',email_id+'拒绝了您的好友申请');
//	}
//	//收到消息
//	com.xmpp.onChatMessage = function(data) {
//		playAudioFn();//播放提示音
//		if( $("#friendlist").hasClass("hidden") ){
//			$("#newmsg").removeClass("hidden");
//		}
//		var divId = emailToUserId(data.email_id);
//		if(divId != undefined){
//			if($('#chat'+divId).length > 0){
//				$('#talking'+divId).dblclick();
//			}else{
//				$('#'+divId).dblclick();
//				$('#chat'+divId).hide();
//				//$('#talking'+divId).css({'background':'#479CF2'});
//				var status = $('#'+divId+' .status').attr('src').split('.')[0];
//				var newStatus = status+'message';
//				$('#'+divId+' .status').attr('src', newStatus+'.gif');
//				$('#talking'+divId+' .status').attr('src', newStatus+'.gif');
//			}
//		}else{
//			var obj = {
//				id : data.email_id.replace('@','-').replace('.','-'),
//				avatar : undefined,
//				name : data.email_id
//			};
//			divId = obj.id;
//			var member = [obj];
//			optionSpecialGroup('会话中','talking','add', member);
//			$('#talking'+divId).dblclick();
//			$('#chat'+divId).hide();
//			$('#talking'+divId).css({'background':'#479CF2'});
//			
//			$(document.getElementById("talking"+divId)).dblclick();
//		}
//		$('#to'+divId).append('<div class=\'leftalign strong blueletter padding5\'>' + data.email_id + '</div>')
//		$('#to'+divId).append('<div class=\'leftalign padding5\'>' + data.message + '</div>');
//		console.log('Receive message from ' + data.email_id + ': ' + data.message);
//		document.getElementById('to'+divId).scrollTop = document.getElementById('to'+divId).scrollHeight;
//	};
//	
//	//连接成功
//	com.xmpp.onConnected = function() {		
//		var username = $('.pub_banner').attr("user");
////		var username = $('.pub_banner').attr("thirdpartyuser");
//		console.log(username);
//		console.log('Connected');
//		VIDEO_URL = com.xmpp.getWebSocketUrl();
//		if(com.webrtc.getMediaSupport() == true){
//			$("#browersupport").val("true");
//			//连接webrtc视频---------------------
//			//webrtc设置本地用户名
//			com.webrtc.setLocalUserID(formatChange(username));
//			console.log(formatChange(username));
//			//webrtc视频创建连接
//			console.log("flag1");
//			com.webrtc.connect(VIDEO_URL);
//
//		}else{
//			var  tipContent = "您的浏览器不支持音视频通话，请更换chrome_dev浏览器！";
//			fillTipBox('error',tipContent);
//			$("#browersupport").val("false");
//		}
//	};
//	
//	//连接失败
//	com.xmpp.onConnectFail = function() {
//		console.log('Connect failed');
//	};
//	
//	//连接鉴权失败
//	com.xmpp.onConnectAuthFail = function() {
//		console.log('Auth failed because your JID or Password is wrong');
//	};
//	
//	//断开连接
//	com.xmpp.onDisconnected = function() {
//		//logout();
//		console.log('xmpp disconnected!!!!!!!!!!!!!!!!!!!!!');
//		if(LOGOUT_FLAG == true)
//		{
//			logout2();
//		}
//		else
//		{
//			var username = $('.pub_banner').attr("user");
//			var oauthToken = $('.pub_banner').attr("userid");
//			com.xmpp.initialize(username, oauthToken);
//		}
//
//		
//	};
//	
	var username = $('.pub_banner').attr("user");
	console.log(username);
	VIDEO_URL = com.websockets[0];
	console.log(VIDEO_URL);
	if(com.webrtc.getMediaSupport() == true){
		loginwebrtc();
		console.log("initAll end to loginwebrtc");
	}else{
		//不支持webrtc API
	}
	
	//连接环信
	console.log("connectToEase");
	connectToEase();
	console.log("connectToEase success in initAll.js");
	
	//连接Netty
	beginWebSocketToNetty();
	
	//初始化顶部未接信息数量
	initHeadTips(username);
});


//格式转化，去掉“@”换成“-”，并在后面加“@WebRTC”	
//eg: jxk143@163.com -->  jxk143-163.com@WebRTC
function formatChange(original){
	if(original.indexOf("@")!=-1){
		console.log("##################################################");
		console.log(original.split("@")[0]+'-'+original.split("@")[1]+"@WebRTC");
		return original.split("@")[0]+'-'+original.split("@")[1]+"@WebRTC";
	}
	else{
		console.log("**************************************************");
		console.log(original+"@WebRTC");
		return original+"@WebRTC";
	}
	
}
//格式转换，去掉“@WebRTC”，“-”换成“@”
////eg: jxk143-163.com@WebRTC -->  jxk143@163.com
function formatRechange(original){
	return original.split('@')[0].replace('-','@');
}
//格式转化，去掉“@”换成“-”  
//eg: jxk143@163.com -->  jxk143-163.com
function formatToEase(original){
	return original.replace('@','-');
}
//格式转化，去掉“-”换成“@”  
//eg: jxk143-163.com -->  jxk143@163.com
function formatReEase(original){
	return original.replace('-','@');
}

//格式转化，加上“@”
//eg: jxk143-163.com -->  jxk143-163.com@WebRTC
function EaseToWCS(original){
	return original+"@WebRTC";;
}
//格式转化，去掉“@WebRTC” 
//eg: jxk143-163.com@WebRTC -->  jxk143-163.com
function WCSToEase(original){
	return original.split('@')[0];
}


//开始IMS call视频通话
function beginIMSVideo(remoteUserName, remoteUserId){
       
	//In IMS CALL remoteUserName和 remoteUserId 是一样的 eg: alice@open-ims.com 

	   console.log(remoteUserName+remoteUserId);

		var localUserName = $('.pub_banner').attr("user"), localUserId = $('.pub_banner').attr("userId");
		var remoteMedia = 'video' + remoteUserId, localMedia = 'video' + localUserId + '_' + remoteUserId;
		var operationId = 'operation' + localUserId + '_' + remoteUserId;
					
        var IMSCHAT=$(document.getElementById('chat'+remoteUserId));
		IMSCHAT.find('.video').removeClass('hidden').attr('src', 'images/videoing.png');
		IMSCHAT.find('.audio').addClass('hidden');
		IMSCHAT.find('.hang').removeClass('hidden');		
		
		com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
		
		com.webrtc.setRemoteUserID(remoteUserName);
					
		var tipContent = "向"+remoteUserName+"发起IMS呼叫...";
		fillTipBox('success',tipContent);
	com.webrtc.call("video", "SDES");

}

//开始IMS 音频通话
function beginIMSAudio(remoteUserName, remoteUserId){
	
		var localUserName = $('.pub_banner').attr("user"), localUserId = $('.pub_banner').attr("userId");
		var remoteMedia = 'video' + remoteUserId, localMedia = 'video' + localUserId + '_' + remoteUserId;
		var operationId = 'operation' + localUserId + '_' + remoteUserId;

		 var IMSCHAT=$(document.getElementById('chat'+remoteUserId));
			IMSCHAT.find('.audio').removeClass('hidden').attr('src', 'images/audioing.png');
			IMSCHAT.find('.video').addClass('hidden');
			IMSCHAT.find('.hang').removeClass('hidden');
			IMSCHAT.find("img[id^=bigaudiopicture]").show();			
		com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
		com.webrtc.setRemoteUserID(remoteUserName);
				
		var tipContent = "向"+remoteUserName+"发起呼叫...";
		fillTipBox('success',tipContent);
	com.webrtc.call("audio", "SDES");
}


//开始Webrtc用户间视频通话
//remoteUserNameOriginal eg:woshikelebaobao@163.com   remoteUserId eg:811
function beginVideo(remoteUserNameOriginal, remoteUserId){
	
	//remoteUserName eg:woshikelebaobao-163.com@WebRTC
	   var remoteUserName = formatChange(remoteUserNameOriginal);
	   console.log("remoteUserName="+remoteUserName+" remoteUserId="+remoteUserId+"\n");
	   
	   //localUserName eg: jxk143@163.com    localUserId eg:742
		var localUserName = $('.pub_banner').attr("user");
		var localUserId = $('.pub_banner').attr("userId");
		var remoteMedia = 'video' + remoteUserId, localMedia = 'video' + localUserId + '_' + remoteUserId;
		var operationId = 'operation' + localUserId + '_' + remoteUserId;
		console.log('#'+operationId+' .video');
		
		var chatname='chat'+remoteUserId;
				
		  var CHAT=$(document.getElementById('chat'+remoteUserId));
			CHAT.find('.video').removeClass('hidden').attr('src', 'images/videoing.png');
			CHAT.find('.audio').addClass('hidden');
			CHAT.find('.hang').removeClass('hidden');
		
	    var CHATdblclick=$(document.getElementById(remoteUserId));
	    CHATdblclick.dblclick();
	
		//暂时存储在com.webrtc中  事实上最终应存在 com.webrtc.gPeerConnections[对端ID]中 
		com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
		com.webrtc.setRemoteUserID(remoteUserName);
				
		var tipContent = "向"+remoteUserName+"发起呼叫...";
		fillTipBox('success',tipContent);
		
	com.webrtc.call("video", "DTLS");

}

//开始音频通话的方法 WebRTC用户间
function beginAudio(remoteUserNameOriginal, remoteUserId){
	   var remoteUserName = formatChange(remoteUserNameOriginal);	

		var localUserName = $('.pub_banner').attr("user"), localUserId = $('.pub_banner').attr("userId");
		var remoteMedia = 'video' + remoteUserId, localMedia = 'video' + localUserId + '_' + remoteUserId;
		var operationId = 'operation' + localUserId + '_' + remoteUserId;
	
		
		var chatname='chat'+remoteUserId;
		
		
		  var CHAT=$(document.getElementById('chat'+remoteUserId));
		 
			CHAT.find('.audio').removeClass('hidden').attr('src', 'images/audioing.png');
			CHAT.find('.video').addClass('hidden');
			CHAT.find('.hang').removeClass('hidden');	 
			CHAT.find("img[id^=bigaudiopicture]").show();		
			var CHATdblclick=$(document.getElementById(remoteUserId));
			    CHATdblclick.dblclick();
				
		com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
		com.webrtc.setRemoteUserID(remoteUserName);
		
		var tipContent = "向"+remoteUserName+"发起呼叫...";
		fillTipBox('success',tipContent);
	com.webrtc.call("audio", "DTLS");

}


//开始屏幕共享
function beginScreen(remoteUserNameOriginal, remoteUserId)
{
	//remoteUserName eg:woshikelebaobao-163.com@WebRTC
	   var remoteUserName = formatChange(remoteUserNameOriginal);
	   console.log("remoteUserName="+remoteUserName+" remoteUserId="+remoteUserId+"\n");
	   
	   //localUserName eg: jxk143@163.com    localUserId eg:742
		var localUserName = $('.pub_banner').attr("user");
		var localUserId = $('.pub_banner').attr("userId");
		var remoteMedia = 'video' + remoteUserId, localMedia = 'video' + localUserId + '_' + remoteUserId;
		var operationId = 'operation' + localUserId + '_' + remoteUserId;
		console.log('#'+operationId+' .video');
		
		var chatname='chatscreen'+remoteUserId;
			
		  var CHAT=$(document.getElementById('chatscreen'+remoteUserId));
			CHAT.find('.video').removeClass('hidden').attr('src', 'images/videoing.png');
			CHAT.find('.hang').removeClass('hidden');
		
//	    var CHATdblclick=$(document.getElementById(remoteUserId));
//	    CHATdblclick.dblclick();			
	
		//暂时存储在com.webrtc中  事实上最终应存在 com.webrtc.gPeerConnections[对端ID]中 
		com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
		com.webrtc.setRemoteUserID(remoteUserName);
		
		
		var tipContent = "向"+remoteUserName+"发起呼叫...";
		fillTipBox('success',tipContent);
		
	com.webrtc.call("screen", "DTLS");
	
}

//开始文件传输
function beginFileTransfer(){
	
	var remoteUserIDs =readFromMark();
	var localUserName = $('.pub_banner').attr("user"), localUserId = $('.pub_banner').attr("userId");
//	var operationId = 'operation' + localUserId + '_' + remoteUserId;
	console.log(remoteUserIDs);
	var tipContent = "向"+remoteUserIDs+"传输文件";
	com.webrtc.setRemoteUserID(formatChange(remoteUserIDs));
    fillTipBox('success',tipContent);
    //判断是否已经建立文件传输的PeerConnection，是的话直接调用sendFile函数，否则调用call函数后再调用sendFile函数
    if  (typeof com.webrtc.gPeerConnections[formatChange(remoteUserIDs)+"file"] !="undefined" 
    	      && com.webrtc.gPeerConnections[formatChange(remoteUserIDs)+"file"]!=null ){
    		com.webrtc.file.sendFiles(formatChange(remoteUserIDs));
            com.webrtc.showprocessbar();
    
        }
    else
    {com.webrtc.call("file", "DTLS");}
}





//开始群组视频通话的方法
//function beginRoomVideo(room
//	
//	var remoteUse=[];
//	remoteUser=com.groupChat.getRoomMemberList(roomJID);
//
//	
//	for (var i=0;i<roomMember.length;i++){
//	
//		
//		console.log(remoteUser[i]);
//	if(com.webrtc.gRemoteUserID == null){
//		var remoteUseId=$(this).attr("id");
//		var remoteUseName=remoteUser[i];
//		var localUserName = $('.pub_banner').attr('user'),localUserId = $('.pub_banner').attr('userId');
//		com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
//		com.webrtc.setRemoteUserID(remoteUserName);
//		var tipContent = "向"+remoteUserName+"发起呼叫...";
//		fillTipBox('success',tipContent);
//		com.webrtc.call(true, true);
//		
//	}
//	
//	}
//}


//开始群组音频的方法
function beginRoomAudio(){
	
}

//关闭Webrtc 用户间会话
function endVideo(remoteUserName, remoteUserId){
	
	var remoteUserNameID=formatChange(remoteUserName);
	
		var hangUpname='chat'+remoteUserId;		
		
        var CHAT=$(document.getElementById('chat'+remoteUserId));
    	CHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
		CHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
		CHAT.find('.hang').addClass('hidden');
		CHAT.find("img[id^=bigaudiopicture]").hide();		
		
		com.webrtc.hangUp(remoteUserNameID);
		
		$("#tipbox").tipbox  ({
	        content: '会话已结束',
	        autoclose: true,
	        hasclose: false
		});
//	}
}

// IMS 挂断
function endIMSVideo(remoteUserName, remoteUserId){
	console.log(remoteUserName+remoteUserId);
	
	var remoteUserNameID=remoteUserName;
	
		var hangUpname='chat'+remoteUserId;
				
        var CHAT=$(document.getElementById('chat'+remoteUserId));
    	CHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
		CHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
		CHAT.find('.hang').addClass('hidden');
		CHAT.find("img[id^=bigaudiopicture]").hide();		
		
		console.log(com.webrtc.gPeerConnections[remoteUserNameID]);
		
		com.webrtc.hangUp(remoteUserNameID);
		$("#tipbox").tipbox  ({
	        content: '会话已结束',
	        autoclose: true,
	        hasclose: false
		});
//	}
}


function endScreen(remoteUserName, remoteUserId)
{	
	var remoteUserNameID=formatChange(remoteUserName);
	
		var hangUpname='chatscreen'+remoteUserId;		
		
        var CHAT=$(document.getElementById('chatscreen'+remoteUserId));
		CHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
		CHAT.find('.hang').addClass('hidden');
		
		com.webrtc.hangUp(remoteUserNameID);
		$("#tipbox").tipbox  ({
	        content: '会话已结束',
	        autoclose: true,
	        hasclose: false
		});
}

function beginIMSmeetingVideo(){
	var IMSId = $('#meetingInputId').val();
	
	if(IMSId==""){
		
		$('#meetingInputId').val("");
		$('#meetingInputId').attr("placeholder","请输入会议号");
		alert("会议号不能为空！");
	}
	else{
		loadmeetingVideoNew(IMSId);
		beginMeetingVideo(IMSId,IMSId);
	}	
}

function beginIMSmeetingAudio(){
	var IMSId = $('#meetingInputId').val();
	
	if(IMSId==""){
		
		$('#meetingInputId').val("");
		$('#meetingInputId').attr("placeholder","请输入会议号");
		alert("会议号不能为空！");
	}
	else{
		loadmeetingVideoNew(IMSId);
		beginMeetingAudio(IMSId,IMSId);
	}
	
}


//发起会议视频
function beginMeetingVideo(remoteUserName,remoteUserId)
{
	   console.log(remoteUserName+remoteUserId);

		var localUserName = $('.pub_banner').attr("user"), localUserId = $('.pub_banner').attr("userId");
		var remoteMedia = 'video' + remoteUserId, localMedia = 'video' + localUserId + '_' + remoteUserId;
		var operationId = 'operation' + localUserId + '_' + remoteUserId;
					
     var IMSCHAT=$(document.getElementById("Meeting"));
		IMSCHAT.find('.video').removeClass('hidden').attr('src', 'images/videoing.png');
		IMSCHAT.find('.audio').addClass('hidden');
		IMSCHAT.find('.hang').removeClass('hidden');		
		IMSCHAT.find("img[id^=bigaudiopicture]").show();	
		com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
		
		com.webrtc.setRemoteUserID(remoteUserName);
					
		var tipContent = "向"+remoteUserName+"发起视频会议呼叫...";
		fillTipBox('success',tipContent);
		com.webrtc.call("video","DTLS");
}

function beginMeetingAudio(remoteUserName,remoteUserId)
{
	   console.log(remoteUserName+remoteUserId);

		var localUserName = $('.pub_banner').attr("user"), localUserId = $('.pub_banner').attr("userId");
		var remoteMedia = 'video' + remoteUserId, localMedia = 'video' + localUserId + '_' + remoteUserId;
		var operationId = 'operation' + localUserId + '_' + remoteUserId;
					
     var IMSCHAT=$(document.getElementById("Meeting"));
		IMSCHAT.find('.audio').removeClass('hidden').attr('src', 'images/audioing.png');
		IMSCHAT.find('.video').addClass('hidden');
		IMSCHAT.find('.hang').removeClass('hidden');	
		IMSCHAT.find("img[id^=bigaudiopicture]").show();	
		
		com.webrtc.setMediaDisplayLabel(localMedia, remoteMedia);
		
		com.webrtc.setRemoteUserID(remoteUserName);
					
		var tipContent = "向"+remoteUserName+"发起音频会议呼叫...";
		fillTipBox('success',tipContent);
		com.webrtc.call("audio","DTLS");
}

function endIMSmeetingVideo(){
	$('#meetingInputId').attr("placeholder","请输入会议号");
	$('#meetingInputId').val("");
	var IMSId=$("#videoflag video").attr("id").substr(5);
	console.log("hangup IMSId="+IMSId);
	$("#ullist").children().remove();	
	endMeetingVideo(IMSId,IMSId);
}


function endMeetingVideo(remoteUserName, remoteUserId){
	console.log(remoteUserName+remoteUserId);
	
	var remoteUserNameID=remoteUserName;
				
        var CHAT=$(document.getElementById("Meeting"));
		CHAT.find('.video').removeClass('hidden').attr('src','images/video.png');
		CHAT.find('.audio').removeClass('hidden').attr('src','images/voice.png');
		CHAT.find('.hang').addClass('hidden');
		CHAT.find("img[id^=bigaudiopicture]").hide();	
		
		console.log(com.webrtc.gPeerConnections[remoteUserNameID]);
		
		com.webrtc.hangUp(remoteUserNameID);
		$("#tipbox").tipbox  ({
	        content: '会话已结束',
	        autoclose: true,
	        hasclose: false
		});
}

//function handlebegin(showid,originId)
//{
//	console.log("showid = " + showid);
//	if(originId.indexOf("WebRTC")>=0)
//	{
//		var divId =emailToUserId(showid);
//		console.log("divId:" + divId);
//
//			if (divId != undefined) {
//				if ($('#chat' + divId).length > 0) {
//					$('#talking' + divId).dblclick();
//				} else {
//					$('#' + divId).dblclick();
//				}
//				count=count+10;
//				$('#chat' + divId).css({'z-index':count});
//			} else {
//				var src = showid.replace('#', '@');
//				var obj = {
//					id : src.replace('@', '-').replace(
//							'.', '-'),
//					avatar : undefined,
//					name : src
//				};
//				var member = [ obj ];
//				optionSpecialGroup('会话中', 'talking','add', member);
//				
//				$(document.getElementById("talking"+obj.id)).dblclick();
//			//	$('#talking' + obj.id).dblclick();
//		
//			}
//		
//	}
//	else if(originId.indexOf("open-ims.com")>=0)
//	{
//		console.log("show ims dialogdiv")
//		 var obj={"id" : showid,"avatar" : undefined,"name" : originId};   //id = alice@open-ims.com  name= alice@open-ims.com
//		   
//		 createIMSDialogDiv(obj,true);
//	}
//	else
//	{
//		console.log("do nothing....................");
//	}
	
	
   
	
//}

//发送im消息的方法
function sendMsg(jid, content, divId){
	jid = jid.replace('-', '@');
	com.xmpp.sendChatMessage(jid, content);
	var myemail = $('.pub_banner').attr("user");
	$('#to'+divId).append('<div class=\'leftalign orangeletter strong padding5\'>' + myemail + '</div>');
	$('#to'+divId).append('<div class=\'lefttalign padding5\'>' + content + '</div>');
	console.log('Send message to ' + jid + ': ' + content);
	document.getElementById('to'+divId).scrollTop = document.getElementById('to'+divId).scrollHeight;
}

//取消、关闭浮层
function cancelFaceboxFn(){
	$(document).trigger('close.facebox');			
}
//检查非空
function checkNullIllegal(checkId,tipId){
	var checkValue = $("#"+checkId).val();
	if(!checkValue || checkValue == ""){
		var errorTip = "该项不能为空";
		$("#"+tipId).html(errorTip);
		return false;
	}else{
		$("#"+tipId).html("√");
		return true;
	}
}
//检查是否符合email格式
function checkEmailIllegalFn(checkId,tipId){
	var checkValue = $("#"+checkId).val();
	var check = new RegExp(/^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/).test(checkValue);	
	if(!check){
		$("#"+tipId).html("格式错误");
		return false;
	}else{
		$("#"+tipId).html("√");
		return true;	
	}
}
//填充状态提醒框
function fillTipBox(status,content){
	var  tipContent = "<table><tr><td><img src='images/"+status+".png'/></td><td>&nbsp;"+content+"&nbsp;</td></tr></table>";
	 
	$("#tipboxWrapper").html("<div  id=\"tipbox\"  class=\"mytipboxposition\"></div>");
	$("#tipbox").tipbox  ({
	         content:tipContent,
	         autoclose:true,
	         hasclose:false
	});
}
//记录刚刚点击的好友的id
function writeIntoMark(friendId){
	$("#whichIsClicked").val(friendId);
}
function readFromMark(){
	return $("#whichIsClicked").val();
}
//点击“我的群组”，分组显示  by chenyan
//存储联系人名字
//function showFriendListOnAddr(){
//	alert('群组列表正在加载中，请在加载成功后再切换到好友列表！');
//}
//
//function ShowAddListOnRoster(){
//	alert('好友列表正在加载中，请在加载成功后再切换到通讯录！');
//}
//
//var roomNameList = [];
//var roomGroupnameList= [];//存储联系人群组名字的数组

//点击“通讯录”，分组显示
 //存储联系人名字
function showFriendListOnAddr(){
	alert('通讯录列表正在加载中，请在加载成功后再切换到好友列表！');
}

function ShowAddListOnRoster(){
	alert('好友列表正在加载中，请在加载成功后再切换到通讯录！');
}
function ShowRoomListOnAddr(){
	alert('好友列表正在加载中，请在加载成功后再切换到群组列表！');
}
function ShowRoomListOnRoster(){
	alert('通讯录列表正在加载中，请在加载成功后再切换到群组列表！');
}

var contactNameList = [];
var contactGroupnameList= [];//存储联系人群组名字的数组


//function showAddListFn(){
//	$("#myfriendgb").unbind();
//	$('#myfriendgb').click(function(){showFriendListOnAddr();});
//	
//	$("#myroomgb").unbind();//移除myroomgb的事件
//	$('#myroomgb').click(function(){showRoomListRoster();});
//	
//	//隐藏好友类表的内容
//	showFriendFrame('addlist');		
//	contactGroupnameList=[];
//	$.ajax({
//		type:"post",
//		url:"platform/getContactlistByGroup",
//		data:{},
//		dataType:"json",
//		success:function(data){
//			$("#realcontact").html('');
//			console.log(data);
//			var j=0;
//			var s=0;
//			var groupContactlist=data.groupContactlist;
//			
//			if(groupContactlist.length==0){
//				$("#frloading").hide();
//				//$("#searchcontact").hide();//隐藏搜索框
//				fillTipBox("success","亲，你还没有联系人呢!赶快添加联系人吧！");
//				$("#realcontact").html('<div class="redletter bigsize">您还没有联系人，点击下方的图标即可添加联系人!</div>');
//			}else{
//				//如果只有根组，且为空，提示用户没有联系人.
//				if(groupContactlist.length==1&&groupContactlist[0].groupName=="我的联系人"&&groupContactlist[0].groupMembers.length==0){
//					$("#frloading").hide();
//					//$("#searchcontact").hide();//隐藏搜索框
//					fillTipBox("success","亲，你还没有联系人呢!赶快添加联系人吧！");
//					var groupName=groupContactlist[0].groupName;
//					var groupMember = [];
//					
//					showContactGroup(groupName, groupMember);//调用
//					//$("#friendcontent").append('<div class="redletter bigsize">您还没有联系人，点击下方的图标即可添加联系人!</div>');
//				}
//				else{
//				for(var i=0;i<groupContactlist.length;i++){
//					var groupName=groupContactlist[i].groupName;
//					//群组名字
//					
//					contactGroupnameList[s++]=groupContactlist[i].groupName;
//					//console.log("the group name: "+groupContactlist[i].groupName);
//					var groupMember = [];
//						for(var k=0; k<groupContactlist[i].groupMembers.length;k++){
//							
//							groupMember[k] = {					
//									userId:groupContactlist[i].groupMembers[k].friendId,
//									userName:groupContactlist[i].groupMembers[k].nickname,
//									
//									qq:groupContactlist[i].groupMembers[k].qq,
//									phone:groupContactlist[i].groupMembers[k].phone,
//									email:groupContactlist[i].groupMembers[k].email,
//									webrtc:groupContactlist[i].groupMembers[k].webrtc
//									};
//							//联系人
//							contactNameList[j++]={					
//									userId:groupContactlist[i].groupMembers[k].friendId,
//									userName:groupContactlist[i].groupMembers[k].nickname
//							};
//							
//						}
//						showContactGroup(groupName, groupMember);//调用
//					}
//				console.log("group name:"+contactGroupnameList);//
//				}
//			}
//			showFriendList();
//			$('a[rel=facebox]').facebox();
//			$('a[rel=facebox]').attr('rel','faceboxready');
//			$(".webwidget_vertical_menu_temp").webwidget_vertical_menu();
//			$(".webwidget_vertical_menu_temp").removeClass('webwidget_vertical_menu_temp').addClass('webwidget_vertical_menu');
//			$('#addContact').removeClass('hidden');
//		}
//	});
//	$("#myfriendgb").unbind();
//	$('#myfriendgb').click(function(){showFriendListFn();});
//	$("#myroomgb").unbind();
//	$('#myroomgb').click(function(){showRoomListFn();});
//}

//点击“我的好友”
function showFriendListFn(){
	showFriendFrame('friend');
	showFriendList();
	
}

function showRoomListFn(){
	
	showFriendFrame('room');
	
	showFriendList();
	
	$("#myfriendgb").unbind();
	$('#myfriendgb').click(function(){showFriendListFn();});
	
}

//将用户email转为用户id
function emailToUserId(email){
	var friendList = [];
	friendList = com.xmpp.getRoster();
	for(var i = 0; i < friendList.length; i++){
		if(friendList[i].email_id == email){
			return friendList[i].name.split('@')[0].replace('#','_').replace('.','_');
			console.log(friendList[i].name);
		}
	}
	return undefined;
}

//将用户id转为email
function userIdToEmail(userId){
	var friendList = [];
	friendList = com.xmpp.getRoster();
	console.log(friendList);
	for(var i = 0; i < friendList.length; i++){
		console.log("friendList name:"+friendList[i].name);
//		var fUserId = friendList[i].name.split('@')[0].replace('#','_').replace('.','_');
		var fUserId= friendList[i].name;
		console.log("fUserId:"+fUserId+','+"userId:"+userId);
		if(fUserId == userId){
			return friendList[i].email_id;
		}
	}
	return undefined;
}
//用户退出账号
function logoutForWebrtc(){
	com.xmpp.close();
}

//播放提示音
function playAudioFn() {
    if (window.HTMLAudioElement) { //支持html5的aduio属性，使用之
        var oAudio = document.getElementById('myaudio');
		oAudio.play();	                   
    }
}


