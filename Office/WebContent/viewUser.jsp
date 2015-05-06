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
<body onload="updateTree('li5d')">
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
<a href="viewUser.action?currentPage=1&deptNumber=<s:property value="deptNumber"/>"><s:property value="deptName"/></a>
</li>
</s:iterator>
</ul>
<hr color="black" align="center">
<table width="100%" cellpadding="0" cellspacing="0">
<tr bgcolor="#c1d9f3" height="35px">
<th style="border-bottom: 2px solid #154ba0;">用戶名</th>
<th style="border-bottom: 2px solid #154ba0;">真實姓名</th>
<th style="border-bottom: 2px solid #154ba0;">性別</th>
<th style="border-bottom: 2px solid #154ba0;">部門</th>
<th style="border-bottom: 2px solid #154ba0;">職位</th>
<th style="border-bottom: 2px solid #154ba0;">電話</th>
<th style="border-bottom: 2px solid #154ba0;">詳情</th>
</tr>
<s:iterator value="userList" status="user">
<tr id="user<s:property value="#user.index"/>" style="height: 40px;" 
onmouseover="mouseovercolor('user<s:property value="#user.index"/>');" onmouseout="mouseoutcolor('user<s:property value="#user.index"/>');">
<td style="border-bottom:1px solid #a8cde4"><s:property value="userName"/></td>
<td style="border-bottom:1px solid #a8cde4"><s:property value="realName"/></td>
<td style="border-bottom:1px solid #a8cde4"><s:property value="gender"/></td>
<td style="border-bottom:1px solid #a8cde4"><s:property value="deptName"/></td>
<td style="border-bottom:1px solid #a8cde4"><s:property value="roleName"/></td>
<td style="border-bottom:1px solid #a8cde4"><s:property value="phone"/></td>
<td style="border-bottom:1px solid #a8cde4">
<a href="userDetail.action?userNumber=<s:property value="userNumber"/>" target="_blank">查看</a>
</td>
</tr>
</s:iterator>
<tr bgcolor="#c1d9f3" height="30px">
<td colspan="8">
<s:form action="viewUser" method="post" theme="simple">
<table width="100%">
<tr>
<td style="border-bottom:1px solid #a8cde4"></td>
<td style="border-bottom:1px solid #a8cde4"></td>
<td style="border-bottom:1px solid #a8cde4"></td>
<td style="border-bottom:1px solid #a8cde4"></td>
<td style="border-bottom:1px solid #a8cde4"></td>
<td style="border-bottom:1px solid #a8cde4"></td>
<td style="border-bottom:1px solid #a8cde4"></td>
<td style="border-bottom:1px solid #a8cde4" align="right">
<s:select onchange="this.form.submit()" name="pageSpan" list="#{2:'2條/頁',5:'5條/頁',10:'10條/頁',15:'15條/頁',20:'20條/頁',25:'25條/頁'}"></s:select>
<s:property value="currentPage"/>/<s:property value="maxPage"/>
<s:if test="currentPage>1">
<a href="viewUser.action?currentPage=<s:property value="currentPage-1"/>&pageSpan=<s:property value='pageSpan'/>"" style="text-decoration: none;color:#0f4097;">上一頁</a>
</s:if>
<s:if test="currentPage<maxPage">
<a href="viewUser.action?currentPage=<s:property value="currentPage+1"/>&pageSpan=<s:property value='pageSpan'/>"" style="text-decoration: none;color:#0f4097;">下一頁</a>
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