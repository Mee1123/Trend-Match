<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<meta charset="UTF-8">
<title>アカウント検索結果</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="container">
		<c:forEach var="user" items="${users}">
			<tr>
				<div class="form-group">
					<td>
					<a href=<c:out value="/SE18G2/AccountView?userId=${user.getId() }"/> >
					<c:out value="${user.getNickname()}" /></td></a>
					<td><c:out value="${user.getFreespace()}" /></td>
				</div>
			</tr>
		</c:forEach>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>