package com.free4lab.webrtc.action.filter;
import com.free4lab.webrtc.common.SessionConstants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.free4lab.utils.account.AccountUtil;
import com.free4lab.utils.account.BaseLoginFilter;

/**
 * 继承common中封装过的BaseLoginFilter
 */
public class LoginFilter extends BaseLoginFilter {
	@Override
	protected String getClientId() {
		//返回account分配给应用的client_id即原customId的值
		return SessionConstants.CUSTOM_ID;
	}
	
	@Override
	protected String getRedirectUri() {
		//返回应用login方法的url，注意login和logout方法要在同一个父目录下！
		return "/login";
	}
	@Override
	protected String getAccessTokenInSession(HttpServletRequest request,HttpServletResponse response) {
/*java.util.Enumeration   e   =   request.getSession().getAttributeNames();   
        
		while( e.hasMoreElements())   {   
		    String sessionName=(String)e.nextElement();   
		    System.out.println("session item name="+sessionName+"   ");  
		    System.out.println("session item value="+request.getSession().getAttribute(sessionName)+ "\n");  
		} 
		
		
*/		
       //返回session中access_token的值
       String accessTokenInSession = (String) request.getSession().getAttribute(SessionConstants.AccessToken);
//       System.out.println("LoginFilter中：先checkPermission：accessToken In Session"+accessTokenInSession);
  
       return accessTokenInSession;
   }
	
//	/**
//	 * 外部用户检查权限，仅仅需要access_token即可，不需要和爬虫数据吻合
//	 * @param request
//	 * @param response
//	 * @return
//	 */
//	@Override
//	protected boolean checkPermission(HttpServletRequest request,HttpServletResponse response) {
//
//		String accessTokenInSession = getAccessTokenInSession(request, response);
//		if( accessTokenInSession != null && !"".equalsIgnoreCase( accessTokenInSession )){
//
//			return true;
//		}
//		return false;
//	}

}