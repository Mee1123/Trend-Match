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
<title>アカウント未登録は完了していません</title>
</head>
<body>
	<jsp:include page="headerForUnfinishAccountRegistration.jsp" />
	<div class="container">
		<form action="/SE18G2/unfinishedAccountRegistration" method="post">

			<h2>まだ自己分析は完全ではありません</h2>
			<br> 次のアカウント登録画面で自分に最も当てはまる価値観を登録すると、<br>
			より正確なマッチングを受けることができます。<br> ぜひ登録してください！<br> <br> <input
				class="btn btn-primary" type="submit" name="goto" value="詳しく見る">
			<input class="btn btn-primary" type="submit" name="goto" value="次へ">
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>