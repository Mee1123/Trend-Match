<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<meta charset="UTF-8">
<title>TOP(アカウント未登録)</title>
</head>
<body>
	<!-- ヘッダー画像を入れます -->
	<jsp:include page="headerForUnfinishAccountRegistration.jsp" />

	<!-- ヘッダー画像を入れます -->
	<div class="container">
		<form action="/SE18G2/startAccountRegistration" method="post">
			<h3>
				<br> アカウント情報を登録してください<br> <br> 登録は<input
					class="btn btn-primary" type="submit" value="こちら">
			</h3>

		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>