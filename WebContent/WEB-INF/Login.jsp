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
<title>login</title>
</head>
<body>
<h1>Login</h1>
	<div class="container">
		<h1 class="page-header">Login</h1>
		<form action="/SE18G2/Login" method="post">
			<div class="form-group">
				メールアドレス<input class="form-control" type="text" name="mailAddress"><br>
			</div>
			<div class="form-group">
				パスワード<input class="form-control" type="password" name="password"><br>
			</div>
			<input class="btn btn-primary" type="submit" name="goto" value="ログイン"><br>
			登録は<input class="btn btn-primary" type="submit" name="goto" value="こちら"><br>
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>