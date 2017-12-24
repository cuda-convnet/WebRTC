function logout1(){
	LOGOUT_FLAG=true;
	
	var accountAddr=com.wmsservers[0];
	console.log(accountAddr);
	var index="http://"+com.nginxservers[0] + "/WCLnew/";	
	console.log(index);
	var userName = $('#userName').val();

	$.cookie(userName,null, {
		// expires : 100000,
		path : "/"
	});
	
	$.cookie(userName+"meeting",null, {
		// expires : 100000,
		
		path : "/"
	});

	//con
	var access_token = $('#access_token').val();
	$.ajax({  
        url:accountAddr+"api/oauth2/revokeoauth2?callback=?",  
        type:"post",
        async:false,
        dataType:"json",  
        data:{'access_token':access_token},  
        complete:function(result) {
        	if(typeof(com) != "undefined"){
        		//com.xmpp.close();
        	}
        	location.replace(index);
        }
    });
}