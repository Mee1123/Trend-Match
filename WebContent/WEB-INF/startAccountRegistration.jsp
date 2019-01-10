<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>TOP(アカウント未登録)</title>
</head>
<body>
<!-- ヘッダー画像を入れます -->
<jsp:include page="headerForUnfinishAccountRegistration.jsp"/>
 <form action="/SE18G2/startAccountRegistration" method="post">
アカウント情報を<br>
登録してください<br>
登録は<input type="submit" value="こちら">

</form>
</body>
</html>