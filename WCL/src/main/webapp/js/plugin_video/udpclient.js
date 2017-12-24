	var socket;

	var temp ;
	
	var beginWebSocketToNetty = function(){
	
	if (!window.WebSocket) {
		window.WebSocket = window.MozWebSocket;
	}
	if (window.WebSocket) {
		//socket = new WebSocket("ws://10.108.114.252:8650/ws");
		//socket = new WebSocket("ws://10.109.247.136:8650/ws");
		
		socket = new WebSocket("ws://"+com.nettyservers[0]+"/ws");
		socket.onmessage = function(event) {
			console.log(event.data);
			//var ta = document.getElementById('responseText');
			
			var JSONMessage= JSON.parse(event.data);
			console.log(JSONMessage);
			console.log("Receive message from netty: username="+JSONMessage.username);
			//ta.value = ta.value + '\n' + "username = " + JSONMessage.username+"  "+event.data;
			handleCSMessage(JSONMessage);
		};
		socket.onopen = function(event) {
			//var ta = document.getElementById('responseText');
			console.log("连接开启！！！");
			loginTonetty();
			console.log("connectToNetty success");
		};
		socket.onclose = function(event) {
			//var ta = document.getElementById('responseText');
			//ta.value = ta.value + "连接被关闭";
			console.log("连接被关闭");
		};
	} else {
		alert("你的浏览器不支持 WebSocket！");
	}
	}

	function send(message) {
		if (!window.WebSocket) {
			return;
		}
		if (socket.readyState == WebSocket.OPEN) {
			//先变成json格式再发出	
			socket.send(JSON.stringify(message));
		} else {
			//alert("连接没有开启.");
			 var contents = "连接没有开启";
				$.fillTipBox({type:'danger', icon:'glyphicon-alert', content:contents});
		}
	}

	//JSONMessage 已经是JSON格式了
	function handleCSMessage(JSONMessage){
		var Event = JSONMessage.event;
		//创建立即会议成功（host）
		if(Event == com.webrtc.Socket.ReceiveTYPE.OK){
			var username = JSONMessage.username;
			var roomid = JSONMessage.roomid;
			console.log(username+roomid);
			/*username:webrtc1-163.cpm@WEBRTC*/
			console.log("-----receive UDP_OK");
            CallVideoMeetingBefore(roomid);
			//至此已收到UDPClient的"UDP_OK"响应信息了，应该构造信令发往wcs了
		}
		else if(Event == com.webrtc.Socket.ReceiveTYPE.FAILED){
			console.log("-----receive UDP_FAILED");
			var username = JSONMessage.username;
			var reason = JSONMessage.reason;
			console.log(username+reason);
			//至此已收到UDPClient的"UDP_OK"响应信息了，应该构造信令发往wcs了
		}
		//处理CS发来的会议邀请(与会者)
		else if(Event == com.webrtc.Socket.ReceiveTYPE.JOIN){
			console.log("-----receive UDP_JOIN");
			var roomid = JSONMessage.roomid;
			$("#JudgeJoinModal").modal("show");
	        $("#JudgeJoinLabel").text(roomid);
		}
		//处理预约或者周期会议到时CS发来的消息(host)
		else if(Event == com.webrtc.Socket.ReceiveTYPE.CREATE){
			console.log("-----receive UDP_CREATE");
            var roomid = JSONMessage.roomid;
            //CallVideoMeetingBefore(roomid);
            $("#JudgeCreateModal").modal("show");
            $("#JudgeCreateLabel").text(roomid);
		}
		else if(Event == com.webrtc.Socket.ReceiveTYPE.RESOK){
			console.log("-----receive UDP_RESOK");
            //var roomid = JSONMessage.roomid;
            var contents = "会议预约成功！！";
			$.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
		}
		//处理超时发回的消息
		else if(Event == com.webrtc.Socket.ReceiveTYPE.TIMEOUT){
			console.log("-----receive UDP_TIMEOUT");
			var roomid = JSONMessage.roomid;
	        $("#timeoutModal").modal("show");
	        $("#timeoutLabel").text(roomid);
		}
		//处理超时之后延时成功消息
		else if(Event == com.webrtc.Socket.ReceiveTYPE.DELAYOK){
			console.log("-----receive UDP_DELAYOK");
            //var roomid = JSONMessage.roomid;
            var contents = "会议延时请求成功！！";
			$.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
		}
		//处理会议超时，被迫解散消息
		else if(Event == com.webrtc.Socket.ReceiveTYPE.TIMEOVER){
			console.log("-----receive UDP_TIMEOVER");
            var gRemoteUserID = JSONMessage.roomid;
						
			var SessionID=$(".meeting_box").find('.SESSIONFLAG').attr("value");
			console.log(SessionID);
			HangUpMeetingvideo(gRemoteUserID,SessionID);
			var contents = "会议超过预定时间，被迫解散！！";
			$.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
		}
		//处理删除会议成员
		else if(Event == com.webrtc.Socket.ReceiveTYPE.UNJOIN){
			console.log("-----receive UDP_UNJOIN");
			var gRemoteUserID = JSONMessage.roomid;
			//var SessionID=$(document.getElementById("tr"+RemoteID+com.webrtc.UserSession.TYPE.MEETING+com.webrtc.UserSession.MODULE_TYPE.VIDEOMEETING)).find('.SESSIONFLAG').html();
			
			var SessionID=$(".meeting_box").find('.SESSIONFLAG').attr("value");
			console.log(SessionID);
			HangUpMeetingvideo(gRemoteUserID,SessionID);
			var contents = "主持人解散了会议！！";
			$.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
		}
//		//处理查询与我相关的会议
//		else if(Event == com.webrtc.Socket.ReceiveTYPE.MESSAGE){
//			console.log("-----receive UDP_MyMeeting");
//			var username = JSONMessage.username;
//		    var content = JSONMessage.content;
//		    //清空我的会议
//		    $("div[class=meeting_list]").empty();
//		    $("div[class=pagedown]").empty();
//		    MeetingNumber=0;
//		    
//		    for(var i=0; i<JSONMessage.content.length; i++){
//		      //添加一条我的会议,显示
//		      MeetingNumber ++; 
//		      addPerMeeting(content[i].roomid, content[i].confname,content[i].type, 
//		    		  content[i].reservation_time,      
//		    		  formatRechange(content[i].creator), MeetingNumber);
//		    }
//		    if(MeetingNumber ==0){
//		      $("div[class=meeting_list]").html("没有与我相关的会议");
//		    }
//		    ///////添加页脚翻页
//		    MeetingPageTurn();
//		}
		//处理有新会议成员加入
		else if(Event == com.webrtc.Socket.ReceiveTYPE.ADD){
			console.log("-----receive UDP_ADD");
			var roomid = JSONMessage.roomid;
			
			var newmembername = formatRechange(JSONMessage.new_member); //新加入的用户名
			console.log("新加入的用户名："+ newmembername);
			var myname = formatRechange(com.webrtc.sigSessionConfig.username);
            if(newmembername == myname){
            	//本端为新加入会议成员，需要查询数据库获得会议列表
            	requestmeetingmember(roomid);
            }else{
			    //本端直接添加新加入会议成员
			    addPerMeetingMember(newmembername,roomid);
            }
            var contents = newmembername + "加入了会议！";
			$.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
		}
		//处理减少会议成员
		else if(Event == com.webrtc.Socket.ReceiveTYPE.LEAVE){
			console.log("-----receive UDP_LEAVE");
			var leaveMember = formatRechange(JSONMessage.leave_member);
			console.log("退出的用户名：" + leaveMember);
			//本端删除视频会议成员
			document.getElementById("MeetingMember"+ leaveMember).remove();
			
			var contents = leaveMember + "退出了会议！";
			$.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
		}
		//处理查询会议成员
		else if(Event == com.webrtc.Socket.ReceiveTYPE.MEETINGMEMBERLIST){
			 console.log("-----receive UDP_MEETINGMEMBERLIST");
			 var content = JSONMessage.content;
			 var roomid = JSONMessage.username;   //会议号
			 
			 for(var i=0; i<JSONMessage.content.length; i++){
			      console.log("会议成员："+content[i].member);
			      //添加一位会议成员,显示
			      addPerMeetingMember(formatRechange(content[i].member),roomid);
			    }
		}
		//处理有会议成员被静音
		else if(Event == com.webrtc.Socket.ReceiveTYPE.MUTE){
			console.log("-----receive UDP_MUTE");
			var MuteMember = formatRechange(JSONMessage.member);
			var roomid = JSONMessage.roomid;
			var isAll = JSONMessage.isAll;  //一定为0，不指定所有与会者静音
			console.log("Mute member:"+ MuteMember+"--roomid:"+roomid+"--isAll:"+isAll);
			
			var contents = "会议成员" + MuteMember + "被静音了！";
			$.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
			
			$(document.getElementById("MeetingMember"+ MuteMember)).children("span").html("静音");
		}
		//处理有会议成员恢复正常听说
		else if(Event == com.webrtc.Socket.ReceiveTYPE.UNMUTE){
			console.log("-----receive UDP_UNMUTE");
			var UnMuteMember = formatRechange(JSONMessage.member);
			var roomid = JSONMessage.roomid;
			var isAll = JSONMessage.isAll; 
			console.log("Mute member:"+ UnMuteMember+"--roomid:"+roomid+"--isAll:"+isAll);
			
			if(isAll == Number(0)){
			    var contents = "会议成员" + UnMuteMember + "恢复正常听说了！";
			    $.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
			
			    $(document.getElementById("MeetingMember"+ UnMuteMember)).children("span").html("正常");
			}
			else{  //全部恢复正常
				var contents = "会议成员" + UnMuteMember + "恢复正常听说了！";
			    $.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
			
			    $(".meeting_member"+" ul li span").html("正常");
			}
		}
		//处理有会议成员被闭音
		else if(Event == com.webrtc.Socket.ReceiveTYPE.UNSAY){
			console.log("-----receive UDP_UNSAY");
			var UnSayMember = formatRechange(JSONMessage.member);
			var roomid = JSONMessage.roomid;
			var isAll = JSONMessage.isAll; 
			console.log("Mute member:"+ UnSayMember+"--roomid:"+roomid+"--isAll:"+isAll);
			
			if(isAll == Number(0)){
			    var contents = "会议成员" + UnSayMember + "被闭音了！";
			    $.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
			
			    $(document.getElementById("MeetingMember"+ UnSayMember)).children("span").html("闭音");
			}
			else{  //全部恢复正常
				var contents = "会议成员" + UnSayMember + "被闭音了！";
			    $.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
			
			    $(".meeting_member"+" ul li span").html("闭音");
			}
		}
		//处理CS用户是否异常退出
		//else if(Event == com.webrtc.Socket.TYPE.ALIVE){
			
		//}
	};
	
	//处理用户输入的延时时间，模态框中点击提交调用
    var ModaltimeOut = function(){
    	var roomid = $("#timeoutLabel").text();
        var more = Number($("input[name='delaytime']").val());
        var UnPrefixRoomid = roomid.substr(0,4);
        var socketMsg = {
            "event":com.webrtc.Socket.SendType.DELAY,
            "username":com.webrtc.sigSessionConfig.username,
            "roomid":UnPrefixRoomid,
            "more":more
        };
        console.log("UDP_DELAY="+socketMsg);
        send(socketMsg);
    };
    
    //加入会议模态框中，点击加入触发
    var ModalJudgeJoin = function(){
    	roomid = $("#JudgeJoinLabel").text();
    	CallVideoMeetingBefore(roomid);    	
    }
    
    //预约、周期会议同意创建会议模态框中，点击创建触发
    var ModalJudgeCreate = function(){
    	roomid = $("#JudgeCreateLabel").text();
    	CallVideoMeetingBefore(roomid);    	
    }
    
    //显示邀请好友模态框
    var InviteMemberModal = function(roomid){
        $("#inviteMemberModal").modal("show");
        $("#inviteMemberLabel").text(roomid);
    };
    
    //邀请好友模态框，点击邀请触发
    var ModalInviteMember = function(){
        var roomid = $("#inviteMemberLabel").text();
        
        var index = roomid.indexOf("@conf.com");
        
        if(index != -1){
        	roomid = roomid.substr(0,index);
        }
        
        var invited_user = $("input[name='invitedName']").val();
        var invited_user2 = formatChange(invited_user);
        var socketMsg = {
            "event":com.webrtc.Socket.SendType.OFFER,
            "username":com.webrtc.sigSessionConfig.username,
            "invited_user":invited_user2,
            "roomid":roomid
        };
        console.log("UDP_OFFER="+socketMsg);
        send(socketMsg);
    };
    
