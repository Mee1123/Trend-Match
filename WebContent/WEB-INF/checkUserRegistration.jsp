<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<meta charset="UTF-8">
<title>CheckUserRegistration</title>
</head>
<body>
	<div class="container">
		<h1>登録確認画面</h1>
		<form action="/SE18G2/checkUserRegistration" method="post">

			氏名:<c:out value="${userName}"/>
			<input type="hidden" name="Name" value=<%=request.getAttribute("userName")%>><br>
			メールアドレス:<c:out value="${mailAddress}"/>
			<input type="hidden" name="MailAddress"value=<%=request.getAttribute("mailAddress")%>><br>
			パスワード:<c:out value="${password}"/>
			<input type="hidden" name="Password" value=<%=request.getAttribute("password")%>><br>
			上記の内容で登録します。よろしいですか？<br>
			<p>
				<input class="btn btn-primary" type="submit" name="goto" value="戻る">
			</p>
			<p>
				<input class="btn btn-primary" type="submit" name="goto" value="確認">
			</p>
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>