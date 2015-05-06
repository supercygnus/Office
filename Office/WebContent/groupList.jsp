<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:select name="group" id="group" list="groupList" listKey="groupNumber" listValue="groupName" onchange="updateRole();"></s:select>
