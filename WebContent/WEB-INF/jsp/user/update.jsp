<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%
	User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー情報編集</title>
</head>
<body>
	<!-- コンテンツ -->
	<div class="container">
		<h2 class="page-header">ユーザー情報編集</h2>
		<hr>
		<!-- 水平線 -->
		<form action="/SE18G2/user/update" method="post">
			<div class="form-group">
				<label for="name">氏名</label> <input class="form-control" type="text"
					name="name" id="name" value="<%=user.getName()%>">
			</div>
			<div class="form-group">
				<label for="description">メールアドレス</label> <input class="form-control"
					name="mailaddress" id="mailaddress"
					value="<%=user.getMailAddress()%>">
			</div>
			<div class="form-group">
				<label for="password">新しいパスワードを入力してください</label> <input
					class="form-control" type="password" name="password" id="password">
				<br> <label for="password2">パスワード確認用</label> <input
					class="form-control" type="password" name="password2" id="password2">
				<br>
				<div align="right">
				<button type="submit" class="btn btn-primary">登録</button>
				</div>
			</div>
		</form>
		<a href="/SE18G2/Unsubscribe"><input class="btn btn-primary" type="button" value="退会"></a>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>