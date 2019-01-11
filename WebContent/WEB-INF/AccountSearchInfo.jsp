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
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="container">
		<form action="/SE18G2/AccountSearchInfo" method="post">
			<div class="form-group">
				ニックネーム:<input class="form-control" type="text" name="nickname"><br>
			</div>
			<div class="form-group">
				卒業年度:<select name="graduate">
					<c:forEach begin=2000 end=2020 var="years">
						<option value="${years}"><c:out value="${years}" /></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				所属:<input class="form-control" type="text" name="department"><br>
			</div>
			<div class="form-group">
				職種:<input type="text" name="occupation"><br>
			</div>
			<div class="form-group">
				性別:<select name="sex">
					<option value="human">ー</option>
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
				</select> ><br>
			</div>
			<input class="btn btn-primary" type="submit" value="検索">
		</form>
	</div>
	<!-- javascript -->
	<script type="text/javascript" src="/SE18G2/CSS/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/SE18G2/CSS/js/bootstrap.min.js"></script>
</body>
</html>