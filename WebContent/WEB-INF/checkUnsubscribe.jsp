<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>checkUnsubscribe</title>
</head>
<body>

<h1>退会確認画面</h1>
<form action="/SE18G2/Unsubscribe" method="post">
本当に退会しますか？
<input type="submit" value="はい"> <input type="submit" value="いいえ">
</form>
</html>