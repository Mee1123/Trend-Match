<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.User"%>
<%@ page import="javax.servlet.http.HttpSession"%>
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
<link rel="stylesheet" type="text/css" href="/SE18G2/CSS/border.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー情報編集</title>
</head>
<body>
	<%
		int userId = (int) session.getAttribute("userID");
		UserService userService = new UserService();
		User account = userService.getMyAccountInfo(userId);
	%>
	<%
		if (account.getNickname() == null) {
	%>
	<jsp:include page="/WEB-INF/headerForUnfinishAccountRegistration.jsp" />
	<%
		} else {
	%>
	<jsp:include page="/WEB-INF/header.jsp" />
	<%
		}
	%>
	<!-- コンテンツ -->
	<div class="container">
		<h2 class="page-header">ユーザー情報編集</h2>
		<br>
		<form action="/SE18G2/user/update" method="post">
			<div class="form-group">
				<div class="sideborder">
					<label for="name">氏名(20文字以下)</label> <input class="form-control"
						type="text" name="name" id="name" value="<%=user.getName()%>">
				</div>
			</div>
			<div class="form-group">
				<div class="sideborder">
					<label for="description">メールアドレス(40文字以下)</label> <input
						class="form-control" name="mailaddress" id="mailaddress"
						value="<%=user.getMailAddress()%>">
				</div>
			</div>
			<div class="form-group">
				<div class="sideborder">
					<label for="password">新しいパスワード(8文字以上20文字以下)</label> <input
						class="form-control" type="password" name="password" id="password">
				</div>
				<br>
				<div class="sideborder">
					<label for="password2">パスワード確認用</label> <input class="form-control"
						type="password" name="password2" id="password2">
				</div>
				<br>
				<button type="submit" class="btn btn-primary">登録</button>
			</div>
		</form>
		<div align="right">
			<a href="/SE18G2/Unsubscribe"><input class="btn btn-danger"
				type="button" value="退会"></a>
		</div>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>