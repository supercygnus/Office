<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

function checkalarm(){

	
}

</script>
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
<s:form action="sendAlarm2" method="post" theme="simple" onsubmit="return checkalarm();">
<table width="100%" cellpadding="0" cellspacing="0">
<tr height="40px">
<td>主題</td>
<td><s:textfield name="title" id="title"></s:textfield></td>
</tr>
<tr height="40px">
<td>報警部門</td>
<td><s:select list="deptList" id="dept" name="dept" listValue="deptName" listKey="deptNumber"></s:select></td>
</tr>
<tr>
<td>詳細訊息</td>
<td><s:textarea name="detail" id="detail" cssStyle="width:500px;height:300px;" ></s:textarea></td>
</tr>
<tr>
<td colspan="2" align="center"><s:submit value="提交"></s:submit>&nbsp;&nbsp;&nbsp;<s:reset value="取消"></s:reset>
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