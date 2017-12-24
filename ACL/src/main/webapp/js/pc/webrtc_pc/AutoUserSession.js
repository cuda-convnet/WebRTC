/**
 *处理接收来自自动总机的会话信息
 *  
 */

(function(){
    com.webrtc.AutoUserSession = Object.subClass({
        /** @Public Methods*/
        ctor : function() {

            this.calleeName=null;

            this.OnResponse=null;

        },

        init : function(onresponse){
    
            this.OnResponse = onresponse;
        }, 
        
        handleMessage : function(message){

			//转换成json格式
			var msg = JSON.parse(message.data);

			//构造自动总机反馈的信息
			var answer = "";
			if(msg.answer_head != "")
				answer += msg.answer_head + "</br>";
			if(msg.answer_body != "")
			{
				//截取结果字段(先去掉最后一个,)
				var results = (msg.answer_body).substring(0,(msg.answer_body).length-1).split(",");

				//判断是邮箱还是分组列表结果，从而进行不同的界面显示
				if(msg.curmenu == com.webrtc.protocol.RTCAutoSessionCurMenu["QUERYBYKEYWORDRESULT"]
				|| msg.curmenu == com.webrtc.protocol.RTCAutoSessionCurMenu["QUERYBYFZRESULT"]
			    || msg.curmenu == com.webrtc.protocol.RTCAutoSessionCurMenu["QUERYBYUSERNAMERESULT"]) //邮箱结果
				{
					eid = $("#eid").val();
					ename = $("#ename").val();
					
					for(var i=0;i<results.length;i++)
					{
						var separate = results[i].indexOf(":");
						var email = results[i].substring(separate+1);
						
						answer += results[i] + '&nbsp<a href="enterchat?chatFriendId='+email+'&eid='+eid+'&ename='+ename+'">呼叫</a></br>';
					}
				}
				else if(msg.curmenu == com.webrtc.protocol.RTCAutoSessionCurMenu["UNKNOWN"]) //用户长时间未响应后返回的：重新发起会话
				{
					answer += '<a href="javascript:void(0);" onclick="createAutoSession();">'+results[0]+'</a></br>';
				}
				else //分组结果
				{
					for(var i=0;i<results.length;i++)
					{
						var separate = results[i].indexOf(":");
						var fzIndex = results[i].substring(0,separate);
						var question = results[i].substring(separate+1);
						
						answer += '<a href="javascript:void(0);" onclick="sendSignalToAuto(\''+fzIndex+'\',\''+ question +'\')">'+question+'</a></br>';
					}
				}
			}

			if(msg.answer_footer != "")
			{ 
				var results = (msg.answer_footer).split(",");
				for(var i=0;i<results.length;i++)
				{
					var signal = results[i].substring(0,1);
					var question = results[i].substring(1);

					if(signal == '#')
						answer += "---------------------------------</br>";
					answer += '<a href="javascript:void(0);" onclick="sendSignalToAuto(\''+signal+'\',\''+ question +'\')">'+question+'</a></br>';
				}
			}

			//显示气泡
			showChatYou(msg.curmenu,answer);
        },

		//发送消息至WCS
        SendMessage : function(message){
            this.appConnected.trigger(com.webrtc.events.RecvUserSession,message);
        },
        HangUp:function(CalleeId)
        {
            com.webrtc.DeleteUserSession(this.SessionID);
        },

        setSessionID:function(sessionID){
            this.SessionID=sessionID;
        }
    });
})();
