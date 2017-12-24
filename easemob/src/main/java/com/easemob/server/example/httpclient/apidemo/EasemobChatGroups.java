package com.easemob.server.example.httpclient.apidemo;

import java.net.URL;
import java.util.*;

import com.easemob.server.example.httpclient.vo.ClientSecretCredential;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.easemob.server.example.comm.Constants;
import com.easemob.server.example.comm.HTTPMethod;
import com.easemob.server.example.comm.Roles;
import com.easemob.server.example.httpclient.utils.HTTPClientUtils;
import com.easemob.server.example.httpclient.vo.Credential;
import com.easemob.server.example.httpclient.vo.EndPoints;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;


/**
 * REST API Demo : 群组管理 HttpClient4.3实现
 * 
 * Doc URL: http://www.easemob.com/docs/rest/groups/
 * 
 * @author Lynch 2014-09-15
 *
 */
public class EasemobChatGroups {

	private static final Logger LOGGER = LoggerFactory.getLogger(EasemobChatGroups.class);

    // 通过app的client_id和client_secret来获取app管理员token
    private static Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
            Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);

    public static void main(String[] args) {
		/** 获取APP中所有的群组ID 
		 * curl示例: 
		 * curl -X GET -i "https://a1.easemob.com/easemob-playground/test1/chatgroups" -H "Authorization: Bearer {token}"
		 */
//		ObjectNode chatgroupidsNode = getAllChatgroupids();
//		
//		
//		
//		System.out.println(chatgroupidsNode.toString());
//		JsonNode data =chatgroupidsNode.get("data");
//		for(int i = 0;i<data.size();i++)
//		{
//			System.out.println(data.get(i).get("groupid"));
//			System.out.println(data.get(i).get("groupname"));
//		}
    	
    	JSONObject result = findGroupIdByGroupName("郭逊1");
    	if(result.get("status").equals("empty"))
    	{
    		System.out.println(result);
    	}
    	else
    	{
    		System.out.println(result);
    	}
		
		
//		
//		/**  
//		 * 获取一个或者多个群组的详情
//		 * curl示例
//		 * curl -X GET -i "https://a1.easemob.com/easemob-playground/test1/chatgroups/1414379474926191,1405735927133519"
//         * -H "Authorization: Bearer {token}"
//		 */
//		String[] chatgroupIDs = {"1414379474926191", "1405735927133519"};
//		ObjectNode groupDetailNode = getGroupDetailsByChatgroupid(chatgroupIDs);
//		System.out.println(groupDetailNode.toString());
//
//		/** 创建群组 
//		 * curl示例
//		 * curl -X POST 'https://a1.easemob.com/easemob-playground/test1/chatgroups' -H 'Authorization: Bearer {token}'
//         * -d '{"groupname":"测试群组","desc":"测试群组","public":true,"approval":true,"owner":"xiaojianguo001","maxusers":333,"members":["xiaojianguo002","xiaojianguo003"]}'
//		 */
//		ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
//		dataObjectNode.put("groupname", "测试群组");
//		dataObjectNode.put("desc", "测试群组");
//		dataObjectNode.put("approval", true);
//		dataObjectNode.put("public", true);
//		dataObjectNode.put("maxusers", 333);
//		dataObjectNode.put("owner", "gxtest1");
//		ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
//		arrayNode.add("gxtest1");
//		arrayNode.add("xiaojianguo003");
//		dataObjectNode.put("members", arrayNode);
//		ObjectNode creatChatGroupNode = creatChatGroups(dataObjectNode);
//		System.out.println(creatChatGroupNode.toString());
//
//		/**
//		 * 删除群组
//		 * curl示例
//		 * curl -X DELETE 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519'
//         * -H 'Authorization: Bearer {token}'
//		 */
//		String toDelChatgroupid = "1405735927133519";
//		ObjectNode deleteChatGroupNode =  deleteChatGroups(toDelChatgroupid) ;
//		System.out.println(deleteChatGroupNode.toString());
//		
//		/**
//		 * 获取群组中的所有成员
//		 * curl示例
//		 * curl -X GET 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users'
//         * -H 'Authorization: Bearer {token}'
//		 */
//		String chatgroupid = "1405735927133519";
//		ObjectNode getAllMemberssByGroupIdNode = getAllMemberssByGroupId(chatgroupid);
//		System.out.println(getAllMemberssByGroupIdNode.toString());
//
//		/**
//		 * 在群组中添加一个人
//		 * curl示例
//		 * curl -X POST 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users/xiaojianguo002'
//         * -H 'Authorization: Bearer {token}'
//		 */
//		String addToChatgroupid = "1405735927133519";
//		String toAddUsername = "xiaojianguo002";
//		ObjectNode addUserToGroupNode = addUserToGroup(addToChatgroupid, toAddUsername);
//		System.out.println(addUserToGroupNode.toString());
//
//		/**
//		 * 在群组中减少一个人
//		 * curl示例
//		 * curl -X DELETE 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users/xiaojianguo002'
//         * -H 'Authorization: Bearer {token}'
//		 */
//		String delFromChatgroupid = "1405735927133519";
//		String toRemoveUsername = "xiaojianguo002";
//		ObjectNode deleteUserFromGroupNode = deleteUserFromGroup(delFromChatgroupid, toRemoveUsername);
//		System.out.println(deleteUserFromGroupNode.asText());
//		
//		/**
//		 * 获取一个用户参与的所有群组
//		 * curl示例
//		 * curl -X GET 'https://a1.easemob.com/easemob-playground/test1/users/xiaojianguo002/joined_chatgroups'
//         * -H 'Authorization: Bearer {token}'
//		 */
//		String username = "xiaojianguo002";
//		ObjectNode getJoinedChatgroupsForIMUserNode = getJoinedChatgroupsForIMUser(username);
//		System.out.println(getJoinedChatgroupsForIMUserNode.toString());
//		
//		/**
//		 * 群组批量添加成员
//		 * curl示例
//		 * curl -X POST -i 'https://a1.easemob.com/easemob-playground/test1/chatgroups/1405735927133519/users' -H 'Authorization: Bearer {token}' -d '{"usernames":["xiaojianguo002","xiaojianguo003"]}'
//		 */
//		String toAddBacthChatgroupid = "1405735927133519";
//		ArrayNode usernames = JsonNodeFactory.instance.arrayNode();
//		usernames.add("xiaojianguo002");
//		usernames.add("xiaojianguo003");
//		ObjectNode usernamesNode = JsonNodeFactory.instance.objectNode();
//		usernamesNode.put("usernames", usernames);
//		ObjectNode addUserToGroupBatchNode = addUsersToGroupBatch(toAddBacthChatgroupid, usernamesNode);
//		System.out.println(addUserToGroupBatchNode.toString());
//    	
//		/** 创建群组 
//		 * curl示例
//		 * curl -X POST 'https://a1.easemob.com/easemob-playground/test1/chatgroups' -H 'Authorization: Bearer {token}'
//        * -d '{"groupname":"测试群组","desc":"测试群组","public":true,"approval":true,"owner":"xiaojianguo001","maxusers":333,"members":["xiaojianguo002","xiaojianguo003"]}'
//		 */
//		ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
//		dataObjectNode.put("groupname", "测试");
//		dataObjectNode.put("desc", "测试");
//		dataObjectNode.put("approval", true);
//		dataObjectNode.put("public", true);
//		dataObjectNode.put("maxusers", 333);
//		dataObjectNode.put("owner", "gxtest1");
//		ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
//		arrayNode.add("gxtest2");
//		dataObjectNode.put("members", arrayNode);
//		ObjectNode creatChatGroupNode = creatChatGroups(dataObjectNode);
//		System.out.println(creatChatGroupNode.toString());    	
	}
	
	private static JsonNodeFactory factory = new JsonNodeFactory(false);
	private static final String APPKEY = Constants.APPKEY;
	
	/**
	 * 获取APP中所有的群组ID
	 * 
	 * @return
	 */
	public static ObjectNode getAllChatgroupids() {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}

		try {
			objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.CHATGROUPS_URL, credential, null,
					HTTPMethod.METHOD_GET);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}

	/**
	 * 获取一个或者多个群组的详情
	 * 
	 * @return
	 */
	public static ObjectNode getGroupDetailsByChatgroupid(String[] chatgroupIDs) {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}

		try {
			URL groupDetailsByChatgroupidUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/")
					+ "/chatgroups/" + chatgroupIDs.toString());
			objectNode = HTTPClientUtils.sendHTTPRequest(groupDetailsByChatgroupidUrl, credential, null,
					HTTPMethod.METHOD_GET);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}
	
	/**
	 * 通过群组的名返回群组id
	 * 
	 * @return 找到群组，返回群组id，否组返回null;
	 */
	public static JSONObject findGroupIdByGroupName(String chatgroupname) {
		
		JSONObject result = new JSONObject();
		JSONArray jsons = new JSONArray();

		ObjectNode chatgroupidsNode = getAllChatgroupids();
		
		if(chatgroupidsNode != null)
		{
			JsonNode data =chatgroupidsNode.get("data");
			for(int i = 0;i<data.size();i++)
			{
				JsonNode gn =data.get(i).get("groupname");
			
				String groupname = gn.asText();
				if(chatgroupname.equals(groupname))
				{
					String gid =data.get(i).get("groupid").asText();
					String gowner  =data.get(i).get("owner").asText();
					String gname = data.get(i).get("groupname").asText();
					
					JSONObject jo=new JSONObject();
					jo.put("groupid", gid);
					jo.put("owner",gowner);
					jo.put("groupname", gname);
					
					jsons.put(jo);
					//return gi.asText();
					
				}
			}
			if(jsons.length()!=0){
				result.put("content", jsons);
				result.put("status", "notempty");
			}
			else{
				result.put("status", "empty");
			}
			return result;
		}
		
		result.put("status", "empty");
		return result;
	}
	
	
	
	/**
	 * 通过群组的名返回群组拥有者
	 * 
	 * @return 找到群组，返回群组拥有者，否组返回null;
	 */
	public static JsonNode findGroupOwnerByGroupName(String chatgroupname) {
		ObjectNode chatgroupidsNode = getAllChatgroupids();
		
		if(chatgroupidsNode != null)
		{
			JsonNode data =chatgroupidsNode.get("data");
			for(int i = 0;i<data.size();i++)
			{
				JsonNode gn =data.get(i).get("groupname");
			
				String groupname = gn.asText();
				if(chatgroupname.equals(groupname))
				{
					JsonNode gi=data.get(i);
					
					return gi;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * 通过群组的ID返回群组拥有者
	 * 
	 * @return 找到群组，返回群组拥有者，否组返回null;
	 */
	public static JsonNode findGroupOwnerByGroupId(String chatgroupid) {
		ObjectNode chatgroupidsNode = getAllChatgroupids();
		
		if(chatgroupidsNode != null)
		{
			JsonNode data =chatgroupidsNode.get("data");
			for(int i = 0;i<data.size();i++)
			{
				JsonNode gn =data.get(i).get("groupid");
			
				String groupid = gn.asText();
				if(chatgroupid.equals(groupid))
				{
					JsonNode gi=data.get(i);
					
					return gi;
				}
			}
		}
		
		return null;
	}
	
	
	/**
	 * 创建群组
	 *	内部调用creatChatGroups
	 */
	public static ObjectNode createChatGroupBefore(String groupname,String desc,boolean approval,boolean pub,String max,String owner)
	{
		ObjectNode dataObjectNode = JsonNodeFactory.instance.objectNode();
		dataObjectNode.put("groupname", groupname);
		dataObjectNode.put("desc", desc);
		dataObjectNode.put("approval", approval);
		dataObjectNode.put("public", pub);
		dataObjectNode.put("maxusers", max);
		dataObjectNode.put("owner", owner);
		ArrayNode arrayNode = JsonNodeFactory.instance.arrayNode();
		arrayNode.add(owner);
		dataObjectNode.put("members", arrayNode);
		ObjectNode creatChatGroupNode = creatChatGroups(dataObjectNode);
		return creatChatGroupNode;
	}

	/**
	 * 创建群组
	 * 
	 */
	public static ObjectNode creatChatGroups(ObjectNode dataObjectNode) {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}

		// check properties that must be provided
		if (!dataObjectNode.has("groupname")) {
			LOGGER.error("Property that named groupname must be provided .");
			objectNode.put("message", "Property that named groupname must be provided .");
			return objectNode;
		}
		if (!dataObjectNode.has("desc")) {
			LOGGER.error("Property that named desc must be provided .");
			objectNode.put("message", "Property that named desc must be provided .");
			return objectNode;
		}
		if (!dataObjectNode.has("public")) {
			LOGGER.error("Property that named public must be provided .");
			objectNode.put("message", "Property that named public must be provided .");
			return objectNode;
		}
		if (!dataObjectNode.has("approval")) {
			LOGGER.error("Property that named approval must be provided .");
			objectNode.put("message", "Property that named approval must be provided .");
			return objectNode;
		}
		if (!dataObjectNode.has("owner")) {
			LOGGER.error("Property that named owner must be provided .");
			objectNode.put("message", "Property that named owner must be provided .");
			return objectNode;
		}
		if (!dataObjectNode.has("members") || !dataObjectNode.path("members").isArray()) {
			LOGGER.error("Property that named members must be provided .");
			objectNode.put("message", "Property that named members must be provided .");
			return objectNode;
		}

		try {
			objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.CHATGROUPS_URL, credential, dataObjectNode,
					HTTPMethod.METHOD_POST);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}

	/**
	 * 删除群组
	 * 
	 */
	public static ObjectNode deleteChatGroups(String chatgroupid) {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}

		try {
			URL deleteChatGroupsUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/chatgroups/"
					+ chatgroupid);
			objectNode = HTTPClientUtils.sendHTTPRequest(deleteChatGroupsUrl, credential, null,
					HTTPMethod.METHOD_DELETE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}

	/**
	 * 获取群组中的所有成员
	 * 
	 */
	public static ObjectNode getAllMemberssByGroupId(String chatgroupid) {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}

		try {
			URL allMemberssByGroupIdUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/chatgroups/"
					+ chatgroupid + "/users");
			objectNode = HTTPClientUtils.sendHTTPRequest(allMemberssByGroupIdUrl, credential, null,
					HTTPMethod.METHOD_GET);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}

	/**
	 * 在群组中添加一个人
	 * 
	 */
	public static ObjectNode addUserToGroup(String chatgroupid, String userName) {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}

		try {
			URL allMemberssByGroupIdUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/chatgroups/"
					+ chatgroupid + "/users/" + userName);
			ObjectNode dataobjectNode = factory.objectNode();
			objectNode = HTTPClientUtils.sendHTTPRequest(allMemberssByGroupIdUrl, credential, dataobjectNode,
					HTTPMethod.METHOD_POST);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}

	/**
	 * 在群组中减少一个人
	 * 
	 */
	public static ObjectNode deleteUserFromGroup(String chatgroupid, String userName) {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}

		try {
			URL allMemberssByGroupIdUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/") + "/chatgroups/"
					+ chatgroupid + "/users/" + userName);
			objectNode = HTTPClientUtils.sendHTTPRequest(allMemberssByGroupIdUrl, credential, null,
					HTTPMethod.METHOD_DELETE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}
	
	/**
	 * 获取一个用户参与的所有群组
	 * 
	 * @param username
	 * @return
	 */
	private static ObjectNode getJoinedChatgroupsForIMUser(String username) {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}
		if (StringUtils.isBlank(username.trim())) {
			LOGGER.error("Property that named username must be provided .");
			objectNode.put("message", "Property that named username must be provided .");
			return objectNode;
		}

		try {
			URL getJoinedChatgroupsForIMUserUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/")
					+ "/users/" + username + "/joined_chatgroups");
			objectNode = HTTPClientUtils.sendHTTPRequest(getJoinedChatgroupsForIMUserUrl, credential, null,
					HTTPMethod.METHOD_GET);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}
	
	/**
	 * 群组批量添加成员
	 * 
	 * @param toAddBacthChatgroupid
	 * @param usernames
	 * @return
	 */
	private static ObjectNode addUsersToGroupBatch(String toAddBacthChatgroupid, ObjectNode usernames) {
		ObjectNode objectNode = factory.objectNode();
		// check appKey format
		if (!HTTPClientUtils.match("^(?!-)[0-9a-zA-Z\\-]+#[0-9a-zA-Z]+", APPKEY)) {
			LOGGER.error("Bad format of Appkey: " + APPKEY);
			objectNode.put("message", "Bad format of Appkey");
			return objectNode;
		}
		if (StringUtils.isBlank(toAddBacthChatgroupid.trim())) {
			LOGGER.error("Property that named toAddBacthChatgroupid must be provided .");
			objectNode.put("message", "Property that named toAddBacthChatgroupid must be provided .");
			return objectNode;
		}
		// check properties that must be provided
		if (null != usernames && !usernames.has("usernames")) {
			LOGGER.error("Property that named usernames must be provided .");
			objectNode.put("message", "Property that named usernames must be provided .");
			return objectNode;
		}

		try {
			URL getJoinedChatgroupsForIMUserUrl = HTTPClientUtils.getURL(Constants.APPKEY.replace("#", "/")
					+ "/chatgroups/" + toAddBacthChatgroupid + "/users");
			objectNode = HTTPClientUtils.sendHTTPRequest(getJoinedChatgroupsForIMUserUrl, credential, usernames,
					HTTPMethod.METHOD_POST);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objectNode;
	}

}
