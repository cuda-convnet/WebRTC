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

import com.easemob.server.example.comm.Constants;
import com.easemob.server.example.httpclient.apidemo.EasemobChatGroups;
import com.easemob.server.example.httpclient.apidemo.EasemobIMUsers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Controller
public class destroyGroupController {
	public static final int DATA = 25;

	private Integer spitterService;
	private static JsonNodeFactory factory = new JsonNodeFactory(false);
	private static Logger LOGGER = LoggerFactory
			.getLogger(EasemobIMUsers.class);

	@RequestMapping(value = "/destroygroup", method = RequestMethod.GET)
	public void createNewIMUser(Model model,HttpServletRequest req, HttpServletResponse response,
			@RequestParam(value = "chatgroupname", required = true) String chatgroupname,
			@RequestParam(value = "userid", required = true) String userid
		) throws IOException {
		System.out.println("chatgroupname:" + chatgroupname);
		System.out.println("userid:" + userid);	
		ObjectNode message = factory.objectNode();		
		if (!chatgroupname.equalsIgnoreCase("") && !userid.equalsIgnoreCase("") ) {
			//edit by rxt
			System.out.println(chatgroupname.toString());
//			System.out.println(chatgroupname);
//			if(chatgroupname.equals(Constants.APPKEY+"_"+userid))
//			{			
//				EasemobChatGroups.deleteChatGroups(chatgroupname);
//				message.put("result", "success");
//				message.put("msg", "destroy group success");
//			}
//			else
//			{
//				message.put("result", "error");
//				message.put("msg", "not the owner of the group");
//			}
			
			//origin code
			JsonNode result = EasemobChatGroups.findGroupOwnerByGroupId(chatgroupname);
			if(result==null)
			{
				message.put("result", "error");
				message.put("msg", "do not have this group");
			}
			else
			{	
				System.out.println(result.toString());
				System.out.println(result.get("owner").asText());
				if(result.get("owner").asText().equals(Constants.APPKEY+"_"+userid))
				{			
					ObjectNode result_json =EasemobChatGroups.deleteChatGroups(result.get("groupid").asText());
					if(!result_json.has("error")){
					message.put("result", "success");
					message.put("msg", "destroy group success");
					}
					else
					{
						message.put("result", "error");
						message.put("msg", "destroy group failed");
					}
				}
				else
				{
					message.put("result", "error");
					message.put("msg", "not the owner of the group");
				}
				
			}
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
