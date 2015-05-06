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

function checkUpload(){

	
}

</script>
</head>
<body onload="updateTree('li2d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<div align="center" style="font-size: 19px; background-color:#A1C7EF;">上傳共享</div>
<s:form action="uploadShare2" onsubmit="return checkUpload();" theme="simple" enctype="multipart/form-data">
<table width="100%">
<tr>
<td rowspan="5" style="width: 70px;" align="center"><img alt="" src="images/share.jpg"></td>
</tr>
<tr>
<td colspan="2" align="right">文件類別</td>
<td><s:select list="typeList" name="type" listValue="typeName" listKey="typeNumber"></s:select></td>

</tr>
<tr>
<td colspan="2" align="right">文件標題</td>
<td><s:textfield name="title" id="title"></s:textfield></td>

</tr>
<tr>
<td colspan="2" align="right">選擇文件</td>
<td><s:file name="shareFile" id="shareFile"></s:file></td>
</tr>
<tr>
<td colspan="2" align="right">文件詳情</td>
<td><s:textarea name="info" id="info" cols="30"></s:textarea></td>
</tr>
<tr>
<td colspan="4" align="center">
<s:submit value="上傳"></s:submit>&nbsp;&nbsp;<s:reset value="取消"></s:reset>
</td>

</tr>
</table>
</s:form>
</div>
</div>
</body>
</html>