<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html >
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<meta charset="UTF-8">
<title>CheckRegistration</title>
</head>
<body>
<jsp:include page="headerForUnfinishAccountRegistration.jsp"/>
	<div class="container">

		<h1 class="page-header">登録確認画面</h1>
		<form action="/SE18G2/checkAccountRegistration" method="post"
			enctype="multipart/form-data">
			<!-- headerを入れます -->
			<!-- <input type="file" name="picturepath" size="30"/><br>
プロフィール画像<br> -->
			<p>
			<div class="form-group">
				<label for="jobOffer">内定情報</label>
				<c:out value="${jobOffer}"></c:out>
				<input class="form-control" type="hidden" name="jobOffer"
					value=<%=request.getAttribute("jobOffer")%>>
			</p>
			</div>
			<p>
			<div class="form-group">
				ニックネーム※<c:out value="${ nickname}"></c:out>
				<input class="form-control" type="hidden" name="nickname"
					value=<%=request.getAttribute("nickname")%>><br>
			</p>
			</div>
			<p>
				卒業(yyyymmdd)<c:out value="${ graduate}"></c:out>
				<input class="form-control" type="hidden" name="graduate"
					value=<%=request.getAttribute("graduate")%>><br>
			</p>
			<p>
				所属 <c:out value="${ department}"></c:out>
				<input class="form-control" type="hidden" name="department"
					value=<%=request.getAttribute("department")%>><br>
			</p>
			<p>
				職種<c:out value="${occupation }"></c:out>
				<input class="form-control" type="hidden" name="occupation"
					value=<%=request.getAttribute("occupation")%>><br>
			</p>
			<p>
				性別<c:out value="${sex }"></c:out>
				<input class="form-control" type="hidden" name="sex"
					value=<%=request.getAttribute("sex")%>><br>
			</p>
			<p>
				連絡先<c:out value="${contact}"></c:out>
				<input class="form-control" type="hidden" name="contact"
					value=<%=request.getAttribute("contact")%>><br>
			</p>
			<p>
				フリースペース(アピールポイントや興味があること等を書いてください)<br>
				<c:out value="${ freeSpace}"></c:out>
				<input class="form-control" type="hidden" name="freespace" value=<%=request.getAttribute("freeSpace")%>>
				<br>
			</p>
			<p>
				価値観<br>
				<c:out value="${value1 }"></c:out><br>
				<c:out value="${value2 }"></c:out><br>
				<c:out value="${value3 }"></c:out><br>
				 <input class="form-control" type="hidden" name="value1"
					value=<%=request.getAttribute("value1")%>><br> <input class="form-control"
					type="hidden" name="value2"
					value=<%=request.getAttribute("value2")%>><br> <input class="form-control"
					type="hidden" name="value3"
					value=<%=request.getAttribute("value3")%>><br>
			</p>



			上記の内容で登録します。よろしいですか？<br>
			<p>
				<input class="btn btn-primary" type="submit" name="goto" value="いいえ">
			</p>
			<p>
				<input class="btn btn-primary" type="submit" name="goto" value="はい">
			</p>
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>