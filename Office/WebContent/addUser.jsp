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

String.prototype.trim=function(){
	return this.replace(/(^\s*)|(\s*$)/g, "");
};


var req;

function checkUnique(){

	var name=document.getElementById("name").value.trim();
	
	var uri="userUnique.action?name="+name;

	if(window.XMLHttpRequest)
		req=new XMLHttpRequest();
	else if(window.ActiveXObject)
		req=new ActiveXObject("Microsoft.XMLHTTP");

	if(name!=""){

		req.open("post",uri,true);
		req.onreadystatechange=handleCallbackUser;
		req.send(null);
		
		}
	
	
	
}


function handleCallbackUser(){

	
	if(req.readyState==4){
		if(req.status==200){
			
			var msg=req.responseText;
			alert(msg);
			if(msg.trim()=="notOK"){
				
				alert("該用戶名已被使用,請重新選擇");
				document.getElementById("name").value="";
				document.getElementById("name").focus();
				}
				
			}
		}
	
}


function handleCallbackGroup(){

	alert("call back");
	if(req.readyState==4){
		if(req.status==200){
			
			var msg=req.responseText;
			alert(msg);
			document.getElementById("groupL").innerHTML=msg;
				
			}
		}
	
}


function handleCallbackRole(){

	if(req.readyState==4){
		if(req.status==200){

			var msg=req.responseText;
			document.getElementById("roleL").innerHTML=msg;
				
			}
		}
	
	
}

function updateGroup(){

	alert("come in group");
	var dept=document.getElementById("dept").value.trim();

	var uri="groupList.action?dept="+dept;

	if(window.XMLHttpRequest)
		req=new XMLHttpRequest();
	else if(window.ActiveXObject)
		req=new ActiveXObject("Microsoft.XMLHTTP");
	
	req.open("post",uri,true);
	req.onreadystatechange=handleCallbackGroup;
	req.send(null);
	
}


function updateRole(){

	var group=document.getElementById("group").value.trim();

	var uri="roleList.action?group="+group;

	if(window.XMLHttpRequest)
		req=new XMLHttpRequest();
	else if(window.ActiveXObject)
		req=new ActiveXObject("Microsoft.XMLHTTP");
	
	req.open("post",uri,true);
	req.onreadystatechange=handleCallbackRole;
	req.send(null);

	
}


function checkAddUser(){

	var name=document.getElementById("name").value.trim();
	var namepat=/^[0-9a-zA-Z_]{1,10}$/;
	
	if(name==""){
		alert("用戶名不能為空");
		return false;
		}
	
	if(name.length>10){
		alert("帳號超過10個字元");
		return false;
		}

	if(!namepat.exec(name)){
		alert("帳號只能由數字字母與下線組成");
		return false;
		}
	
	var pwd1=document.getElementById("pwd1").value.trim();
	var pwd2=document.getElementById("pwd2").value.trim();

	if(pwd1==""){
		alert("密碼不能為空");
		return false;
		}
	if(pwd2==""){
		alert("確認密碼不能為空");
		return false;
		}


	var pwdpat=/^[0-9a-zA-Z_]{1,10}$/;

	if(!pwdpat.exec(pwd1)){
		alert("密碼只能由10位以內數字與英文字母組成");
		return false;
		}

	if(pwd1!=pwd2){
		alert("兩次密碼輸入不一致!!");
		return false;
		}

	var realname=document.getElementById("realName").value.trim();

	if(realname==""){
		alert("真實姓名不能為空");
		return false;
		}

	var birth=document.getElementById("birth").value.trim();
	var birthpat=/^[0-9]{4}-[0-9]{2}-[0-9]{2}$/;

	if(birth==""){
		alert("生日不能為空");
		return false;
		}


	if(!bithpat.exec(birth)){
		alert("生日格式不正確!!");
		return false;
		}

	var role=document.getElementById("role").value.trim();
	
	if(role==""){
		alert("請選擇角色!!");
		return false;
		}

	var email=document.getElementById("email").value.trim();
	var emailpat=/^[.-_a-zA-Z0-9]+@[-_a-zA-Z0-9]+\.[.a-zA-Z0-9]+$/;

	if(!emailpat.exec(email)){
		alert("E-Mail格式不正確!!");
		return false;
		}

	var tel=document.getElementById("tel").value.trim();
	var telpat=/^[0-9]{7,20}$/;

	if(!telpat.exec(tel)){
		alert("電話格式不正確!!");
		return false;
		}

	var salary=document.getElementById("salary").value.trim();
	var salarypat=/^[0-9]{1,5}[\.]?[0-9]{0,2}$/;

	if(!salarypat.exec(salary)){
		alert("薪水格式不正確!!");
		return false;
		}

	var jianli=document.getElementById("jianli").value.trim();
	

	if(jianli==""){
		alert("簡歷不能為空");
		return false;
		}
	
}

</script>
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
<s:form action="addUser2" theme="simple" method="post" onsubmit="return checkAddUser();" enctype="multipart/form-data">
<table cellpadding="0" cellspacing="0" width="100%">
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">用戶名:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:textfield name="name" id="name" onblur="checkUnique();" value="s001"></s:textfield></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">由字母或數字組成</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">密碼:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:password name="pwd1" id="pwd1" value="123"></s:password></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">由字母或數字組成</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">再次輸入密碼:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:password name="pwd2" id="pwd2" value="123"></s:password></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">由字母或數字組成</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">真實姓名:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:textfield name="realName" id="realName" value="邱岳溢"></s:textfield></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; "></td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">性別:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:select name="gender" id="gender" list="#{'男':'男','女':'女'}" listKey="key" listValue="value"></s:select></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">選擇性別</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">出生日期:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:textfield name="birth" id="birth" value="1988-01-14"></s:textfield></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">格式為YYYY-MM-DD</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">所屬部門:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:select name="dept" id="dept" list="deptList" listKey="deptNumber" listValue="deptName" onchange="updateGroup();"></s:select></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">必填</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">所屬組:</td>
<td id="groupL" style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:select name="group" id="group" list="groupList" listKey="groupNumber" listValue="groupName" onchange="updateRole();"></s:select></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">必填</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">職位角色:</td>
<td id="roleL" style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:select name="role" id="role" list="roleList" listKey="roleNumber" listValue="roleName"></s:select></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; "></td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">電子信箱:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:textfield name="email" id="email" value="yueyiqiu100@gmail.com"></s:textfield></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">Email</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">電話:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:textfield name="tel" id="tel" value="0932528459"></s:textfield></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">最常用的電話</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">基本工資:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:textfield name="salary" id="salary" value="50000"></s:textfield></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">必填</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">上傳頭像:</td>
<td style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:file name="headPic" id="headPic" cssStyle="width:210px;"></s:file></td>
<td style="width: 400px;border-bottom:#a8cde4 solid 1px; ">選填</td>
</tr>
<tr height="40px">
<td align="right" style="width:120px; border-bottom:#a8cde4 solid 1px;">個人簡歷:</td>
<td colspan="2" style="width: 230px;border-bottom:#a8cde4 solid 1px; "><s:textarea name="jianli" id="jianli" cssStyle="width:610px;height:250px;" value="哈囉,你好嗎??"></s:textarea></td>

</tr>
<tr>
<td colspan="3" align="center">
<s:submit value="提交"></s:submit>&nbsp;&nbsp;&nbsp;<s:reset value="取消"></s:reset>
</td>
</tr>
</table>
</s:form>
</div>
</div>
</body>
</html>