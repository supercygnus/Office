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

String.prototype.trim = function()
{
  return this.replace(/(^\s*)|(\s*$)/g, "");
}

function checkall(form){

	alert(document.getElementById("allcheck").checked);
	
	if(document.getElementById("allcheck").checked==true){
		
		for(var i=0;i<form.elements.length;i++){

			var e=form.elements[i];

			
			
			if(e.name=="delList"){
				
				e.checked=true;
				}
			
			}
		}
	else{
		
		for(var i=0;i<form.elements.length;i++){

			var e=form.elements[i];

			
			if(e.name=="delList"){
				e.checked=false;

		}
}
	}
	
alert("OK");
	
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
<s:form action="delMsg" theme="simple" method="post" id="delform">
<table cellpadding="0" cellspacing="0" align="center" width="100%">
<tr style="background-color:#c1d9f3;height: 40px ">
<th style="border-bottom: 2px solid #154ba0;">&nbsp;
<s:checkbox name="allcheck" id="allcheck" onclick="checkall(this.form);"></s:checkbox>
</th>
<th style="border-bottom: 2px solid #154ba0;">發送人</th>
<th style="border-bottom: 2px solid #154ba0;">消息主題</th>
<th style="border-bottom: 2px solid #154ba0;">時間</th>
<th style="border-bottom: 2px solid #154ba0;">查看</th>
</tr>
<s:iterator value="messageList" status="msg">
<tr id="msg<s:property value="#msg.index"/>" style="height: 40px;" 
onmouseover="mouseovercolor('msg<s:property value="#msg.index"/>');" onmouseout="mouseoutcolor('msg<s:property value="#msg.index"/>');">
<td style="border-bottom:1px solid #a8cde4;">
&nbsp;&nbsp;&nbsp;<s:checkboxlist id="delList" name="delList" list="#msg" listKey="msgNumber" listValue="''"></s:checkboxlist>
</td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="fromUserName"/></td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="msgInfo"/></td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="msgTimeStr"/></td>
<td style="border-bottom:1px solid #a8cde4;"><a href="msgDetail.action?msgNumber=<s:property value="msgNumber"/>"><img alt="點擊查看詳細訊息" src="images/download.gif">&nbsp;查看</a></td>
</tr>
</s:iterator>
</s:form>
<tr>
<td colspan="5">
<s:form action="receiveMessage" theme="simple" method="post">
<table width="100%">
<tr>
<td><s:submit onclick="document.getElementById('delform').submit(); return false;" value="刪除"></s:submit></td>

<td>
<s:select onchange="this.form.submit()" name="pageSpan" list="#{2:'2條/頁',5:'5條/頁',10:'10條/頁',15:'15條/頁',20:'20條/頁',25:'25條/頁'}" ></s:select>
<s:property value="currentPage"/>/<s:property value="maxPage"/>
<s:if test="currentPage>1">
<a href="receiveMessage.action?currentPage=<s:property value='currentPage-1'/>&pageSpan=<s:property value='pageSpan'/>" style="text-decoration:none; color:#0f4097;">上一頁</a>
</s:if>
<s:if test="currentPage<maxPage">
<a href="receiveMessage.action?currentPage=<s:property value='currentPage+1'/>&pageSpan=<s:property value='pageSpan'/>" style="text-decoration:none; color:#0f4097;">下一頁</a>
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