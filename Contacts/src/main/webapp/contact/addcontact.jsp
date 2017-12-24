<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
	<table>
		<tr>
			<td>姓：</td>
			<td><input type="text" name="lname" id="lname"
				class="squareinput bottommargin_10" value="" /> <span id="error2"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>名：</td>
			<td><input type="text" name="fname" id="fname"
				class="squareinput bottommargin_10" value="" /> <span id="error3"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>性别：</td>
			<td><input type="text" name="sex" id="sex"
				class="squareinput bottommargin_10" value="" /> <span id="error4"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>昵称：</td>
			<td><input type="text" name="nc" id="nc"
				class="squareinput bottommargin_10" value="" /> <span id="error5"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>生日：</td>
			<td><input type="text" name="birth" id="birth"
				class="squareinput bottommargin_10" value="" /> <span id="error6"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>职务：</td>
			<td><input type="text" name="zw" id="zw"
				class="squareinput bottommargin_10" value="" /> <span id="error7"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>部门：</td>
			<td><input type="text" name="bm" id="bm"
				class="squareinput bottommargin_10" value="" /> <span id="error8"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>办公电话：</td>
			<td><input type="text" name="telp" id="telp"
				class="squareinput bottommargin_10" value="" /> <span id="error9"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>手机：</td>
			<td><input type="text" name="mobp" id="mobp"
				class="squareinput bottommargin_10" value="" /> <span id="error10"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>Email地址：</td>
			<td><input type="text" name="emails" id="emails"
				class="squareinput bottommargin_10" value="" /> <span id="error11"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>通信地址：</td>
			<td><input type="text" name="address" id="address"
				class="squareinput bottommargin_10" value="" /> <span id="error12"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>邮政编码：</td>
			<td><input type="text" name="postcode" id="postcode"
				class="squareinput bottommargin_10" value="" /> <span id="error13"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td><input type="hidden" name="fz" id="fz"
				class="squareinput bottommargin_10" value="" /> <span id="error14"
				class="redletter"></span></td>
		</tr>
		<tr>
			<td>备注：</td>
			<td><input type="text" name="bz" id="bz"
				class="squareinput bottommargin_10" value="" /> <span id="error15"
				class="redletter"></span></td>
		</tr>

		<tr>
			<td></td>
			<td class="exit"><br /> <input type="button" class="button"
				value="确定" onclick="addfriend()" /> <!--<button class="graybutton" onclick="return false;">取消</button>-->
				<a href="contactship/contacts" class="graybutton">取消</a></td>
		</tr>
	</table>

	<script type="text/javascript">
		function addfriend() {

			var lname = $('#lname').val().trim();
			var fname = $('#fname').val().trim();
			var sex = $('#sex').val().trim();
			var nc = $('#nc').val().trim();
			var birth = $('#birth').val().trim();
			var zw = $('#zw').val().trim();
			var bm = $('#bm').val().trim();
			var telp = $('#telp').val().trim();
			var mobp = $('#mobp').val().trim();
			var emails = $('#emails').val().trim();
			var address = $('#address').val().trim();
			var postcode = $('#postcode').val().trim();
			var groupId = "${param.groupId}";
			var bz = $('#bz').val().trim();

			//	showLoading();
			$.ajax({
				type : "post",
				url : "contactship/addcontact",
				data : {
					lname : lname,
					fname : fname,
					sex : sex,
					nc : nc,
					birth : birth,
					zw : zw,
					bm : bm,
					telp : telp,
					mobp : mobp,
					emails : emails,
					address : address,
					postcode : postcode,
					groupId : groupId,
					bz : bz

				},
				success : function(data) {
					//console.log(data);
					//if(data =="success"){
					//	hideLoading();
					$(document).trigger('close.facebox');
					alert("添加联系人成功");
					location.reload(true);
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