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
<link rel="stylesheet" type="text/css" href="/SE18G2/CSS/border.css">
<meta charset="UTF-8">
<title>退会確認</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<h1>退会確認画面</h1>
		<form action="/SE18G2/Unsubscribe" method="post">
			<br>
			<div class="form-group">
				本当に退会しますか？ <br>
			</div>
			<div class="form_conf">
				<input class="btn btn-danger" type="submit" value="はい">
		</form>
		<form action="/SE18G2/HeaderUserInfo" method="get"> <input class="btn btn-primary"
			type="submit" value="いいえ">
		</form>
		    </div>
	</div>

	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>