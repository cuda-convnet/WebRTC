package com.easemob.server.example.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

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

import com.easemob.server.example.httpclient.apidemo.EasemobIMUsers;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

@SuppressWarnings("unused")
@Controller
public class createUserController {
	public static final int DATA = 25;

	private Integer spitterService;
	private static JsonNodeFactory factory = new JsonNodeFactory(false);
	private static Logger LOGGER = LoggerFactory
			.getLogger(EasemobIMUsers.class);

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public void createNewIMUser(Model model, HttpServletResponse response,
			@RequestBody(required = true) String param) throws IOException {

		ObjectNode message = factory.objectNode();

		JSONObject a = new JSONObject(param);
		String uid = a.get("uid").toString();
		String password = a.get("password").toString();
		
		if (!uid.equalsIgnoreCase("") && !password.equalsIgnoreCase("") ) {
			if (null!=EasemobIMUsers.getIMUsersByUserName(uid)) {
				message.put("result", "error");
				message.put("msg", "the user already exist");
			} else {
				
				ObjectNode dataNode = factory.objectNode();
				dataNode.put("username", uid);
				dataNode.put("password", password);
				EasemobIMUsers.createNewIMUserSingle(dataNode);
				message.put("result", "success");
				message.put("msg", "create the user success");
			}
		} else 
			message.put("result", "error");
			message.put("msg", "parameter error");
		

		try {
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().println(message);
			System.out.println(message);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}

	}

}
