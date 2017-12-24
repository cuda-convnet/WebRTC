package com.free4lab.webrtc.action.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.free4lab.utils.account.BaseLoginFilter;
import com.free4lab.webrtc.common.Constants;

public class LoginFilter extends BaseLoginFilter {

	@Override
	protected String getClientId() {
		return Constants.CUSTOM_ID;
	}

	@Override
	protected String getRedirectUri() {
		return "/login";
	}

	@Override
	protected String getAccessTokenInSession(HttpServletRequest request,
			HttpServletResponse response) {
		String accessTokenInSession = (String) request.getSession().getAttribute(Constants.AccessToken);
		System.out.println("LoginFilter中：先checkPermission：accessTokenInSession"+accessTokenInSession);
		return accessTokenInSession;
	}

}
