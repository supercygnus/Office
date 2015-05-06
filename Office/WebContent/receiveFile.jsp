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





function checkall(form){

	alert(document.getElementById("allcheck").checked);
	
	if(document.getElementById("allcheck").checked==true){
		
		for(var i=0;i<form.elements.length;i++){

			var e=form.elements[i];

			alert(e.name);
			
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
<body onload="updateTree('li1d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<div align="center" style="font-size: 19px; background-color:#A1C7EF;">接收文件</div>
<s:form action="delTransFile" theme="simple" method="post" id="delform">
<table cellpadding="0" cellspacing="0" align="center" width="100%">
<tr style="background-color:#c1d9f3;height: 40px ">
<th style="border-bottom: 2px solid #154ba0;">&nbsp;&nbsp;&nbsp;
<s:checkbox name="allcheck" id="allcheck" onclick="checkall(this.form);"></s:checkbox>
</th>
<th style="border-bottom: 2px solid #154ba0;">發送人</th>
<th style="border-bottom: 2px solid #154ba0;">消息主題</th>
<th style="border-bottom: 2px solid #154ba0;">時間</th>
<th style="border-bottom: 2px solid #154ba0;">文件</th>
</tr>
<s:iterator value="myFileList" status="file">
<s:set var="name" value="fileName"></s:set>
<tr id="file<s:property value="#file.index"/>" style="height: 40px;" 
onmouseover="mouseovercolor('file<s:property value="#file.index"/>');" onmouseout="mouseoutcolor('file<s:property value="#file.index"/>');">
<td style="border-bottom:1px solid #a8cde4;">
&nbsp;&nbsp;&nbsp;
<s:checkboxlist id="delList" name="delList" list="#file" listKey="fileName" listValue="''"></s:checkboxlist>
<!--<s:checkbox id="delList" name="delList" fieldValue="#name"></s:checkbox>-->
</td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="fileUserRealName"/></td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="fileInfo"/></td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="timeStr"/></td>
<td style="border-bottom:1px solid #a8cde4;"><a href="loadFile.action?fileNumber=<s:property value="fileNumber"/>"><img title="點擊下載" src="images/download.gif">&nbsp;<s:property value="fileRealName"/></a></td>
</tr>
</s:iterator>

</s:form>
<tr>
<td colspan="5">
<s:form action="receiveFile" theme="simple" method="post">
<table width="100%">
<tr  style="background-color:#c1d9f3;height: 23px ">
<td><s:submit onclick="document.getElementById('delform').submit(); return false;" value="刪除"></s:submit>

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<s:select onchange="this.form.submit()" name="pageSpan" list="#{2:'2條/頁',5:'5條/頁',10:'10條/頁',15:'15條/頁',20:'20條/頁',25:'25條/頁'}" ></s:select>
<s:property value="currentPage"/>/<s:property value="maxPage"/>
<s:if test="currentPage>1">
<a href="receiveFile.action?currentPage=<s:property value='currentPage-1'/>&pageSpan=<s:property value='pageSpan'/>" style="text-decoration:none; color:#0f4097;">上一頁</a>
</s:if>
<s:if test="currentPage<maxPage">
<a href="receiveFile.action?currentPage=<s:property value='currentPage+1'/>&pageSpan=<s:property value='pageSpan'/>" style="text-decoration:none; color:#0f4097;">下一頁</a>
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