<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="banner_index" class="pub_banner" sys="freeabout" user=<s:property value="#session.email"/> 
 acctoken=<s:property value="#session.accToken"/> userId=<s:property value="#session.uid"/>
 	index="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/"%>"></div>
 <div class="banner">
    <img id="logo" src="images/logo.png" border="0" />
</div><!--banner-->