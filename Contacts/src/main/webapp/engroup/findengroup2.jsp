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
				<div class="divline">
					<a class="greyletter" href="engroupship/engroups">企业通信录</a> > 
					<s:iterator id="engroupfather" value="engroupfathers">
						<s:property value="#engroupfather.fzmc"/>
				    </s:iterator>
				</div>
				<a href="engroup/addengroup2.jsp?lfz=${param.fz}" class="button"
					rel="facebox" title="添加分组" size="s">添加分组</a>
			</div>
<!-- 		<table id="engroupfatherlist" class="datatable">
				<tr>
					<td>父亲分组名称</td>
				</tr>
				<s:iterator id="engroupfather" value="engroupfathers">
					<tr id="tr<s:property value="engroupfather.fz"/>">
						<td><s:property value="#engroupfather.fzmc" /></td>
					</tr>
				</s:iterator>
			</table> 	
			<br/> -->
			<table id="engrouplist" class="datatable">
				<tr>
					<td>分组名称</td>
					<td>操作</td>
				</tr>
				<s:iterator id="engroup" value="engroups">
					<tr id="tr<s:property value="#engroup.fz"/>">
						<td class="fzmc"><s:property value="#engroup.fzmc" /></td>
						<td><a class="blueletter"
							href="engroupship/engroups3?fz=<s:property value="#engroup.fz"/>&lfz=<s:property value="#engroup.lfz"/>&fzmc=<s:property value="#engroup.fzmc"/>&size=5">查看</a>
							<a
							href="engroup/modengroup.jsp?fz=<s:property value="#engroup.fz"/>&fzmc=<s:property value="#engroup.fzmc"/>&lfz=<s:property value="#engroup.lfz"/>"
							class="blueletter" rel="facebox" title="修改" size="s">修改</a> <a
							href="javascript:void(0)" class="blueletter"
							onclick="deleteGroup(<s:property value="#engroup.fz"/>)">删除</a></td>
					</tr>
				</s:iterator>
			</table>
			
			<div class="divpage">
				共${total1}页 <a id="firstpage1" class="text" href="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&size=5">首页</a> 
					<a class="text" id="uppage1" href="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&page1=${page1-1}&size=5">上一页</a>
					<span class="currpage">${page1}</span> 
				<a class="text" id="nextpage1" href="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&page1=${page1+1}&size=5">下一页</a> 
				<a class="text" id="lastpage1" href="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&page1=${total1}&size=5">尾页</a>
				<input id="page1" type="hidden" value="${page1}" name="page1">
				<input id="total1" type="hidden" value="${total1}" name="total1">
			<!--  
				<input id="page1" type="text" class="squareinput" placeholder="跳转到页面" />
				<a href= class="button">跳转</a> -->
				<div class="tiaozhuan" style={position:relative}>
				<form action="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&size=5" method="post">
 				 <input type="text" name="page1" class="squareinput"  placeholder="输入第几页"/>
 				 <input type="submit" value="跳转" class="button"/>
				</form>
				</div>
			</div>
			
		</div>

		<div id="inner" class="content">
			<div class="rightalign topmargin_10 bottommargin_10">
				<a href="encontact/addencontact2.jsp?fz=${param.fz}" class="button"
					rel="facebox" title="添加联系人" size="s">添加联系人</a>
			</div>

			<table id="encontactlist" class="datatable">
				<tr>
					<td>姓</td>
					<td>名</td>
					<td>性别</td>
					<td>昵称</td>
					<td>生日</td>
					<td>工号</td>
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
				<s:iterator id="encontact" value="encontacts">
					<tr id="tr<s:property value="#encontact.id"/>">
						<td><s:property value="#encontact.lname" /></td>
						<td><s:property value="#encontact.fname" /></td>
						<td><s:property value="#encontact.sex" /></td>
						<td><s:property value="#encontact.nc" /></td>
						<td><s:property value="#encontact.birth" /></td>
						<td><s:property value="#encontact.gh" /></td>
						<td><s:property value="#encontact.zw" /></td>
						<td><s:property value="#encontact.bm" /></td>
						<td><s:property value="#encontact.telp" /></td>
						<td><s:property value="#encontact.mobp" /></td>
						<td><s:property value="#encontact.emails" /></td>
						<td><s:property value="#encontact.address" /></td>
						<td><s:property value="#encontact.postcode" /></td>
						<td><s:property value="#encontact.bz" /></td>
						<td><a
							href="encontact/modencontact.jsp?id=<s:property value="#encontact.id"/>
		&lname=<s:property value="#encontact.lname"/>&fname=<s:property value="#encontact.fname"/>
		&sex=<s:property value="#encontact.sex"/>&nc=<s:property value="#encontact.nc"/>
		&birth=<s:property value="#encontact.birth"/>&gh=<s:property value="#encontact.gh"/>
		&zw=<s:property value="#encontact.zw"/>&bm=<s:property value="#encontact.bm"/>
		&telp=<s:property value="#encontact.telp"/>&mobp=<s:property value="#encontact.mobp"/>
		&emails=<s:property value="#encontact.emails"/>&address=<s:property value="#encontact.address"/>
		&postcode=<s:property value="#encontact.postcode"/>&fz=<s:property value="#encontact.fz"/>
		&bz=<s:property value="#encontact.bz"/>"
							class="blueletter" rel="facebox" title="修改" size="s">修改</a> <a
							href="javascript:void(0)" class="blueletter"
							onclick="deleteContact(<s:property value="#encontact.id"/>)">删除</a>
						</td>
					</tr>
				</s:iterator>
			</table>
			
		<div class="divpage">
				共${total2}页 <a id="firstpage2" class="text" href="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&size=5">首页</a> 
					<a class="text" id="uppage2" href="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&page2=${page2-1}&size=5">上一页</a>
					<span class="currpage">${page2}</span> 
				<a class="text" id="nextpage2" href="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&page2=${page2+1}&size=5">下一页</a> 
				<a class="text" id="lastpage2" href="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&page2=${total2}&size=5">尾页</a>
				<input id="page2" type="hidden" value="${page2}" name="page2">
				<input id="total2" type="hidden" value="${total2}" name="total2">
			<!--  
				<input id="page2" type="text" class="squareinput" placeholder="跳转到页面" />
				<a href= class="button">跳转</a> -->
				<div class="tiaozhuan" style={position:relative}>
				<form action="engroupship/engroups2?fz=${param.fz}&lfz=${param.lfz}&fzmc=${param.fzmc}&size=5" method="post">
 				 <input type="text" name="page2" class="squareinput"  placeholder="输入第几页"/>
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
function deleteContact(id){
	if(confirm("确定删除该联系人？")){
		$.post("encontactship/delencontact",{id:id},function(data){
			$("#tr"+id).remove();
		});
	}
}
</script>
<script>
$(document).ready(function(){
	if($("#page1").attr("value")==1){
		$("#uppage1").hide();
	}
	if($("#total1").attr("value")==$("#page1").attr("value")){
		$("#nextpage1").hide();
	}
})
</script>
<script>
$(document).ready(function(){
	if($("#page2").attr("value")==1){
		$("#uppage2").hide();
	}
	if($("#total2").attr("value")==$("#page2").attr("value")){
		$("#nextpage2").hide();
	}
})
</script>
</body>
</html>

