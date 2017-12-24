<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
<table>
    <tr>
   		<td><input type=hidden name="fz" id="fz" value="${param.fz}" /></td>
   	</tr>
   	<tr>
        <td>分组名称：</td>
        <td><input type="text"  name="fzmc" id="fzmc" class="squareinput bottommargin_10" value="${param.fzmc}"/>
        <span id="error2" class="redletter"></span></td>  
      </tr><tr>
        <td></td>
        <td class="rightfloat"> <input id="justselect" type="button" class="button" value="确定" onclick="submitFzmc(${param.fz})"/>
        <!-- <button class="graybutton" onclick="return false;">取消</button> -->
        <a href="engroups" class="graybutton" >取消</a></td>  
    </tr>
</table>
<script type="text/javascript">
function submitFzmc(fz){
	var username = $('#banner_index').attr("user");
	var fzmc = $('#fzmc').val().trim();
	
//	showLoading();
	$.ajax({
		type:"post",
		url:"engroupship/modengroup",
		data:{
			fz:fz,
			username:username,
			fzmc:fzmc,
		},
		success : function(data)
		{
	 		$(document).trigger('close.facebox');
    		alert("修改分组成功");
    		//$( "#tr"+data.fz).remove();
    		$("#engrouplist #tr"+data.fz+" td:eq(0)").remove();
    		//$("tbody").append("<tr class=\"tablevalue\" id=\"tr"+data.fz+"\"><td>"+data.fzmc+"</td><td><a class=\"blueletter\" href=\"contactship/contacts?fz="+data.fz+">查看</a> <a href=\"modengroup.jsp?fz="+data.fz+"&fzmc="+data.fzmc+" class=\"blueletter\" rel=\"facebox\" title=\"修改\" size=\"s\">修改</a> <a href=\"javascript:void\(0\)\" class=\"blueletter\" onclick=\"deleteGroup("+data.fz+")\">删除</a></td></tr>");
            $("#engrouplist #tr"+data.fz).prepend("<td class=\"fzmc\">"+data.fzmc+"</td>");  
    		
		}
	
	});
}
$(function() {
	var $toggleBtn = $('td.rightfloat > a');
	$toggleBtn.click(function() {
		$(document).trigger('close.facebox');
		return false;
	})

})

</script>
</body>
</html>