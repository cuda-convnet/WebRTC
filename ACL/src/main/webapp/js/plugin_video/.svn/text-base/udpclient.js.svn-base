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
			console.log("--------处理消息 username="+JSONMessage.username);
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
		if(Event == com.webrtc.Socket.TYPE.OK){
			var username = JSONMessage.username;
			var roomid = JSONMessage.roomid;
			console.log(username+roomid);
			/*username:webrtc1-163.cpm@WEBRTC*/
			console.log("-----receive UDP_OK");
            CallVideoMeetingBefore(roomid);
			//至此已收到UDPClient的"UDP_OK"响应信息了，应该构造信令发往wcs了
		}
		else if(Event == com.webrtc.Socket.TYPE.FAILED){
			console.log("-----receive UDP_FAILED");
			var username = JSONMessage.username;
			var reason = JSONMessage.reason;
			console.log(username+reason);
			//至此已收到UDPClient的"UDP_OK"响应信息了，应该构造信令发往wcs了
		}
		//处理CS发来的会议邀请(与会者)
		else if(Event == com.webrtc.Socket.TYPE.JOIN){
			console.log("-----receive UDP_JOIN");
			var roomid = JSONMessage.roomid;
			$("#JudgeJoinModal").modal("show");
	        $("#JudgeJoinLabel").text(roomid);
		}
		//处理预约或者周期会议到时CS发来的消息(host)
		else if(Event == com.webrtc.Socket.TYPE.CREATE){
			console.log("-----receive UDP_CREATE");
            var roomid = JSONMessage.roomid;
            CallVideoMeetingBefore(roomid);
		}
		//处理超时请求
		else if(Event == com.webrtc.Socket.TYPE.TIMEOUT){
			console.log("-----receive UDP_TIMEOUT");
            var roomid = JSONMessage.roomid;
            $("#timeoutModal").modal("show");
            $("#timeoutLabel").text(roomid);
		}
		//处理删除会议成员
		else if(Event == com.webrtc.Socket.TYPE.UNJOIN){
			console.log("-----receive UDP_UNJOIN");
			var gRemoteUserID = JSONMessage.roomid;
			var RemoteID = gRemoteUserID;
			//var SessionID=$(document.getElementById("tr"+RemoteID+com.webrtc.UserSession.TYPE.MEETING+com.webrtc.UserSession.MODULE_TYPE.VIDEOMEETING)).find('.SESSIONFLAG').html();
			
			var SessionID=$(".meeting_box").find('.SESSIONFLAG').attr("value");
			console.log(SessionID);
			HangUpMeetingvideo(gRemoteUserID,SessionID);
			var contents = "主持人解散了会议！！";
			$.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:contents});
		}
		//处理查询与我相关的会议
		else if(Event == com.webrtc.Socket.TYPE.MESSAGE){
			console.log("-----receive UDP_MyMeeting");
			var username = JSONMessage.username;
		    var content = JSONMessage.content;
		    //清空我的会议
		    $("div[class=meeting_list]").empty();
		    $("div[class=pagedown]").empty();
		    MeetingNumber=0;
		    
		    for(var i=0; i<JSONMessage.content.length; i++){
		      console.log(content[i].confname);
		      //添加一条我的会议,显示
		      MeetingNumber ++; 
		      addPerMeeting(content[i].roomid, content[i].confname, 
		    		        content[i].type, content[i].creator, MeetingNumber);
		    }
		      MeetingPageTurn();
		}
		//处理有新会议成员加入
		else if(Event == com.webrtc.Socket.TYPE.ADD){
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
			    addPerMeetingMember(newmembername);
            }
		}
		//处理减少会议成员
		else if(Event == com.webrtc.Socket.TYPE.LEAVE){
			console.log("-----receive UDP_LEAVE");
			var leaveMember = formatRechange(JSONMessage.leave_member);
			console.log("退出的用户名：" + leaveMember);
			//本端删除视频会议成员
			document.getElementById("MeetingMember"+ leaveMember).remove();
		}
		//处理查询会议成员
		else if(Event == com.webrtc.Socket.TYPE.MEETINGMEMBERLIST){
			 console.log("-----receive UDP_MEETINGMEMBERLIST");
			 var content = JSONMessage.content;
			 
			 for(var i=0; i<JSONMessage.content.length; i++){
			      console.log("会议成员："+content[i].member);
			      //添加一位会议成员,显示
			      addPerMeetingMember(formatRechange(content[i].member));
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
        var socketMsg = {
            "event":com.webrtc.Socket.TYPE.DELAY,
            "username":com.webrtc.sigSessionConfig.username,
            "roomid":roomid,
            "more":more
        };
        console.log("UDP_DELAY="+socketMsg);
        send(socketMsg);
    };
    
    var ModalJudgeJoin = function(){
    	roomid = $("#JudgeJoinLabel").text();
    	CallVideoMeetingBefore(roomid);    	
    }
    
    //显示邀请好友模态框，会话界面点击邀请联系人时调用
    var InviteMemberModal = function(roomid){
        $("#inviteMemberModal").modal("show");
        $("#inviteMemberLabel").text(roomid);
    };
    
    //模态框点击邀请好友时调用
    var ModalInviteMember = function(){
        var roomid = $("#inviteMemberLabel").text();
        
        var index = roomid.indexOf("@conf.com");
        
        if(index != -1){
        	roomid = roomid.substr(0,index);
        }
        
        var invited_user = $("input[name='invitedName']").val();
        var invited_user2 = formatChange(invited_user);
        var socketMsg = {
            "event":com.webrtc.Socket.TYPE.OFFER,
            "username":com.webrtc.sigSessionConfig.username,
            "invited_user":invited_user2,
            "roomid":roomid
        };
        console.log("UDP_OFFER="+socketMsg);
        send(socketMsg);
    };
    
    var DeleteMemberModal = function(roomid){
    	$("#deleteMemberModal").modal("show");
        $("#deleteMemberLabel").text(roomid);
    };
    
    var ModalDeleteMember = function(){
        var roomid = $("#deleteMemberLabel").text();
        
        var index = roomid.indexOf("@conf.com");
        
        if(index != -1){
        	roomid = roomid.substr(0,index);
        }
        
        var delete_user = $("input[name='deleteName']").val();
        var delete_user2 = formatChange(delete_user);
        var socketMsg = {
            "event":com.webrtc.Socket.TYPE.DELETE,
            "username":com.webrtc.sigSessionConfig.username,
            "username_del":delete_user2,
            "roomid":roomid
        };
        console.log("UDP_DELETE="+socketMsg);
        send(socketMsg);
    };
    
    //读取创建会议内容发送给netty
    var sendBefore = function() {
    	//除去theme属性，与FunctionArea对应
		var username = com.webrtc.sigSessionConfig.username;
		var event = com.webrtc.Socket.TYPE.CREATE;

		var confName = $("input[name='confname']").val();

//		var confType =  Number($("select[name='conftype'] option:selected").val());
		//暂时默认为视频会议
		var confType = Number(1);

		var duration = Number($("input[name='DurationHour']").val())*60 + Number($("input[name='DurationMinute']").val());
//		var duration =  Number($("input[name='DurationMinute']").val());
//		var isImmediateConf = Number($("select[name='isimmediateconf'] option:selected").val());
		var isImmediateConf = 0;
		var temp = $("input[name='isimmediateconf']").val();
		if(temp=="立即会议"){isImmediateConf = Number(1); var reservationTime = "";}
		else{
			isImmediateConf = Number(0);
			var reservationTime = temp;
		}
//		var reservationTime = $("input[name='reservationTime']").val();
		var cycle = Number($("input[name='cycle']").val());
		
		var member_num = Number($("input[name='member_num']").val());
		//与会人
		var membersBefore = $("textarea[name='members']").val();
		var membersTemp = membersBefore.split(';');
		var members = "";
		if(membersTemp[0]) 
			   members = members + formatChange(membersTemp[0]);
		for(var i=1; i< membersTemp.length; i++){
			if(membersTemp[i])
			   members =  members + "#"  + formatChange(membersTemp[i]);
		}
		
		console.log("pqevent="+event+"--confName="+confName+"--confType="+confType+
				    "--duration="+duration+"--isImmediate="+isImmediateConf+
				    "--reservationTime="+reservationTime+"--cycle="+cycle+
				    "--member_num="+member_num+"--members="+members);
        
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
	
	//拉取我的会议列表，向netty发request请求
	var requestmeetinginfo = function(){
		var Username = com.webrtc.sigSessionConfig.username;
		var RequestMsg = com.webrtc.Socket.RequestMessage(com.webrtc.Socket.TYPE.REQUEST, Username,com.webrtc.Socket.MeetingType.MeetingList);
		console.log("Send socket : " + JSON.stringify(RequestMsg));

		send(RequestMsg);
	}
   
	//发送查询会议成员列表请求
	var requestmeetingmember = function(roomid){
		//var Username = com.webrtc.sigSessionConfig.username;
		var UnPrefixRoomid = roomid.substr(0,4);
		console.log("发送查询会议成员列表请求，会议号：" + UnPrefixRoomid);
		var MeetingMember = com.webrtc.Socket.RequestMeetingMember(com.webrtc.Socket.TYPE.MEETINGMEMBER,UnPrefixRoomid,com.webrtc.Socket.MeetingType.MeetingMember);
		console.log("Send socket : " + JSON.stringify(MeetingMember));
		
		send(MeetingMember);
	}
	
	com.webrtc.Socket = {
        ////////////////////创建会议
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

		SocketMessage: function(event, username, theme, confName, confType, duration, isImmediateConf, reservationTime, cycle, member_num, members) {
			var socketMsg = new com.webrtc.Socket.SocketProtocol(event, username, theme, confName, confType, duration, isImmediateConf, reservationTime, cycle, member_num, members);
			return socketMsg;
		},
        
		///////////////////////连netty
		ConnectProtocol: function(type,username) {
			var temp = {
				"type": type,
				"username": username,
			};
			return temp;
		},
		ConnectMessage: function(type,username) {
			var socketMsg = new com.webrtc.Socket.ConnectProtocol(type,username);
			return socketMsg;
		},
		
		//////////////////////查询我的会议
		RequestProtocol: function(type,username,content) {
			var temp = {
				"type": type,
				"username": username,
				"content":content
			};
			return temp;
		},
		RequestMessage: function(type,username,content) {
			var socketMsg = new com.webrtc.Socket.RequestProtocol(type,username,content);
			return socketMsg;
		},
		
		/////////////////////查询会议成员
		MeetingMemberProtocol: function(type,roomid,content) {
			var temp = {
				"type": type,
				"username": roomid,
				"content":content
			};
			return temp;
		},
		RequestMeetingMember: function(type,roomid,content) {
			var socketMsg = new com.webrtc.Socket.MeetingMemberProtocol(type,roomid,content);
			return socketMsg;
		}
	},

	com.webrtc.Socket.TYPE = {
    	OK:"UDP_OK",
    	FAILED:"UDP_FAILED",
        JOIN:"UDP_JOIN",
        CREATE:"UDP_CREATE",
        TIMEOUT:"UDP_TIMEOUT",
        DELAY:"UDP_DELAY",
        OFFER:"UDP_OFFER",
        DELETE:"UDP_DELETE",
        UNJOIN:"UDP_UNJOIN",
        MESSAGE:"UDP_MESSAGE",   //接收我的会议列表
        REQUEST:"UDP_REQUEST",   //发送我的会议列表请求
        ADD:"UDP_ADD",           //有新会议成员加入
        LEAVE:"UDP_LEAVE",       //有会议成员离开
        MEETINGMEMBER:"UDP_MEETINGMEMBER",        //发送会议成员请求
        MEETINGMEMBERLIST:"UDP_MEETINGMEMBERLIST" //接收会议成员
	},

	com.webrtc.Socket.ConnectType = {
		CONNECT: "connect",
		DISCONNECT: "disconnect" 
	}
	
	com.webrtc.Socket.MeetingType = {
			MeetingList: "meetinglist" ,
			MeetingMember: "meetingmember"
	}
