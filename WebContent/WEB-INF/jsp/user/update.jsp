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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー情報編集</title>
</head>
<body>
	<!-- ナビゲーションバー -->
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
					name="mailaddress" id="mailaddress" value="<%=user.getMailAddress()%>">
			</div>
			<div class="form-group">
				<label for="password">パスワード</label> <input class="form-control"
					name="password" value="新しいパスワードを入力してください">
				<button type="submit" class="btn btn-primary">登録</button>
				<!-- メールアドレスハッシュ値で戻ってきてしまう -->
			</div>
		</form>
	</div>
	<input type="button" onclick="location.href='./unsubscribe.jsp'"
		value="退会">
	<!-- javascript -->
</body>
</html>