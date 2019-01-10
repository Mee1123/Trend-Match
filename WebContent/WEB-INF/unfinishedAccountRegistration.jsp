<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>アカウント未登録は完了していません</title>
</head>
<body>

<form action="/SE18G2/unfinishedAccountRegistration" method="post">

<h2>まだ自己分析は完全ではありません</h2><br>

次のアカウント登録画面で自分に最も当てはまる価値観を登録すると、<br>
より正確なマッチングを受けることができます。<br>
ぜひ登録してください！<br>

<!-- <a href="aboutMotivationServlet">詳しくみる</a><br>-->
<input type="submit" name="goto" value="詳しくみる"><br>
<input type="submit" name="goto" value="次へ">
</form>
</body>
</html>