<%@ page import="model.User"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>ユーザー情報編集完了</title>
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
	<div class="container">
		<div class="form-group">
			<h2>
				<label for="finish">登録が完了しました</label>
			</h2>
		</div>
		<a href="/SE18G2/Top"><button class="btn btn-primary">Topへ</button></a>
		<!-- ホーム画面に戻る -->
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>