<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>マッチング結果</title>
</head>
<body>
<table border="1">
<tr>
<td>ニックネーム</td>
<td>フリースペース</td>
</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><a href=<c:out value="/SE18G2/AccountView?userId=${user.getId() }"/> >
				<c:out value="${user.getNickname()}" /></a></td>
				<td><c:out value="${user.getFreespace()}" /></td>
			</tr>
		</c:forEach>
		</table>
</body>
</html>