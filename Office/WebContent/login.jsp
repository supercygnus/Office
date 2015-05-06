<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link type="text/css" href="css/login.css" rel="stylesheet"/>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/position.js"></script>
<script type="text/javascript">

function showErrMsg(msg,id){
	
	
	var fromObj=getElementPos(id);
	var y=fromObj.y+fromObj.h-1;
	var x=fromObj.x+fromObj.w/2;
	
	var messagetable=document.getElementById("myerr");
	messagetable.style.left=fromObj.x+80+"px";
	messagetable.style.top=fromObj.y+"px";
		
	var messagearea=document.getElementById("myerrs");
	messagearea.innerHTML=msg;
	messagetable.style.visibility="visible";
	
	var up=document.getElementById("myup");
	up.style.left=x+200+"px";
	up.style.top=y+"px";
	//up.style.visibility="visible";
	
	setTimeout('hidden()',1000);
	
}


function hidden(){

	var table=document.getElementById("myerr");
	

	table.style.visibility="hidden";
	
}


function getElementPos(id){
	
	var ua=navigator.userAgent.toLowerCase();
	var el=document.getElementById(id);
	
	if(el.parentNode==null||el.style.display=="hidden"){
		return false;
	}
	
	var box;
	
	if(el.getBoundingClientRect){
		box=el.getBoundingClientRect();
		var scrollTop = Math.max(document.documentElement.scrollTop, document.body.scrollTop); 
        var scrollLeft = Math.max(document.documentElement.scrollLeft, document.body.scrollLeft); 
        return {x:box.left+ scrollLeft, y:box.top + scrollTop,w:box.right-box.left,h:box.bottom-box.top};    
	}
	
	return false;
	
}

function hideError(){

	var table=document.getElementById("myerr");
	var up=document.getElementById("myup");

	table.style.visibility="hidden";
	up.style.visibility="hidden";
}


</script>
</head>
<body>
<div id="container">
<div id="topimage">
<img alt="" src="images/login_main.jpg">
</div>
<div id="loginmain">
<s:form action="login" theme="simple" method="post" onsubmit="return check();">
<table border="1" cellpadding="0" cellspacing="0" align="center">
<tr>
<td>用戶名</td>
<td><s:textfield name="uid" id="uid" value="tom"></s:textfield></td>
</tr>
<tr>
<td>密碼</td>
<td><s:password name="pwd" id="pwd" value="123"></s:password></td>
</tr>
<tr>
<td>驗證碼</td>
<td><s:textfield name="verifycode" id="verifycode"></s:textfield>
<a href="" onclick="change()"><img alt="點擊換一張" src="verifycode.jsp" id="ipic" height="25"></a>
<a href="" onclick="change()">換一張</a>
</td>
</tr>
<tr>
<td colspan="2" align="center">
<s:submit value="登錄" id="submit"></s:submit>&nbsp;
<s:reset value="重設"></s:reset>
</td>
</tr>
</table>
<s:textfield name="result" id="result"  cssStyle="display:none;"></s:textfield>
</s:form>
</div>
</div>

<table id="myerr" style="background-color: red;width: 120px" height="30px" class="jd" onclick="hideErr();">
<tr bordercolor="red">
<td id="myerrs" align="left"></td>
</tr>
</table>


<img class="jd" id="myup" src="images/up.gif" onclick="hideError()" style="z-index: 1;">


<script type="text/javascript">

var ptr=document.getElementById("result").value;

if(ptr!=""){
	
	showErrMsg(ptr,"ipic");
}

</script>

</body>
</html>