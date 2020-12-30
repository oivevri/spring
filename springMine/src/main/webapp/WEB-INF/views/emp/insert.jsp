<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원등록/수정</title>
</head>
<body>
<form:form action="empInsert" method="poset" modelAttribute="emp">
<c:if test="${not empty employeeId }">
<form:input path="employeeId" readonly="readonly"/><br>
</c:if>
<form:input path="firstName" placeholder="firstName"/><br>
<form:input path="lastName" placeholder="lastName"/><br>
<form:input path="email" placeholder="email"/><br>
<form:select path="jobId">
	<form:option value="">job선택</form:option>
	<form:options items="${jobs}"
				  itemLabel="jobTitle"
				  itemValue="jobId" />
</form:select><br>
<form:input path="hireDate" placeholder="hireDate"/><br>
<form:input path="departmentId" placeholder="departmentId"/><br>
<form:checkboxes items="${departments}" path="departmentId"
				 itemLable="departmentName"
				 itemValue="departmentId"/><br>
<form:input path="salary" placeholder="salary"/><br>

<form:button>등록</form:button>
</form:form>
</body>
</html>