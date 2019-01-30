<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.User"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.text.ParseException"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
	<div class="container">
		<h1 class="page-header">アカウント情報編集</h1>
		<br> ※は必須項目です <br>
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
				<label for="nickname">ニックネーム(40文字以下)※</label> <input
					class="form-control" type="text" name="nickName" id="nickName"
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
				<%
					Date str1 = user.getGraduate();

					String str = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(str1);
					String str2 = str.substring(0, 4);
				%>
				<label for="graduate">卒業年度※</label> <input class="form-control"
					type="text" name="graduate" id="graduate" maxlength="4"
					value="<%=str2%>">
			</div>
			<div class="form-group">
				<label for="department">所属(20文字以下)</label> <input
					class="form-control" type="text" name="department" id="department"
					value="<%=user.getDepartment()%>">
			</div>
			<div class="form-group">
				<label for="occupation">職種</label><select name="occupationId"
					id="occupationId">
					<c:choose>
						<c:when test="${user.getOccupation_id()==1}">
							<option selected value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
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
						</c:when>
						<c:when test="${user.getOccupation_id()==2}">
							<option value="1">学部生</option>
							<option selected value="2">大学院生</option>
							<option value="3">農林・水産</option>
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
						</c:when>
						<c:when test="${user.getOccupation_id()==3}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option selected value="3">農林・水産</option>
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
						</c:when>
						<c:when test="${user.getOccupation_id()==4}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option selected value="4">林業</option>
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
						</c:when>
						<c:when test="${user.getOccupation_id()==5}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option selected value="5">漁業</option>
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
						</c:when>
						<c:when test="${user.getOccupation_id()==6}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option value="5">漁業</option>
							<option selected value="6">鉱業</option>
							<option value="7">建設業</option>
							<option value="8">製造業</option>
							<option value="9">電気・ガス</option>
							<option value="10">運輸・通信業</option>
							<option value="11">卸売・小売・飲食業</option>
							<option value="12">金融・保険業</option>
							<option value="13">不動産業</option>
							<option value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==7}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option value="5">漁業</option>
							<option value="6">鉱業</option>
							<option selected value="7">建設業</option>
							<option value="8">製造業</option>
							<option value="9">電気・ガス</option>
							<option value="10">運輸・通信業</option>
							<option value="11">卸売・小売・飲食業</option>
							<option value="12">金融・保険業</option>
							<option value="13">不動産業</option>
							<option value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==8}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option value="5">漁業</option>
							<option value="6">鉱業</option>
							<option value="7">建設業</option>
							<option selected value="8">製造業</option>
							<option value="9">電気・ガス</option>
							<option value="10">運輸・通信業</option>
							<option value="11">卸売・小売・飲食業</option>
							<option value="12">金融・保険業</option>
							<option value="13">不動産業</option>
							<option value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==9}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option value="5">漁業</option>
							<option value="6">鉱業</option>
							<option value="7">建設業</option>
							<option value="8">製造業</option>
							<option selected value="9">電気・ガス</option>
							<option value="10">運輸・通信業</option>
							<option value="11">卸売・小売・飲食業</option>
							<option value="12">金融・保険業</option>
							<option value="13">不動産業</option>
							<option value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==10}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option value="5">漁業</option>
							<option value="6">鉱業</option>
							<option value="7">建設業</option>
							<option value="8">製造業</option>
							<option value="9">電気・ガス</option>
							<option selected value="10">運輸・通信業</option>
							<option value="11">卸売・小売・飲食業</option>
							<option value="12">金融・保険業</option>
							<option value="13">不動産業</option>
							<option value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==11}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option value="5">漁業</option>
							<option value="6">鉱業</option>
							<option value="7">建設業</option>
							<option value="8">製造業</option>
							<option value="9">電気・ガス</option>
							<option value="10">運輸・通信業</option>
							<option selected value="11">卸売・小売・飲食業</option>
							<option value="12">金融・保険業</option>
							<option value="13">不動産業</option>
							<option value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==12}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option value="5">漁業</option>
							<option value="6">鉱業</option>
							<option value="7">建設業</option>
							<option value="8">製造業</option>
							<option value="9">電気・ガス</option>
							<option value="10">運輸・通信業</option>
							<option value="11">卸売・小売・飲食業</option>
							<option selected value="12">金融・保険業</option>
							<option value="13">不動産業</option>
							<option value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==13}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
							<option value="4">林業</option>
							<option value="5">漁業</option>
							<option value="6">鉱業</option>
							<option value="7">建設業</option>
							<option value="8">製造業</option>
							<option value="9">電気・ガス</option>
							<option value="10">運輸・通信業</option>
							<option value="11">卸売・小売・飲食業</option>
							<option value="12">金融・保険業</option>
							<option selected value="13">不動産業</option>
							<option value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==14}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
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
							<option selected value="14">サービス業</option>
							<option value="15">その他</option>
						</c:when>
						<c:when test="${user.getOccupation_id()==15}">
							<option value="1">学部生</option>
							<option value="2">大学院生</option>
							<option value="3">農林・水産</option>
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
							<option selected value="15">その他</option>
						</c:when>
					</c:choose>
				</select>
			</div>
			<div class="form-group">
				<label for="sex"> 性別</label><select name="sexId" id="sexId">
					<c:choose>
						<c:when test="${user.getSex_id()==1}">
							<option selected value="1">男</option>
							<option value="2">女</option>
							<option value="0">選択しない</option>
						</c:when>
						<c:when test="${user.getSex_id()==2}">
							<option value="1">男</option>
							<option selected value="2">女</option>
							<option value="0">選択しない</option>
						</c:when>
						<c:when test="${user.getSex_id()==0}">
							<option value="1">男</option>
							<option value="2">女</option>
							<option selected value="0">選択しない</option>
						</c:when>
					</c:choose>
				</select>
			</div>
			<div class="form-group">
				<label for="contact">連絡先(40文字以下)</label> <input class="form-control"
					type="text" name="contact" id="contact"
					value="<%=user.getContact()%>">
			</div>
			<div class="form-group">
				<label for="freespace">フリースペース(200文字以下でアピールポイントや興味があること等を書いてください)</label>
				<input class="form-control" type="text" name="freeSpace"
					id="freeSpace" value="<%=user.getFreespace()%>">
			</div>
			<div class="form-group">
				<label for="value">価値観(最低一つは入力してください)</label>
				<datalist id="values"> <c:forEach var="value"
					items="${values}">
					<option value="${value.getValue()}">
				</c:forEach> </datalist>
				<input class="form-control" type="text" name="value1" id="value1"
					value="<%=request.getAttribute("value1")%>" autocomplete="on"
					list="values"> <input class="form-control" type="text"
					name="value2" id="value2"
					value="<%=request.getAttribute("value2")%>" autocomplete="on"
					list="values"> <input class="form-control" type="text"
					name="value3" id="value3"
					value="<%=request.getAttribute("value3")%>" autocomplete="on"
					list="values">
			</div>
			<button type="submit" class="btn btn-primary">登録</button>
		</form>
	</div>
	<br>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>
