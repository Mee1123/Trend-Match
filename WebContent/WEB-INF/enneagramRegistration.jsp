<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="tableDesign.css">
<title>自己分析</title>
</head>
<body>
	<jsp:include page="headerForUnfinishAccountRegistration.jsp" />
	<div class="container">
		<form action="/SE18G2/enneagramRegistration" method="post">

			<h1>自己分析<span class="label label-denger">${form}</span></h1>

			<br>
			★まずエニアグラム診断を受け、その結果を入力してください。<br> <a
				href="https://www.enneagram.ne.jp/about" target="_blank"><input class="btn btn-primary" type="button" value="エニアグラムとは"></a><br>
			エニアグラムはAppleやIBMなどの企業でも採用されている性格診断の手法です。<br>
			<a href="https://www.enneagram.ne.jp/about/diagnosis/dns01" target="blank">こちら</a>
			からエニアグラム診断が受けられます。<br>
			タイプ1～タイプ9のチェック数を以下に入力してください。<br>
			未記入の場合は0となります。
			<br>
			<br>
			<table>
				<tr>
					<td>タイプ1</td>
					<td>タイプ2</td>
					<td>タイプ3</td>
				</tr>
				<tr>
					<td><input type="text" name="enneagram1" value="0"></td>
					<td><input type="text" name="enneagram2" value="0"></td>
					<td><input type="text" name="enneagram3" value="0"></td>
				</tr>
				<tr>
					<td>タイプ4</td>
					<td>タイプ5</td>
					<td>タイプ6</td>
				</tr>
				<tr>
					<td><input type="text" name="enneagram4" value="0"></td>
					<td><input type="text" name="enneagram5" value="0"></td>
					<td><input type="text" name="enneagram6" value="0"></td>
				</tr>
				<tr>
					<td>タイプ7</td>
					<td>タイプ8</td>
					<td>タイプ9</td>
				</tr>
				<tr>
					<td><input type="text" name="enneagram7" value="0"></td>
					<td><input type="text" name="enneagram8" value="0"></td>
					<td><input type="text" name="enneagram9" value="0"></td>
				</tr>
			</table>
			<br>
			<input class="btn btn-primary" type="submit" value="次へ">
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>