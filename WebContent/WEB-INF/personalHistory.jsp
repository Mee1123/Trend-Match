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
<title>自分史の作成</title>
</head>
<body>
	<jsp:include page="headerForUnfinishAccountRegistration.jsp" />
	<div class="container">
		<form action="/SE18G2/personalHistory" method="post">
			<h1>自分史の作成</h1>
			<br> 手元に紙とペンを用意してください。<br> <br> 出生から現在を振り返り<br>
			どんな出来事があって、<br> どんなことを学び感じたのか言語化しよう<br> 深めることができれば<br>
			自分の中で大切にしてきた価値観が見えてくるはず。<br> <br>
			振り返るときには何故そう感じたのか？を大事にしよう。<br>
			<br> <input class="btn btn-primary" type="submit" value="おしまい">

		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>