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
<title>ユーザー登録</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="/WEB-INF/pages/aboutTrendMatch.jsp">About
			TrendMatch</a>
	</nav>
	<br>
	<div class="container">
		<h1>ユーザー登録</h1>
		<form action="/SE18G2/userRegistration" method="post">
			氏名(20文字以下):<input class="form-control" type="text" name="userName"><br>
			メールアドレス(40文字以下):<input class="form-control" type="text" name="mailAddress"><br>
			パスワード(8文字以上20文字以下):<input class="form-control" type="password" name="password"><br>
			パスワード確認用:<input class="form-control" type="password" name="password2"><br>
			<input class="btn btn-primary" type="submit" value="登録">
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>