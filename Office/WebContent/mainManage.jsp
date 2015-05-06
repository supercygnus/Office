<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>

<link href="css/mainstyle.css" type="text/css" rel="stylesheet"/>
<link href="css/style.css" type="text/css" rel="stylesheet"/>
<link href="css/dashboard.css" type="text/css" rel="stylesheet"/>

<script type="text/javascript">

function changepic_alerm(picid){
	
	var obj=document.getElementById(picid);
	var strarray=new Array();
	var picsrc=obj.src;
	strarray=picsrc.split("/");
	var size=strarray.length;
	if(strarray[size-1]=="light.png"){
		obj.src="images/dashboard/weight.png";
		}
	else{
		obj.src="images/dashboard/light.png";
		}

	setTimeout("changepic_alerm('"+picid+"')",500);
}

</script>
</head>
<body>
<div id="container">
<div id="tophead"><s:action name="top" executeResult="true"></s:action></div>

<div id="leftcontent"><s:action name="leftTree" executeResult="true"></s:action></div>
<div id="maincontent">
<s:if test="right==3">
<table>
<tr>
<td>
<a href="viewAlarm.action?deptNumber=10000"><img alt="" src="images/dashboard/ok.png" id="president">總經理</a>
</td>
<td>
<a href="viewAlarm.action?deptNumber=10004"><img alt="" src="images/dashboard/ok.png" id="finance">財務部</a>
</td>
<td>
<a href="viewAlarm.action?deptNumber=10003"><img alt="" src="images/dashboard/ok.png" id="publicrelation">公關部</a>
</td>
</tr>
<tr>
<td colspan="3" bgcolor="#f7f7f7">
</td>
</tr>
<tr>
<td>
<a href="viewAlarm.action?deptNumber=10002"><img alt="" src="images/dashboard/ok.png" id="technology">技術部</a>
</td>
<td>
<a href="viewAlarm.action?deptNumber=10001"><img alt="" src="images/dashboard/ok.png" id="marketing">市場部</a>
</td>
<td>
<a href="viewAlarm.action?deptNumber=10005"><img alt="" src="images/dashboard/ok.png" id="logistic">後勤部</a>
</td>
</tr>
</table>
</s:if>
<s:else>
<table>
<tr>
<td style="width:33%">
<table>
<tr>
<td><img alt="" src="images/dashboard/zongjingli.png"/></td>
<td>總經理室</td>
</tr>
<tr>
<td>負責管理公司重大任務</td>
</tr>
</table>
</td>
<td style="width:33%">
<table>
<tr>
<td>
<img alt="" src="images/dashboard/caiwubu.png">
</td>
<td>
財務部
</td>
</tr>
<tr>
<td>
負責公司財務部分
</td>
</tr>
</table>
</td>
<td style="width: 34%">
<table>
<tr>
<td>
<img alt="" src="images/dashboard/gongguan.png">
</td>
<td>
公關部
</td>
</tr>
<tr>
<td>
負責公關部分
</td>
</tr>
</table>
</td>
</tr>
<tr>
<td colspan="3" bgcolor="#f7f7f7"></td>
</tr>
<tr>
<td style="width:33%;">
<table>
<tr>
<td>
<img alt="" src="images/dashboard/jishu.png">
</td>
<td>
技術部
</td>
</tr>
<tr>
<td>
負責公司技術部分
</td>
</tr>
</table>
</td>
<td style="width:33%;">
<table>
<tr>
<td>
<img alt="" src="images/dashboard/shichangbu.png">
</td>
<td>
市場部
</td>
</tr>
<tr>
<td>
負責開拓市場
</td>
</tr>
</table>
</td>
<td style="width:33%;">
<table>
<tr>
<td>
<img alt="" src="images/dashboard/houqin.png">
</td>
<td>
後勤部
</td>
</tr>
<tr>
<td>
負責支援公司
</td>
</tr>
</table>
</td>
</tr>
</table>
</s:else>
</div>
</div>


<script type="text/javascript">
var president=<s:property value="president"/>
var marketing=<s:property value="marketing"/>
var technology=<s:property value="technology"/>
var publicrelation=<s:property value="publicrelation"/>
var finance=<s:property value="finance"/>
var logistic=<s:property value="logistic"/>


if(president!=0){
	changepic_alerm("president");
}
if(marketing!=0){
	changepic_alerm("marketing");
}
if(technology!=0){
	
	changepic_alerm("technology");
}
if(publicrelation!=0){
	changepic_alerm("publicrelation");
}
if(finance!=0){
	changepic_alerm("finance");
}

if(logistic!=0){
	changepic_alerm("logistic");
}

</script>
<script type="text/javascript">
	
</script>
</body>
</html>