<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>
<body>

<h1>Login</h1>
<form action="/SE18G2/Login" method="post">
メールアドレス:<input type="text" name="mailAddress"><br>
パスワード:<input type="password" name="password"><br>
<input type="submit" name ="goto" value="ログイン"><br>
登録は<input type="submit" name="goto" value="こちら">

</form>
</html>