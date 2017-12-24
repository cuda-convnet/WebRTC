package com.easemob.server.example.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easemob.server.example.httpclient.apidemo.EasemobChatGroups;
import com.easemob.server.example.httpclient.apidemo.EasemobIMUsers;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class createGroupController {
	public static final int DATA = 25;

	private Integer spitterService;
	private static JsonNodeFactory factory = new JsonNodeFactory(false);
	private static Logger LOGGER = LoggerFactory
			.getLogger(EasemobIMUsers.class);

	@RequestMapping(value = "/creategroup", method = RequestMethod.GET)
	public void createNewIMUser(Model model,HttpServletRequest req, HttpServletResponse response,
			@RequestParam(value = "chatgroupname", required = true) String chatgroupname,
			@RequestParam(value = "userid", required = true) String userid,
			@RequestParam(value = "desc", required = true) String desc,
			@RequestParam(value = "approval", required = true) boolean approval,
			@RequestParam(value = "pub", required = true) boolean pub,
			@RequestParam(value = "max", required = true) String max			
		) throws IOException {
		System.out.println("chatgroupname:" + chatgroupname);
		System.out.println("userid:" + userid);	
		System.out.println("desc:" + desc);	
		System.out.println("approval:" + approval);	
		System.out.println("pub:" + pub);	
		System.out.println("max:" + max);	
		ObjectNode message = factory.objectNode();		
		if (!chatgroupname.equalsIgnoreCase("") && !userid.equalsIgnoreCase("") ) {
			//String result = EasemobChatGroups.findGroupIdByGroupName(chatgroupname);
			//System.out.println("CreateGroup:findGroupIdByGroupName="+result);
			
			ObjectNode result_json = EasemobChatGroups.createChatGroupBefore(chatgroupname, desc, approval, pub, max, userid);
			System.out.println(result_json.has("error"));
			if(!result_json.has("error")){
				message.put("result", "success");
				message.put("msg", "create group success");
			}
			else
			{
				message.put("result", "error");
				message.put("msg", "create group failed");
			}
			
		
//			if(result==null)
//			{			
//				EasemobChatGroups.createChatGroupBefore(chatgroupname, desc, approval, pub, max, userid);
//				message.put("result", "success");
//				message.put("msg", "create group success");
//			}
//			else
//			{	message.put("result", "error");
//				message.put("msg", "this group exist");
//				
//			}
		} else {
			message.put("result", "error");
			message.put("msg", "parameter error");
		}
		try {
			response.setContentType("application/x-javascript;charset=UTF-8");
			String callbackFunName =req.getParameter("callbackparam");
			response.getWriter().write(callbackFunName + "([ "+ message.toString() + "])"); //返回jsonp数据  
			System.out.println(message);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}
}
