<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>通信录管理</title>
    <s:include value="/template/_head.jsp"></s:include>
</head>

<body>
<div class="container">
<s:include value="/template/_banner.jsp"></s:include> 
    <div id="inner" class="content">
	<div class="rightalign topmargin_10 bottommargin_10">
	<div class="divline">
	<a class="greyletter" href="groupship/groups">个人通信录</a> > ${param.groupName}
	</div>
	
	<a href="contact/addcontact.jsp?groupId=${param.groupId}" class="button" rel="facebox" title="添加联系人" size="s">添加联系人</a>
	</div>
	
	<table  id="contactlist" class="datatable">
	<tr>
	    <td>姓</td>
	    <td>名</td>
	    <td>性别</td>
	    <td>昵称</td>
	    <td>生日</td>
	    <td>职务</td>
	    <td>部门</td>
	    <td>办公电话</td>
	    <td>手机</td>
	    <td>Email地址</td>
	    <td>通信地址</td>
	    <td>邮政编码</td>
	  
	  	<td>备注</td>
	  	<td>操作</td>
	   </tr>
		<s:iterator id="contact" value="contacts">
		<tr id="tr<s:property value="#contact.id"/>">

		<td><s:property value="#contact.lname"/></td>
		<td><s:property value="#contact.fname"/></td>
		<td><s:property value="#contact.sex"/></td>
		<td><s:property value="#contact.nc"/></td>
		<td><s:property value="#contact.birth"/></td>
		<td><s:property value="#contact.zw"/></td>
		<td><s:property value="#contact.bm"/></td>
		<td><s:property value="#contact.telp"/></td>
		<td><s:property value="#contact.mobp"/></td>
		<td><s:property value="#contact.emails"/></td>
		<td><s:property value="#contact.address"/></td>
		<td><s:property value="#contact.postcode"/></td>
	
		<td><s:property value="#contact.bz"/></td>
		    <td>
		<a href="contact/modcontact.jsp?id=<s:property value="#contact.id"/>
		&lname=<s:property value="#contact.lname"/>
		&fname=<s:property value="#contact.fname"/>&sex=<s:property value="#contact.sex"/>
		&nc=<s:property value="#contact.nc"/>&birth=<s:property value="#contact.birth"/>
		&zw=<s:property value="#contact.zw"/>&bm=<s:property value="#contact.bm"/>
		&telp=<s:property value="#contact.telp"/>&mobp=<s:property value="#contact.mobp"/>
		&emails=<s:property value="#contact.emails"/>&address=<s:property value="#contact.address"/>
		&postcode=<s:property value="#contact.postcode"/>&groupId=<s:property value="#contact.groupId"/>
		&bz=<s:property value="#contact.bz"/>" class="blueletter" rel="facebox" title="修改" size="s">修改</a>
		<a href="javascript:void(0)" class="blueletter" onclick="deleteContact(<s:property value="#contact.id"/>)">删除</a>
		</td></tr>
		</s:iterator>
	</table>
	
		<div class="divpage">
				共${total}页 <a id="firstpage" class="text" href="contactship/contacts?groupId=${param.groupId}&groupName=${param.groupName}">首页</a> 
					<a class="text" id="uppage" href="contactship/contacts?groupId=${param.groupId}&groupName=${param.groupName}&page=${page-1}">上一页</a>
					<span class="currpage">${page}</span> 
				<a class="text" id="nextpage" href="contactship/contacts?groupId=${param.groupId}&groupName=${param.groupName}&page=${page+1}">下一页</a> 
				<a class="text" id="lastpage" href="contactship/contacts?groupId=${param.groupId}&groupName=${param.groupName}&page=${total}">尾页</a>
				<input id="page" type="hidden" value="${page}" name="page">
				<input id="total" type="hidden" value="${total}" name="total">
			<!--  
				<input id="page" type="text" class="squareinput" placeholder="跳转到页面" />
				<a href= class="button">跳转</a> -->
				<div class="tiaozhuan" style={position:relative}>
				<form action="contactship/contacts?groupId=${param.groupId}&groupName=${param.groupName}" method="post">
 				 <input type="text" name="page" class="squareinput"  placeholder="输入第几页"/>
 				 <input type="submit" value="跳转" class="button"/>
				</form>
				</div>
			</div>
	
    </div>
    <s:include value="/template/_footer.jsp"></s:include> 
</div>

<s:include value="/template/_commonjs.jsp"></s:include>
<script src="js/one.js" type="text/javascript"></script>
<script>
function deleteContact(id){
	if(confirm("确定删除该联系人？")){
		$.post("contactship/delcontact",{id:id},function(data){
			$("#tr"+id).remove();
		});
	}
}
</script>
<script>
$(document).ready(function(){
	if($("#page").attr("value")==1){
		$("#uppage").hide();
	}
	if($("#total").attr("value")==$("#page").attr("value")){
		$("#nextpage").hide();
	}
})
</script>
</body>
</html>

