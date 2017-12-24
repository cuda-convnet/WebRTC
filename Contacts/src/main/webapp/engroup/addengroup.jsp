<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>

	<table>
		<tr>
			<td>分组名称：</td>
			<td><input type="text" name="fzmc" id="fzmc"
				class="squareinput bottommargin_10" value="" /> <span id="error2"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="hidden" name="lfz" id="lfz"
				class="squareinput bottommargin_10" value="" /> <span id="error2"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td></td>
			<td class="rightfloat"><input type="button" class="button"
				value="确定" onclick="submitFz(${param.lfz})" /> <!-- <button class="graybutton" onclick="return false;">取消</button> -->
				<a href="engroupship/engroups" class="graybutton">取消</a></td>
		</tr>
	</table>
	<script type="text/javascript">
function submitFz(lfz){
	var username = $('#banner_index').attr("user");
	var fzmc = $('#fzmc').val().trim();
	if(fzmc == ""){
		$('#text').html('请输入分组名称');
		return false;
	}
//	showLoading();
	$.ajax({
		type:"post",
		url:"engroupship/addengroup",
		data:{
			username:username,
			fzmc:fzmc,
			lfz:lfz,
		},
		success : function(data)
		{
			//if(data =="success"){
			//	hideLoading();
        		$(document).trigger('close.facebox');
        		alert("新建分组成功");
        		location.reload(true);
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