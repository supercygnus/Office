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




var req;

function checksend(){

	
	
}


function getUserList(){
	alert("Go!!");
	var deptNumber=document.getElementById("deptlist").value;
	alert(deptNumber);
	if(deptNumber!=""){
		var uri="userListAction.action?deptNumber="+deptNumber;

		if(window.XMLHttpRequest)
			req=new XMLHttpRequest();
		else if(window.ActiveXObject)
			req=new ActiveXObject("Microsoft.XMLHTTP");

		req.open("post",uri,true);
		req.onreadystatechange=handleResponse;
		req.send(null);
		
		}
}



function handleResponse(){

	alert("OK!!");
	alert("readyState="+req.readyState+" status="+req.status);
	if(req.readyState==4){
		alert("inner");
		if(req.status==200){
			alert("fine!!");
			var msg=req.responseText;
			msg=unescape(msg);
			document.getElementById("userlist").innerHTML=msg;
			//alert("fine!!");
			}
		}
	
}


function mouseovercolor(id){
	document.getElementById(id).className="mouseover";
}


function mouseoutcolor(id){
	document.getElementById(id).className="mouseout";
}


function add(user){

	var receiver=document.getElementById("receiver");
	receiver.value=user;
	
}

</script>
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

<table width="100%" bgcolor="#eff5fb">
<tr>
<td valign="top" style="border-right:solid 3px black;">
<s:form action="sendMessage2" onsubmit="return checksend()" theme="simple" method="post" enctype="multipart/form-data">
<table width="500px">
<tr>
<td></td>
<td align="left">發送消息</td>
<td align="right">發件人:<s:property value="fromUser"/></td>
</tr>
<tr>
<td align="right">接收人</td>
<td colspan="2"><s:textfield name="receiver" id="receiver" onkeydown="return false;"></s:textfield></td>

</tr>
<tr>
<td align="right">簡要主題</td>
<td colspan="2"><s:textfield name="info" id="info"></s:textfield></td>

</tr>
<tr>
<td align="right">消息內容</td>
<td colspan="2"><s:textarea name="content" id="content" theme="simple" wrap="virtual" cols="20" cssStyle="width:420px;height:200px;"></s:textarea></td>

</tr>

<tr>
<td></td>
<td><s:submit value="發送"></s:submit>&nbsp;&nbsp;&nbsp;&nbsp;
<s:reset value="取消"></s:reset>
</td>
<td></td>
</tr>
</table>
</s:form>
</td>
<td valign="top">
<table width="220px">
<tr>
<td>
部門:<s:select id="deptlist" list="deptList" listKey="deptNumber" listValue="deptName" theme="simple" onchange="getUserList()"></s:select>
</td>
</tr>
<tr>
<td>
<div id="userlist"></div>
</td>
</tr>
</table>
</td>
</tr>
</table>

</div>
</div>
<div id="divdown" style="display:none;width:300px;height:20px;position:absolute;">
<table>
<tr>
<td><img alt="" src="images/ico_loading.gif"></td>
<td></td>
<td>&nbsp;&nbsp;&nbsp;&nbsp;正在發送,請稍後.....</td>
</tr>
</table>
</div>
</body>
</html>