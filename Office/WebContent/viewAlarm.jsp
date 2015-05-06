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
<link href="css/type.css" type="text/css" rel="stylesheet"/>
<script type="text/javascript" src="js/position.js"></script>
</head>
<body onload="updateTree('li8d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">

<ul>
<s:iterator value="deptList">
<li>
<a href="viewAlarm.action?currentPage=1&deptNumber=<s:property value="deptNumber"/>"><s:property value="deptName"/></a>
</li>
</s:iterator>
</ul>

<table width="100%" align="center" cellpadding="0" cellspacing="0">
<s:form action="delAlarm" method="post" theme="simple" id="delform">
<s:hidden name="currentPage"></s:hidden>

<tr style="background-color:#c1d9f3;height: 40px ">
<th style="border-bottom: 2px solid #154ba0;">&nbsp;<s:checkbox name="allcheck" id="allcheck" onclick="checkall(this.form);"></s:checkbox></th>
<th style="border-bottom: 2px solid #154ba0;">發件人</th>
<th style="border-bottom: 2px solid #154ba0;">主題</th>
<th style="border-bottom: 2px solid #154ba0;">時間</th>
<th style="border-bottom: 2px solid #154ba0;">部門</th>

</tr>
<s:iterator value="alarmList" status="alarm">
<tr id="alarm<s:property value="#alarm.index"/>" style="height: 40px;" 
onmouseover="mouseovercolor('alarm<s:property value="#alarm.index"/>');" onmouseout="mouseoutcolor('alarm<s:property value="#alarm.index"/>');">
<td>&nbsp;&nbsp;&nbsp;<s:checkboxlist id="delList" name="delList" list="#{'0':''}" listKey="alarmNumber" listValue="''"></s:checkboxlist></td>
<td style="border-bottom:1px solid #a8cde4;" onclick="document.location.href='alarmDetail.action?currentPage=<s:property value="currentPage"/>&alarmNumber=<s:property value="alarmNumber"/>'"><s:property value="fromUserName"/></td>
<td style="border-bottom:1px solid #a8cde4;" onclick="document.location.href='alarmDetail.action?currentPage=<s:property value="currentPage"/>&alarmNumber=<s:property value="alarmNumber"/>'"><s:property value="title"/></td>
<td style="border-bottom:1px solid #a8cde4;" onclick="document.location.href='alarmDetail.action?currentPage=<s:property value="currentPage"/>&alarmNumber=<s:property value="alarmNumber"/>'"><s:property value="time"/></td>
<td style="border-bottom:1px solid #a8cde4;" onclick="document.location.href='alarmDetail.action?currentPage=<s:property value="currentPage"/>&alarmNumber=<s:property value="alarmNumber"/>'"><s:property value="deptName"/></td>
</tr>

</s:iterator>
</s:form>
<tr>
<td colspan="6">
<s:form action="viewAlarm" theme="simple" method="post">
<table width="100%">
<tr style="background-color:#c1d9f3;height: 40px; ">
<td align="right">
<s:submit onclick="document.getElementById('delform').submit(); return false;" value="刪除"></s:submit>
<s:select onchange="this.form.submit()" name="pageSpan" list="#{2:'2條/頁',5:'5條/頁',10:'10條/頁',15:'15條/頁',20:'20條/頁',25:'25條/頁'}"></s:select>
<s:property value="currentPage"/>/<s:property value="maxPage"/>
<s:if test="currentPage>1">
<a href="viewAlarm.action?currentPage=<s:property value="currentPage-1"/>&pageSpan=<s:property value='pageSpan'/>" style="text-decoration: none;color:#0f4097;">上一頁</a>
</s:if>
<s:if test="currentPage<maxPage">
<a href="viewAlarm.action?currentPage=<s:property value="currentPage+1"/>&pageSpan=<s:property value='pageSpan'/>" style="text-decoration: none;color:#0f4097;">下一頁</a>
</s:if>
</td>
</tr>
</table>
</s:form>
</td>
</tr>
</table>
</div>
</div>
</body>
</html>