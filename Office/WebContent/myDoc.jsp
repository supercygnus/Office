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
<script type="text/javascript" src="js/position.js"></script>
</head>
<body onload="updateTree('li4d')">
<div id="container">
<div id="tophead">
<s:action name="top" executeResult="true"></s:action>
</div>
<div id="leftcontent">
<s:action name="leftTree" executeResult="true"></s:action>
</div>
<div id="maincontent">
<table cellpadding="0" cellspacing="0" align="center" width="100%">
<tr style="background-color:#c1d9f3;height: 40px ">
<th style="border-bottom: 2px solid #154ba0;">公文發送者</th>
<th style="border-bottom: 2px solid #154ba0;">所屬部門</th>
<th style="border-bottom: 2px solid #154ba0;">主題</th>
<th style="border-bottom: 2px solid #154ba0;">發送時間</th>
<th style="border-bottom: 2px solid #154ba0;">進度</th>

</tr>
<s:iterator value="docList" status="doc">
<tr id="doc<s:property value="#doc.index"/>" style="height: 40px;" 
onmouseover="mouseovercolor('doc<s:property value="#doc.index"/>');" onmouseout="mouseoutcolor('doc<s:property value="#doc.index"/>');">
<td style="border-bottom:1px solid #a8cde4;"><s:property value="fromUserName"/></td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="deptName"/></td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="title"/></td>
<td style="border-bottom:1px solid #a8cde4;"><s:property value="docTime"/></td>
<td style="border-bottom:1px solid #a8cde4;">
<a href="docPro.action?docNum=<s:property value="docNumber"/>">查看</a>
</td>
</tr>
</s:iterator>
<tr>
<td colspan="6">
<s:form action="myDoc" theme="simple" method="post">
<table width="100%">
<tr style="background-color:#c1d9f3;height: 23px ">
<td align="right">
<s:select onchange="this.form.submit()" name="pageSpan" list="#{2:'2條/頁',5:'5條/頁',10:'10條/頁',15:'15條/頁',20:'20條/頁',25:'25條/頁'}"></s:select>
<s:property value="currentPage"/>/<s:property value="maxPage"/>
<s:if test="currentPage>1">
<a href="myDoc.action?currentPage=<s:property value="currentPage-1"/>&pageSpan=<s:property value='pageSpan'/>">上一頁</a>
</s:if>
<s:if test="currentPage<maxPage">
<a href="myDoc.action?currentPage=<s:property value="currentPage+1"/>&pageSpan=<s:property value='pageSpan'/>">下一頁</a>
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