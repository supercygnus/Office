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

function checkdoc(){

	
}


function changeDoc(){

	var type=document.getElementById("type").value;

	if(type==1){
			document.getElementById("second").style.visibility="hidden";
		}
	else{
			document.getElementById("second").style.visibility="visible";
		}
	
}



</script>
</head>
<body onload="updateTree('li4d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<s:form action="sendDoc2" theme="simple" method="post" onsubmit="return checkdoc();">
<table width="100%">
<tr height="40px">
<td>公文類型:</td>
<td><s:select name="type" id="type" list="#{'1':'一級批准','2':'二級批准'}" listKey="key" listValue="value" headerKey="-1" headerValue="請選擇" onchange="changeDoc();"></s:select></td>
</tr>
<tr height="40px">
<td>一級批准部門</td>
<td><s:checkboxlist name="firstList" id="firstList" list="deptList" listKey="deptNumber" listValue="deptName"></s:checkboxlist></td>
</tr>
<tr id="second" height="40px">
<td>二級批准部門</td>
<td><s:checkboxlist name="secondList" id="secondList" list="deptList" listKey="deptNumber" listValue="deptName"></s:checkboxlist></td>
</tr>
<tr height="40px">
<td>公文主題</td>
<td><s:textfield name="topic" id="topic"></s:textfield></td>
</tr>
<tr>
<td>公文內容</td>
<td><s:textarea name="content" id="content" cols="40"></s:textarea></td>
</tr>
<tr>
<td colspan="2" align="center">
<s:submit value="提 交"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;<s:reset value="取 消"></s:reset>
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