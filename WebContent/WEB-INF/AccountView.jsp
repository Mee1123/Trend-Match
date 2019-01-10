<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	ユーザー情報 ニックネーム
	<c:out value="${user.getNickname()}" />
	<br> 所属:
	<c:out value="${user.getDepartment()}" />
	<br> 職種:
	<c:out value="${user.getOccupation_id()}" />
	<br> 性別:
	<c:choose>
		<c:when test="${user.getSex_id()==0}">-</c:when>
		<c:when test="${user.getSex_id()==1}">男</c:when>
		<c:when test="${user.getSex_id()==2}">女</c:when>
	</c:choose>
	<br> 連絡先:
	<c:out value="${user.getContact()}" />
	<br> 価値観:
	<c:out value="${user.getNickname()}" />
	<br> フリースペース:
	<c:out value="${user.getFreespace()}" />
	<br> エニアグラム
	<table border>
		<tr bgcolor="#ffb6c1">
			<td>1</td>
			<td>2</td>
			<td>3</td>
		</tr>
		<tr>
			<td><c:out value ="${user.getEnneagram()[0]}"/></td>
			<td><c:out value ="${user.getEnneagram()[1]}"/></td>
			<td><c:out value ="${user.getEnneagram()[2]}"/></td>
		</tr>
		<tr bgcolor="#ffb6c1">
			<td>4</td>
			<td>5</td>
			<td>6</td>
		</tr>
		<tr>
			<td><c:out value ="${user.getEnneagram()[3]}"/></td>
			<td><c:out value ="${user.getEnneagram()[4]}"/></td>
			<td><c:out value ="${user.getEnneagram()[5]}"/></td>
		</tr>
		<tr bgcolor="#ffb6c1">
			<td>7</td>
			<td>8</td>
			<td>9</td>
		</tr>
		<tr>
			<td><c:out value ="${user.getEnneagram()[6]}"/></td>
			<td><c:out value ="${user.getEnneagram()[7]}"/></td>
			<td><c:out value ="${user.getEnneagram()[8]}"/></td>
		</tr>
	</table>
	<c:choose>
		<c:when test="${session == 1 }">
編集
</c:when>
		<c:when test="${session ==2 }">
通報
連絡
</c:when>
	</c:choose>

</body>
</html>