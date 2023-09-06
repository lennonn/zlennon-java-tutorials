<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<table align="center">
		<s:form action="login" label="登陆">
			<tr><td><s:textfield label="用户名" name="user.name"></s:textfield><td></tr>
			<tr><td><s:password  label="密     码" name="user.password"></s:password><td></tr>
			<tr><td><s:submit label="登     陆 " name="submit"></s:submit></td></tr>
		</s:form>
	</table>
	  <a href="prepareLogin.action">登陆</a>
</body>
</html>