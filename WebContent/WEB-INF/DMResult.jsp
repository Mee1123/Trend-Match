<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Message"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 <!--
     a       {display:block;width:100%;height:100%;}
 -->
 </style>
 <!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/chat.css">
<meta charset="UTF-8">
<title>メッセージボックス</title>
</head>
<body>
<h1>メッセージボックス</h1>
	<table border="1">
		<tr>
			<td>ニックネーム</td>
		</tr>
		<c:forEach var="user" items="${usersList}">
			<tr>
				<td width="200" height="30">
					<a href=<c:out value="/SE18G2/DMResult?Id=${user.getUserId() }"/> >
					<c:out value="${user.getUserNickname()}" />
					<c:out value="${user.getMessageContents()}"/>
					</a>
					</td>
			</tr>
		</c:forEach>
	</table>
	<%-- 表示中の相手の名前 --%>
	<c:out value="${user.getNickname()}"/>
	<%-- チャット風表示 --%>
	<c:forEach var = "message" items = "${messageList}">
	<c:choose>
	<c:when test="${message.getSendUserId() == userId}">
		<div class="kaiwa">
			<div class="kaiwa-text-right">
				<p class="kaiwa-text">
		 		<c:out value="${message.getMessageContents() }"></c:out>
				</p>
			 </div>
		</div>
	</c:when>
	<c:when test="${message.getSendUserId() != userId}">
		<div class="kaiwa">
 			<div class="kaiwa-text-left">
				<p class="kaiwa-text">
		 		<c:out value="${message.getMessageContents() }"></c:out>
				</p>
			 </div>
		</div>
	</c:when>
	</c:choose>
	</c:forEach>
	<c:if test="${user.getId() != null}">
		 <form action="/SE18G2/DMResult" method="post">
			 <input type="hidden" name="toUserId" value=<c:out value="${user.getId()}"/>>
			 <textarea name="message" rows="5" cols="200">本文</textarea>
			 <input type="submit" value="送信">
		 </form>
	 </c:if>

</body>
</html>