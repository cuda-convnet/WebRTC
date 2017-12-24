var VIDEO_URL;
var LOGOUT_FLAG=false;
//var VIDEO_URL = "http://mysparkweb.free4lab.com/http-bind:8888";
//填写IM的一些回调函数,待替换
$(document).ready(function(){

	//获取服务器wcs地址
	server = com.websockets[0];
	
	//username eg: e444a1ec850548bf8d31bdc6ae607f26@switchboard
	eid = $('#eid').val();
	userName = $('#userName').val();
	token = $('#access_token').val();

	console.log("eid="+eid);
	console.log("userName="+userName);
	console.log("access_token="+token);
	
	//from eg : e444a1ec850548bf8d31bdc6ae607f26-A@WebRTC
	//连接wcs的用户名格式
    from  = formatChange(userName);
	
	//连接WCS服务器
    loginWebRTC(from,server,token);

//	VIDEO_URL = com.websockets[0];
//	console.log(VIDEO_URL);
//	if(com.webrtc.getMediaSupport() == true){
//		loginwebrtc();
//		console.log("initAll end to loginwebrtc");
//	}else{
//		//不支持webrtc API
//	}

});

/**
 * WCS通用操作（自动总机、人工总机、呼叫用户页面均需用到）
 */
//以username、token连接在服务器server上的wcs
var loginWebRTC = function(from,server,token){

	//var Server = com.websockets[0];
	console.log("begin");

	com.webrtc.sigSessionConfig.serverhost = server;
	com.webrtc.sigSessionConfig.username = from;
	com.webrtc.sigSessionConfig.token = token;
	com.webrtc.starting();
	com.webrtc.sigSession.Login();
    com.webrtc.app.init(onNotify);
	
};

//断开当前连接
var logoutWebRTC = function(){
	
	com.webrtc.sigSession.Logout();
};