package com.free4lab.webrtc.action.account;


import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;

import com.free4lab.utils.account.AccountUtil;
import com.free4lab.utils.account.BaseLoginAction;
import com.free4lab.webrtc.common.SessionConstants;
import com.opensymphony.xwork2.ActionContext;
//import com.free4lab.webrtc.action.authorization.Auth;

public class LoginAction extends BaseLoginAction {

	public static final String NOT_LOGINED = "notlogined";
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	private String userName;

	public String execute() {
		
		System.out.println("走这里了"+redirect_url);
		Map<String, Object> session = ActionContext.getContext().getSession();
		String stateInSession = (String) session.get("state");
		logger.info("stateInSession"+stateInSession);
		if(stateInSession == null || stateInSession.equalsIgnoreCase("") || 
				state == null || state.equalsIgnoreCase("") || 
				(state != null && !"".equalsIgnoreCase(state) && stateInSession.equalsIgnoreCase(state)) ){
			session.remove("state");
			if( code != null && !"".equalsIgnoreCase(code)){
				//获得accessToken
				String client_secret = giveClientSecret();
				String access_token = AccountUtil.getAccessTokenByCode(code, client_secret);

				logger.info("access_token="+access_token);
				if (null == access_token || access_token.isEmpty()) {
					logger.info("the code is invalid! access_token is null or empty!");
					return INPUT;
				}

				writeAccessTokenToSession(access_token);
				// 获取用户名信息，并把用户信息写入会话中
				logger.info("开始请求用户信息，accesstoken为：" + access_token);

				//写入临时用户名
				session.put(SessionConstants.UserName, userName);

				if(redirect_url == null || "".equalsIgnoreCase(redirect_url)){
					redirect_url = giveDefaultRedirect();
				}
				redirect_url = java.net.URLDecoder.decode(redirect_url);
				return SUCCESS;
			} else {
				logger.info("code 为空!");
				return INPUT;
			}
		}else{
			logger.info("state为空或者错误");
			return INPUT;
		}
		
	}
	
	
	
	@Override
	public boolean writeToSession(JSONObject obj) {

		return true;
	}

	@Override
	public String giveDefaultRedirect() {
		//返回应用默认跳转的地址，
		return "/majors";
	}

	@Override
	public String writeAccessTokenToSession(String access_token) {
		Map<String, Object> session = ActionContext.getContext().getSession();//获取http session
		//将传入的access_token写入session
		session.put(SessionConstants.AccessToken, access_token);
		session.put(SessionConstants.AccToken, access_token.substring(8, 24));
		session.put(SessionConstants.Access_Token, access_token);

		return null;
	}

	@Override
	public String giveClientSecret() {
		//返回account分配给应用的secret_key
		return SessionConstants.SECRET_KEY;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}



