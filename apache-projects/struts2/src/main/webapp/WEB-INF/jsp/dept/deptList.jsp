<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>部门列表</title>
</head>
<body>
<center>
    <h1>部门列表</h1>

	<table border="1" style="background-color:gray ;" align="center" width="500px" height="100px">
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

	   <s:a action="submitDept">添加部门</s:a>
	   <s:a action="queryDeptSingle">部门编号查询</s:a>
</center>
</body>
</html>