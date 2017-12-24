//格式转化，去掉“@”换成“-”，并在后面加“@WebRTC”	
//eg: jxk143@163.com -->  jxk143-163.com@WebRTC
var formatChange = function(original){
	return original.split("@")[0]+'-'+original.split("@")[1]+"@WebRTC";
}
//格式转换，去掉“@WebRTC”，“-”换成“@”
////eg: jxk143-163.com@WebRTC -->  jxk143@163.com
var formatRechange = function(original){
	return original.split('@')[0].replace('-','@');
}
//格式转化，去掉“@”换成“-”  
//eg: jxk143@163.com -->  jxk143-163.com
var formatToEase = function(original){
	return original.replace('@','-');
}
//格式转化，去掉“-”换成“@”  
//eg: jxk143-163.com -->  jxk143@163.com
var formatReEase = function(original){
	return original.replace('-','@');
}

//格式转化，加上“@”
//eg: jxk143-163.com -->  jxk143-163.com@WebRTC
var EaseToWCS = function(original){
	return original+"@WebRTC";;
}
//格式转化，去掉“@WebRTC” 
//eg: jxk143-163.com@WebRTC -->  jxk143-163.com
var WCSToEase = function(original){
	return original.split('@')[0];
}