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
				<label for="nickname">ニックネーム</label> <input class="form-control"
					type="text" name="nickName" id="nickName"
					value="<%=user.getName()%>">

			</div>
			<div class="form-group">
				<label for="picture">プロフィール画像</label>
				<p>
					<input class="form-control" type="text" name="picturePath"
						id="picturePath" value="<%=user.getPicturepath()%>">
				</p>
			</div>
			<div class="form-group">
				<label for="graduate">卒業年度</label> <input class="form-control"
					type="text" name="graduate" id="graduate"
					value="<%=user.getGraduate()%>">
			</div>
			<div class="form-group">
				<label for="joboffer">内定の有無</label> <input class="form-control"
					type="text" name="jobOfferId" id="jobOfferId"
					value="<%=user.getJoboffer_id()%>">
			</div>
			<div class="form-group">
				<label for="department">所属</label> <input class="form-control"
					name="department" id="department" value="<%=user.getDepartment()%>">
			</div>
			<div class="form-group">
				<label for="occupation">職種</label> <input class="form-control"
					name="occupationId" id="occupationId"
					value="<%=user.getOccupation_id()%>">
			</div>
			<div class="form-group">
				<label for="sex">性別</label> <input class="form-control" name="sexId"
					id="sexId" value="<%=user.getSex_id()%>">
			</div>
			<div class="form-group">
				<label for="contact">連絡先</label> <input class="form-control"
					name="contact" id="contact" value="<%=user.getContact()%>">
			</div>
			<div class="form-group">
				<label for="freespace">フリースペース</label> <input class="form-control"
					name="freeSpace" id="freeSpace" value="<%=user.getFreespace()%>">
			</div>
			<div class="form-group">
				<label for="value">価値観</label> <input class="form-control"
					name="valueId1" id="valueId1"
					value="<%=user.getValue_id().get(0)%>"> <input
					class="form-control" name="valueId2" id="valueId2"
					value="<%=user.getValue_id().get(1)%>"> <input
					class="form-control" name="valueId3" id="valueId3"
					value="<%=user.getValue_id().get(2)%>">
			</div>
			<button type="submit" class="btn btn-primary">登録</button>
		</form>
	</div>
	<input type="button" onclick="location.href='./unsubscribe.jsp'"
		value="退会" />
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>
