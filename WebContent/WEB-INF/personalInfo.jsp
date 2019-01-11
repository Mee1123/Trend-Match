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
<title>個人情報の公開について</title>
</head>
<body>
	<div class="container">
		<form action="/SE18G2/personalInfo" method="post">

			注意：個人情報の公開について<br>

			・これより作成するアカウント情報、およびエニアグラム診断結果情報はユーザーマッチングシステムをはじめとする、各機能に使用されます。<br>
			・またあなたのアカウント情報、およびエニアグラム診断結果情報は当システムにログインした全てのユーザーが閲覧することができます。<br>
			・ただし、ユーザー情報においてはこれの限りではありません。<br>
			・また、アカウント情報は必須項目を除いて、未記入にすることができます。<br> ・登録後の変更も可能です。<br> <input
				class="btn btn-primary" type="submit" value="同意">

		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>