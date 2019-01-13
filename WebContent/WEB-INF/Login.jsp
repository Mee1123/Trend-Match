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
<title>ログイン</title>
</head>
<body>
	<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="/SE18G2/AboutTrendMatch">About
			TrendMatch</a>
		<div align="right">
			<a class="navbar-brand" href="/SE18G2/PrivacyPolicy">Privacy
				Policy</a>
		</div>
	</nav>
	<br>
	<div class="container">
		<h1 class="page-header">Login</h1>
		<br>
		<form action="/SE18G2/Login" method="post">
			<div class="form-group">
				<div class="sideborder">
					メールアドレス<input class="form-control" type="text" name="mailAddress">
				</div>
			</div>
			<br>
			<div class="form-group">

				<div class="sideborder">
					パスワード<input class="form-control" type="password" name="password">
				</div>
			</div>
			<br> <input class="btn btn-primary" type="submit" name="goto"
				value="ログイン"><br> <br>
			<div align="center">
				登録は<input class="btn btn-primary" type="submit" name="goto"
					value="こちら">
			</div>
			<br>
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>