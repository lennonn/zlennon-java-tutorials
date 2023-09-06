<%@ page import="com.opensymphony.xwork2.ActionContext" %>
<%@ page import="org.apache.struts2.dispatcher.HttpParameters" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    HttpParameters parameters = ActionContext.getContext().getParameters();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">你请求的页面找不到了！</h1>
<div style="background-image :url(<%=basePath%>images/error.jpg)"></div>

<h1>Oops! Something went wrong.</h1>
<p><s:property value="%{#parameters.statusCode'}"/></p>
<p><s:property value="#request.interceptor"/></p>
<p>
<%--
<s:set name="params" value="%{#parameters}" />
--%>

<s:iterator value="%{#parameters}" var="entry">
    <p>${entry.key}: ${entry.value}</p>
</s:iterator>
</p>

<%=parameters.get("statusCode")%>
<%=parameters.get("excludeParams")%>
<h1>Error: ${excludeParams}</h1>
<p>${exception.message}</p>
<p>${exception.stackTrace}</p>
<s:debug></s:debug>
</body>
</html>