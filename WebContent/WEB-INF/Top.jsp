<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>アカウントありのトップページ</h1>
	<table>
		<c:forEach var="user" items="${users}" end = "5">
			<tr>
				<div class="form-group">
					<td><c:out value="${user.getNickname()}" /></td>
					<td><c:out value="${user.getFreespace()}" /></td>
				</div>
			</tr>
		</c:forEach>
	</table>
	<a href = "AccountMatchingResult">もっと見る</a>
	<a href ="AccountSearchInfo">アカウント検索</a>
</body>
</html>