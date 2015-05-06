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
<body>
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<table width="90%" cellpadding="0" cellspacing="0" style="font-size: 14px">
<tr>
<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">
報警人:
</td>
<td style="border-bottom: #c1d9f3 solid 1px;">
<s:property value="alarm.fromUserName"/>
</td>
<td align="right" style="width:130px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">
報警時間:<s:property value="alarm.time"/>
</td>
</tr>
<tr>
<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">
報警部門:
</td>
<td colspan="2" style="border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;">
<s:property value="alarm.deptName"/>
</td>
</tr>
<tr>
<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">
主題:
</td>
<td colspan="2" style="border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;">
<s:property value="alarm.title"/>
</td>
</tr>
<tr>
<td align="right" style="width:100px;background-color:#c1d9f3;border-bottom:#c1d9f3 solid 1px;">
詳細訊息
</td>
<td valign="top" colspan="2" style="height:300px; border-bottom:#c1d9f3 solid 1px;border-right:#c1d9f3 solid 1px;">
<s:property value="alarm.detail"/>
</td>
</tr>
<tr>
<td colspan="3" align="center" style="font-size: 16px;">
<a href="viewAlarm?currentPage=<s:property value="currentPage"/>">返回</a>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>