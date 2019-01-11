<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>アカウント情報編集</title>
</head>
<body>
	<!-- ナビゲーションバー -->
	<!-- コンテンツ -->
	<div class="container">
		<h2 class="page-header">アカウント情報編集</h2>
		<hr>
		<!-- 水平線 -->
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
					value="<%=user.getName()%>">
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
					type="text" name="valueId1" id="valueId1"
					value="<%=request.getAttribute("value1")%>"> <input
					class="form-control" type="text" name="valueId2" id="valueId2"
					value="<%=request.getAttribute("value2")%>"> <input
					class="form-control" type="text" name="valueId3" id="valueId3"
					value="<%=request.getAttribute("value3")%>">
			</div>
			<button type="submit" class="btn btn-primary">登録</button>
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>
