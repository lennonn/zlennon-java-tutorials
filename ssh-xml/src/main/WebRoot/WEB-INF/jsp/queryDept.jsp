<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询页面</title>
</head>
<body>
	<h2 align="center">Dept 查询页面</h2>
	<s:form name="queryDeptSingle" action="queryDeptSingle">
		<s:textfield label="单个Dept查询，请输入部门编号" name="dept.deptno"></s:textfield>
		<s:submit value="查询"></s:submit>

	</s:form>
	<table border="1" style="background-color:gray ;" align="left"
		width="500px" height="100px">
		<tr>
			<td>部门编号</td>
			<td>部门名称</td>
			<td>部门地址</td>
		</tr>
		<tr>
			<td><s:property value="#request.Dept.deptno" /></td>
			<td><s:property value="#request.Dept.dname" /></td>
			<td><s:property value="#request.Dept.loc" /></td>
		</tr>
	</table>

	<s:form name="queryDeptSingle" action="queryDeptList">
		<s:textfield label="多个个Dept查询，请输入部门编号"></s:textfield>
		<s:submit value="查询"></s:submit>

	</s:form>
	<table border="1" style="background-color:gray ;" align="right"
		width="500px" height="100px">
		<tr>
			<td>部门编号</td>
			<td>部门名称</td>
			<td>部门地址</td>
		</tr>

		<s:iterator var="deptList" value="#request.deptList" status="status">
			<tr>
				<td><s:property value="#deptList.deptno" /></td>
				<td><s:property value="#deptList.dname" /></td>
				<td><s:property value="#deptList.loc" /></td>

			</tr>
		</s:iterator>
	</table>
</body>
</html>