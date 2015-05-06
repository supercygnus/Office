<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<link href="css/treestyle.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript">

function changetree(id){

	for(var i=1;i<10;i++){

		if(id!="li"+i){

			}
		else{

			var opdiv=document.getElementById(id+"d")
			var displayvalue=opdiv.style.display;

			if(displayvalue=="none"){
				opdiv.style.display="block";
				}
			else{
				opdiv.style.display="none";
				}
			
			}
			
		}
	
}

</script>
</head>
<body>

<div id="lefttree">
<ul>
<li id="li1"><a href="#" onclick="changetree('li1')" class="a">文件管理</a></li>
<div id="li1d" style="display: none;">
<a href="receiveFile.action"><img alt="" src="images/left/001.gif" onmousedown="" onmouseover="" onmouseout=""><br/>接收文件</a><br/>
<a href="sendFile.action"><img alt="" src="images/left/002.gif" onmousedown="" onmouseover="" onmouseout=""><br/>發送文件</a>
</div>
<li id="li2"><a href="#" onclick="changetree('li2')" class="a">企業共享</a></li>
<div id="li2d" style="display: none;">
<a href="viewShare.action"><img alt="" src="images/left/003.gif" onmousedown="" onmouseover="" onmouseout=""><br/>查看共享</a><br/>
<a href="uploadShare.action"><img alt="" src="images/left/004.gif" onmousedown="" onmouseover="" onmouseout=""><br/>上傳共享</a><br/>
<s:if test="right==3">
<a href="manageShare.action"><img alt="" src="images/left/005.gif" onmousedown="" onmouseover="" onmouseout=""><br/>管理共享</a><br/>
</s:if>
</div>
<li id="li3"><a href="#" onclick="changetree('li3')" class="a">消息管理</a></li>
<div id="li3d" style="display: none;">
<a href="receiveMessage.action"><img alt="" src="images/left/006.gif" onmousedown="" onmouseover="" onmouseout=""><br/>接收消息</a><br/>
<a href="sendMessage.action"><img alt="" src="images/left/007.gif" onmousedown="" onmouseover="" onmouseout=""><br/>發送消息</a><br/>
</div>
<li id="li4"><a href="#" onclick="changetree('li4')" class="a">申請簽核</a></li>
<div id="li4d" style="display: none;">
<s:if test="right==3">
<a href="viewDoc.action"><img alt="" src="images/left/009.gif" onmousedown="" onmouseover="" onmouseout=""><br/>待批申請</a><br/>
<a href="sendDoc.action"><img alt="" src="images/left/010.gif" onmousedown="" onmouseover="" onmouseout=""><br/>發送申請</a><br/>
<a href="allDoc.action"><img alt="" src="images/left/011.gif" onmousedown="" onmouseover="" onmouseout=""><br/>所有申請</a><br/>
<a href="myDoc.action"><img alt="" src="images/left/012.gif" onmousedown="" onmouseover="" onmouseout=""><br/>我的申請</a><br/>
</s:if>
<s:else>
<s:if test="right==2">
<a href="viewDoc.action"><img alt="" src="images/left/009.gif" onmousedown="" onmouseover="" onmouseout=""><br/>待批申請</a><br/>
<a href="sendDoc.action"><img alt="" src="images/left/010.gif" onmousedown="" onmouseover="" onmouseout=""><br/>發送申請</a><br/>
<a href="myDoc.action"><img alt="" src="images/left/012.gif" onmousedown="" onmouseover="" onmouseout=""><br/>我的申請</a><br/>
</s:if>
<s:else>
<a href="sendDoc.action"><img alt="" src="images/left/010.gif" onmousedown="" onmouseover="" onmouseout=""><br/>發送申請</a><br/>
<a href="myDoc.action"><img alt="" src="images/left/012.gif" onmousedown="" onmouseover="" onmouseout=""><br/>我的申請</a><br/>

</s:else>
</s:else>
</div>
<li id="li9"><a href="#" onclick="changetree('li9')" class="a">考勤管理</a></li>
<div id="li9d" style="display: none;">
<s:if test="right==3">
<a href="attTime.action"><img alt="" src="images/left/008.gif" onmousedown="" onmouseover="" onmouseout=""><br/>考勤時間</a><br/>
<a href="viewAtt.action"><img alt="" src="images/left/013.gif" onmousedown="" onmouseover="" onmouseout=""><br/>考勤查詢</a><br/>
</s:if>
<a href="attOnline.action"><img alt="" src="images/left/012.gif" onmousedown="" onmouseover="" onmouseout=""><br/>在線考勤</a><br/>
</div>
<s:if test="right==3">
<li id="li5"><a href="#" onclick="changetree('li5')" class="a">人力資源</a></li>
<div id="li5d" style="display: none;">
<a href="addUser.action"><img alt="" src="images/left/014.gif" onmousedown="" onmouseover="" onmouseout=""><br/>添加員工</a><br/>
<a href="viewUser.action"><img alt="" src="images/left/015.gif" onmousedown="" onmouseover="" onmouseout=""><br/>員工管理</a><br/>
</div>
</s:if>
<li id="li6"><a href="#" onclick="changetree('li6')" class="a">電子郵件</a></li>
<div id="li6d" style="display: none;">
<a href="sendEmail.jsp"><img alt="" src="images/left/016.gif" onmousedown="" onmouseover="" onmouseout=""><br/>發送郵件</a><br/>
</div>
<li id="li8"><a href="#" onclick="changetree('li8')" class="a">緊急事務</a></li>
<div id="li8d" style="display: none;">
<a href="sendAlarm.action"><img alt="" src="images/left/010.gif" onmousedown="" onmouseover="" onmouseout=""><br/>緊急報警</a><br/>
<s:if test="right==3">
<a href="viewAlarm.action"><img alt="" src="images/left/011.gif" onmousedown="" onmouseover="" onmouseout=""><br/>查看報警</a><br/>
</s:if>
</div>
<li id="li7"><a href="#" onclick="changetree('li7')" class="a">系統管理</a></li>
<div id="li7d" style="display: none;">
<a href="changePwd.jsp"><img alt="" src="images/left/017.gif" onmousedown="" onmouseover="" onmouseout=""><br/>修改密碼</a><br/>
</div>
</ul>
</div>
<div id="marq">
<marquee onmouseover="this.stop()" onmouseout="this.start()" >
<center>
<s:if test="right==3">
</s:if>
<s:else>
<s:if test="right==2">
</s:if>
<s:else></s:else>
</s:else>
</center>
</marquee>
</div>
</body>
</html>