<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>
<h1>Login</h1>
<form action="/WebAPSample/students/sessions/new" method="post">
メールアドレス:<input type="text" name="mailAddress"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" value="ログイン">
</form>
</html>