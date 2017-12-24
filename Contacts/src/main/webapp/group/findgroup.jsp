<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<base
	href="<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
					+ request.getContextPath()%>/" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>联系人分组</title>
<s:include value="/template/_head.jsp"></s:include>
</head>

<body>
	<div class="container">
		<s:include value="/template/_banner.jsp"></s:include>
		<div id="inner" class="content">
			<div class="rightalign topmargin_10 bottommargin_10">
				<div class="divline">个人通信录</div>
				<a href="group/addgroup2.jsp" class="button" rel="facebox"
					title="添加分组" size="s">添加分组</a>
			</div>

			<table id="grouplist" class="datatable">
				<tr>
					<td>分组名称</td>
					<td>操作</td>
				</tr>
				<s:iterator id="group" value="groups">
					<tr id="tr<s:property value="#group.id"/>">
						<td class="fzmc"><s:property value="#group.groupName" /></td>
						<td><a class="blueletter"
							href="contactship/contacts?groupId=<s:property value="#group.id"/>&groupName=<s:property value="#group.groupName"/>">查看</a>
							<a
							href="group/modgroup.jsp?id=<s:property value="#group.id"/>
		&groupName=<s:property value="#group.groupName"/>"
							class="blueletter" rel="facebox" title="修改" size="s">修改</a> <a
							href="javascript:void(0)" class="blueletter"
							onclick="deleteGroup(<s:property value="#group.id"/>)">删除</a></td>
					</tr>
				</s:iterator>

			</table>
			<div class="divpage">
				共${total}页 <a id="firstpage" class="text" href="groupship/groups">首页</a> 
					<a class="text" id="uppage" href="groupship/groups?page=${page-1}">上一页</a>
					<span class="currpage">${page}</span> 
				<a class="text" id="nextpage" href="groupship/groups?page=${page+1}">下一页</a> 
				<a class="text" id="lastpage" href="groupship/groups?page=${total}">尾页</a>
				<input id="page" type="hidden" value="${page}" name="page">
				<input id="total" type="hidden" value="${total}" name="total">
			<!--  
				<input id="page" type="text" class="squareinput" placeholder="跳转到页面" />
				<a href= class="button">跳转</a> -->
				<div class="tiaozhuan" style={position:relative}>
				<form action="groupship/groups" method="get">
 				 <input type="text" name="page" class="squareinput"  placeholder="输入第几页"/>
 				 <input type="submit" value="跳转" class="button"/>
				</form>
				</div>
			</div>

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

