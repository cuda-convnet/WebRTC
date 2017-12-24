/**
 * 与自动总机聊天相关的界面及动效部分
 */

//显示我的自动总机聊天气泡
var showChatMe = function(content)
{
	chatListBox = $('.chat_list_box');
	
	//这里要改！！！!!!!根据from查到的用户的头像
	avatar = "css/pc/images/img/portrait65_1.jpg";
	
	bubbleHTML = '<div class="chat_me">\
      <div class="img_li"><img src="'+avatar +'" width="65" height="65" /></div>\
      <div class="img_text">\
        <div class="text_box"><i></i>\
          <p>'+ content +'</p>\
        </div>\
      </div>\
    </div>';

	chatListBox.append(bubbleHTML);
	chatListBox.scrollTop(chatListBox[0].scrollHeight); //滑动条下移
}


//显示自动总机的聊天气泡
var showChatYou = function(curmenu,content)
{	
	chatListBox = $('.chat_list_box');
	
	//让以前的链接都不能点击
	allLinks = chatListBox.find("a");
	allLinks.removeAttr("onclick");
	allLinks.css('color','#97A2A7');
	allLinks.css('cursor','not-allowed');

	
	//这里要改！！！根据from查到的用户的头像
	avatar = "css/pc/images/portrait6-38.png";

	bubbleHTML = '<div class="chat_you">\
      <div class="img_li"><img src="'+avatar +'" width="65" height="65" /></div>\
      <div class="img_text">\
        <div class="text_box"><i></i>\
          <p>'+ content +'</p>\
        </div>\
      </div>\
    </div>';
	
//	//通过判断是否为同一菜单，决定是否要显示新气泡
//	if(lastmenu == curmenu && lastmenu != com.webrtc.protocol.RTCAutoSessionCurMenu.QUERYBYREALNAME)//是,（即点击上一页、下一页的时候），更改最后一个chat_you的气泡
//	{
//		chatListBox.children(".chat_you").last().html(bubbleHTML);
//	}
//	else //不是,append一个新气泡
//	{
//		chatListBox.append(bubbleHTML);
//	}
	chatListBox.append(bubbleHTML);
	chatListBox.scrollTop(chatListBox[0].scrollHeight); //滑动条下移
	lastmenu = curmenu;
};

//自动总机的enter键按下
var checkAutoChatBoxEnterDown = function(){
	
	event = window.event;
	if(event.keyCode == 13){
		
	  event.preventDefault();
	  event.stopPropagation();
	        
	  $('#sendto_auto').click();
	}
};

////创建可拖动的聊天对话框
//var createChatWindow = function(chatFriendId) {
//	
//	var windowDiv = $('<div></div>');
//	windowDiv.attr("id", MessagePrefix + chatFriendId);
//
//	//对聊天对话框进行修改，让其符合浮动对话框特性
//	windowDiv.addClass("rtc_box_center");
//	windowDiv.css("background","#fafafa");
//	windowDiv.css("position","absolute");
//	windowDiv.css("z-index","150");
//	windowDiv.css("overflow","hidden");
//	windowDiv.css("left", 500);
//	windowDiv.css("top", 100);
//  /*************对话框头部***************************************/ 
//	var chatHead = $("<div class=\"chat_head\"><h2 onclick=\"FriendModalFunctionArea\('"+ chatFriendId+ "'\);\">"+ chatFriendId +"</h2></div>");
//	windowDiv.append(chatHead);
//	var chatHeadRight = $("<div class=\"chat_head_operation\">"+ 
//		                  "<ul><li class='operation_close' onclick=\"exitChatWindow\('"+ chatFriendId+ "'\);\">关闭</li>"+
//                        "<li class='operation_video' onclick=\"createCallVideoPageBefore\('"+ chatFriendId+ "'\);\">发起视频</li>"+
//                        "<li class='operation_audio' onclick=\"createCallAudioPageBefore\('"+ chatFriendId+ "'\);\">发起音频</li></ul></div>");
//	$(chatHead).append(chatHeadRight);
//	
//	//设置对话框可拖动
//	dragChatWindow(chatHead, windowDiv);
//	/** ****************对话框内容*********************************/
//	var chatListBox = $("<div id=\"" + chatFriendId + "front\" class='chat_list_box'></div>");
//	windowDiv.append(chatListBox);
// 
//  var inputChatBox = $("<div class='input_chat_box'>");
//  windowDiv.append(inputChatBox);
//
//  var inputTextArea = $("<textarea id=\"" + chatFriendId
//			          + "message\" onkeydown='checkChatBoxEnterDown(\""+chatFriendId+"\")' name='' cols='' rows='' class='input_text'></textarea>");
//  $(inputChatBox).append(inputTextArea);
//
//  var inputFace = $("<div class='input_chat_edit'>"+
//                "<ul class='input_chat_edit_l'><li class='icon_history'>查看历史对话</li>"+
//                "<li class='icon_face'>选择表情</li>"+
//                "<li class='icon_font_size'>文字大小</li>"+
//                "<li class='icon_color'>文字颜色</li></ul>"+
//                "<div class='input_chat_edit_r'>"+
//                "<input id=\""+chatFriendId+"sendBtn\" type='button' onclick=\"sendText\('"+ 
//                	chatFriendId + "'\);\" value='发送' class='send_out btn_blue'/></div></div>");
//  $(inputChatBox).append(inputFace);
//
//	return windowDiv;
//};
//
////设置以chat_head区域为拖动事件的触发，newContent为整个对话框区域，可拖动
//var dragChatWindow = function(headDiv, windowDiv){
//
//	  var bool=false, offsetX = 0, offsetY = 0;   //标识是否移动元素，声明DIV在当前窗口的Left和Top值
//	  headDiv.mouseover(function(){
//	    $(this).css('cursor','move');     //当鼠标移动到拖拽的DIV上的时候，将鼠标的样式设置为移动(move)
//	  });
//
//	  headDiv.mousedown(function(evt){ 
//
//	    $(this).css('cursor','move');
//	    bool=true;                //当鼠标在移动元素按下的时候将bool设定为true
//	    offsetX = evt.offsetX;        //获取鼠标在当前窗口的相对偏移位置的Left值并赋值给offsetX
//	    offsetY = evt.offsetY;        //获取鼠在当前窗口的相对偏移位置的Top值并赋值给offsetY
//	    console.log(offsetX+","+offsetY);
//	  });
//
//	  $(document).mousemove(  function(evt){
//	    if(!bool){
//	      return;
//	    }   
//	    var x = evt.clientX-offsetX, y = evt.clientY-offsetY; 
//	    if(y < 0){
//	      y = 0;
//	     }
//
//	    windowDiv.css("left", x);
//	    windowDiv.css("top", y);
//	  }   ).mouseup(function(){
//
//	    bool=false;               //当鼠标在移动元素起来的时候将bool设定为false
//	  });
//};