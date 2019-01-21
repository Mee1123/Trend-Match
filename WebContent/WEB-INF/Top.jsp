<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<link rel="stylesheet" type="text/css" href="/SE18G2/CSS/border.css">
<meta charset="UTF-8">
<title>Top</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<h1>アカウント保持者のトップページ</h1>
		<table border="1">
			<tr>
				<td align="center">ニックネーム</td>
				<td align="center">フリースペース</td>
			</tr>
			<c:forEach var="user" items="${users}" end="5">
				<tr>
					<div class="form-group">
					<td align="center"><a
						href=<c:out value="/SE18G2/AccountView?userId=${user.getId() }"/>>
							<c:out value="${user.getNickname()}" />
					</a></td>
					<td align="center"><c:out value="${user.getFreespace()}" /></td>
				</div>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="AccountMatchingResult"><button
				class="btn btn-primary">もっと見る</button></a> <a href="AccountSearchInfo"><button
				class="btn btn-primary">アカウント検索</button></a>

	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>