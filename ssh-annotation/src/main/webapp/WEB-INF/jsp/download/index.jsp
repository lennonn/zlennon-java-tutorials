<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-tags" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>&nbsp; 文件下载 </h2>

	<table>
	<s:iterator var="cate" value="#request.categories" status="statu">
	<tr>
	<td>
	<s:property value="%{#cate.CName}"/>
	</td>
	<s:iterator var="cc" value="#cate.childCategories">
	<td>
	<s:property value="#cc.ccName"/>
	</td>
	<td>
		<s:iterator var="file" value="#cc.fileSources">
		<a href="downloadSingle.action?filename=files/download/<s:property value='#file.fileName'/>"><s:property value="#file.fileName"/></a>
		</s:iterator>
	</td>
	</s:iterator>
	</tr>

	 </s:iterator>

	<%-- <s:iterator var="files" value="#request.files" status="status">
	<a href="downloadSingle.action?filename=files/download/"><s:property value="#files.fileUrl"/></a><br>
		<s:property value="cate.cateName"/>

	</s:iterator> --%>
	</table>
	 <a href="logout.action">登出</a>
	  <a href="prepareLogin.action">登陆</a>
</body>
</html>