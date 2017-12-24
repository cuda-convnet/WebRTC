/**
 *处理接收来自人工总机模块的会话信息
 *  
 */

(function(){
    com.webrtc.ArtiUserSession = Object.subClass({
        /** @Public Methods*/
        ctor : function() {

            this.calleeName=null;

            this.OnResponse=null;

        },

        init : function(onresponse){
    
            this.OnResponse = onresponse;
        }, 
        
        handleMessage : function(message){

			//处理反馈的结果
			var msg = JSON.parse(message.data);//转换成json格式
			switch(msg.answer)
			{
				case com.webrtc.protocol.RTCArtiAnswerType["NONEARTI"]:handleNoneArti();break;
				case com.webrtc.protocol.RTCArtiAnswerType["ARTILOGOUT"]:handleArtiLogout();break;
				case com.webrtc.protocol.RTCArtiAnswerType["FORM_REQUESTERNUM"]:handleFormNum(msg.requesternum);break;
				case com.webrtc.protocol.RTCArtiAnswerType["UPDATE_REQUESTERNUM"]:handleUpdateNum();break;
				case com.webrtc.protocol.RTCArtiAnswerType["SUCCESS"]:handleSuccess(msg.targetname);break;
				case com.webrtc.protocol.RTCArtiAnswerType["FINISH"]:handleFinish(msg.targetname);break;
			}
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

function handleNoneArti()
{
	//1.注销环信
	console.log("logoutFromEase");
	logout();
	console.log("logoutFromEase success in ArtiUserSession.js");
	
	//2.清空隐藏域中刚才的客服名
	$("#servername").val("");
	
	//3.让发送按钮不可点击
	disableInput();
	
	//4.对话框头部清空人工总机账号
	$(".switchboard_head .user_name").text("");
	
	//4.显示气泡
	showChatYou("暂无客服，请稍后再试<br><a href='javascript:void(0);' onclick='requestOneArti()'>重新请求</a>");
}

function handleArtiLogout()
{
	//1.注销环信
	console.log("logoutFromEase");
	logout();
	console.log("logoutFromEase success in ArtiUserSession.js");
	
	//2.清空隐藏域中刚才的客服名
	$("#servername").val("");
	
	//3.让发送按钮不可点击
	disableInput();
	
	//4.对话框头部清空人工总机账号
	$(".switchboard_head .user_name").text("");
	
	//5.显示气泡
	showChatYou("客服已下线，正在竭力为您分配新的客服");
}

function handleFormNum(requesternum)
{
	//1.设置人数
	$("#requesternum").val(requesternum);
	
	//2.显示人数
	content = (requesternum <= 0 ? "即将为您服务，请稍等..." : "正在为您分配客服，前面还有" + requesternum +"人");
	showChatYou(content);
}

function handleUpdateNum()
{
	//1.获取人数
	requesternum = $("#requesternum").val();
	
	//2.更新人数
	$("#requesternum").val(--requesternum);
	
	//3.显示人数
	content =  (requesternum <= 0 ? "即将为您服务，请稍等..." : "正在为您分配客服，前面还有" + requesternum +"人");
	updateRequesterNumInChatYou(content);
}

function handleSuccess(servername)
{
	//1.连接环信
	console.log("connectToEase");
	connectToEase();
	console.log("connectToEase success in ArtiUserSession.js");
	
	//2.设置隐藏域为客服的用户名
	servername = formatRechange(servername);
	$("#servername").val(servername);
	
	//3.让发送按钮可以点击
	enableInput();
	
	//4.对话框头部显示人工总机账号
	$(".switchboard_head .user_name").text("正在与"+servername+"会话");
		
	//5.显示气泡
	showChatYou("您好，客服"+servername+"为您服务");
}

function handleFinish(servername)
{
	//1.注销环信
	console.log("logoutFromEase");
	logout();
	console.log("logoutFromEase success in ArtiUserSession.js");
	
	//2.清空隐藏域中刚才的客服名
	$("#servername").val("");
	
	//3.让发送按钮不可点击
	disableInput();
	
	//4.显示气泡
	showChatYou("感谢您的来访，本次服务已结束<br><a href='javascript:void(0);' onclick='requestOneArti()'>重新请求</a>");
}

//设置为不可输入
function disableInput()
{
	$("#input_box").attr("disabled","disabled");
	$("#input_box").css("cursor","not-allowed");
	$("#sendto_arti").attr("disabled","disabled");
	$("#sendto_arti").css("cursor","not-allowed");
}

//设置为可输入
function enableInput()
{
	$("#input_box").removeAttr("disabled");
	$("#input_box").css("cursor","text");
	$("#sendto_arti").removeAttr("disabled");
	$("#sendto_arti").css("cursor","pointer");
}