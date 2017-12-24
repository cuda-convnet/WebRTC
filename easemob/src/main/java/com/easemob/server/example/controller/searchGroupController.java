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
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@Controller
public class searchGroupController {
	public static final int DATA = 25;

	private Integer spitterService;
	private static JsonNodeFactory factory = new JsonNodeFactory(false);
	private static Logger LOGGER = LoggerFactory
			.getLogger(EasemobIMUsers.class);

	@RequestMapping(value = "/searchgroup", method = RequestMethod.GET)
	public void createNewIMUser(Model model,HttpServletRequest req, HttpServletResponse response,
			@RequestParam(value = "chatgroupname", required = true) String chatgroupname
		) throws IOException {
		System.out.println("chatgroupname:" + chatgroupname);
		//ObjectNode message = factory.objectNode();	
		JSONObject result_json = null;
		if (!chatgroupname.equalsIgnoreCase("") ) {
			result_json = EasemobChatGroups.findGroupIdByGroupName(chatgroupname);
			
		}
		try {
			response.setContentType("application/x-javascript;charset=UTF-8");
			String callbackFunName =req.getParameter("callbackparam");
			response.getWriter().write(callbackFunName + "([ "+ result_json.toString() + "])"); //返回jsonp数据  
			System.out.println(result_json);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}
}
