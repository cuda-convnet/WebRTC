package com.free4lab.webrtc.action.account;

import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.free4lab.utils.account.BaseLoginAction;
import com.free4lab.webrtc.common.Constants;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction extends BaseLoginAction {

	/**
	 *登录account的login方法
	 */
	private static final long serialVersionUID = 1L;

	final static Logger logger = Logger.getLogger(LoginAction.class);
	
	@Override
	public boolean writeToSession(JSONObject obj) {
		logger.info("LoginAction：写session"+obj);
		//可以通过检查uid字段判断此json对象是否有效
		if (obj != null && obj.has(Constants.UserID)){
			Map<String, Object> session = ActionContext.getContext().getSession();
			//将用户信息存入session，session的key可以自己在应用的Constants里定义
			Integer userId = jsonGetUserId(obj);
			String email = jsonGetEmail(obj);
			session.put(Constants.UserID, userId);
			session.put(Constants.UserEmail, email);
			return true;
		} else {
			logger.info("获取的用户信息为空");
		}
		return false;
	}

	@Override
	public String giveDefaultRedirect() {
		//返回应用默认跳转的地址，
		return "/contacts";
	}

	@Override
	public String writeAccessTokenToSession(String access_token) {
		logger.info("LoginAction：accessToken，写session"+access_token);
		Map<String, Object> session = ActionContext.getContext().getSession();
		//将传入的access_token写入session
		session.put(Constants.AccessToken, access_token);
		session.put(Constants.AccToken, access_token.substring(8, 24));
		return null;
	}

	@Override
	public String giveClientSecret() {
		//返回account分配给应用的secret_key
		return Constants.SECRET_KEY;
	}

}

/*package com.free4lab.newtest.action.account;

import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.free4lab.newtest.common.Constants;
import com.free4lab.utils.account.BaseLoginAction;
import com.opensymphony.xwork2.ActionContext;


public class LoginAction extends BaseLoginAction {

	*//**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginAction.class);
	@Override
	public boolean writeToSession(JSONObject obj) {
		logger.info(obj);
		if (obj != null && obj.has("uid")){
			//可以通过检查uid字段判断此json对象是否有效
			Map<String, Object> session = ActionContext.getContext().getSession();
			//将用户信息存入session，session的key可以自己在应用的Constants里定义
			Integer userId = jsonGetUserId(obj);
			String email = jsonGetEmail(obj);
			session.put(Constants.UserID, userId);
			session.put(Constants.UserEmail, email);
			return true;
       } else {
    	   	logger.info("获取的用户信息为空");
       }
       return false;
	}

	@Override
	public String giveDefaultRedirect() {
		//返回应用默认跳转的地址，
		return "/majors";
	}

	@Override
	public String writeAccessTokenToSession(String access_token) {
		Map<String, Object> session = ActionContext.getContext().getSession();
		//将传入的access_token写入session
		session.put(Constants.AccessToken, access_token);
		session.put(Constants.AccToken, access_token.substring(8, 24));
		return null;
	}

	@Override
	public String giveClientSecret() {
		//返回account分配给应用的secret_key
		return Constants.SECRET_KEY;
	}

}
*/