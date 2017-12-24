<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>

<table>
     <tr>
        <td>分组名称：</td>
        <td><input type="text"  name="fzmc" id="fzmc" class="squareinput bottommargin_10" value=""/>
        <span id="error2" class="redletter"></span></td>  
     </tr><tr>
        <td></td>
        <td class="rightfloat">
         <input type="button" class="button" value="确定" onclick="submitFz()"/>
        <!-- <button class="graybutton" onclick="return false;">取消</button> -->
        <a href="groups" class="graybutton" >取消</a></td>  
    </tr>
</table>
<script type="text/javascript">
function submitFz(){
	var username = $('#banner_index').attr("userid");
	var fzmc = $('#fzmc').val().trim();
	if(fzmc == ""){
		$('#text').html('请输入分组名称');
		return false;
	}
//	showLoading();
	$.ajax({
		type:"post",
		url:"groupship/addgroup",
		data:{
			userId:username,
			groupName:fzmc,
		},
		success : function(data)
		{
			//if(data =="success"){
			//	hideLoading();
        		$(document).trigger('close.facebox');
        		alert("新建分组成功");
        		location.reload(true);
        		$("#grouplist").append("<tr id=tr"+data.userId+"/><td class=\"fzmc\">"+data.groupName+"</td><td><a class=\"blueletter\" href=\"contactship/contacts?groupId="+data.userId+"&groupName="+data.groupName+">查看</a><a href=\"group/modgroup.jsp?id="+data.userId+"&groupName="+data.groupName+"class=\"blueletter\" rel=\"facebox\" title=\"修改\" size=\"s\">修改</a><a href=\"javascript:void(0)\" class=\"blueletter\" onclick=\"deleteGroup("+data.userId+")>删除</a></td></tr>")
        		console.log("异步添加分组成功!");
			//}
		}
	
	});
}
$(function(){
	var $toggleBtn = $('td.rightfloat > a');
	$toggleBtn.click(function(){
		$(document).trigger('close.facebox');
		return false;
	})
	
})
</script>
</body>
</html>