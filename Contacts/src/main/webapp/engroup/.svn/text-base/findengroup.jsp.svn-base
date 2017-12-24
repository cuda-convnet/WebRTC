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
			<div class="divline">企业通信录</div>
				<a href="engroup/addengroup.jsp?lfz=0" class="button" rel="facebox"
					title="添加分组" size="s">添加分组</a>
			</div>
			<table id="engrouplist" class="datatable" width=560px>
				<tr>
					<td>分组名称</td>
					<td>操作</td>
				</tr>
				<s:iterator id="engroup" value="engroups">
					<tr id="tr<s:property value="#engroup.fz"/>">
						<td class="fzmc"><s:property value="#engroup.fzmc" /></td>
						<td><a class="blueletter" href="engroupship/engroups2?fz=<s:property value="#engroup.fz"/>&lfz=<s:property value="#engroup.lfz"/>&fzmc=<s:property value="#engroup.fzmc"/>&size=5">查看</a>
							<a
							href="engroup/modengroup.jsp?fz=<s:property value="#engroup.fz"/>&fzmc=<s:property value="#engroup.fzmc"/>&lfz=<s:property value="#engroup.lfz"/>"
							class="blueletter" rel="facebox" title="修改" size="s">修改</a> <a
							href="javascript:void(0)" class="blueletter"
							onclick="deleteGroup(<s:property value="#engroup.fz"/>)">删除</a></td>
					</tr>
				</s:iterator>
			</table>
			
			<div class="divpage">
				共${total1}页 <a id="firstpage1" class="text" href="engroupship/engroups">首页</a> 
					<a class="text" id="uppage1" href="engroupship/engroups?page1=${page1-1}">上一页</a>
					<span class="currpage">${page1}</span> 
				<a class="text" id="nextpage1" href="engroupship/engroups?page1=${page1+1}">下一页</a> 
				<a class="text" id="lastpage1" href="engroupship/engroups?page1=${total}">尾页</a>
				<input id="page1" type="hidden" value="${page1}" name="page1">
				<input id="total" type="hidden" value="${total1}" name="total">
			<!--  
				<input id="page1" type="text" class="squareinput" placeholder="跳转到页面" />
				<a href= class="button">跳转</a> -->
				<div class="tiaozhuan" style={position:relative}>
				<form action="engroupship/engroups" method="get">
 				 <input type="text" name="page1" class="squareinput"  placeholder="输入第几页"/>
 				 <input type="submit" value="跳转" class="button"/>
				</form>
				</div>
			</div>
			
		</div>
		<s:include value="/template/_footer.jsp"></s:include>
	</div>

	<s:include value="/template/_commonjs.jsp"></s:include>
	<script>
function deleteGroup(fz){
	if(confirm("确定删除该分组？")){
		console.log("shantest");
		$.post("engroupship/delengroup",{fz:fz},function(data){
			$("#tr"+fz).remove();
		});
	}
}
</script>
<script>
$(document).ready(function(){
	if($("#page1").attr("value")==1){
		$("#uppage1").hide();
	}
	if($("#total").attr("value")==$("#page1").attr("value")){
		$("#nextpage1").hide();
	}
})
</script>
</body>
</html>

