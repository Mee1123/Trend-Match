<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="UTF-8">
<title>自分史の作成</title>
</head>
<body>
<jsp:include page="headerForUnfinishAccountRegistration.jsp"/>
<form action="/SE18G2/personalHistory" method="post">

<h2>自分史の作成</h2><br>

手元に紙とペンを用意してください。<br>
<br>
出生から現在を振り返り<br>
どんな出来事があって、<br>
どんなことを学び感じたのか言語化しよう<br>
深めることができれば<br>
自分の中で大切にしてきた価値観が見えてくるはず。<br>
<br>
振り返るときには何故そう感じたのか？を大事にしよう。<br>


<input type="submit" value="おしまい">



</form>
</body>
</html>