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
<body onload="updateTree('li9d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<table style="width: 100%;border: 1px solid #154ba0;">
<tr style="background-color:#eff5fb;color:#154ba0;font-size: 18px;font-weight: 500;  ">
<td align="center">在線考勤</td>
</tr>
<tr style="color: #154ba0;">
<td align="center"><img alt="" src="images/time.gif"><span id="time"></span></td>
</tr>
<tr>
<td style="color: #154ba0; font-size: 17px;" align="center">
上班時段:<s:property value="start"/>至<s:property value="end"/>
</td>
</tr>
<tr>
<td>
<table width="95%" cellpadding="0" cellspacing="0" style="border:1px solid #154ba0;">
<tr style="height: 25px;background-color: #eff5fb;">
<td align="center" style="border-right:1px solid #154ba0;border-bottom:1px solid #154ba0;">姓名</td>
<td align="center" style="border-right:1px solid #154ba0;border-bottom:1px solid #154ba0;">部門</td>
<td align="center" style="border-right:1px solid #154ba0;border-bottom:1px solid #154ba0;">網路IP</td>
<td align="center" style="border-bottom:1px solid #154ba0;">狀態</td>
</tr>
<tr height="25px">
<td style="color:#154ba0;border-right:1px solid #154ba0;border-bottom:1px solid #154ba0;" align="center"><s:property value="attUser"/></td>
<td style="color:#154ba0;border-right:1px solid #154ba0;border-bottom:1px solid #154ba0;" align="center"><s:property value="attDept"/></td>
<td style="color:#154ba0;border-right:1px solid #154ba0;border-bottom:1px solid #154ba0;" align="center"><s:property value="cIp"/></td>
<td style="color:#154ba0;border-bottom:1px solid #154ba0;" align="center">
<s:if test="attStart==0">
<span style="color:#154ba0;">上班還未打卡</span>
</s:if>
<s:else>
<s:if test="attStart==2">
<span style="color:#154ba0;">上班按時打卡</span>
</s:if>
<s:else>
<span style="color:#f00;">上班打卡遲到</span>
</s:else>
</s:else>
&nbsp;|&nbsp;
<s:if test="attEnd==0">
<span style="color:#154ba0;">下班還未打卡</span>
</s:if>
<s:else>
<s:if test="attEnd==2">
<span style="color:#154ba0;">下班按時打卡</span>
</s:if>
<s:else>
<span style="color:#f00;">下班打卡早退</span>
</s:else>
</s:else>
</td>
</tr>
<tr height="30px">
<td colspan="4" align="right">
<br/>
<s:if test="attStart==0">
<s:form action="checkOn" theme="simple" method="post">
<s:hidden name="type" value="0"></s:hidden>
<s:submit value="上班考勤" theme="simple"></s:submit>
</s:form>
</s:if>
<s:if test="attEnd==0">
<s:form action="checkOn" theme="simple" method="post">
<s:hidden name="type" value="1"></s:hidden>
<s:submit value="下班考勤" theme="simple"></s:submit>
</s:form>
</s:if>
</td>
</tr>
</table>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>