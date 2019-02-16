<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>标题</title>
</head>
<body>
	<table>
		<tr>
			<td>编号</td> 
			<td>姓名</td>
			<td>性别</td>
			<td>职位</td>
			<td>薪水</td>
			<td>入职日期</td>
			<td>部门编号</td>
		</tr>
		<c:forEach items="${emps}" var="emp">
			<tr>
				<td>${emp.id }</td> 
				<td>${emp.name}</td>
				<td>${emp.sex }</td>
				<td>${emp.job }</td>
				<td>${emp.salary }</td>
				<td><fmt:formatDate value="${emp.hiredate }"
						pattern="yyyy-MM-dd" /></td>
				<td>${emp.deptno }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>