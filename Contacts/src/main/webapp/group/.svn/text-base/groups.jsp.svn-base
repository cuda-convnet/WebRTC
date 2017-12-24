<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <base href="<%= request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() %>/" />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>联系人分组</title>
    <s:include value="/template/_head.jsp"></s:include>
</head>

<body>
<div class="container">
<s:include value="/template/_banner.jsp"></s:include> 
    <div id="inner" class="content">
	<div class="rightalign topmargin_10 bottommargin_10">
	<a href="group/addgroup.jsp" class="button" rel="facebox" title="添加分组" size="s">添加分组</a>
	</div>
	
	<table  class="datatable">
	    <tr><td>用户账号</td>
	    <td>分组名称</td>
	    <td>操作</td>
	   </tr>
		<s:iterator id="group" value="groups">
		<tr id="tr<s:property value="#group.id"/>">
		<td><s:property value="#group.userId"/></td>
		<td><s:property value="#group.groupName"/></td>
		    <td>
		<a href="group/modgroup.jsp?id=<s:property value="#group.id"/>
		&userId=<s:property value="#group.userId"/>&groupName=<s:property value="#group.groupName"/>"
		class="blueletter" rel="facebox" title="修改" size="s">修改</a>
		<a href="javascript:void(0)" class="blueletter" onclick="deleteGroup(<s:property value="#group.id"/>)">删除</a>
		</td></tr>
		</s:iterator>
	</table>
    </div>
    <s:include value="/template/_footer.jsp"></s:include> 
</div>

<s:include value="/template/_commonjs.jsp"></s:include>
<script>
function deleteGroup(id){
	if(confirm("确定删除该分组？")){
		console.log("shantest");
		$.post("groupship/delgroup",{id:id},function(data){
			$("#tr"+id).remove();
		});
	}
}
</script>
</body>
</html>

