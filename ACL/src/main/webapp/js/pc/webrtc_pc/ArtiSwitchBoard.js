/**
 * add by yck
 * 前端与自动总机的会话消息交互
 */
var eid = 0; //企业id号
var sessionID = ""; //等待createArtiSession后产生
var userName = "";
var from = "";
var to = "ARTI";

//首次与自动总机会话（初次进入，或点击进入自动总机会话的时候）
var createArtiSession = function()
{
	//创建自动总机会话session
	sessionID = guid(); //生成会话标识
	var artiUserSession = new com.webrtc.ArtiUserSession();
	var userSessionBase = new com.webrtc.WUserSessionBase();

	artiUserSession.calleeName = to;
	artiUserSession.init(onResponse);

	$.extend( true, artiUserSession,userSessionBase);
	artiUserSession.setSessionID(sessionID);
	com.webrtc.app.AddSession(artiUserSession);

	requestOneArti();
};

//再次重新请求人工总机
var requestOneArti = function()
{
	var artiMsg = new com.webrtc.protocol.RTCArtiMessage(com.webrtc.protocol.RTCMsgType["artiswitchboard"],from,to,sessionID,eid,0,"",0,com.webrtc.protocol.RTCArtiActionType["REQUEST"]); 
	com.webrtc.app.usersessionlist[sessionID].SendMessage(artiMsg);	
};

//发送信息咨询人工总机
var sendQuestionToArti = function(question)
{
	$inputbox = $('#input_box');
	$inputbox.focus();
	
	if(question != "")
	{
		$inputbox.val(""); //清空输入框文本
		showChatMe(question);//显示我的气泡

		//下面走的是环信，并非WCS了，只有在REQUEST客服的时候是走WCS
		
		//获取客服用户名
//		servername = $("#servername").val();
		
	}
};

//结束会话（点击小叉）
var endArtiSession = function()
{
    if(true == com.webrtc.app.isExistSession(sessionID))
    {
    	//通知自动总机客户端删除session，并返回感谢词
    	var artiMsg = new com.webrtc.protocol.RTCArtiMessage(com.webrtc.protocol.RTCMsgType["artiswitchboard"],from,to,sessionID,eid,0,"",0,com.webrtc.protocol.RTCArtiActionType["END"]); 
		com.webrtc.app.usersessionlist[sessionID].SendMessage(artiMsg);
		
	    //对话框消失
	    $('.switchboard_box').remove();
	    
	    //删除ARTI类型会话sessionID
		com.webrtc.app.usersessionlist[sessionID].HangUp("ARTI");
	    
	    //感谢词
	    $.fillTipBox({type:'info', icon:'glyphicon-info-sign', content:"感谢您的使用，欢迎下次再来"});
    }
    else
    {
        console.log("UserSession do not exist!");
    }
};

////点击呼叫，弹出与用户chatFriendId的聊天框
//var callUser = function(chatFriendId){
//	
//	//判断chatFriendId窗口是否已经存在
//	if(getChatWindowDiv(chatFriendId) == null) //不存在
//		$("body").append(createChatWindow(chatFriendId));//弹出对话框
//}
//
////关闭聊天对话框
//var exitChatWindow = function(chatFriendId){
//	$(document.getElementById( MessagePrefix + chatFriendId)).remove();
//};

//挂断视频（点击小叉关闭）
var HangUpvideo = function(gRemoteUserID,SessionID)
{
    if(true == com.webrtc.app.isExistSession(SessionID))
    {
        com.webrtc.app.usersessionlist[SessionID].HangUp(gRemoteUserID,com.webrtc.UserSession.MODULE_TYPE.VIDEO);
    }
    else
    {
        console.log("UserSession do not exist!");
    }
};

//挂断音频（点击小叉关闭）
var HangUpaudio = function(gRemoteUserID,SessionID)
{
    if(true == com.webrtc.app.isExistSession(SessionID))
    {
        com.webrtc.app.usersessionlist[SessionID].HangUp(gRemoteUserID,com.webrtc.UserSession.MODULE_TYPE.AUDIO);
    }
    else
    {
        console.log("UserSession do not exist!");
    }
};