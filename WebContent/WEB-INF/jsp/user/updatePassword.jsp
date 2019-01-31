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
<title>ユーザー情報変更</title>
</head>
<body>
	<%
		int userId = (int) session.getAttribute("userID");
		UserService userService = new UserService();
		User account = userService.getMyAccountInfo(userId);
	%>
	<%
	if(userId == 1){
	%>
	<jsp:include page="/WEB-INF/headerForAdmin.jsp" />
	<%
	}	else if (account.getNickname() == null) {
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
		<h1 class="page-header">パスワード編集</h1>
		<br>
		<form action="/SE18G2/user/updatePassword" method="post">
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
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>