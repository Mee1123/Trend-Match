<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h1>ユーザ登録</h1>

<form action="/SE18G2/userRegistration" method="post">
氏名:<input type="text" name="userName"><br>
メールアドレス:<input type="text" name="mailAddress"><br>
パスワード:<input type="password" name="password"><br>
パスワード確認用:<input type="password" name="password2"><br>
<input type="submit" value="登録">
</form>
</body>
</html>