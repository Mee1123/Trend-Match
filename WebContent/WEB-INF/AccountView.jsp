<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/SE18G2/CSS/css/bootstrap.min.css">
<link rel="stylesheet"
	href="/SE18G2/CSS/font/css/open-iconic-bootstrap.css">
<link rel="stylesheet" type="text/css" href="/SE18G2/CSS/table.css">
<link rel="stylesheet" type="text/css" href="/SE18G2/CSS/box.css">
<meta charset="UTF-8">
<title>アカウント閲覧</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="container">
		<br>
		<h2 class="page-header">アカウント情報</h2>
		<br>
		<div class="form-group">
			ニックネーム:
			<div class="box1">
				<p>
		<c:out value="${user.getNickname()}" />
				</p>
			</div>
		</div>
		<div class="form-group">
			所属:
			<div class="box1">
				<p>
		<c:out value="${user.getDepartment()}" />
				</p>
			</div>
		</div>
		<div class="form-group">
			職種:
			<div class="box1">
				<p>
		<c:out value="${user.getOccupation_id()}" />
				</p>
			</div>
		</div>
		<div class="form-group">
			性別:
			<div class="box1">
				<p>
		<c:choose>
			<c:when test="${user.getSex_id()==0}">-</c:when>
			<c:when test="${user.getSex_id()==1}">男</c:when>
			<c:when test="${user.getSex_id()==2}">女</c:when>
		</c:choose>
				</p>
			</div>
		</div>
		<div class="form-group">
			連絡先:
			<div class="box1">
				<p>
		<c:out value="${user.getContact()}" />
				</p>
			</div>
		</div>
		<div class="form-group">
			価値観:
			<div class="box1">
				<p>
		<c:out value="${value1}" /><br>
		<c:out value="${value2}" /><br>
		<c:out value="${value3}" />
				</p>
			</div>
		</div>
		<div class="form-group">
			フリースペース:
			<div class="box2">
				<p>
		<c:out value="${user.getFreespace()}" />
				</p>
			</div>
		</div>
		<div class="form-group">エニアグラム</div>
		<div class="table">
		<table border>
				<!-- <tr bgcolor="#ffb6c1">  -->
				<tr>
					<td>タイプ１（改革する人）</td>
					<td>タイプ2（人を助ける人）</td>
					<td>タイプ3（達成する人）</td>
			</tr>
			<tr>
				<td><c:out value="${user.getEnneagram()[0]}" /></td>
				<td><c:out value="${user.getEnneagram()[1]}" /></td>
				<td><c:out value="${user.getEnneagram()[2]}" /></td>
			</tr>
				<!-- <tr bgcolor="#ffb6c1">  -->
				<tr>
					<td>タイプ4（個性的な人）</td>
					<td>タイプ5（調べる人）</td>
					<td>タイプ6（忠実な人）</td>
			</tr>
			<tr>
				<td><c:out value="${user.getEnneagram()[3]}" /></td>
				<td><c:out value="${user.getEnneagram()[4]}" /></td>
				<td><c:out value="${user.getEnneagram()[5]}" /></td>
			</tr>
				<!-- <tr bgcolor="#ffb6c1">  -->
				<tr>
					<td>タイプ7（熱中する人）</td>
					<td>タイプ8（挑戦する人）</td>
					<td>タイプ9（平和をもたらす人）</td>
			</tr>
			<tr>
				<td><c:out value="${user.getEnneagram()[6]}" /></td>
				<td><c:out value="${user.getEnneagram()[7]}" /></td>
				<td><c:out value="${user.getEnneagram()[8]}" /></td>
			</tr>
		</table>
		</div>
		<c:choose>
			<c:when test="${session == 1 }">
				<div align="right">
					<a href=/SE18G2/account/update><img
						src="header/Edit(black).jpg"><br>EDIT ACCOUNT INFO.</a>
				</div>
				<br>
</c:when>
			<c:when test="${session ==2 }">
通報
連絡
</c:when>
		</c:choose>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>