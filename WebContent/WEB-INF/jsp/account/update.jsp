<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<%
	User user = (User) request.getAttribute("user");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<link rel="stylesheet" type="text/css" href="/SE18G2/CSS/border.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント情報編集</title>
</head>
<body>
	<jsp:include page="/WEB-INF/header.jsp" />
	<!-- ナビゲーションバー -->
	<!-- コンテンツ -->
	<div class="container">
		<h1 class="page-header">アカウント情報編集</h1>
		<br>
		<form action="/SE18G2/account/update" method="post">
			<div class="form-group">
				<%
					if (user.getJoboffer_id() == 0) {
				%>
				<input type="radio" name="jobOffer" value="内定あり">内定あり<br>
				<input type="radio" name="jobOffer" value="内定なし" checked="checked">内定なし<br>
				<%
					} else {
				%>
				<input type="radio" name="jobOffer" value="内定あり" checked="checked">内定あり<br>
				<input type="radio" name="jobOffer" value="内定なし">内定なし<br>
				<%
					}
				%>
			</div>
			<div class="form-group">
				<label for="nickname">ニックネーム</label> <input class="form-control"
					type="text" name="nickName" id="nickName"
					value="<%=user.getNickname()%>">
			</div>
			<!-- <div class="form-group">
				<label for="picture">プロフィール画像</label>
				<p>
					<input class="form-control" type="text" name="picturePath"
						id="picturePath" value="<%=user.getPicturepath()%>">
				</p>
			</div> -->
			<div class="form-group">
				<label for="graduate">卒業年度</label> <input class="form-control"
					type="text" name="graduate" id="graduate"
					value="<%=user.getGraduate()%>">
			</div>
			<div class="form-group">
				<label for="department">所属</label> <input class="form-control"
					type="text" name="department" id="department"
					value="<%=user.getDepartment()%>">
			</div>
			<div class="form-group">
				<label for="occupation">職種</label> <input class="form-control"
					type="text" name="occupationId" id="occupationId"
					value="<%=user.getOccupation_id()%>">
			</div>
			<div class="form-group">
				<label for="sex">性別</label> <input class="form-control" type="text"
					name="sexId" id="sexId" value="<%=user.getSex_id()%>">
			</div>
			<div class="form-group">
				<label for="contact">連絡先</label> <input class="form-control"
					type="text" name="contact" id="contact"
					value="<%=user.getContact()%>">
			</div>
			<div class="form-group">
				<label for="freespace">フリースペース(アピールポイントや興味があること等を書いてください)</label> <input
					class="form-control" type="text" name="freeSpace" id="freeSpace"
					value="<%=user.getFreespace()%>">
			</div>
			<div class="form-group">
				<label for="value">価値観</label> <input class="form-control"
					type="text" name="value1" id="value1"
					value="<%=request.getAttribute("value1")%>" autocomplete="on"
					list="values"> <input class="form-control" type="text"
					name="value2" id="value2"
					value="<%=request.getAttribute("value2")%>" autocomplete="on"
					list="values"> <input class="form-control" type="text"
					name="value3" id="value3"
					value="<%=request.getAttribute("value3")%>" autocomplete="on"
					list="values">
				<datalist id="values"> <c:forEach var="value"
					items="${values}">
					<option value="${value.getValue()}">
				</c:forEach> </datalist>
			</div>
			<button type="submit" class="btn btn-primary">登録</button>
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>
