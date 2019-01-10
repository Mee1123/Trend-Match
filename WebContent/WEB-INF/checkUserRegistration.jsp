<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>CheckUserRegistration</title>
</head>
<body>
<h1>登録確認画面</h1>
<form action="/SE18G2/checkUserRegistration" method="post">
氏名:<input type="text" name="Name" value= <%=request.getAttribute("userName") %>><br>
メールアドレス:<input type="text" name="MailAddress" value = <%=request.getAttribute("mailAddress") %>><br>
パスワード:<input type="text" name="Password" value = <%=request.getAttribute("password") %>><br>
上記の内容で登録します。よろしいですか？<br>
<p><input type="button" onclick="location.href='/WEB-INF/userRegistration'"value="戻る"></p>
<p><input type="submit" value="確認"></p>
</form>
</body>
</html>