var DeleteMeetingMember = function(deleteMember,roomid){ 
	    var index = roomid.indexOf("@conf.com");
		  
	    if(index != -1){
		  	roomid = roomid.substr(0,index);
		}
		  
		var delete_user = formatChange(deleteMember);
		var socketMsg = {
		      "event":com.webrtc.Socket.SendType.DELETE,
		      "username":com.webrtc.sigSessionConfig.username,
		      "username_del":delete_user,
		      "roomid":roomid
		};
		console.log("UDP_DELETE="+socketMsg);
		send(socketMsg);
};
    
      //显示删除会议成员模态框
//    var DeleteMemberModal = function(roomid){
//    	$("#deleteMemberModal").modal("show");
//        $("#deleteMemberLabel").text(roomid);
//    };
    
      //模态框触发删除会议成员
//    var ModalDeleteMember = function(){
//        var roomid = $("#deleteMemberLabel").text();
//        
//        var index = roomid.indexOf("@conf.com");
//        
//        if(index != -1){
//        	roomid = roomid.substr(0,index);
//        }
//        
//        var delete_user = $("input[name='deleteName']").val();
//        var delete_user2 = formatChange(delete_user);
//        var socketMsg = {
//            "event":com.webrtc.Socket.SendType.DELETE,
//            "username":com.webrtc.sigSessionConfig.username,
//            "username_del":delete_user2,
//            "roomid":roomid
//        };
//        console.log("UDP_DELETE="+socketMsg);
//        send(socketMsg);
//    };
    
    //读取创建会议内容发送给netty
    var sendBefore = function() {

		var username = com.webrtc.sigSessionConfig.username;
		var event = com.webrtc.Socket.SendType.CREATE;
		
        ////////////////会议主题
		var confName = $("input[name='confname']").val();
		
		/////////////////会议类型（暂时默认为视频会议）
		var confType = Number(1);
		//var confType =  Number($("select[name='conftype'] option:selected").val());
        
		////////////////会议时间（1为立即会议；0为周期或预约会议）
		var MeetingMenuType = $("#formIsImmediate").text();
		if(MeetingMenuType=="立即会议"){       //立即会议
			  var isImmediateConf = Number(1); 
			  var reservationTime = new Date().Format("yyyy-MM-dd hh:mm:ss"); //预约时间(立即会议为当前时间)		
			  console.log("当前时间：" + reservationTime);
			  var cycle = Number(0);
		}
		else if(MeetingMenuType=="预约会议"){  //预约会议
		      var isImmediateConf = Number(0);
			  var reservationTime = $("input[name='reservationTime']").val();  //预约时间
			  var cycle = Number(0);
		}
		else if(MeetingMenuType=="周期会议"){ //周期会议
			  var isImmediateConf = Number(0);
			  var reservationTime = $("input[name='reservationTime']").val();  //预约时间
			  var cycle = Number($("input[name='cycle']").val()); 
		}
		
		//////////////////会议时长
		var duration = Number($("input[name='DurationHour']").val())*60 + Number($("input[name='DurationMinute']").val());
		
		////////////////////////与会人(与会人之间用分号隔开,处理中间以及最后有多个分号的情况)
        //var members RtcMeetingArea取值；
		////////////////////////与会人数
		//var member_num = Number($("input[name='member_num']").val(member_num));
		//var member_num取值；
		
		var socketMsg = com.webrtc.Socket.SocketMessage(event, username, "123", confName, confType, duration, isImmediateConf, reservationTime, cycle, member_num, members);
		console.log("Send socket : " + JSON.stringify(socketMsg));


		send(socketMsg);
	};


	function loginTonetty(){
		//var Username = document.getElementById("callerid").value;
		var Username = com.webrtc.sigSessionConfig.username;
		/*username：  webrtc1-163.com@WEBRTC*/
		console.log("------------connect to netty username:" + Username);
		var ConnectMsg = com.webrtc.Socket.ConnectMessage(com.webrtc.Socket.ConnectType.CONNECT, Username);
		console.log("Send socket : " + JSON.stringify(ConnectMsg));


		send(ConnectMsg);
	}
	
