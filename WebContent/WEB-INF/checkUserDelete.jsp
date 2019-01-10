<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>checkUserDelete</title>
</head>
<body>
<jsp:include page="headerForAdmin.jsp"/>
<h1>ユーザー削除確認画面</h1>

<form action="/SE18G2/DeleteUser" method="post">
プロフィール画像<br>
ニックネーム<br>
所属<br>
職種<br>
性別<br>
連絡先<br>
フリースペース<br>
このユーザーを削除しますか？<br>
	<input type="hidden" name="id" value="4">
<input type="submit" value="はい"> <input type="submit" value="いいえ">
</form>
</html>