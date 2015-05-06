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
</head>
<body onload="updateTree('li3d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<table border="1" align="center" cellpadding="0" cellspacing="0" width="100%">
<tr>
<td align="right" style="width:100px;background-color: #c1d9f3;border-bottom: #c1d9f3 solid 1px;">發送人</td>
<td align="center" style="width:200px; background-color: #c1d9f3;border-bottom: #c1d9f3 solid 1px;"><s:property value="msg.fromUserName"/></td>
<td align="right" style="background-color: #c1d9f3;border-bottom: #c1d9f3 solid 1px;">發送時間:<s:property value="msg.msgTimeStr"/></td>
</tr>
<tr>
<td align="right">訊息主題</td>
<td colspan="2" align="center"><s:property value="msg.msgInfo"/></td>
</tr>
<tr height="300px">
<td align="right" valign="top">訊息內容</td>
<td colspan="2" valign="top">
<s:property value="msg.msgContent"/>
</td>
</tr>
<tr>
<td colspan="3" align="center">
<a href="receiveMessage.action?currentPage=<s:property value="currentPage"/>" style="text-decoration: none;color: #1D1BA3;">返回</a>
</td>

</tr>
</table>
</div>
</div>
</body>
</html>