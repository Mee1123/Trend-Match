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
<link rel="stylesheet" type="text/css" href="/SE18G2/CSS/border.css">
<meta charset="UTF-8">
<title>アカウント登録</title>
</head>
<body>
	<jsp:include page="headerForUnfinishAccountRegistration.jsp" />
	<div class="container">
		<form action="/SE18G2/accountRegistration" method="post"
			enctype="multipart/form-data">
			<h1>アカウント登録(※は必須項目です)</h1>
			<br>
			<!--
<input type="file" name="file" size="30"/><br>
プロフィール画像<br>
-->
			<p>
				<input type="radio" name="jobOffer" value="内定あり">内定あり<br>
				<input type="radio" name="jobOffer" value="内定なし" checked="checked">内定なし<br>
			</p>
			<p>
				ニックネーム※<input type="text" name="nickname"><br>
			</p>
			<p>
				卒業年度(西暦4桁で入力してください)※<input type="text" name="graduate" maxlength="4"><br>
			</p>
			<p>
				所属<input type="text" name="department"><br>
			</p>
			<p>
				職種<select name="occupation">
					<option value="学部生">学部生</option>
					<option value="大学院生">大学院生</option>
					<option value="農業・水産">農林・水産</option>
					<option value="林業">林業</option>
					<option value="漁業">漁業</option>
					<option value="鉱業">鉱業</option>
					<option value="建設業">建設業</option>
					<option value="製造業">製造業</option>
					<option value="電気・ガス">電気・ガス</option>
					<option value="運輸・通信業">運輸・通信業</option>
					<option value="卸売・小売・飲食業">卸売・小売・飲食業</option>
					<option value="金融・保険業">金融・保険業</option>
					<option value="不動産業">不動産業</option>
					<option value="サービス業">サービス業</option>
					<option value="その他">その他</option>
				</select><br>
			</p>
			<p>
				性別<select name="sex">
					<option value="男">男</option>
					<option value="女">女</option>
					<option value="選択しない">選択しない</option>
				</select><br>
			</p>
			<p>
				連絡先<input type="text" name="contact"><br>
			</p>
			<p>
				フリースペース(アピールポイントや興味があること等を書いてください)<br>
				<textarea name=freespace maxlength=200 cols="40" rows="5"></textarea>
				<br>
			</p>
			<p>
				価値観(最低一つは入力してください)<br> <input type="text" name="valueId1" autocomplete="on"
					list="values">
				<datalist id="values">
					<c:forEach var="value" items="${values}">
						<option value="${value.getValue()}">
					</c:forEach>
				</datalist>
				<input type="text" name="valueId2" autocomplete="on" list="values">
				<input type="text" name="valueId3" autocomplete="on" list="values">
			</p>
			<br> <input class="btn btn-primary" type="submit" value="次へ">

		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>