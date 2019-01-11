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
<title>ユーザー削除確認</title>
</head>
<body>
<jsp:include page="headerForAdmin.jsp"/>
	<div class="container">
		<h1>ユーザー削除確認画面</h1>
		<form action="/SE18G2/DeleteUser" method="post">
			プロフィール画像<br> ニックネーム<br> 所属<br> 職種<br> 性別<br>
			連絡先<br> フリースペース<br> このユーザーを削除しますか？<br> <input
				type="hidden" name="id" value="4"> <input
				class="btn btn-primary" type="submit" value="はい"> <input
				class="btn btn-primary" type="submit" value="いいえ">
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>