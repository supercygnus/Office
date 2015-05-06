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
<style type="text/css">

.jd{

	visibility: hidden;
	position: absolute;
	
}

.Blur{

	filter: Alpha(opacity=20);
				  -moz-opacity:0.2;
				  opacity:0.2;

}


.NoBlur{

	
}

</style>
<script type="text/javascript">

function showtable(){

	var tab=document.getElementById("dcdetail");
	//alert(tab);
	var pos=getElementPos("maincontent");
	//alert(pos.x);
	//alert(pos.y);
	
	var y=pos.y+100;
	var x=pos.x+100;
	//alert(x);
	//alert(y);
	tab.style.top=y+"px";
	tab.style.left=x+"px";
	//tab.style.top="40px";
	//tab.style.left="40px";
	tab.style.visibility="visible";
	document.getElementById("maincontent").className="Blur";
}

function closetable()
{
	var tab=document.getElementById("dcdetail");
	tab.style.visibility="hidden";
	document.getElementById("maincontent").className="NoBlur";
}


</script>
</head>
<body onload="updateTree('li9d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<table>
<tr>
<td rowspan="3"><img alt="" src="images/png-0571.png"></td>
<td>上班考勤時間</td>
<td>
<s:property value="startTime"/>
</td>
</tr>
<tr>
<td>下班考勤時間</td>
<td>
<s:property value="endTime"/>
</td>

</tr>
<tr>
<td colspan="2">
<input type="button" value="修改" onclick="showtable();"/>
</td>
</tr>
</table>
</div>
</div>


<table id="dcdetail" class="jd" cellpadding="0" cellspacing="0" style="border: 6px solid #a8cde4;width: 400px.;height:130px;font-size: 14px;color:#154ba0;background-color:#eff5fb;">
<tr height="20px" bgcolor="#a8cde4">
<td>修改考勤時間</td>
<td><img id="closeimg" alt="" src="images/close2.gif" onclick="closetable();"></td>
</tr>
<s:form action="changeAtt" method="post" theme="simple">
<tr>
<td colspan="2">
上班考勤時間:<s:select name="startHour" list="hourList" headerKey="-1" headerValue="請選擇"/>&nbsp;時&nbsp;<s:select name="startMin" list="minList" headerKey="-1" headerValue="請選擇"/>&nbsp;分
</td>
</tr>
<tr>
<td colspan="2">
下班考勤時間:<s:select name="endHour" list="hourList" headerKey="-1" headerValue="請選擇"/>&nbsp;時&nbsp;<s:select name="endMin" list="minList" headerKey="-1" headerValue="請選擇"/>&nbsp;分
</td>
</tr>
<tr>
<td colspan="2">
<s:submit value="確定"></s:submit>&nbsp;&nbsp;&nbsp;<s:reset value="取消"></s:reset>
</td>
</tr>
</s:form>
</table>
</body>
</html>