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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easemob.server.example.httpclient.apidemo.EasemobMessages;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

@SuppressWarnings("unused")
@Controller
public class testController {
	public static final int DATA = 25;
	
	private Integer spitterService;
	private static JsonNodeFactory factory = new JsonNodeFactory(false);
	private static Logger LOGGER = LoggerFactory.getLogger(EasemobMessages.class);
	
	@RequestMapping(value = "/hello",method=RequestMethod.GET)
	public String showHomePage(Model model,
			HttpServletResponse response,
			@RequestParam(value="api_key", required=true) String apiKey) throws IOException{
		System.out.println("In testController: apiKey:" + apiKey);
		model.addAttribute("liming","黎明你好");
		
//		EasemobMessages em = new EasemobMessages();
//		
//		String targetType = "users";
//		ArrayNode target = factory.arrayNode();
//		target.add("user2");
//		
//		ObjectNode msg = factory.objectNode();
//		msg.put("type", "txt");
//		msg.put("msg", "helloSunday");
//		String from = "user1";
//		ObjectNode ext = factory.objectNode();
//		ext.put("attr1", "attr1v1");
//		ext.put("attr2", "attr2v1");
//		try {
//			response.setContentType("text/html;charset=UTF-8");
//			response.getWriter().println(msg);
//		} catch (IOException e) {
//			LOGGER.error(e.getMessage());
//		}
//		EasemobMessages.sendMessages("users", target, msg, from, ext);
		
		return "home";
	}
	
	public void sendMessage(String from, JSONObject message, List<Integer> toIds)
	{
		String targetType = "users";
		ArrayNode targetIds = factory.arrayNode();
		Iterator<Integer> it = toIds.iterator();
		while(it.hasNext()){
			Integer tempId = it.next();
			targetIds.add(tempId);
		}
		System.out.println(targetIds.toString());
		
		ObjectNode ext = factory.objectNode();
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		String s = message.getString("msg");
		
		EasemobMessages.sendMessages(targetType, targetIds, ext, from, ext);
		
	}
}
