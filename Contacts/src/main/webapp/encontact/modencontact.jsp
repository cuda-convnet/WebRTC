<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<table>
		<tr>
			<td><input type=hidden name="id" id="id" value="${param.id}" /></td>
		</tr>
		<tr>
			<td>姓：</td>
			<td><input name="lname" id="lname" class="squareinput bottommargin_10"
				value="${param.lname}" /> <span id="error2" class="redletter"></span></td>
		</tr>
		<tr>
			<td>名：</td>
			<td><input name="fname" id="fname" class="squareinput bottommargin_10"
				value="${param.fname}" /> <span id="error3" class="redletter"></span></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><input name="sex" id="sex" class="squareinput bottommargin_10"
				value="${param.sex}" /> <span id="error4" class="redletter"></span></td>
		</tr>
		<tr>
			<td>昵称：</td>
			<td><input name="nc" id="nc" class="squareinput bottommargin_10"
				value="${param.nc}" /> <span id="error5" class="redletter"></span></td>
		</tr>
		<tr>
			<td>生日：</td>
			<td><input name="birth" id="birth" class="squareinput bottommargin_10"
				value="${param.birth}" /> <span id="error6" class="redletter"></span></td>
		</tr>
		<tr>
			<td>工号：</td>
			<td><input name="gh" id="gh" class="squareinput bottommargin_10"
				value="${param.gh}" /> <span id="error7" class="redletter"></span></td>
		</tr>
		<tr>
			<td>职务：</td>
			<td><input name="zw" id="zw" class="squareinput bottommargin_10"
				value="${param.zw}" /> <span id="error8" class="redletter"></span></td>
		</tr>
		<tr>
			<td>部门：</td>
			<td><input name="bm" id="bm" class="squareinput bottommargin_10"
				value="${param.bm}" /> <span id="error9" class="redletter"></span></td>
		</tr>
		<tr>
			<td>办公电话：</td>
			<td><input name="telp" id="telp" class="squareinput bottommargin_10"
				value="${param.telp}" /> <span id="error10" class="redletter"></span></td>
		</tr>
		<tr>
			<td>手机：</td>
			<td><input name="mobp" id="mobp" class="squareinput bottommargin_10"
				value="${param.mobp}" /> <span id="error11" class="redletter"></span></td>
		</tr>
		<tr>
			<td>Email地址：</td>
			<td><input name="emails" id="emails" class="squareinput bottommargin_10"
				value="${param.emails}" /> <span id="error12" class="redletter"></span></td>
		</tr>
		<tr>
			<td>通信地址：</td>
			<td><input name="address" id="address" class="squareinput bottommargin_10"
				value="${param.address}" /> <span id="error13" class="redletter"></span></td>
		</tr>
		<tr>
			<td>邮政编码：</td>
			<td><input name="postcode" id="postcode" class="squareinput bottommargin_10"
				value="${param.postcode}" /> <span id="error14" class="redletter"></span></td>
		</tr>
		<tr>

			<td><input name="fz" id="fz" type="hidden"
				class="squareinput bottommargin_10" value="${param.fz}" /> <span
				id="error15" class="redletter"></span></td>
		</tr>
		<tr>
			<td>备注：</td>
			<td><input name="bz" id="bz" class="squareinput bottommargin_10"
				value="${param.bz}" /> <span id="error16" class="redletter"></span></td>
		</tr>
		<tr>
			<td></td>
			<td class="exit"><br />
				 <input type="button" class="button" value="确定" onclick="modenfriend(${param.id})"/> <!-- <button class="graybutton" onclick="return false;">取消</button> -->
				<a href="encontactship/encontacts" class="graybutton">取消</a></td>
		</tr>
	</table>
<script type="text/javascript">
	function modenfriend(id){
		
		var lname = $('#lname').val().trim();
		var fname = $('#fname').val().trim();
		var sex = $('#sex').val().trim();
		var nc = $('#nc').val().trim();
		var birth = $('#birth').val().trim();
		var gh = $('#gh').val().trim();
		var zw = $('#zw').val().trim();
		var bm = $('#bm').val().trim();
		var telp = $('#telp').val().trim();
		var mobp = $('#mobp').val().trim();
		var emails = $('#emails').val().trim();
		var address = $('#address').val().trim();
		var postcode = $('#postcode').val().trim();
		var fz = "${param.fz}";
		var bz = $('#bz').val().trim();
		
//		showLoading();
		$.ajax({
			type:"post",
			url:"encontactship/modencontact",
			data:{
				id:id,
				lname:lname,
				fname:fname,
				sex:sex,
				nc:nc,
				birth:birth,
				gh:gh,
				zw:zw,
				bm:bm,
				telp:telp,
				mobp:mobp,
				emails:emails,
				address:address,
				postcode:postcode,
				fz:fz,
				bz:bz
		
			},
			success : function(data)
			{
				//if(data =="success"){
				//	hideLoading();
	        		$(document).trigger('close.facebox');
	        		alert("修改联系人成功");
	        		$("#encontactlist #tr"+data.id+" td:not(:last)").remove();
	        		$("#encontactlist #tr"+data.id).prepend("<td>"+data.lname+"</td><td>"+data.fname+"</td><td>"+data.sex+"</td><td>"+data.nc+"</td><td>"+data.birth+"</td><td>"+data.gh+"</td><td>"+data.zw+"</td><td>"+data.bm+"</td><td>"+data.telp+"</td><td>"+data.mobp+"</td><td>"+data.emails+"</td><td>"+data.address+"</td><td>"+data.postcode+"</td><td>"+data.bz+"</td>");
				//}
			},
		
		});
	}
		$(function() {
			var $toggleBtn = $('td.exit > a');
			$toggleBtn.click(function() {
				$(document).trigger('close.facebox');
				return false;
			})

		})
	</script>
</body>
</html>