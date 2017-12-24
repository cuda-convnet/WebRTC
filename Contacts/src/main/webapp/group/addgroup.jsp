<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<body>
<form method="post" action="groupship/addgroup">
<table>
      <tr>
        <td width="100px">用户账号：</td>
        <td><input name="username" class="squareinput bottommargin_10" value="${param.username}"/>
        <span id="error1" class="redletter"></span></td>  
    </tr><tr>
        <td>分组名称：</td>
        <td><input name="fzmc" class="squareinput bottommargin_10" value="${param.fzmc}"/>
        <span id="error2" class="redletter"></span></td>  
     </tr><tr>
        <td></td>
        <td><br /><button class="button">确定</button>
        <!-- <button class="graybutton" onclick="return false;">取消</button> -->
        <a href="groups" class="graybutton" >取消</a></td>  
    </tr>
</table>
</form>
</body>
</html>