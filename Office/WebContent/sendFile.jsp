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

String.prototype.trim=function(){
	return this.replace(/(^\s*)|(\s*$)/g,"");
}


var req;

function checksend(){

	
	
}


function getUserList(){

	var deptNumber=document.getElementById("deptlist").value;
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

	if(req.readyState==4){
		if(req.status==200){

			var msg=req.responseText;
			msg=unescape(msg);
			document.getElementById("userlist").innerHTML=msg;
				
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

	var area=document.getElementById("touser");
	var touser=area.value.trim();
	var array=touser.split(";");
	
	for(var i=0;i<array.length;i++){
		if(array[i].trim()==user.trim()){
			return}
		}

		if(touser!=""){
			touser=touser+" ";
			}


		touser=touser+user.trim()+";";
		area.value=touser;
}

</script>
</head>
<body onload="updateTree('li1d');">
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
<td valign="top">
<s:form action="sendFile2" onsubmit="return checksend();" theme="simple" method="post" enctype="multipart/form-data">
<table style="width: 500px;text-align: left;" >
<tr>
<td></td>
<td>發送文件</td>
<td>發件人:<s:property value="fromUser"/></td>
</tr>
<tr>
<td>簡要主題</td>
<td colspan="2"><s:textfield name="info" id="info"></s:textfield></td>

</tr>
<tr>
<td>選擇文件</td>
<td colspan="2"><s:file name="myFile" id="myFile"></s:file></td>

</tr>
<tr>
<td>收件人列表</td>
<td colspan="2"><s:textarea name="touser" id="touser" theme="simple" cols="20" wrap="virtual"></s:textarea></td>

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
<table width="220px" align="center" style="margin: 0 auto;">
<tr>
<td>
部門:<s:select id="deptlist" list="deptList" listKey="deptNumber" listValue="deptName" theme="simple" onchange="getUserList()"></s:select>
</td>
</tr>
<tr>
<td>
<div id="userlist" style="width200px; border:2px outset #a8cde4; "></div>
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