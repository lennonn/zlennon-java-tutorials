<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
	   <h1><s:text name="save.title"></s:text></h1>
	   <s:property value="getText('save.title')" />
	   <s:form name="saveDept" action="saveDept" >
   		    <s:textfield name="dept.deptno" label="部门编码"></s:textfield>
   			<s:textfield name="dept.dname" label="部门名称"></s:textfield>
   			<s:textfield name="dept.loc" label="部分地点"></s:textfield>
   			<s:submit name="submit">提交保存</s:submit>
   		</s:form>
   </center>
</body>
</html>