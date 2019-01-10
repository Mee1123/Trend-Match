<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/SE18G2/AccountSearchInfo" method="post">
ニックネーム:<input type="text" name="nickname"><br>
卒業年度:<select name = "graduate">
	<c:forEach begin=2000 end=2020 var="years">
		<option value="${years}"><c:out value="${years}" /></option>
	</c:forEach>
</select>
所属:<input type="text" name="department"><br>
職種:<input type="text" name="occupation"><br>
性別:<select name ="sex">
<option value ="human">ー</option>
<option value= "man">男</option>
<option value = "woman">女</option></select>
フリースペース:<input type="text" name="freespace"><br>
表示順:<select name = "display">
<option value = "number">登録順</option>
</select>
><br>
<input type="submit" value="検索">
</form>
</body>
</html>