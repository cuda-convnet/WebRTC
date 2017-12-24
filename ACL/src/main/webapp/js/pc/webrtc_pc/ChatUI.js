/**
 * 与呼叫的内部用户聊天相关的界面及动效部分
 */
$(document).ready(function(){
	
	//连接环信
	console.log("connectToEase");
	connectToEase();
	console.log("connectToEase success in ChatUI.js");
});


//与chatTargetId的聊天框的enter键按下
var checkChatBoxEnterDown = function(chatTargetId){

	event = window.event;
	if(event.keyCode == 13)
	{
		event.preventDefault(); //禁止默认回车事件
	    event.stopPropagation();
	    $(document.getElementById(chatTargetId+"sendBtn")).click();
	}
};

//判断显示聊天内容函数
var addMessageMsg = function(userName, remoteUserName,data) {

	console.log("curUserId=" + curUserId);
	console.log("userName=" + userName);
	console.log("data="+data);
	// var ImuserName = formatToEase
	if (curUserId == userName) 
	{
		// 本端发出去的消息，放在右边;
		createOneMessageOnRight(userName,remoteUserName, data);
	} 
	else 
	{
		// 对端发送来的消息,放在左边;
		createOneMessageOnLeft(userName, data);
	}
}

var createOneMessageOnLeft = function(userName, data) {

	var name = formatReEase(userName);
	console.log("对方name="+name);
	var LeftChat = $("<div class='chat_you'></div>");

    var LeftChatImg = $("<div class='img_li'>"+
        "<img src='css/pc/images/img/portrait65_1.jpg' width='65' height='65'/></div>");
	
	$(LeftChat).append(LeftChatImg);

	var LeftChatMessage = $("<div class='img_text'><div class='text_box'>"+
			"<i></i><p>"+ data +"</p></div></div>");
	
	$(LeftChat).append(LeftChatMessage);

	var front = $(".chat_list_box");
	front.append(LeftChat);
	front.scrollTop(front[0].scrollHeight); //滑动条置底
	console.log("addMessage to MsgPage on left finish!");
}

var createOneMessageOnRight = function(userName,remoteUserName, data) {
	var name = formatReEase(userName);
	var remoteName =formatReEase(remoteUserName);
	console.log("addMessage to MsgPage on right start!");

	var rightChat = $("<div class='chat_me'></div>");
    var rightChatImg = $("<div class='img_li'>"+
        "<img src='css/pc/images/img/portrait65_2.jpg' width='65' height='65'/></div>");
	var rightChatMessage = $("<div class='img_text'><div class='text_box'>"+
			"<i></i><p>"+ data +"</p></div></div>");
	
	$(rightChat).append(rightChatImg);
	$(rightChat).append(rightChatMessage);

	var front =$(".chat_list_box");
	front.append(rightChat);
	front.scrollTop(front[0].scrollHeight); //滑动条置底

	console.log("addMessage to MsgPage on right finish!");
}