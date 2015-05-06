<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link href="css/mainstyle.css" type="text/css" rel="stylesheet"/>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/position.js"></script>
<script type="text/javascript">

function checkEmail(){

	
}

</script>
</head>
<body onload="updateTree('li6d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<s:form theme="simple" action="sendEmail" method="post" onsubmit="return checkEmail();">
<table width="100%" cellpadding="0" cellspacing="0">
<tr height="40px">
<td>收件人地址</td>
<td><s:textfield name="toEmail" id="toEmail"></s:textfield></td>
</tr>
<tr height="40px">
<td>郵件主題</td>
<td><s:textfield name="topic" id="topic" cssStyle="width:300px;"></s:textfield></td>
</tr>
<tr>
<td>郵件內容</td>
<td><s:textarea name="content" id="content" cssStyle="width:500px;height:300px"></s:textarea></td>
</tr>
<tr>
<td colspan="2" align="center">
<s:submit value="發送"></s:submit>&nbsp;&nbsp;&nbsp;<s:reset value="取消"></s:reset>
</td>
</tr>
</table>
</s:form>
</div>
</div>

<script type="text/javascript">
var result="<s:property value="result"/>";
if(result!=""){
	alert(result);
}
</script>
</body>
</html>