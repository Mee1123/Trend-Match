<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<meta charset="UTF-8">
<title>アカウント検索</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="container">
		<form action="/SE18G2/AccountSearchInfo" method="post">
			<div class="form-group">
				ニックネーム:<input class="form-control" type="text" name="nickname"><br>
			</div>
			<div class="form-group">
				卒業年度:<input class="form-control" type="text" name="graduate" maxlength="4"><br>
			</div>
			<div class="form-group">
				所属:<input class="form-control" type="text" name="department"><br>
			</div>
			<div class="form-group">
				職種:<select name="occupation">
					<option value=""> - </option>
					<option value="1">学部生</option>
					<option value="2">大学院生</option>
					<option value="3">農業・水産</option>
					<option value="4">林業</option>
					<option value="5">漁業</option>
					<option value="6">鉱業</option>
					<option value="7">建設業</option>
					<option value="8">製造業</option>
					<option value="9">電気・ガス</option>
					<option value="10">運輸・通信業</option>
					<option value="11">卸売・小売・飲食業</option>
					<option value="12">金融・保険業</option>
					<option value="13">不動産業</option>
					<option value="14">サービス業</option>
					<option value="15">その他</option>
				</select>
			</div>
			<div class="form-group">
				性別:<select name="sex">
					<option value="human">-</option>
					<option value="man">男</option>
					<option value="woman">女</option>
				</select>
			</div>
			<div class="form-group">
				フリースペース:<input class="form-control" type="text" name="freespace"><br>
			</div>
			<div class="form-group">
				表示順:<select name="display">
					<option value="number">登録順</option>
				</select><br>
			</div>
			<input class="btn btn-primary" type="submit" value="検索">
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>