//	//拉取我的会议列表，向netty发request请求（暂时用的）
//	var requestmeetinginfo = function(){
//		var Username = com.webrtc.sigSessionConfig.username;
//		var RequestMsg = com.webrtc.Socket.RequestMessage(com.webrtc.Socket.SendType.REQUEST, Username,com.webrtc.Socket.SendType.MeetingList);
//		console.log("Send socket : " + JSON.stringify(RequestMsg));
//
//		send(RequestMsg);
//	}
   
	//发送查询会议成员列表请求（浏览器端主动发送查询会议成员请求，在我是新加入的会议成员的时候）
	var requestmeetingmember = function(roomid){
		//var Username = com.webrtc.sigSessionConfig.username;
		var UnPrefixRoomid = roomid.substr(0,4);
		console.log("发送查询会议成员列表请求，会议号：" + UnPrefixRoomid);
		var MeetingMember = com.webrtc.Socket.RequestMeetingMember(com.webrtc.Socket.SendType.MEETINGMEMBER,UnPrefixRoomid,com.webrtc.Socket.SendType.MeetingMember);
		console.log("Send socket : " + JSON.stringify(MeetingMember));
		
		send(MeetingMember);
	}
	
	//发送会议成员静音、闭音、正常听说消息
	var requestMeetingVoice = function(member,roomid,event){
		//发送的会议号为4位数字，发送的用户名为webrtc9-163.com@WEBRTC
		console.log("收到会议号："+roomid+"收到member："+member);
		var Username = com.webrtc.sigSessionConfig.username;
		var UnPrefixRoomid = roomid.substr(0,4);
		var WcsMember = formatChange(member);
		var MeetingVoice = com.webrtc.Socket.RequestMeetingVoice(event,Username,UnPrefixRoomid,Number(0),WcsMember);
		console.log("Send socket : " + JSON.stringify(MeetingVoice));
	
		send(MeetingVoice);
	}

	
	com.webrtc.Socket = {
        ////////////////////创建会议
		SocketMessage: function(event, username, theme, confName, confType, duration, isImmediateConf, reservationTime, cycle, member_num, members) {
			var socketMsg = new com.webrtc.Socket.SocketProtocol(event, username, theme, confName, confType, duration, isImmediateConf, reservationTime, cycle, member_num, members);
			return socketMsg;
		},
		
		SocketProtocol: function(event, username, theme, confName, confType, duration, isImmediateConf, reservationTime, cycle, member_num, members) {
			var temp = {
				"event": event,
				"username": username,
				"theme":theme,
				"confName": confName,
				"confType": confType,
				"duration": duration,
				"isImmediateConf": isImmediateConf,
				"reservationTime": reservationTime,
				"cycle": cycle,
				"member_num": member_num,
				"members": members,

			};
			return temp;
		},
		///////////////////////连netty
		ConnectMessage: function(type,username) {
			var socketMsg = new com.webrtc.Socket.ConnectProtocol(type,username);
			return socketMsg;
		},
		ConnectProtocol: function(type,username) {
			var temp = {
				"type": type,
				"username": username,
			};
			return temp;
		},
		
//		//////////////////////查询我的会议
//		RequestMessage: function(type,username,content) {
//			var socketMsg = new com.webrtc.Socket.RequestProtocol(type,username,content);
//			return socketMsg;
//		},
//		RequestProtocol: function(type,username,content) {
//			var temp = {
//				"type": type,
//				"username": username,
//				"content":content
//			};
//			return temp;
//		},
		
		/////////////////////查询会议成员
		RequestMeetingMember: function(type,roomid,content) {
			var socketMsg = new com.webrtc.Socket.MeetingMemberProtocol(type,roomid,content);
			return socketMsg;
		},
		MeetingMemberProtocol: function(type,roomid,content) {
			var temp = {
				"type": type,
				"username": roomid,
				"content":content
			};
			return temp;
		},
		
		///////////////会议成员静音、闭音、解除函数
		RequestMeetingVoice: function(event,username,roomid,isAll,member){
			var socketMsg = new com.webrtc.Socket.MeetingVoiceProtocol(event,username,roomid,isAll,member);
			return socketMsg;
		},
		MeetingVoiceProtocol: function(event,username,roomid,isAll,member) {
			var temp = {
				"event": event,
				"username": username,
				"roomid":roomid,
				"isAll":isAll,
				"member":member
			};
			return temp;
		}
	},
	
    //接收消息类型
	com.webrtc.Socket.ReceiveTYPE = {
    	OK:"UDP_OK",             //创建立即会议成功
    	FAILED:"UDP_FAILED",     //创建立即会议失败
        JOIN:"UDP_JOIN",         //被邀请加入会议会议
        CREATE:"UDP_CREATE",     //预约会议开始
        TIMEOUT:"UDP_TIMEOUT",   //会议超时
        DELAYOK:"UDP_DELAYOK",   //会议超时后，延时请求成功
        RESOK:"UDP_RESOK",           //预约或周期会议创建成功提醒
        TIMEOVER:"UDP_TIMEOVER", //会议超时，被迫解散
        UNJOIN:"UDP_UNJOIN",     //被踢出会议
        ADD:"UDP_ADD",           //有新会议成员加入
        LEAVE:"UDP_LEAVE",       //有会议成员离开
        
        MESSAGE:"UDP_MESSAGE",   //接收我的会议列表
        MEETINGMEMBERLIST:"UDP_MEETINGMEMBERLIST", //接收会议成员列表
        
        MUTE:"UDP_MUTE",         //会议成员静音
        UNMUTE:"UDP_UNMUTE",     //会议成员恢复正常听说
        UNSAY:"UDP_UNSAY"        //会议成员闭音
	},
    
	//连接消息类型
	com.webrtc.Socket.ConnectType = {
		CONNECT: "connect",
		DISCONNECT: "disconnect" 
	}
	
	//发送消息类型
	com.webrtc.Socket.SendType = {
			REQUEST:"UDP_REQUEST",             //发送我的会议列表请求(udp_type)
			MeetingList: "meetinglist" ,       //查询我的会议（内容）
			
		    MEETINGMEMBER:"UDP_MEETINGMEMBER", //发送会议成员请求(udp_type)
			MeetingMember: "meetingmember",    //查询会议成员(内容)
			
			CREATE:"UDP_CREATE",             //创建会议
		    OFFER:"UDP_OFFER",               //邀请会议成员
		    DELETE:"UDP_DELETE",             //删除会议成员
			DELAY:"UDP_DELAY",        //发送用户选择的延迟时间
	}
