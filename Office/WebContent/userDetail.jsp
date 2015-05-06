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

	position: absolute;
	visibility: hidden;
}

</style>
<script type="text/javascript">

function showtable(){

	var tab=document.getElementById("dcdetail");
	tab.style.visibility="visible";
		
}

</script>
</head>
<body>
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<table border="1" width="99%" cellpadding="0" cellspacing="0">
<caption style="text-align: center; font-size: 20px;background-color: #eff5fb; border-bottom:1px solid #154ba0;">
<s:property value="user.realName"/>的個人詳細基本訊息
</caption>
<tr height="40px">
<td style="width: 110px;border-bottom:1px solid #154ba0; ">用戶名:</td>
<td style="width: 170px;border-bottom:1px solid #154ba0; "><s:property value="user.userName"/></td>
<td style="width: 110px;border-bottom:1px solid #154ba0; ">真實姓名:</td>
<td style="width: 170px;border-bottom:1px solid #154ba0; "><s:property value="user.realName"/></td>
<td rowspan="5" valign="top" align="center">
<img id="pic" src="headpic/<s:property value="user.imgpath"/>" onload="changePic('pic');"/>

<br/>
<br/>
<s:submit value="更改頭像" onclick="showtable();" theme="simple"></s:submit>
</td>
</tr>
<tr height="40px">
<td>性別</td>
<td><s:property value="user.gender"/></td>
<td>生日</td>
<td><s:property value="user.birth"/></td>
</tr>
<tr height="40px">
<td>所屬部門:</td>
<td><s:property value="user.deptName"/></td>
<td>所屬組:</td>
<td><s:property value="user.groupName"/></td>
</tr>
<tr height="40px">
<td>職位</td>
<td><s:property value="user.roleName"/></td>
<td>電子信箱</td>
<td><s:property value="user.email"/></td>
</tr>
<tr height="40px">
<td>電話</td>
<td><s:property value="user.phone"/></td>
<td>基本薪資</td>
<td><s:property value="user.salary"/></td>
</tr>
<tr height="200px">
<td>個人簡歷</td>
<td colspan="4" valign="top">
<s:property value="user.experience"/>
</td>
</tr>
</table>
</div>
</div>


<table class="jd" id="dcdetail">
<tr>
<td>更改頭像</td>
<td>
<img id="closeimg" alt="" src="images/close2.gif" onclick="closetable();" onmouseover="" onmouseout="">
</td>
</tr>
<tr>
<td colspan="2">
<table class="jd" id="dcdetail" cellpadding="0" cellspacing="0" style="width: 500px;height: 200px;">
<tr>
<td>
請選擇頭像!!
</td>
</tr>
<tr>
<td>
<s:form action="changePic" theme="simple" method="post" enctype="multipart/form-data">
<s:hidden name="oldpic" value="%{user.imgpath}"></s:hidden>
<s:hidden name="userNumber" value="%{user.userNumber}"></s:hidden>
<s:hidden name="userName" value="%{user.userName}"></s:hidden>
<s:file name="pic"></s:file><br/>
<s:submit value="提交"></s:submit>
</s:form>
</td>
</tr>
</table>
</td>
</tr>
</table>

<script type="text/javascript">

var result="<s:property value="result"/>";

if(result!=""){
	alert(result);
}

</script>
</body>
</html>